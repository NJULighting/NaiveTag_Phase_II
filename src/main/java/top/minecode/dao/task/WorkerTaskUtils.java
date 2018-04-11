package top.minecode.dao.task;

import top.minecode.po.TableCandidate;
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
        TableCandidate<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTableCandidate
                = TableFactory.thirdLevelTaskResultTable();
        return thirdLevelTaskResultPOTableCandidate
                .getAll().stream().filter(e -> e.getDoerId().equals(userId)
                        && e.getThirdLevelTaskId().equals(taskId)).findFirst()
                .get();
    }

}
