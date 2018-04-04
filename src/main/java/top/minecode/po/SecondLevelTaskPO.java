package top.minecode.po;

import top.minecode.domain.task.TaskInfo;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class SecondLevelTaskPO {

    private Integer id;

    private Integer firstLevelTaskId;

    private String taskName;

    private Double totalScore;

    private LocalDate endDate;

    private Integer taskDetailsId;

    private TaskInfo taskInfo;

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstLevelTaskId() {
        return firstLevelTaskId;
    }

    public void setFirstLevelTaskId(Integer firstLevelTaskId) {
        this.firstLevelTaskId = firstLevelTaskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getTaskDetailsId() {
        return taskDetailsId;
    }

    public void setTaskDetailsId(Integer taskDetailsId) {
        this.taskDetailsId = taskDetailsId;
    }
}
