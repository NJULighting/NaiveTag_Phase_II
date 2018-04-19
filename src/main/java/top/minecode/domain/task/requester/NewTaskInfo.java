package top.minecode.domain.task.requester;

import java.time.LocalDate;

/**
 * Created on 2018/4/14.
 * Description:
 * @author Liao
 */
public class NewTaskInfo {
    private Integer ownerId;
    private String taskName; // Task
    private WorkerFilter workerFilter; // The limit set for worker
    private LocalDate endTime; // DDL of the task
    private Double score; // Score provided for the workers

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public WorkerFilter getWorkerFilter() {
        return workerFilter;
    }

    public void setWorkerFilter(WorkerFilter workerFilter) {
        this.workerFilter = workerFilter;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public static class WorkerFilter {
        private Double workerRankRate;
        private Double averageScore;

        public Double getWorkerRankRate() {
            return workerRankRate;
        }

        public void setWorkerRankRate(Double workerRankRate) {
            this.workerRankRate = workerRankRate;
        }

        public Double getAverageScore() {
            return averageScore;
        }

        public void setAverageScore(Double averageScore) {
            this.averageScore = averageScore;
        }
    }

}

