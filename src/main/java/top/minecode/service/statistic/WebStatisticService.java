package top.minecode.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.statistic.WebStatisticDao;
import top.minecode.domain.statistic.TimeNumberGraph;
import top.minecode.domain.statistic.WebStatisticInfo;
import top.minecode.json.JsonConfig;
import top.minecode.utils.Pair;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
@Service
public class WebStatisticService {

    private WebStatisticDao webStatisticDao;

    @Autowired
    public void setWebStatisticDao(WebStatisticDao webStatisticDao) {
        this.webStatisticDao = webStatisticDao;
    }

    public WebStatisticInfo getWebStatistic() {
        Pair<Integer, Integer> completedTotalTaskNumPair = webStatisticDao.getAllTaskInfo();
        TimeNumberGraph activeWorkerTrend = webStatisticDao.activeWorkerTrend();
        TimeNumberGraph totalWorkerTrend = webStatisticDao.totalWorkerTrend();
        TimeNumberGraph totalRequesterTrend = webStatisticDao.totalRequesterTrend();

        System.out.println(JsonConfig.getGson().toJson(totalRequesterTrend));

        return new WebStatisticInfo(completedTotalTaskNumPair.getRight(), completedTotalTaskNumPair.getLeft(),
                activeWorkerTrend, totalWorkerTrend, totalRequesterTrend);
    }
}
