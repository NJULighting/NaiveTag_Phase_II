package top.minecode.dao.task.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.domain.task.requester.TaskParticipant;
import top.minecode.po.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

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
        Map<Integer, List<ThirdLevelTaskPO>> twoThreeTaskMap = TaskMaps.INSTANCE.twoThreeIdObjMap(firstTaskId);

        Table<WorkerPO> workerTable = TableFactory.workerTable();
        RankTable rankTable = TableFactory.rankTable();

        Map<Integer, List<TaskParticipant>> participantsMap = new HashMap<>();

        for (Map.Entry<Integer, List<ThirdLevelTaskPO>> entry : twoThreeTaskMap.entrySet()) {
            List<TaskParticipant> participants = entry.getValue().stream().map(e -> {
                int id = e.getId();
                int rank = rankTable.getRankById(id);
                double rankRatio = rankTable.getRankRatio(id);
                double ability = workerTable.getPOBy(e, WorkerPO::getId).getAverageScoreRatio();
                return new TaskParticipant(rank, ability, rankRatio);
            }).collect(toList());
            participantsMap.put(entry.getKey(), participants);
        }

        return participantsMap;
    }

    @Autowired
    public void setStatisticDao(RequesterStatisticDao statisticDao) {
        this.statisticDao = statisticDao;
    }
}