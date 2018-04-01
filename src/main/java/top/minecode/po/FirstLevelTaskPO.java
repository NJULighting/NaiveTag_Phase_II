package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class FirstLevelTaskPO {

    private Integer id;

    private Integer ownerId;

    private String taskName;

    private List<Integer> secondLevelTaskIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Integer> getSecondLevelTaskIds() {
        return secondLevelTaskIds;
    }

    public void setSecondLevelTaskIds(List<Integer> secondLevelTaskIds) {
        this.secondLevelTaskIds = secondLevelTaskIds;
    }
}
