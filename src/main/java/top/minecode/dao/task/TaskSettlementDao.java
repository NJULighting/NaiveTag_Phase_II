package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.SecondLevelTaskPO;
import top.minecode.po.Table;
import top.minecode.po.TableFactory;

import java.time.LocalDate;
import java.util.List;
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

    /**
     * 根据一级任务id集合查找对应的二级任务
     * @param ids
     * @return
     */
    public List<SecondLevelTaskPO> getSecondLevelTasksByIds(Set<Integer> ids) {
        return TableFactory.secondLevelTaskTable().getAll()
                .stream().filter(e -> ids.contains(e.getFirstLevelTaskId()))
                .collect(Collectors.toList());
    }

}
