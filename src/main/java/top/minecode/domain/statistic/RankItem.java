package top.minecode.domain.statistic;

import top.minecode.po.WorkerPO;

import java.io.Serializable;

/**
 * Created on 2018/4/4.
 * Description:
 * @author iznauy
 */
public class RankItem implements Serializable {

    private Double score;

    private String name;

    public RankItem() {
    }

    public RankItem(Double score, String name) {
        this.score = score;
        this.name = name;
    }

    public RankItem(WorkerPO worker) {
        score = worker.getScores();
        name = worker.getName();
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
