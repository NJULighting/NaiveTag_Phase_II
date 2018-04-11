package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
@Deprecated
public class TaskDetailsPOList {

    private List<TaskDetailsPO> taskDetailsPOS;

    public List<TaskDetailsPO> getTaskDetailsPOS() {
        return taskDetailsPOS;
    }

    public void setTaskDetailsPOS(List<TaskDetailsPO> taskDetailsPOS) {
        this.taskDetailsPOS = taskDetailsPOS;
    }

    public TaskDetailsPO getTaskDetailsById(Integer id) {
        return taskDetailsPOS.stream().filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Integer getNextTaskDetailsId() {
        return taskDetailsPOS.size() + 1;
    }
}
