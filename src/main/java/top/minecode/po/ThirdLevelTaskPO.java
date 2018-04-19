package top.minecode.po;

import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.task.WorkerGeneralTaskInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class ThirdLevelTaskPO implements Serializable {

    private Integer id;
    private Integer secondLevelTaskId;
    private String taskName;
    private Double standardScore;
    private LocalDate endDate; //任务本身的截止日期，也就是payDay
    private Integer taskDetailsId;
    private List<String> picList;
    private String taskDescription;
    private List<Integer> currentDoingWorkerIds; //当前正在做这个任务的Worker的集合
    private List<Integer> finishedWorkerIds; // 完成过这个任务的Worker的集合
    private Integer workerFilterId;
    private Integer taskType;
    private ThirdLevelTaskState state;

    public ThirdLevelTaskPO() {
    }

    public ThirdLevelTaskPO(int id, int secondLevelTaskId, String taskName, Double standardScore, LocalDate endDate,
                            int taskDetailsId, List<String> picList, String taskDescription, int workerFilterId,
                            int taskType) {
        this.id = id;
        this.secondLevelTaskId = secondLevelTaskId;
        this.taskName = taskName;
        this.standardScore = standardScore;
        this.endDate = endDate;
        this.taskDetailsId = taskDetailsId;
        this.picList = picList;
        this.taskDescription = taskDescription;
        this.workerFilterId = workerFilterId;
        this.taskType = taskType;

        currentDoingWorkerIds = new ArrayList<>();
        finishedWorkerIds = new ArrayList<>();
        state = ThirdLevelTaskState.doing;
    }

    public Integer getWorkerFilterId() {
        return workerFilterId;
    }

    public List<Integer> getParticipants() {
        List<Integer> participants = new ArrayList<>();
        participants.addAll(currentDoingWorkerIds);
        participants.addAll(finishedWorkerIds);
        return participants;
    }

    public void setWorkerFilterId(Integer workerFilterId) {
        this.workerFilterId = workerFilterId;
    }

    public int getFinishedPeopleNum() {
        return finishedWorkerIds.size();
    }

    public boolean isFinished() {
        return state == ThirdLevelTaskState.finished;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    public String getCover() {
        return picList.get(0);
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

    @Override
    public String toString() {
        return "ThirdLevelTaskPO{" +
                "id=" + id +
                ", secondLevelTaskId=" + secondLevelTaskId +
                ", taskName='" + taskName + '\'' +
                ", standardScore=" + standardScore +
                ", endDate=" + endDate +
                ", taskDetailsId=" + taskDetailsId +
                ", picList=" + picList +
                ", taskDescription='" + taskDescription + '\'' +
                ", currentDoingWorkerIds=" + currentDoingWorkerIds +
                ", finishedWorkerIds=" + finishedWorkerIds +
                ", workerFilterId=" + workerFilterId +
                ", taskType=" + taskType +
                ", state=" + state +
                '}';
    }
}
