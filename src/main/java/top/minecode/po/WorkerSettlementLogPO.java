package top.minecode.po;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 2018/4/14.
 * Description:
 *
 * @author iznauy
 */
public class WorkerSettlementLogPO implements Serializable, Comparable<WorkerSettlementLogPO> {

    private Integer taskType;

    private LocalDate settleTime;

    private Integer userId;

    private Double earnedScore = 0.0;

    public WorkerSettlementLogPO() {
        settleTime = LocalDate.now();
    }

    public WorkerSettlementLogPO(Integer taskType,
                                 Integer userId, Double earnedScore) {
        this();
        this.taskType = taskType;
        this.userId = userId;
        this.earnedScore = earnedScore;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public LocalDate getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(LocalDate settleTime) {
        this.settleTime = settleTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getEarnedScore() {
        return earnedScore;
    }

    public void setEarnedScore(Double earnedScore) {
        this.earnedScore = earnedScore;
    }

    @Override
    public int compareTo(@NotNull WorkerSettlementLogPO o) {
        return settleTime.isBefore(o.settleTime) ? -1 : 1;
    }

    @Override
    public String toString() {
        return "WorkerSettlementLogPO{" +
                "taskType=" + taskType +
                ", settleTime=" + settleTime +
                ", userId=" + userId +
                ", earnedScore=" + earnedScore +
                '}';
    }

}
