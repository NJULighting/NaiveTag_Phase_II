package top.minecode.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class TaskDetailsPO implements Serializable {

    private Integer id;
    private Integer SLTaskId;
    private Integer taskType;
    private String description;
    private List<String> classes;

    public TaskDetailsPO(int id, int SLTaskId, int taskType, String description, List<String> classes) {
        this.id = id;
        this.SLTaskId = SLTaskId;
        this.taskType = taskType;
        this.description = description;
        this.classes = classes;
    }

    public TaskDetailsPO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSLTaskId() {
        return SLTaskId;
    }

    public void setSLTaskId(Integer SLTaskId) {
        this.SLTaskId = SLTaskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "TaskDetailsPO{" +
                "id=" + id +
                ", SLTaskId=" + SLTaskId +
                ", taskType=" + taskType +
                ", description='" + description + '\'' +
                ", classes=" + classes +
                '}';
    }
}
