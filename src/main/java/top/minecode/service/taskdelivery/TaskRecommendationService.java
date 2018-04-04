package top.minecode.service.taskdelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.WorkerGeneralTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.po.ThirdLevelTaskPO;

import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class TaskRecommendationService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }

    public List<WorkerGeneralTaskInfo> getRecommendations(User user) {
        List<ThirdLevelTaskPO>
    }

}
