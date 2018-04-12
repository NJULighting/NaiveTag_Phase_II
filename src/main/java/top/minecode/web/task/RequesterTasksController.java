package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.RequesterTaskService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/requester")
public class RequesterTasksController extends BaseController {

    private RequesterTaskService service;

    @Autowired
    public void setService(RequesterTaskService service) {
        this.service = service;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String getTasks(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<RequesterTaskInfo> tasks = service.getTasksInfo(user.getId());
        return JsonConfig.getGson().toJson(tasks);
    }

    @RequestMapping("/details")
    @ResponseBody
    public String getTaskDetail(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/new")
    @ResponseBody
    public String newTask(HttpServletRequest request) {
        return null;
    }
}
