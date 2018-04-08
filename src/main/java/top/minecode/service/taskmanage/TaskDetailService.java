package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.WorkerTaskDetail;
import top.minecode.domain.user.User;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.po.ThirdLevelTaskResultPO;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class TaskDetailService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }

    public WorkerTaskDetail getWorkerTaskDetail(User user, int taskId) {
        ThirdLevelTaskPO rawTaskPO = workerTaskDao.loadTaskByTaskId(taskId);
        ThirdLevelTaskResultPO taskResultPO = workerTaskDao.loadTaskResultByUserAndTaskId(user, taskId);
        return null;
    }

}
