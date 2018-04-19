package top.minecode.po;

import top.minecode.domain.task.TaskInfo;
import top.minecode.utils.Config;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class SecondLevelTaskPO implements Serializable {

    private Integer id;
    private Integer firstLevelTaskId;
    private String taskName;
    private Double totalScore;
    private LocalDate endDate;
    private Integer taskDetailsId;

    public SecondLevelTaskPO(int id, int firstLevelTaskId, String taskName, double totalScore, LocalDate endDate,
                             int taskDetailsId) {
        this.id = id;
        this.firstLevelTaskId = firstLevelTaskId;
        this.taskName = taskName;
        this.totalScore = totalScore;
        this.endDate = endDate;
        this.taskDetailsId = taskDetailsId;
    }

    public TaskInfo getTaskInfo() {
        Table<TaskDetailsPO> taskDetailsTable = TableFactory.taskDetailsTable();
        TaskDetailsPO detail = taskDetailsTable.getPOBy(taskDetailsId, TaskDetailsPO::getId);

        if (Config.INSTANCE.isWithClassesType(detail.getTaskType()))
            return new TaskInfo(detail.getTaskType(), detail.getDescription(), detail.getClasses());
        return new TaskInfo(detail.getTaskType(), detail.getDescription());
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

    @Override
    public String toString() {
        return "SecondLevelTaskPO{" +
                "id=" + id +
                ", firstLevelTaskId=" + firstLevelTaskId +
                ", taskName='" + taskName + '\'' +
                ", totalScore=" + totalScore +
                ", endDate=" + endDate +
                ", taskDetailsId=" + taskDetailsId +
                ", taskInfo="  +
                '}';
    }
}
