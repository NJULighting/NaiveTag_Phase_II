package top.minecode.po;

import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class TaskDetailsPO {

    private Integer id;

    private Integer correspondingSecondLevelTaskId;

    private Integer taskType;

    private String taskDescription;

    private @Nullable List<String> targetClasses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorrespondingSecondLevelTaskId() {
        return correspondingSecondLevelTaskId;
    }

    public void setCorrespondingSecondLevelTaskId(Integer correspondingSecondLevelTaskId) {
        this.correspondingSecondLevelTaskId = correspondingSecondLevelTaskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public List<String> getTargetClasses() {
        return targetClasses;
    }

    public void setTargetClasses(List<String> targetClasses) {
        this.targetClasses = targetClasses;
    }
}
