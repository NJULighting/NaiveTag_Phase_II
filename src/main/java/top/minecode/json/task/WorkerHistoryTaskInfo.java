package top.minecode.json.task;

import java.time.LocalDate;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public class WorkerHistoryTaskInfo extends WorkerGeneralTaskInfo {

    private double actualScore;

    private String process;

    private LocalDate beginDate;

    private LocalDate endDate;

    public double getActualScore() {
        return actualScore;
    }

    public void setActualScore(double actualScore) {
        this.actualScore = actualScore;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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
