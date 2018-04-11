package top.minecode.dao.task;

import top.minecode.po.Table;
import top.minecode.po.TableFactory;
import top.minecode.po.ThirdLevelTaskResultPO;

/**
 * Created on 2018/4/11.
 * Description:
 *
 * @author iznauy
 */
public class WorkerTaskUtils {

    ThirdLevelTaskResultPO getResultPOByUserIdAndTaskId(int userId, int taskId) {
        Table<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTable
                = TableFactory.thirdLevelTaskResultTable();
        return thirdLevelTaskResultPOTable
                .getAll().stream().filter(e -> e.getDoerId().equals(userId)
                        && e.getThirdLevelTaskId().equals(taskId)).findFirst()
                .get();
    }

}
