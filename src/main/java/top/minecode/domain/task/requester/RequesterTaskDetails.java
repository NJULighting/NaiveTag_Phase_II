package top.minecode.domain.task.requester;

import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.json.JsonConfig;

import java.util.List;

/**
 * Created on 2018/4/11.
 * Description:
 * @author Liao
 */
public class RequesterTaskDetails {

    private double taskProcess;
    private List<TaskParticipant> participants;

    public RequesterTaskDetails(double taskProcess, List<TaskParticipant> participants) {
        this.taskProcess = taskProcess;
        this.participants = participants;
    }

    public List<TaskParticipant> getParticipants() {
        return participants;
    }

    public double getTaskProcess() {
        return taskProcess;
    }

    public String toJson() {
        return JsonConfig.getGson().toJson(this);
    }
}
