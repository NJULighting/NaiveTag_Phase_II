package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.domain.user.User;
import top.minecode.po.*;

import java.util.List;

/**
 * Created on 2018/4/11.
 * Description:
 *
 * @author iznauy
 */

@Repository
public class WorkerUtilsDao {

    ThirdLevelTaskResultPO getResultPOByUserIdAndTaskId(int userId, int taskId) {
        Table<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTable
                = TableFactory.thirdLevelTaskResultTable();
        return thirdLevelTaskResultPOTable
                .getAll().stream().filter(e -> e.getDoerId().equals(userId)
                        && e.getThirdLevelTaskId().equals(taskId)).findFirst()
                .get();
    }

    public List<SecondLevelTaskPO> getSubTaskByFirstLevelTaskId(int taskId) {
        return TableFactory.secondLevelTaskTable().getPOsBy(taskId, SecondLevelTaskPO::getFirstLevelTaskId);
    }

    public List<ThirdLevelTaskPO> getSubTaskBySecondLevelTaskId(int taskId) {
        return TableFactory.thirdLevelTaskTable().getPOsBy(taskId, ThirdLevelTaskPO::getSecondLevelTaskId);
    }

    public List<ThirdLevelTaskResultPO> getTaskResultsByTaskId(int taskId) {
        return TableFactory.thirdLevelTaskResultTable().getPOsBy(taskId, ThirdLevelTaskResultPO::getThirdLevelTaskId);
    }

    public WorkerPO getWorkerPOById(int id) {
        return TableFactory.workerTable().getPOBy(id, WorkerPO::getId);
    }

    public ThirdLevelTaskPO getThirdLevelTaskById(int id) {
        return TableFactory.thirdLevelTaskTable().getPOBy(id, ThirdLevelTaskPO::getId);
    }

}
