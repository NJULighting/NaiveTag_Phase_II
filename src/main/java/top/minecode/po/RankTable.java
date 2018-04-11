package top.minecode.po;

import top.minecode.domain.statistic.RankItem;
import top.minecode.service.statistic.StatisticConstant;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    }


    public Integer getRankByName(String name) {
        List<RankItem> rankItems = rank.getAll();
        for (int i = 0; i < rankItems.size(); i++) {
            if (rankItems.get(i).getName().equals(name))
                return i;
        }

        return null;
    }

    public void add(RankItem rankItem) {
        // Add and sort
        List<RankItem> rankItems = rank.getAll();
        rankItems.add(rankItem);
        sort();
        // Update the file
        rank.save();
    }

    public List<RankItem> getWorkerRank() {
        int length = rank.size() > StatisticConstant.RANK_BOARD_SHOW_COUNT
                ? rank.size() : StatisticConstant.RANK_BOARD_SHOW_COUNT;

        sort();

        return rank.getAll().subList(0, length);
    }

    private void sort() {
        rank.getAll().sort(Comparator.comparing(RankItem::getScore));
    }
}
