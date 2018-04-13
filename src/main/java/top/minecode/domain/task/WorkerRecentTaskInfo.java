package top.minecode.domain.task;

/**
 * Created on 2018/4/13.
 * Description:
 *
 * @author iznauy
 */
public class WorkerRecentTaskInfo {

    private int taskId;

    private int taskType;

    private String taskName;

    private Double averageScore;

    private double process;

    private String cover;

    public WorkerRecentTaskInfo() {
    }

    public WorkerRecentTaskInfo(int taskId, int taskType, String taskName,
                                Double averageScore, double process, String cover) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskName = taskName;
        this.averageScore = averageScore;
        this.process = process;
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

    public double getProcess() {
        return process;
    }

    public void setProcess(double process) {
        this.process = process;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
