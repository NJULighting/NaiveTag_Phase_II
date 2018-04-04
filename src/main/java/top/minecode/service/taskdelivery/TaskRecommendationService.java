package top.minecode.service.taskdelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.WorkerGeneralTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.po.ThirdLevelTaskPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    // 迭代三实现为智能化算法
    public List<WorkerGeneralTaskInfo> getRecommendations(User user) {
        List<ThirdLevelTaskPO> possibleTasks = workerTaskDao.getAccessibleTaskList(user);

        // 迭代二使用随机化推荐算法
        List<Integer> targetTasksIndex = new ArrayList<>();
        int totalTaskAmount = possibleTasks.size();
        // 任务过少，直接返回全部的
        if (TaskDeliveryConstant.RECOMMENDATION_COUNT >= totalTaskAmount)
            for (int i = 0; i < TaskDeliveryConstant.RECOMMENDATION_COUNT; i++)
                targetTasksIndex.add(i);
        else {
            // 否则随机生成一定数量的任务返回回去
            Random random = new Random();
            while (targetTasksIndex.size() < TaskDeliveryConstant.RECOMMENDATION_COUNT) {
                int index = Math.abs(random.nextInt()) % totalTaskAmount;
                if (targetTasksIndex.contains(index))
                    continue;
                targetTasksIndex.add(index);
            }
        }

        // 从index到WorkerGeneralTaskInfo
        return targetTasksIndex.stream().map(e -> possibleTasks.get(e).toGeneralTaskInfo())
                .collect(Collectors.toList());



    }

}
