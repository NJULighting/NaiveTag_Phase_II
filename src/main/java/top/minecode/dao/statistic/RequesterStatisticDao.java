package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.po.SecondLevelTaskPO;
import top.minecode.po.TableFactory;
import top.minecode.po.ThirdLevelTaskPO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/8.
 * Description:
 * @author Liao
 */
@Repository
public class RequesterStatisticDao {

    /**
     *
     * @param id id of <tt>FirstLevelTask</tt>
     * @return process of the task
     */
    public double getTaskProcess(int id) {

        return 0.0;
    }

    private void calculate(int firstLevelTaskId) {
        // Find corresponding second level tasks
        List<SecondLevelTaskPO> secondLevelTaskPOS = TableFactory.secondLevelTaskTable()
                .getPOsBy(firstLevelTaskId, SecondLevelTaskPO::getFirstLevelTaskId);
        // Find corresponding third level tasks
        Map<Integer, List<ThirdLevelTaskPO>> thirdLevelTaskPOS = TableFactory.thirdLevelTaskTable()
                .getAll().stream()
                .collect(Collectors.groupingBy(ThirdLevelTaskPO::getSecondLevelTaskId));
        // Calculate
        for (SecondLevelTaskPO task : secondLevelTaskPOS) {

            int sum = thirdLevelTaskPOS.get(task.getId()).stream()
                    .mapToInt(po -> po.getFinishedWorkerIds().size())
                    .sum();
        }
    }
}
