package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.WorkerGeneralTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.domain.user.Worker;
import top.minecode.po.ThirdLevelTaskPO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class SearchingService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }

    /**
     * 搜索
     * @param user
     * @param key
     * @param begin
     * @param step
     * @return
     */
    public List<WorkerGeneralTaskInfo> searchingTaskByKey(User user, String key,
                                                          int begin, int step) { // begin是从1开始的
        List<ThirdLevelTaskPO> matchingTasks = workerTaskDao.searchingTaskByKey(user, key);
        if (begin > matchingTasks.size())
            return new ArrayList<>(); // 如果起始位置就已经超出了范围，就返回一个空的

        // begin ~ end 区间的数据将会被返回
        int end = begin + step - 1;

        // 超过全部数据的尾部的自然被截断到最后
        if(begin + step - 1 > matchingTasks.size())
            end = matchingTasks.size();

        return matchingTasks.subList(begin - 1, end).stream()
                .map(ThirdLevelTaskPO::toGeneralTaskInfo).collect(Collectors.toList());
    }

}
