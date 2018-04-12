package top.minecode.domain.task.requester;

import top.minecode.json.JsonConfig;
import top.minecode.po.FirstLevelTaskPO;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class RequesterTaskInfo {

    private String name;
    private int taskId;
    private double process;
    private Result result;

    public RequesterTaskInfo(FirstLevelTaskPO po, double process) {
        name = po.getTaskName();
        taskId = po.getId();
        this.process = process;
        result = process >= 1 ? Result.completed : Result.ongoing;
    }

    public String getName() {
        return name;
    }

    public int getTaskId() {
        return taskId;
    }

    public double getProcess() {
        return process;
    }

    public Result getResult() {
        return result;
    }

    public String toJson() {
        return JsonConfig.getGson().toJson(this);
    }

    public enum Result {
        ongoing,
        completed
    }


}
