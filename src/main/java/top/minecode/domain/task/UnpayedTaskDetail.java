package top.minecode.domain.task;

import java.time.LocalDate;

/**
 * Created on 2018/4/8.
 * Description:
 *
 * @author iznauy
 */
public class UnpayedTaskDetail extends WorkerTaskDetail {

    private LocalDate payDay;

    private LocalDate beginDate;

    private LocalDate endDate;

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
