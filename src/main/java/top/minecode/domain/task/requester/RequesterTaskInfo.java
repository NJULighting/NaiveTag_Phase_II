package top.minecode.domain.task.requester;

import top.minecode.json.JsonConfig;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.FirstLevelTaskState;

import java.time.LocalDate;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class RequesterTaskInfo {

    private String taskName;
    private int taskId;
    private double process;
    private LocalDate endDate;
    private FirstLevelTaskState state;

    public RequesterTaskInfo(FirstLevelTaskPO po, double process) {
        taskName = po.getTaskName();
        taskId = po.getId();
        this.process = process;
        this.endDate = po.getEndDate();
        state = process >= 1 ? FirstLevelTaskState.completed : FirstLevelTaskState.ongoing;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public double getProcess() {
        return process;
    }

    public FirstLevelTaskState getState() {
        return state;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String toJson() {
        return JsonConfig.getGson().toJson(this);
    }

}
