package top.minecode.po;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.time.LocalDate;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class WorkerFilterPO {

    private Integer id;
    private Integer workerRank;
    private Double score;
    private LocalDate startTime;
    private LocalDate endTime;

    public WorkerFilterPO(Integer id, Integer workerRank, Double score, LocalDate startTime, LocalDate endTime) {
        this.id = id;
        this.workerRank = workerRank;
        this.score = score;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Nullable
    public Integer getWorkerRank() {
        return workerRank;
    }

    public void setWorkerRank(Integer workerRank) {
        this.workerRank = workerRank;
    }

    @Nullable
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull LocalDate endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
