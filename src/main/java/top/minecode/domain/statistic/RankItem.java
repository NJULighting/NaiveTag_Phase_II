package top.minecode.domain.statistic;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public class RankItem {

    private Double score;

    private String name;

    public RankItem() {

    }

    public RankItem(Double score, String name) {
        this.score = score;
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
