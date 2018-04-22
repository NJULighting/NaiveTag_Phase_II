package top.minecode.domain.statistic;

import top.minecode.domain.statistic.TimeNumberGraph.GraphPoint;

import java.util.List;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
public class WebStatisticInfo {

    private final int taskQuantity;
    private final int completedTask;
    private final List<GraphPoint> activeWorkerTrend;
    private final List<GraphPoint> totalWorkerTrend;
    private final List<GraphPoint> totalRequesterTrend;

    public WebStatisticInfo(int taskQuantity, int completedTask, TimeNumberGraph activeWorkerTrend,
                            TimeNumberGraph totalWorkerTrend, TimeNumberGraph totalRequesterTrend) {
        this.taskQuantity = taskQuantity;
        this.completedTask = completedTask;
        this.activeWorkerTrend = activeWorkerTrend.getDots();
        this.totalWorkerTrend = totalWorkerTrend.getDots();
        this.totalRequesterTrend = totalRequesterTrend.getDots();
    }

    public int getTaskQuantity() {
        return taskQuantity;
    }

    public int getCompletedTask() {
        return completedTask;
    }

    public List<GraphPoint> getActiveWorkerTrend() {
        return activeWorkerTrend;
    }

    public List<GraphPoint> getTotalWorkerTrend() {
        return totalWorkerTrend;
    }

    public List<GraphPoint> getTotalRequesterTrend() {
        return totalRequesterTrend;
    }
}
