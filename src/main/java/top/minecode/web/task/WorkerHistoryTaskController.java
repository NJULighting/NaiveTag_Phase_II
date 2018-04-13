package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.task.WorkerRecentTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.WorkerHistoryTaskService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 2018/4/3.
 * Description: 工人历史任务
 * @author Liao
 */
@Controller
@RequestMapping("/worker")
public class WorkerHistoryTaskController extends BaseController {

    private WorkerHistoryTaskService service;

    public WorkerHistoryTaskService getService() {
        return service;
    }

    @Autowired
    public void setService(WorkerHistoryTaskService service) {
        this.service = service;
    }

    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    @ResponseBody
    public String getRecentTasks(HttpServletRequest request, int count) {
        User user = getSessionUser(request);
        List<WorkerRecentTaskInfo> workerRecentTaskInfoList = service.getWorkerRecentTaskInfo(user, count);
        return JsonConfig.getGson().toJson(workerRecentTaskInfoList);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody
    public String getAllHistoryTasks(HttpServletRequest request) {
        return null;
    }
}
