package top.minecode.domain.task;

import java.util.List;

/**
 * Created on 2018/4/4.
 * Description: 通用的任务描述父类
 *
 * @author iznauy
 */
public class TaskInfo {

    private Integer taskType;
    private String description;
    private List<String> classes;

    public TaskInfo(int taskType, String description) {
        this.taskType = taskType;
        this.description = description;
    }

    public TaskInfo(int taskType, String description, List<String> classes) {
        this(taskType, description);
        this.classes = classes;
    }

    public List<String> getClasses() {
        return classes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "taskType=" + taskType +
                ", description='" + description + '\'' +
                ", classes=" + classes +
                '}';
    }
}
