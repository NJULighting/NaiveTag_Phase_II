package top.minecode.po;

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

    private List<Integer> thirdLevelTaskIds;

    private Double totalScore;

    private LocalDate endDate;

    private Integer taskDetailsId;

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

    public List<Integer> getThirdLevelTaskIds() {
        return thirdLevelTaskIds;
    }

    public void setThirdLevelTaskIds(List<Integer> thirdLevelTaskIds) {
        this.thirdLevelTaskIds = thirdLevelTaskIds;
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
