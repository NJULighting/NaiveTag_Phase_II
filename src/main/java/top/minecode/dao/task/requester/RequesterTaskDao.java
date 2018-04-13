package top.minecode.dao.task.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.domain.task.requester.TaskParticipant;
import top.minecode.po.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
@Repository
public class RequesterTaskDao {

    private RequesterStatisticDao statisticDao;

    public List<FirstLevelTaskPO> getTasks(int ownerId) {
        return TableFactory.firstLevelTaskTable().getPOsBy(ownerId, FirstLevelTaskPO::getOwnerId);
    }

    public Map<Integer, List<TaskParticipant>> getParticipants(int firstTaskId) {
        List<Integer> secondTasks = TaskMaps.INSTANCE.getSecondTasks(firstTaskId);

        Map<Integer, List<ThirdLevelTaskPO>> twoThreeTaskMap = TaskMaps.INSTANCE.twoThreeIdObjMap(firstTaskId);

//        Function<List<ThirdLevelTaskPO>, List<TaskParticipant>> transformer = tasks -> {
//
//        };

//        twoThreeTaskMap.entrySet().stream().collect(Collectors.toMap(null, transformer));

        // Second level task id is the key and participants id list is the value
        Map<Integer, List<Integer>> taskWorkerMap = secondTasks.stream().collect(toMap(Function.identity(),
                t -> twoThreeTaskMap.get(t).stream().flatMap(e -> e.getParticipants().stream())
                        .distinct().collect(Collectors.toList())));

        Table<WorkerPO> workerTable = TableFactory.workerTable();
        RankTable rankTable = TableFactory.rankTable();
        // Key is second level task id and value is participants
        Map<Integer, List<TaskParticipant>> result = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : taskWorkerMap.entrySet()) {
            List<TaskParticipant> participants = entry.getValue().stream()
                    .map(e -> {
                        int rank = rankTable.getRankById(e);
                        double rankRatio = rankTable.getRankRatio(e);
                        double ability = workerTable.getPOBy(e, WorkerPO::getId).getAverageScoreRatio();
                        return new TaskParticipant(rank, ability, rankRatio);
                    }).collect(toList());
            result.put(entry.getKey(), participants);
        }

        return result;
    }

    @Autowired
    public void setStatisticDao(RequesterStatisticDao statisticDao) {
        this.statisticDao = statisticDao;
    }
}
