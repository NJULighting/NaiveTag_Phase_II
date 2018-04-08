package top.minecode.po;

import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.task.WorkerGeneralTaskInfo;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class ThirdLevelTaskPO {

    private Integer id;

    private Integer secondLevelTaskId;

    private String taskName;

    private Double standardScore;

    private LocalDate endDate; //任务本身的截止日期，也就是payDay

    private Integer taskDetailsId;

    private List<String> picList;

    private List<Integer> currentDoingWorkerIds; //当前正在做这个任务的Worker的集合

    private List<Integer> finishedWorkerIds; // 完成过这个任务的Worker的集合

    private Integer workerFilterId;

    private Integer taskType;

    private ThirdLevelTaskState state;

    public Integer getWorkerFilterId() {
        return workerFilterId;
    }

    public void setWorkerFilterId(Integer workerFilterId) {
        this.workerFilterId = workerFilterId;
    }

    public List<Integer> getCurrentDoingWorkerIds() {
        return currentDoingWorkerIds;
    }

    public void setCurrentDoingWorkerIds(List<Integer> currentDoingWorkerIds) {
        this.currentDoingWorkerIds = currentDoingWorkerIds;
    }

    public List<Integer> getFinishedWorkerIds() {
        return finishedWorkerIds;
    }

    public void setFinishedWorkerIds(List<Integer> finishedWorkerIds) {
        this.finishedWorkerIds = finishedWorkerIds;
    }


    public ThirdLevelTaskState getState() {
        return state;
    }

    public void setState(ThirdLevelTaskState state) {
        this.state = state;
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

    public WorkerGeneralTaskInfo toGeneralTaskInfo() {
        WorkerGeneralTaskInfo info = new WorkerGeneralTaskInfo();
        info.setAverageScore(standardScore);
        info.setTaskId(id);
        info.setTaskName(taskName);
        info.setTaskType(taskType);
        info.setPayDay(endDate);
        info.setPicAmount(picList.size());
        info.setCover(picList.get(0)); //默认封面就是0
        return info;
    }
}
