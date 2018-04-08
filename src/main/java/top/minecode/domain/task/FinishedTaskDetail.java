package top.minecode.domain.task;

import java.time.LocalDate;

/**
 * Created on 2018/4/8.
 * Description:
 *
 * @author iznauy
 */
public class FinishedTaskDetail extends WorkerTaskDetail {

    private double earnedScore;

    private LocalDate beginDate;

    private LocalDate endDate;

    public double getEarnedScore() {
        return earnedScore;
    }

    public void setEarnedScore(double earnedScore) {
        this.earnedScore = earnedScore;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
