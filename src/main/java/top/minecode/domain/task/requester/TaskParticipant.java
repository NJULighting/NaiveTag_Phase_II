package top.minecode.domain.task.requester;

import top.minecode.json.JsonConfig;

/**
 * Created on 2018/4/11.
 * Description:
 * @author Liao
 */
public class TaskParticipant {

    private Integer rank;
    private double ability; // Average score ratio
    private double rankRate;

    public TaskParticipant(Integer rank, double ability, double rankRate) {
        this.rank = rank;
        this.ability = ability;
        this.rankRate = rankRate;
    }

    public String toJson() {
        return JsonConfig.getGson().toJson(this);
    }

    public Integer getRank() {
        return rank;
    }

    public double getAbility() {
        return ability;
    }

    public double getRankRate() {
        return rankRate;
    }

    @Override
    public String toString() {
        return "TaskParticipant{" +
                "rank=" + rank +
                ", ability=" + ability +
                ", rankRate=" + rankRate +
                '}';
    }
}
