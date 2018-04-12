package top.minecode.web.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.json.JsonConfig;
import top.minecode.service.statistic.WorkerStatisticService;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/rank")
public class RankInfoController {

    private WorkerStatisticService workerStatisticService;

    public WorkerStatisticService getWorkerStatisticService() {
        return workerStatisticService;
    }

    @Autowired
    public void setWorkerStatisticService(WorkerStatisticService workerStatisticService) {
        this.workerStatisticService = workerStatisticService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getRankInfo() {
        return JsonConfig.getGson().toJson(workerStatisticService.getWorkersRank());
    }
}
