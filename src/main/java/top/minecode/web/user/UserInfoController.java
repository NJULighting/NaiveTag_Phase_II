package top.minecode.web.user;

import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.user.GeneralUser;
import top.minecode.domain.user.User;
import top.minecode.domain.user.UserType;
import top.minecode.domain.user.Worker;
import top.minecode.json.JsonConfig;
import top.minecode.json.user.UserInfoResponse;
import top.minecode.json.user.WorkerUserInfoResponse;
import top.minecode.service.statistic.WorkerStatisticService;
import top.minecode.service.user.UserService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/2.
 * Description: Worker and requester
 *
 * @author iznauy
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController extends BaseController {

    private WorkerStatisticService workerStatisticService;

    public WorkerStatisticService getWorkerStatisticService() {
        return workerStatisticService;
    }

    @Autowired
    public void setWorkerStatisticService(WorkerStatisticService workerStatisticService) {
        this.workerStatisticService = workerStatisticService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public @ResponseBody String getUserInfo(HttpServletRequest request) {
        GeneralUser user = (GeneralUser) getSessionUser(request);

        UserInfoResponse userInfoResponse = null;
        if (user.getUserType() == UserType.worker) {
            Worker worker = (Worker) user;
            WorkerUserInfoResponse workerUserInfo = new WorkerUserInfoResponse();
            workerUserInfo.setAverageScoreRatio(worker.getAverageScoreRatio());

            int rank = workerStatisticService.getWorkerRank(user);
            workerUserInfo.setRank(rank);

            userInfoResponse = workerUserInfo;
        } else if (user.getUserType() == UserType.requester) {
            userInfoResponse = new WorkerUserInfoResponse();
        } else {
            return null;
        }
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setName(user.getName());
        userInfoResponse.setScore(user.getScore());
        userInfoResponse.setUsername(user.getUsername());
        return JsonConfig.getGson().toJson(userInfoResponse);
    }


    // 调用逻辑层的 statistic 包中的 service 来计算得到结果
    @RequestMapping("/ability")
    @ResponseBody
    public String getAbilityGraph(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<Double> recentEarnedScores = workerStatisticService.getUserAbilityChanges(user);
//        List<Double> naive = new ArrayList<>();
//        naive.add(17.2);
//        naive.add(27.2);
//        naive.add(47.2);
//        naive.add(77.2);
        return JsonConfig.getGson().toJson(recentEarnedScores);
 //       return JsonConfig.getGson().toJson(naive);
    }

}
