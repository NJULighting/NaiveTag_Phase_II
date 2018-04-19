package top.minecode.po;


import top.minecode.domain.task.requester.NewTaskInfo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerFilterPO implements Serializable {

    private Integer id;
    private Double workerRankRatio;
    private Double averageScore;

    public WorkerFilterPO(NewTaskInfo.WorkerFilter workerFilter, int id) {
        workerRankRatio = workerFilter.getWorkerRankRate();
        averageScore = workerFilter.getAverageScore();

        this.id = id;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getWorkerRankRatio() {
        return workerRankRatio;
    }

    public void setWorkerRankRatio(Double workerRankRatio) {
        this.workerRankRatio = workerRankRatio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WorkerFilterPO{" +
                "id=" + id +
                ", workerRankRatio=" + workerRankRatio +
                '}';
    }
}
