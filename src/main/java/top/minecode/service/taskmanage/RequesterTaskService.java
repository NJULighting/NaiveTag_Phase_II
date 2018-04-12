package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.dao.task.requester.RequesterTaskDao;
import top.minecode.domain.task.requester.RequesterTaskDetails;
import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.domain.task.requester.TaskParticipant;
import top.minecode.po.FirstLevelTaskPO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/8.
 * Description:
 * @author Liao
 */
@Service
public class RequesterTaskService {

    private RequesterTaskDao requesterTaskDao;
    private RequesterStatisticDao requesterStatisticDao;

    @Autowired
    public void setRequesterStatisticDao(RequesterStatisticDao requesterStatisticDao) {
        this.requesterStatisticDao = requesterStatisticDao;
    }

    @Autowired
    public void setRequesterTaskDao(RequesterTaskDao requesterTaskDao) {
        this.requesterTaskDao = requesterTaskDao;
    }

    public List<RequesterTaskInfo> getTasksInfo(int ownerId) {

        List<FirstLevelTaskPO> tasks = requesterTaskDao.getTasks(ownerId);
        List<Integer> tasksIds = tasks.stream().map(FirstLevelTaskPO::getId).collect(Collectors.toList());
        Map<Integer, Double> tasksProcess = requesterStatisticDao.getTaskProcess(tasksIds);

        return tasks.stream().map(po -> new RequesterTaskInfo(po, tasksProcess.get(po.getId())))
                .collect(Collectors.toList());
    }

    public List<RequesterTaskDetails> getTaskDetails(int ownerId, int taskId) {
        // Get task information and participants
        List<RequesterTaskInfo> taskInformation = getTasksInfo(ownerId);
        Map<Integer, List<TaskParticipant>> participants = requesterTaskDao.getParticipants(taskId);

        return taskInformation.stream().map(t -> new RequesterTaskDetails(t, participants.get(t.getTaskId())))
                .collect(Collectors.toList());
    }
}
