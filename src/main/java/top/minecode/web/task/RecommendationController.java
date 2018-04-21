package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.task.WorkerGeneralTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskdelivery.TaskRecommendationService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/recommendation")
public class RecommendationController extends BaseController {

    private TaskRecommendationService recommendationService;

    public TaskRecommendationService getRecommendationService() {
        return recommendationService;
    }

    @Autowired
    public void setRecommendationService(TaskRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String getRecommendation(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<WorkerGeneralTaskInfo> recommendations = recommendationService.getRecommendations(user);
        return JsonConfig.getGson().toJson(recommendations);
    }
}
