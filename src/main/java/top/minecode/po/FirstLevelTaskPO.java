package top.minecode.po;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class FirstLevelTaskPO implements Serializable {

    private Integer id;

    private Integer ownerId;

    private String taskName;

    private Double totalScore;

    private LocalDate endDate;

    private String resultFilePath;

    private FirstLevelTaskState state;

    public String getResultFilePath() {
        return resultFilePath;
    }

    public void setResultFilePath(String resultFilePath) {
        this.resultFilePath = resultFilePath;
    }

    public FirstLevelTaskState getState() {
        return state;
    }

    public void setState(FirstLevelTaskState state) {
        this.state = state;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
