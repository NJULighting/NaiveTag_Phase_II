package top.minecode.domain.task;

import top.minecode.domain.task.WorkerGeneralTaskInfo;

import java.time.LocalDate;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public class WorkerHistoryTaskInfo extends WorkerGeneralTaskInfo {

    private double actualScore;

    private LocalDate beginDate;

    private LocalDate endDate;

    private double process;

    public double getProcess() {
        return process;
    }

    public void setProcess(double process) {
        this.process = process;
    }

    public double getActualScore() {
        return actualScore;
    }

    public void setActualScore(double actualScore) {
        this.actualScore = actualScore;
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
