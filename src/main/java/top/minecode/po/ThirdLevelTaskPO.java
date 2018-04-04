package top.minecode.po;

import top.minecode.domain.task.ThirdLevelTaskState;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class ThirdLevelTaskPO {

    private Integer taskSize; // equals to picList.size();

    private Integer id;

    private Integer secondLevelTaskId;

    private String taskName;

    private Double standardScore;

    private LocalDate endDate;

    private Integer taskDetailsId;

    private List<String> picList;

    private Integer currentAcceptedCount = 0; // 这个任务当前有多少人接受了，且正在进行。

    private Integer finishCount = 0;  // 这个任务已经被多少人完成了

    private Integer taskType;

    private ThirdLevelTaskState state;

    public Integer getCurrentAcceptedCount() {
        return currentAcceptedCount;
    }

    public void setCurrentAcceptedCount(Integer currentAcceptedCount) {
        this.currentAcceptedCount = currentAcceptedCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    public ThirdLevelTaskState getState() {
        return state;
    }

    public void setState(ThirdLevelTaskState state) {
        this.state = state;
    }

    public Integer getTaskSize() {
        return taskSize;
    }

    public void setTaskSize(Integer taskSize) {
        this.taskSize = taskSize;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecondLevelTaskId() {
        return secondLevelTaskId;
    }

    public void setSecondLevelTaskId(Integer secondLevelTaskId) {
        this.secondLevelTaskId = secondLevelTaskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Double getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(Double standardScore) {
        this.standardScore = standardScore;
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

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }
}
