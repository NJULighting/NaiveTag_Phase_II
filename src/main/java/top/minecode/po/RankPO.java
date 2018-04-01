package top.minecode.po;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
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

    public @Nullable Integer getRankByName(@NotNull String name) {
        for (int i = 0; i < rank.size(); i++)
            if (rank.get(i).getLeft().equals(name))
                return i + 1;
        return null;
    }

}
