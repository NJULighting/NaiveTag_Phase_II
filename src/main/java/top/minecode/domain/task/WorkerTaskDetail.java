package top.minecode.domain.task;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public abstract class WorkerTaskDetail {

    private WorkerTaskState state;

    private String cover;

    private String taskName;

    private int taskType;

    private String taskDescription;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public WorkerTaskState getState() {
        return state;
    }

    public void setState(WorkerTaskState state) {
        this.state = state;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
