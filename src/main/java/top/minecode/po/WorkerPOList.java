package top.minecode.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
@Deprecated
public class WorkerPOList extends Table {

    private List<WorkerPO> workerList;

    public WorkerPOList() {
        super();
    }

    public List<WorkerPO> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<WorkerPO> workerList) {
        this.workerList = workerList;
    }

    public boolean addWorkerPO(WorkerPO po) {
        workerList.add(po);

        // 增加用户后保存
        save();
        return true;
    }

    public Integer getNextWorkerId() {
        return workerList.size() + 1;
    }

    @Override
    protected String getFileName() {
        return "work.json";
    }

    @Override
    protected void load() {
        String json = loadFromFile();
        if (json == null)
            workerList = new ArrayList<>();
        else {
            WorkerPOList list = POConfig.gson.fromJson(json, WorkerPOList.class);
            this.workerList = list.workerList;
        }
    }

    @Override
    protected void save() {
        String json = POConfig.gson.toJson(this);
        writeToFile(json);
    }
}
