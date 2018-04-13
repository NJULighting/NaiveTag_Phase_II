package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.ThirdLevelTaskResultType;
import top.minecode.domain.task.WorkerHistoryTaskInfo;
import top.minecode.domain.task.WorkerRecentTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.domain.user.Worker;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.po.ThirdLevelTaskResultPO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class WorkerHistoryTaskService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }


    public List<WorkerRecentTaskInfo> getWorkerRecentTaskInfo(User user, int count) {
        List<ThirdLevelTaskResultPO> userAllResults = workerTaskDao.loadAllTaskResultByUserId(user.getId());
        // 没有完成的任务的列表
        List<ThirdLevelTaskResultPO> unfinishedResults = userAllResults.stream()
                .filter(e -> e.getState().equals(ThirdLevelTaskResultType.doing)).collect(Collectors.toList());
        // 从其中截取count个
        List<ThirdLevelTaskResultPO> requiredResults = unfinishedResults.subList(0,
                Math.min(count, unfinishedResults.size()));
        List<ThirdLevelTaskPO> requiredTasks = requiredResults.stream()
                .map(e -> workerTaskDao.loadTaskByTaskId(e.getThirdLevelTaskId()))
                .collect(Collectors.toList());

        List<WorkerRecentTaskInfo> workerRecentTaskInfoList = new ArrayList<>();

        for (int i = 0; i < requiredResults.size(); i++) {
            ThirdLevelTaskPO task = requiredTasks.get(i);
            ThirdLevelTaskResultPO result = requiredResults.get(i);

            int taskId = task.getId();
            String taskName = task.getTaskName();
            int taskType = task.getTaskType();
            Double averageScore = task.getStandardScore();
            double process = 1.0 * result.getTagResults().size() / task.getPicList().size();
            String cover = task.getPicList().get(0);

            WorkerRecentTaskInfo workerRecentTaskInfo = new WorkerRecentTaskInfo(taskId, taskType, taskName,
                    averageScore, process, cover);
            workerRecentTaskInfoList.add(workerRecentTaskInfo);
        }

        return workerRecentTaskInfoList;
    }

    public List<WorkerHistoryTaskInfo> getWorkerHistoryTaskInfo(User user) {
        List<ThirdLevelTaskResultPO> userAllResults = workerTaskDao.loadAllTaskResultByUserId(user.getId());
        List<ThirdLevelTaskPO> userAllTasks = userAllResults.stream().map(e -> workerTaskDao.loadTaskByTaskId(e.getId()))
                .collect(Collectors.toList());
        List<WorkerHistoryTaskInfo> workerHistoryTaskInfoList = new ArrayList<>(userAllResults.size());
        for (int i = 0; i < userAllResults.size(); i++) {
            ThirdLevelTaskResultPO taskResult = userAllResults.get(i);
            ThirdLevelTaskPO task = userAllTasks.get(i);

            int taskId = task.getId();
            int taskType = task.getTaskType();
            String taskName = task.getTaskName();
            double averageScore = task.getStandardScore();
            LocalDate payDay = task.getEndDate();
            int picAmount = task.getPicList().size();
            String cover = task.getPicList().get(0);
            Double actualScore = taskResult.getActualScore();
            ThirdLevelTaskResultType state = taskResult.getState();
            LocalDate beginDate = taskResult.getAcceptTime();
            LocalDate endDate = taskResult.getExpireTime();

            int hasLabelAmount = taskResult.getTagResults().size();
            Double process = hasLabelAmount * 1.0 / picAmount;

            WorkerHistoryTaskInfo workerHistoryTaskInfo = new WorkerHistoryTaskInfo(taskId,
                    taskType, taskName, averageScore, payDay, picAmount, cover, actualScore,
                    beginDate, endDate, process, state);
            workerHistoryTaskInfoList.add(workerHistoryTaskInfo);
        }
        Collections.sort(workerHistoryTaskInfoList);
        return workerHistoryTaskInfoList;
    }

}
