package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.domain.task.ThirdLevelTaskResultType;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.user.User;
import top.minecode.po.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */

@Repository
public class WorkerTaskDao {

    private WorkerUtilsDao workerUtilsDao = new WorkerUtilsDao();

    public List<ThirdLevelTaskPO> getAccessibleTaskList(User user) {

        // 获取用户当前排名比例
        double ratio = getUserRatio(user);


        List<ThirdLevelTaskPO> allThirdLevelTaskPOS = TableFactory.thirdLevelTaskTable().getAll();
        List<WorkerFilterPO> workerFilterPOS = TableFactory.workerFilterTable().getAll();

        // 根据任务状态、用户排名是否足够接、用户是否已经接过或者完成过进行筛选，筛选出可以接的任务
        return allThirdLevelTaskPOS.stream().filter(e -> e.getState() == ThirdLevelTaskState.doing)
                .filter( e -> workerFilterPOS.stream()
                    .filter( t -> t.getId().equals(e.getWorkerFilterId()))
                        .findFirst().get().getWorkerRankRatio() >= ratio
                ).filter(e -> !(e.getFinishedWorkerIds().contains(user.getId())
                    || e.getCurrentDoingWorkerIds().contains(user.getId())))
                .collect(Collectors.toList());
    }

    private double getUserRatio(User user) {
  //      Integer rank = DataBase.rankPO.getRankByName(user.getName());
   //     int totalWorkerAmount = DataBase.workerPOList.getNextWorkerId() - 1;
        Integer rank = TableFactory.rankTable().getRankByName(user.getName());
        int totalWorkerAmount = TableFactory.workerTable().size();
        return rank == null ? 1.0 : rank * 1.0 / totalWorkerAmount;
    }

    public List<ThirdLevelTaskPO> searchingTaskByKey(User user, String key) {

        // 所有的任务
//        List<ThirdLevelTaskPO> allThirdLevelTaskPOS = DataBase.thirdLevelTaskPOList.getThirdLevelTaskPOS();

        List<ThirdLevelTaskPO> allThirdLevelTaskPOS = TableFactory.thirdLevelTaskTable().getAll();

//        Predicate<ThirdLevelTaskPO> filter = e -> e.getState() == ThirdLevelTaskState.doing;
//        filter.and(e -> e.getTaskName().contains(key)).and(e -> !(e.getFinishedWorkerIds().contains(user.getId())
//                || e.getCurrentDoingWorkerIds().contains(user.getId())));

        // 字符串匹配
        // 不会柔性匹配算法，就完全匹配了..
        return allThirdLevelTaskPOS.stream().filter(e -> e.getState() == ThirdLevelTaskState.doing)
                .filter(e -> e.getTaskName().contains(key))
                .filter(e -> !(e.getFinishedWorkerIds().contains(user.getId())
                        || e.getCurrentDoingWorkerIds().contains(user.getId())))
                .collect(Collectors.toList());
    }

    public ThirdLevelTaskResultPO loadTaskResultByUserAndTaskId(User user, int taskId) {
        List<ThirdLevelTaskResultPO> resultPOS = TableFactory.thirdLevelTaskResultTable()
                .getAll();
        return resultPOS.stream().filter(e -> e.getDoerId().equals(user.getId())
                && e.getThirdLevelTaskId().equals(taskId)).findFirst().orElse(null);
    }

    public ThirdLevelTaskPO loadTaskByTaskId(int taskId) {
        List<ThirdLevelTaskPO> thirdLevelTaskPOS = TableFactory.thirdLevelTaskTable().getAll();
        return thirdLevelTaskPOS.stream().filter(e -> e.getId().equals(taskId))
                .findFirst().orElse(null);
    }

    public List<ThirdLevelTaskResultPO> loadAllTaskResultByUserId(int userId) {
        return TableFactory.thirdLevelTaskResultTable().getPOsBy(userId, ThirdLevelTaskResultPO::getDoerId);
    }

    public boolean canAcceptTask(User user, int taskId) {
        ThirdLevelTaskPO taskPO = loadTaskByTaskId(taskId);
        double ratio = getUserRatio(user);
        if (taskPO == null)
            return false;
        Double lowBound =  TableFactory.workerFilterTable().getAll().stream()
                .filter(e -> e.getId().equals(taskPO.getWorkerFilterId())).findFirst()
                .orElse(null).getWorkerRankRatio();
        return lowBound == null || lowBound > ratio;

    }

    public boolean commit(User user, int taskId) {

        Table<ThirdLevelTaskPO> thirdLevelTaskPOTable
                = TableFactory.thirdLevelTaskTable();

        ThirdLevelTaskResultPO thirdLevelTaskResultPO = workerUtilsDao.getResultPOByUserIdAndTaskId(user.getId(), taskId);
        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTable.getPOBy(taskId, ThirdLevelTaskPO::getId);
        // 如果任务没有做完
        if (thirdLevelTaskResultPO.getTagResults().size() != thirdLevelTaskPO.getPicList().size())
            return false;

        // 改变 taskresult的状态
        thirdLevelTaskResultPO.setEndTime(LocalDate.now());
        thirdLevelTaskResultPO.setState(ThirdLevelTaskResultType.unpay);

        // 改变 task的状态
        List<Integer> finishUser = thirdLevelTaskPO.getFinishedWorkerIds();
        finishUser.add(user.getId());
        List<Integer> acceptedUser = thirdLevelTaskPO.getCurrentDoingWorkerIds();
        acceptedUser.remove(user.getId());

        if (finishUser.size() == 3) //假定每个任务派发给3个人，那么就设置为完成
            thirdLevelTaskPO.setState(ThirdLevelTaskState.finished);

        thirdLevelTaskPOTable.save();

        return true;
    }

    public boolean acceptTask(User user, int taskId) {
        if (!canAcceptTask(user, taskId))
            return false;

        Table<ThirdLevelTaskPO> thirdLevelTaskPOTable =
                TableFactory.thirdLevelTaskTable();

        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTable.getPOBy(taskId,
                ThirdLevelTaskPO::getId);

        if (thirdLevelTaskPO.getFinishedWorkerIds().contains(user.getId()))
            return false;


        thirdLevelTaskPO.getCurrentDoingWorkerIds().add(user.getId());
        thirdLevelTaskPOTable.save();

        LocalDate endDate = thirdLevelTaskPO.getEndDate();
        LocalDate acceptDate = LocalDate.now();
        LocalDate expiredDate = endDate.isBefore(acceptDate.plusDays(3)) ? endDate : acceptDate.plusDays(3);
        ThirdLevelTaskResultPO thirdLevelTaskResultPO = new ThirdLevelTaskResultPO(
            taskId, user.getId(), acceptDate, expiredDate
        );

        Table<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTable =
                TableFactory.thirdLevelTaskResultTable();
        thirdLevelTaskResultPOTable.add(thirdLevelTaskResultPO);

        return true;
    }


}
