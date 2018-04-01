package top.minecode.po;

import top.minecode.utils.Pair;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class RankPO {

    private List<Pair<String, Double>> rank;

    public List<Pair<String, Double>> getRank() {
        return rank;
    }

    public void setRank(List<Pair<String, Double>> rank) {
        this.rank = rank;
    }
    
}
