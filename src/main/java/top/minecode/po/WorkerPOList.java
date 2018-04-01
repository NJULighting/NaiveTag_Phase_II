package top.minecode.po;

import java.util.Collections;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerPOList {
    private List<WorkerPO> workerList;

    public WorkerPOList(List<WorkerPO> workerList) {
        this.workerList = workerList;
    }

    public boolean loginValid(String username, String password) {
        return workerList.stream()
                .anyMatch(w -> w.getUsername().equals(username) && w.getPassword().equals(password));
    }
}
