package top.minecode.domain.task;

/**
 * Created on 2018/4/4.
 * Description: 通用的任务描述父类
 *
 * @author iznauy
 */
public abstract class TaskInfo {

    private Integer taskType;

    private String format;

    private String description;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
}
