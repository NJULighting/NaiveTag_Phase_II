package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.user.User;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
@Service
public class TaskAcceptAndCommitService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }

    public boolean acceptTask(User user, int taskId) {
        boolean canAccept = workerTaskDao.canAcceptTask(user, taskId);
        if (!canAccept)
            return false;
        return workerTaskDao.acceptTask(user, taskId);
    }

    public boolean commit(User user, int taskId) {
        return workerTaskDao.commit(user, taskId);
    }



}
