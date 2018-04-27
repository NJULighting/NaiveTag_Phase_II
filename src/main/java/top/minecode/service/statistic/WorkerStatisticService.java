package top.minecode.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.statistic.WorkerStatisticDao;
import top.minecode.domain.statistic.RankItem;
import top.minecode.domain.user.User;

import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class WorkerStatisticService {

    private WorkerStatisticDao workerStatisticDao;

    @Autowired
    public void setWorkerStatisticDao(WorkerStatisticDao workerStatisticDao) {
        this.workerStatisticDao = workerStatisticDao;
    }

    public WorkerStatisticDao getWorkerStatisticDao() {
        return workerStatisticDao;
    }

    public List<RankItem> getWorkersRank() {
        return workerStatisticDao.getWorkersRank();
    }

    public int getWorkerRank(User user) {
        return workerStatisticDao.getWorkerRank(user.getId());
    }

    public List<Double> getUserAbilityChanges(User user) {
        return workerStatisticDao.getWorkerSettlementHistory(user.getId());
    }

}
