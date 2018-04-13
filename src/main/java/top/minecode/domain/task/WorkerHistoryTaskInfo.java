package top.minecode.domain.task;

import top.minecode.domain.task.WorkerGeneralTaskInfo;

import java.time.LocalDate;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public class WorkerHistoryTaskInfo extends WorkerGeneralTaskInfo implements Comparable<WorkerHistoryTaskInfo> {

    private Double actualScore;

    private LocalDate beginDate;

    private LocalDate endDate;

    private double process;

    private ThirdLevelTaskResultType state;

    public WorkerHistoryTaskInfo() {
    }

    public WorkerHistoryTaskInfo(int taskId, int taskType, String taskName,
                                 Double averageScore, LocalDate payDay, int picAmount,
                                 String cover, Double actualScore, LocalDate beginDate,
                                 LocalDate endDate, double process, ThirdLevelTaskResultType state) {
        super(taskId, taskType, taskName, averageScore, payDay, picAmount, cover);
        this.actualScore = actualScore;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.process = process;
        this.state = state;
    }

    public ThirdLevelTaskResultType getState() {
        return state;
    }

    public void setState(ThirdLevelTaskResultType state) {
        this.state = state;
    }

    public double getProcess() {
        return process;
    }

    public void setProcess(double process) {
        this.process = process;
    }

    public Double getActualScore() {
        return actualScore;
    }

    public void setActualScore(Double actualScore) {
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

    @Override
    public int compareTo(WorkerHistoryTaskInfo o) {
        return this.beginDate.isBefore(o.beginDate) ? -1 : 1;
    }
}
