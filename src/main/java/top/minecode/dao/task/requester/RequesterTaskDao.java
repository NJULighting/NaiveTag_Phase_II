package top.minecode.dao.task.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.domain.task.TaskInfo;
import top.minecode.domain.task.requester.TaskParticipant;
import top.minecode.po.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
@Repository
public class RequesterTaskDao {

    public List<FirstLevelTaskPO> getTasks(int ownerId) {
        return TableFactory.firstLevelTaskTable().getPOsBy(ownerId, FirstLevelTaskPO::getOwnerId);
    }

    public String getTaskResultPath(int taskId) {
        return TableFactory.firstLevelTaskTable().getPOBy(taskId, FirstLevelTaskPO::getId).getResultFilePath();
    }

    public boolean isDone(int taskId) {
        return TableFactory.firstLevelTaskTable().getPOBy(taskId, FirstLevelTaskPO::getId).getState()
                == FirstLevelTaskState.completed;
    }

    public Map<Integer, TaskInfo> secondLevelTaskInfo(int firstTaskId) {

        Table<SecondLevelTaskPO> table = TableFactory.secondLevelTaskTable();
        List<SecondLevelTaskPO> tasks = table.getPOsBy(firstTaskId, SecondLevelTaskPO::getFirstLevelTaskId);
        return tasks.stream().collect(Collectors.toMap(SecondLevelTaskPO::getId, SecondLevelTaskPO::getTaskInfo));
    }

    public Map<Integer, List<TaskParticipant>> getParticipants(int firstTaskId) {
        Map<Integer, List<ThirdLevelTaskPO>> twoThreeTaskMap = TaskMaps.INSTANCE.twoThreeIdObjMap(firstTaskId);

        Table<WorkerPO> workerTable = TableFactory.workerTable();
        RankTable rankTable = TableFactory.rankTable();

        // Key is second level task's id and the value is the task's participants
        Map<Integer, List<TaskParticipant>> participantsMap = new HashMap<>();

        for (Map.Entry<Integer, List<ThirdLevelTaskPO>> entry : twoThreeTaskMap.entrySet()) {
            List<TaskParticipant> participants = entry.getValue().stream()
                    .flatMap(e -> e.getParticipants().stream()).distinct().map(e -> {
                        int rank = rankTable.getRankById(e);
                        double rankRatio = rankTable.getRankRatio(e);
                        double ability = workerTable.getPOBy(e, WorkerPO::getId).getAverageScoreRatio();
                        return new TaskParticipant(rank, ability, rankRatio);
                    }).collect(toList());

            participantsMap.put(entry.getKey(), participants);
        }

        return participantsMap;
    }
}