package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.domain.statistic.RankItem;
import top.minecode.po.DataBase;
import top.minecode.po.RankPO;
import top.minecode.service.statistic.StatisticConstant;
import top.minecode.utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class WorkerStatisticDao {

    public List<RankItem> getWorkerRank() {
        RankPO rankPO = DataBase.rankPO;
        List<Pair<String, Double>> poRanks = rankPO.getRank();

        // 获取最终排行榜会显示的人数
        int length = poRanks.size() > StatisticConstant.RANK_BOARD_SHOW_COUNT
                ? poRanks.size() : StatisticConstant.RANK_BOARD_SHOW_COUNT;

        // 获取排行榜信息
        return poRanks.subList(0, length).stream().map(
                e -> new RankItem(e.getRight(), e.getLeft())
        ).collect(Collectors.toList());
    }

}
