package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
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
     * Get point table of tasks.
     * @param tasks ids of tasks
     * @return A map whose key is id and value is process.
     */
    public Map<Integer, Double> getTaskProcess(List<Integer> tasks) {
        updatePointTable();
        return tasks.stream().collect(Collectors.toMap(Function.identity(), this::calculate));
    }

    private double calculate(int firstLevelTaskId) {
        // Find corresponding second level tasks
        List<SecondLevelTaskPO> secondLevelTaskPOS = TableFactory.secondLevelTaskTable()
                .getPOsBy(firstLevelTaskId, SecondLevelTaskPO::getFirstLevelTaskId);

        return secondLevelTaskPOS.stream().mapToDouble(po -> pointTable.get(po.getId())).sum();
    }

    private void updatePointTable() {

        Table<ThirdLevelTaskPO> taskTable = TableFactory.thirdLevelTaskTable();
        List<ThirdLevelTaskPO> tasks = taskTable.getAll();
        Map<Integer, Pair<Integer, Integer>> numberTable = new HashMap<>();

        // Iterate all third level tasks to count finished tasks and tasks number
        for (ThirdLevelTaskPO task : tasks) {
            int i = task.isFinished() ? 1 : 0;
            Pair<Integer, Integer> finishedScale = numberTable.get(task.getSecondLevelTaskId());
            if (finishedScale == null) {
                numberTable.put(task.getSecondLevelTaskId(), new Pair<>(i, 1));
            } else {
                finishedScale.setRight(finishedScale.getRight() + 1);
                finishedScale.setLeft(finishedScale.getLeft() + i);
            }
        }

        // Update the map
        pointTable.clear();
        pointTable = numberTable.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                entry -> (entry.getValue().getLeft() * 1.0 / entry.getValue().getRight())));
    }
}
