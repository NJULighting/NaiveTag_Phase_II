package top.minecode.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.minecode.dao.user.UserDao;
import top.minecode.domain.task.ThirdLevelTaskResultType;
import top.minecode.po.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/13.
 * Description:
 *
 * @author iznauy
 */

@Repository
public class TaskSettlementDao {

    public List<FirstLevelTaskPO> getAllRequireSettlementTask() {
        LocalDate currentDate = LocalDate.now();
        return TableFactory.firstLevelTaskTable().getPOsBy(currentDate,
                FirstLevelTaskPO::getEndDate);
    }

    public List<ThirdLevelTaskResultPO> getAllRequireExpiredTask() {
        LocalDate currentDate = LocalDate.now();
        return TableFactory.thirdLevelTaskResultTable().getPOsBy(currentDate,
                ThirdLevelTaskResultPO::getExpireTime).stream()
                .filter(e -> e.getState().equals(ThirdLevelTaskResultType.doing))
                .collect(Collectors.toList());
    }

    @Deprecated
    public Map<Integer, List<SecondLevelTaskPO>> groupedTasks(Set<Integer> ids) {
        return TableFactory.secondLevelTaskTable().getAll()
                .stream().filter(e -> ids.contains(e.getFirstLevelTaskId()))
                .collect(Collectors.groupingBy(SecondLevelTaskPO::getFirstLevelTaskId));
    }

    @Deprecated
    public Map<Integer, List<ThirdLevelTaskPO>> groupedThirdLevelTasks(Set<Integer> ids) {
        return TableFactory.thirdLevelTaskTable().getAll()
                .stream().filter(e -> ids.contains(e.getSecondLevelTaskId()))
                .collect(Collectors.groupingBy(ThirdLevelTaskPO::getSecondLevelTaskId));
    }

    @Deprecated
    public Map<Integer, List<ThirdLevelTaskResultPO>> groupedThirdLevelResultTasks(Set<Integer> ids) {
        return TableFactory.thirdLevelTaskResultTable().getAll()
                .stream().filter(e -> ids.contains(e.getThirdLevelTaskId()))
                .collect(Collectors.groupingBy(ThirdLevelTaskResultPO::getThirdLevelTaskId));
    }

}
