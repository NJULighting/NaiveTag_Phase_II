package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.domain.statistic.RankItem;
import top.minecode.po.RankTable;
import top.minecode.po.TableFactory;

import java.util.List;

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

}