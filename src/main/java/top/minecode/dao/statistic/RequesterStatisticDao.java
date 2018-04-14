package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.dao.task.requester.TaskMaps;
import top.minecode.po.SecondLevelTaskPO;
import top.minecode.po.Table;
import top.minecode.po.TableFactory;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.utils.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/8.
 * Description:
 * @author Liao
 */
@Repository
public class RequesterStatisticDao {

    private Map<Integer, Double> pointTable = new HashMap<>();

    /**
     * Get process table of tasks.(For FirstLevelTask)
     * @param ownerId id of the requester(FirstLevelTask's id)
     * @return A map whose key is id and value is process.
     */
    public Map<Integer, Double> getTaskTotalProcess(int ownerId) {
        return calculate(TaskMaps.INSTANCE.oneThreeIdObjMap(ownerId));
    }

    public Map<Integer, Double> getSecondLevelTaskProcess(int firstLevelTaskId) {

        return calculate(TaskMaps.INSTANCE.twoThreeIdObjMap(firstLevelTaskId));
    }

    //TODO Need to check
    private Map<Integer, Double> calculate(Map<Integer, List<ThirdLevelTaskPO>> relations) {
        // Key is second level task id and the value is the process
        Map<Integer, Double> processTable = new HashMap<>();

        // Iterate all third level tasks to count finished tasks and tasks number
        for (Map.Entry<Integer, List<ThirdLevelTaskPO>> relation : relations.entrySet()) {
            Pair<Integer, Integer> doneToTotal = new Pair<>(0, 0);
            for (ThirdLevelTaskPO task : relation.getValue()) {
                int i = task.isFinished() ? 1 : 0;
                doneToTotal.setRight(doneToTotal.getRight() + 1);
                doneToTotal.setLeft(doneToTotal.getLeft() + i);
            }
            double process = doneToTotal.getLeft() * 1.0 / doneToTotal.getRight();
            processTable.put(relation.getKey(), process);
        }

        return processTable;
    }
}
