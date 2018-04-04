package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.task.WorkerGeneralTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.SearchingService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/search")
public class TaskSearchingController extends BaseController {

    private SearchingService searchingService;

    public SearchingService getSearchingService() {
        return searchingService;
    }

    @Autowired
    public void setSearchingService(SearchingService searchingService) {
        this.searchingService = searchingService;
    }

    // Need annotation
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String search(HttpServletRequest request, String key, int begin, int step) {
        User user = getSessionUser(request);
        List<WorkerGeneralTaskInfo> matchedTasks = searchingService.searchingTaskByKey(user,
                key, begin, step);
        return JsonConfig.getGson().toJson(matchedTasks);
    }
}
