package top.minecode.dao.task.requester;

import top.minecode.po.*;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created on 2018/4/11.
 * Description:
 * @author Liao
 */
public enum TaskMaps {
    INSTANCE;

    private Map<Integer, List<Integer>> oneTwoMap;
    private Map<Integer, List<Integer>> twoThreeMap;

    TaskMaps() {
        updateMaps();
    }

    public List<Integer> getSecondTasks(int firstTaskId) {
        return oneTwoMap.get(firstTaskId);
    }

    public Map<Integer, List<Integer>> getOneTwoMap(int ownerId) {
        updateMaps();
        Table<FirstLevelTaskPO> firstLevelTaskTable = TableFactory.firstLevelTaskTable();
        List<FirstLevelTaskPO> tasks = firstLevelTaskTable.getPOsBy(ownerId, FirstLevelTaskPO::getOwnerId);

        return tasks.stream().collect(toMap(FirstLevelTaskPO::getId, p -> oneTwoMap.get(p.getId())));
    }

    public Map<Integer, List<Integer>> getOneTwoMap() {
        return Collections.unmodifiableMap(oneTwoMap);
    }

    public Map<Integer, List<Integer>> getTwoThreeMap() {
        return Collections.unmodifiableMap(twoThreeMap);
    }

    private void updateMaps() {
        Table<SecondLevelTaskPO> secondLevelTasks = TableFactory.secondLevelTaskTable();
        Table<ThirdLevelTaskPO> thirdLevelTasks = TableFactory.thirdLevelTaskTable();
        // Update first-second level tasks map
        oneTwoMap = secondLevelTasks.getAll()
                .stream().collect(groupingBy(SecondLevelTaskPO::getFirstLevelTaskId,
                        mapping(SecondLevelTaskPO::getId, toList())));

        // Update second-third level tasks map
        twoThreeMap = thirdLevelTasks.getAll()
                .stream().collect(groupingBy(ThirdLevelTaskPO::getSecondLevelTaskId,
                        mapping(ThirdLevelTaskPO::getId, toList())));
    }
}
