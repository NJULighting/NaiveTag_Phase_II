package top.minecode.po;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class UserTrendPO implements Serializable {

    private Map<LocalDate, Integer> activeWorkerTrend;
    private Map<LocalDate, Integer> totalWorkerTrend;
    private Map<LocalDate, Integer> totalRequesterTrend;

    public UserTrendPO(Map<LocalDate, Integer> activeWorkerTrend,
                       Map<LocalDate, Integer> totalWorkerTrend,
                       Map<LocalDate, Integer> totalRequesterTrend) {
        this.activeWorkerTrend = activeWorkerTrend;
        this.totalWorkerTrend = totalWorkerTrend;
        this.totalRequesterTrend = totalRequesterTrend;
    }

    public Map<LocalDate, Integer> getActiveWorkerTrend() {
        return activeWorkerTrend;
    }

    public void setActiveWorkerTrend(Map<LocalDate, Integer> activeWorkerTrend) {
        this.activeWorkerTrend = activeWorkerTrend;
    }

    public Map<LocalDate, Integer> getTotalWorkerTrend() {
        return totalWorkerTrend;
    }

    public void setTotalWorkerTrend(Map<LocalDate, Integer> totalWorkerTrend) {
        this.totalWorkerTrend = totalWorkerTrend;
    }

    public Map<LocalDate, Integer> getTotalRequesterTrend() {
        return totalRequesterTrend;
    }

    public void setTotalRequesterTrend(Map<LocalDate, Integer> totalRequesterTrend) {
        this.totalRequesterTrend = totalRequesterTrend;
    }
}
