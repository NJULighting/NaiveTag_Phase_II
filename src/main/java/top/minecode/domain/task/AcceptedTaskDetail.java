package top.minecode.domain.task;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/8.
 * Description:
 *
 * @author iznauy
 */
public class AcceptedTaskDetail extends WorkerTaskDetail {

    private double averageScore;

    private List<String> finishedPicList;

    private List<String> unfinishedPicList;

    private LocalDate beginDate;

    private LocalDate endDate;

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<String> getFinishedPicList() {
        return finishedPicList;
    }

    public void setFinishedPicList(List<String> finishedPicList) {
        this.finishedPicList = finishedPicList;
    }

    public List<String> getUnfinishedPicList() {
        return unfinishedPicList;
    }

    public void setUnfinishedPicList(List<String> unfinishedPicList) {
        this.unfinishedPicList = unfinishedPicList;
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
