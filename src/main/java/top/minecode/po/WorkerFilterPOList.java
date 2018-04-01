package top.minecode.po;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerFilterPOList {

    private List<WorkerFilterPO> workerFilterList;

    public WorkerFilterPOList(List<WorkerFilterPO> workerFilterList) {
        this.workerFilterList = workerFilterList;
    }

    public WorkerFilterPO getWorkerFilter(int id) {
        return workerFilterList.stream().filter(f -> f.getId() == id)
                .findFirst().orElseThrow(NoSuchElementException::new);
    }
}
