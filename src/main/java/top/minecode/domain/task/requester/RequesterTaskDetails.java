package top.minecode.domain.task.requester;

import top.minecode.domain.task.requester.RequesterTaskInfo;

import java.util.List;

/**
 * Created on 2018/4/11.
 * Description:
 * @author Liao
 */
public class RequesterTaskDetails {

    private RequesterTaskInfo taskInfo;
    private List<TaskParticipant> participants;

    public RequesterTaskDetails(RequesterTaskInfo taskInfo, List<TaskParticipant> participants) {
        this.taskInfo = taskInfo;
        this.participants = participants;
    }

    public RequesterTaskInfo getTaskInfo() {
        return taskInfo;
    }

    public List<TaskParticipant> getParticipants() {
        return participants;
    }
}
