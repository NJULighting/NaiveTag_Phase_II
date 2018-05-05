package top.minecode.po;

import top.minecode.domain.statistic.RankItem;
import top.minecode.service.statistic.StatisticConstant;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class RankTable implements Serializable {

    private Table<RankItem> rank;
    private static final String TABLE_NAME = "rank";

    RankTable() {
        rank = new Table<>(TABLE_NAME);
        updateRankTable();
    }

    public void save() {
        updateRankTable();
        rank.save();
    }

    public void printContent() {
        rank.printContent();
    }

    public Integer getRankByName(String name) {
        updateRankTable();
        List<RankItem> rankItems = rank.getAll();
        for (int i = 0; i < rankItems.size(); i++) {
            if (rankItems.get(i).getName().equals(name))
                return i + 1;
        }

        // If the user has no rank, then return the end of the rank list
        return rankItems.size() + 1;
    }

    public Integer getRankById(int id) {
        updateRankTable();
        String name = TableFactory.workerTable().getPOBy(id, WorkerPO::getId).getName();
        return getRankByName(name);
    }

    public double getRankRatio(int id) {
        return getRankById(id) * 1.0 / rank.size();
    }

    public List<RankItem> getWorkerRank() {
        updateRankTable();
        int length = rank.size() < StatisticConstant.RANK_BOARD_SHOW_COUNT
                ? rank.size() : StatisticConstant.RANK_BOARD_SHOW_COUNT;

        return rank.getAll().subList(0, length);
    }

    private void updateRankTable() {
        // Load from worker table
        Table<WorkerPO> workerTable = TableFactory.workerTable();
        rank.setPos(workerTable.getAll().stream().map(RankItem::new).collect(Collectors.toList()));

        // sort the table
        rank.getAll().sort(Comparator.comparing(RankItem::getScore, Comparator.reverseOrder()));
    }
}
