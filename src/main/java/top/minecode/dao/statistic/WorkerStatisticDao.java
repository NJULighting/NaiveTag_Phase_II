package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.domain.statistic.RankItem;
import top.minecode.po.RankTable;
import top.minecode.po.TableFactory;
import top.minecode.po.WorkerSettlementLogPO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/4.
 * Description:
 * @author iznauy
 */
@Repository
public class WorkerStatisticDao {

    public List<RankItem> getWorkersRank() {
        RankTable rankTable = TableFactory.rankTable();

        // 获取排行榜信息
        return rankTable.getWorkerRank();
    }

    public int getWorkerRank(int userId) {
        return TableFactory.rankTable().getRankById(userId);
    }

    public List<Double> getWorkerSettlementHistory(int userId) {
        List<WorkerSettlementLogPO> settlementLogs = TableFactory
                .workerSettlementLogTable().getPOsBy(userId, WorkerSettlementLogPO::getUserId);
        Collections.sort(settlementLogs);
        return settlementLogs.stream().map(WorkerSettlementLogPO::getEarnedScore)
                .collect(Collectors.toList());
    }

}