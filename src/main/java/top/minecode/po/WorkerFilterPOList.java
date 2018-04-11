package top.minecode.po;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
@Deprecated
public class WorkerFilterPOList {

    private List<WorkerFilterPO> workerFilterList;

    public WorkerFilterPOList() {
    }

    public List<WorkerFilterPO> getWorkerFilterList() {
        return workerFilterList;
    }

    public void setWorkerFilterList(List<WorkerFilterPO> workerFilterList) {
        this.workerFilterList = workerFilterList;
    }
}
