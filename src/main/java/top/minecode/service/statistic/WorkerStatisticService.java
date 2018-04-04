package top.minecode.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.statistic.WorkerStatisticDao;
import top.minecode.domain.statistic.RankItem;

import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class WorkerStatisticService {

    private WorkerStatisticDao workerStatisticDao;

    public void setWorkerStatisticDao(WorkerStatisticDao workerStatisticDao) {
        this.workerStatisticDao = workerStatisticDao;
    }

    @Autowired
    public WorkerStatisticDao getWorkerStatisticDao() {
        return workerStatisticDao;
    }

    public List<RankItem> getWorkerRank() {
        return workerStatisticDao.getWorkerRank();
    }

}