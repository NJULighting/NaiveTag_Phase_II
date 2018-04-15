package top.minecode.po;


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
    private LocalDate startTime;
    private LocalDate endTime;

    public Double getWorkerRankRatio() {
        return workerRankRatio;
    }

    public void setWorkerRankRatio(Double workerRankRatio) {
        this.workerRankRatio = workerRankRatio;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
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
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
