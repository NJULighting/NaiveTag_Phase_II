package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.TaskSettlementDao;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.SecondLevelTaskPO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/13.
 * Description:
 *
 * @author iznauy
 */

@Service
public class TaskSettlementService {

    private TaskSettlementDao taskSettlementDao;

    public TaskSettlementDao getTaskSettlementDao() {
        return taskSettlementDao;
    }

    @Autowired
    public void setTaskSettlementDao(TaskSettlementDao taskSettlementDao) {
        this.taskSettlementDao = taskSettlementDao;
    }

    /**
     * 每日自动结算任务
     */
    public void settle() {
        List<FirstLevelTaskPO> targetFLTs = taskSettlementDao.getAllRequireSettlementTask();
        Set<Integer> targetFLTIds = targetFLTs.stream().map(FirstLevelTaskPO::getId)
                .collect(Collectors.toSet());
        List<SecondLevelTaskPO> targetSLTs = taskSettlementDao.getSecondLevelTasksByIds(targetFLTIds);

    }


}
