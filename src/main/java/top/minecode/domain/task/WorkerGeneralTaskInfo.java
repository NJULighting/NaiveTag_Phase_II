package top.minecode.domain.task;

import java.time.LocalDate;

/**
 * Created on 2018/4/4.
 * Description: 作为推荐系统和搜索结果的一项呈现
 *
 * @author iznauy
 */
public class WorkerGeneralTaskInfo {

    private int taskId;

    private int taskType;

    private String taskName;

    private Double averageScore;

    private LocalDate payDay;

    private int picAmount;

    private String cover;

    public WorkerGeneralTaskInfo() {
    }

    public WorkerGeneralTaskInfo(int taskId, int taskType,
                                 String taskName, Double averageScore,
                                 LocalDate payDay, int picAmount, String cover) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskName = taskName;
        this.averageScore = averageScore;
        this.payDay = payDay;
        this.picAmount = picAmount;
        this.cover = cover;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    public int getPicAmount() {
        return picAmount;
    }

    public void setPicAmount(int picAmount) {
        this.picAmount = picAmount;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
