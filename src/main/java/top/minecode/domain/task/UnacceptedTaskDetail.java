package top.minecode.domain.task;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/8.
 * Description:
 *
 * @author iznauy
 */
public class UnacceptedTaskDetail extends WorkerTaskDetail {

    private double averageScore;

    private List<String> picList;

    private LocalDate payDay;

    private boolean canAccept;

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    public boolean isCanAccept() {
        return canAccept;
    }

    public void setCanAccept(boolean canAccept) {
        this.canAccept = canAccept;
    }
}
