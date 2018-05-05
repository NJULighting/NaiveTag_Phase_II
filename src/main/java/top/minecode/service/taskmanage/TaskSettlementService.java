package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.TaskSettlementDao;
import top.minecode.dao.task.WorkerUtilsDao;
import top.minecode.dao.user.UserDao;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.task.ThirdLevelTaskResultType;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.task.requester.SubTaskResult;
import top.minecode.domain.task.requester.TaskResult;
import top.minecode.domain.user.Worker;
import top.minecode.json.JsonConfig;
import top.minecode.po.*;
import top.minecode.utils.Config;
import top.minecode.utils.Pair;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/4/13.
 * Description:
 *
 * @author iznauy
 */

@Service
public class TaskSettlementService {

    private TaskSettlementDao taskSettlementDao;

    private WorkerUtilsDao workerUtilsDao;

    public TaskSettlementDao getTaskSettlementDao() {
        return taskSettlementDao;
    }

    @Autowired
    public void setTaskSettlementDao(TaskSettlementDao taskSettlementDao) {
        this.taskSettlementDao = taskSettlementDao;
    }

    public WorkerUtilsDao getWorkerUtilsDao() {
        return workerUtilsDao;
    }

    @Autowired
    public void setWorkerUtilsDao(WorkerUtilsDao workerUtilsDao) {
        this.workerUtilsDao = workerUtilsDao;
    }

    /**
     * 结算一个三级任务
     * 随便返回一份标注结果
     * @param taskPO
     * @return
     */
    private Pair<Map<String, TagResult>, Double> settleThirdLevelTasks(ThirdLevelTaskPO taskPO) {
        double totalPayedScore = 0.0;
        Map<String, TagResult> tagResults = null;
        List<ThirdLevelTaskResultPO> resultPOS = workerUtilsDao.getTaskResultsByTaskId(taskPO.getId());
        for (ThirdLevelTaskResultPO resultPO: resultPOS) {
            // 找出worker，创建log对象

            WorkerSettlementLogPO logPO = new WorkerSettlementLogPO();
            logPO.setTaskType(taskPO.getTaskType());
            logPO.setUserId(resultPO.getDoerId());

            // 只可能出现正在做，以及没有支付
            // 因为finish只有在结算后才会出现，而expired不需要给他结算

            if (resultPO.getState() == ThirdLevelTaskResultType.doing) {
                resultPO.setState(ThirdLevelTaskResultType.expired);
                // 把用户从doer里面移除
                taskPO.getCurrentDoingWorkerIds().remove(resultPO.getDoerId());
                resultPO.setActualScore(0.0);
                // 设置赚得的分数为0
                logPO.setEarnedScore(0.0);
            } else if (resultPO.getState() == ThirdLevelTaskResultType.unpay) {

                WorkerPO workerPO = workerUtilsDao.getWorkerPOById(resultPO.getDoerId());

                double rawScore = workerPO.getScores();
                double newScore = rawScore + taskPO.getStandardScore();
                workerPO.setScores(newScore);
                resultPO.setState(ThirdLevelTaskResultType.finish);

                totalPayedScore += taskPO.getStandardScore();

                resultPO.setActualScore(taskPO.getStandardScore());

                // 设置赚得的分数
                logPO.setEarnedScore(taskPO.getStandardScore());

                if (tagResults == null) {
                    tagResults = new HashMap<>();
                    Map<String, TagResult> rawResult = resultPO.getTagResults();
                    for (Map.Entry<String, TagResult> entry: rawResult.entrySet()) {
                        TagResult value = entry.getValue();
                        String rawPicPath = entry.getKey();
                        int lastSeparator = rawPicPath.lastIndexOf('/');
                        String finalPicPath = rawPicPath.substring(lastSeparator + 1);
                        tagResults.put(finalPicPath, value);
                    }
                }
            }
            taskPO.setState(ThirdLevelTaskState.finished);
            // 插入结算日志
            taskSettlementDao.addWorkerTaskSettlement(logPO);
        }
        System.out.println("对于任务：" + taskPO.getId());
        System.out.println("当前都有以下人已经提交：");
        System.out.println(taskPO.getFinishedWorkerIds());
        return new Pair<>(tagResults, totalPayedScore);
    }


    /**
     * 结算一个二级任务
     * @param taskPO
     * @return
     */
    private Pair<SubTaskResult, Double> settleSecondLevelTasks(SecondLevelTaskPO taskPO) {
        SubTaskResult subTaskResult =  new SubTaskResult();
        double totalPayedScore = 0.0;
        List<ThirdLevelTaskPO> subTasks = workerUtilsDao.getSubTaskBySecondLevelTaskId(taskPO.getId());
        for (ThirdLevelTaskPO subTask: subTasks) {
            Pair<Map<String, TagResult>, Double> subSubTaskResultPair = settleThirdLevelTasks(subTask);
            if (subSubTaskResultPair.getLeft() == null)
                continue;
            subTaskResult.extendResult(subSubTaskResultPair.getLeft());
            totalPayedScore += subSubTaskResultPair.getRight();
        }
        return new Pair<>(subTaskResult, totalPayedScore);
    }

    public void settle() {
        System.out.println("Start settlement task!");
        settleRequesterCompletedTask();
        settleWorkerExpiredTask();
        TableFactory.saveAll();
        System.out.println("End settlement task");
    }

    /**
     * 每日自动结算任务，结算的是用户接的三级任务到期而引发的任务停止
     */
    private void settleWorkerExpiredTask() {
        List<ThirdLevelTaskResultPO> requireExpiredTaskResult = taskSettlementDao.getAllRequireExpiredTask();
        for (ThirdLevelTaskResultPO resultPO: requireExpiredTaskResult) {

            resultPO.setState(ThirdLevelTaskResultType.expired);
            resultPO.setActualScore(0.0);

            int taskId = resultPO.getThirdLevelTaskId();
            ThirdLevelTaskPO task = workerUtilsDao.getThirdLevelTaskById(taskId);

            // 移除正在做的人的id
            int doerId = resultPO.getDoerId();
            task.getCurrentDoingWorkerIds().remove(doerId);
            if (task.getState() == ThirdLevelTaskState.locked)
                task.setState(ThirdLevelTaskState.doing);

            WorkerSettlementLogPO logPO = new WorkerSettlementLogPO();
            logPO.setUserId(resultPO.getDoerId());
            logPO.setEarnedScore(0.0);
            logPO.setTaskType(task.getTaskType());

            taskSettlementDao.addWorkerTaskSettlement(logPO);
        }
    }

    /**
     * 每日自动结算任务 -> 这里结算的是一级任务到期而引发的任务结算
     * 很复杂的方法
     * 迭代二中结算采用随机化选择一个人标注结果的方法来进行结算
     * 这一情况将在 TODO:迭代三
     * 出现改善
     * TODO: 加上详细的注释
     */
    private void settleRequesterCompletedTask() {
        // 获取当天需要结算的一级任务
        List<FirstLevelTaskPO> targetFLTs = taskSettlementDao.getAllRequireSettlementTask();
//        Set<Integer> targetFLTIds = targetFLTs.stream().map(FirstLevelTaskPO::getId)
//                .collect(Collectors.toSet());
//        // 获取需要结算的一级任务对应的所有的二级任务
//        Map<Integer, List<SecondLevelTaskPO>> targetSLTs = taskSettlementDao
//                .groupedTasks(targetFLTIds);
//
//        for(FirstLevelTaskPO fltTask: targetFLTs) {
//
//            // 加载必备的数据
//            // 对应一级任务的二级任务
//            List<SecondLevelTaskPO> sltTasks = targetSLTs.get(fltTask.getId());
//            // 二级任务的id
//            Set<Integer> sltTaskIds = sltTasks.stream().map(SecondLevelTaskPO::getId)
//                    .collect(Collectors.toSet());
//
//            // 获取需要结算的二级任务对应的所有三级任务
//            Map<Integer, List<ThirdLevelTaskPO>> targetTLTs = taskSettlementDao
//                    .groupedThirdLevelTasks(sltTaskIds);
//
//            // 三级任务id的集合
//            Set<Integer> tltIds = targetTLTs.values().stream().flatMap(List::stream)
//                    .map(ThirdLevelTaskPO::getId).collect(Collectors.toSet());
//            // 三级任务的id到三级任务结果的映射
//            Map<Integer, List<ThirdLevelTaskResultPO>> targetTLTResults = taskSettlementDao
//                    .groupedThirdLevelResultTasks(tltIds);
//
//
//
//
//        }
        for (FirstLevelTaskPO flTask: targetFLTs) {
            //存储结果
            TaskResult taskResult = new TaskResult();

            double totalPayedScores = 0.0;

            List<SecondLevelTaskPO> subTasks = workerUtilsDao.getSubTaskByFirstLevelTaskId(flTask.getId());

            for (SecondLevelTaskPO secondLevelTaskPO: subTasks) {
                Pair<SubTaskResult, Double> subTaskResultDoublePair = settleSecondLevelTasks(secondLevelTaskPO);
                taskResult.addSubTasks(subTaskResultDoublePair.getLeft());
                totalPayedScores += subTaskResultDoublePair.getRight();
            }

            flTask.setState(FirstLevelTaskState.completed);
            Double repay = flTask.getTotalScore() - totalPayedScores;
            flTask.setTotalScore(totalPayedScores);

            RequesterPO requesterPO = TableFactory.requesterTable().getPOBy(flTask.getOwnerId(), RequesterPO::getId);
            requesterPO.setScore(requesterPO.getScore() + repay);

            String result = JsonConfig.getGson().toJson(taskResult); // 这个任务的结果

            System.out.println(result);

            File resultFile = new File(Config.INSTANCE.getAbsolutePath(flTask.getResultFilePath()));
//            System.out.println(flTask.getResultFilePath());
//            System.out.println(resultFile.getAbsolutePath());

            try {
                if (!resultFile.exists()) {
                    if (!resultFile.createNewFile())
                        throw new IOException();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
                PrintWriter printWriter = new PrintWriter(bufferedOutputStream);
                printWriter.write(result);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
