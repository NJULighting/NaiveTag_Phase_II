package top.minecode.dao.statistic;

import org.springframework.stereotype.Repository;
import top.minecode.domain.statistic.TimeNumberGraph;
import top.minecode.domain.user.UserType;
import top.minecode.po.*;
import top.minecode.utils.Pair;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
@Repository
public class WebStatisticDao {

    public Pair<Integer, Integer> getAllTaskInfo() {
        Table<FirstLevelTaskPO> firstLevelTaskTable = TableFactory.firstLevelTaskTable();
        int completedTaskNum = firstLevelTaskTable.getPOsBy(FirstLevelTaskState.completed,
                FirstLevelTaskPO::getState).size();
        return new Pair<>(completedTaskNum, firstLevelTaskTable.size());
    }

    public TimeNumberGraph activeWorkerTrend() {
        List<LoginLogPO> loginLogs = TableFactory.loginLogTable()
                .getPOsBy(UserType.worker, LoginLogPO::getUserType);
        return getTrend(loginLogs, log -> log.getLoginTime().toLocalDate());
    }

    public TimeNumberGraph totalWorkerTrend() {
        List<RegisterLogPO> registerLogs = TableFactory.registerLogTable()
                .getPOsBy(UserType.worker, RegisterLogPO::getUserType);
        return getTrend(registerLogs, RegisterLogPO::getDate);
    }

    public TimeNumberGraph totalRequesterTrend() {
        List<RegisterLogPO> registerLogs = TableFactory.registerLogTable()
                .getPOsBy(UserType.requester, RegisterLogPO::getUserType);
        return getTrend(registerLogs, RegisterLogPO::getDate);
    }

    private <T> TimeNumberGraph getTrend(List<T> pos, Function<T, LocalDate> function) {
        TimeNumberGraph timeNumberGraph = new TimeNumberGraph();
        if (pos.isEmpty())
            return timeNumberGraph;

        pos.stream().map(function).forEach(timeNumberGraph::addDot);

        return timeNumberGraph;
    }
}
