package top.minecode.domain.task.requester;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2018/4/14.
 * Description:
 *
 * @author iznauy
 */
public class TaskResult {

    List<SubTaskResult> subTasks;

    public TaskResult() {
        subTasks = new LinkedList<>();
    }

    public TaskResult(List<SubTaskResult> subTasks) {
        this.subTasks = subTasks;
    }

    public List<SubTaskResult> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskResult> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTasks(SubTaskResult subTaskResult) {
        subTasks.add(subTaskResult);
    }

}
