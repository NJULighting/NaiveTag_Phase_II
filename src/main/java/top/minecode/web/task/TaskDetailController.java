package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.task.WorkerTaskDetail;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.TaskDetailService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/task")
public class TaskDetailController extends BaseController {

    private TaskDetailService taskDetailService;

    public TaskDetailService getTaskDetailService() {
        return taskDetailService;
    }

    @Autowired
    public void setTaskDetailService(TaskDetailService taskDetailService) {
        this.taskDetailService = taskDetailService;
    }

    @RequestMapping("/details")
    @ResponseBody
    public String getTaskDetail(HttpServletRequest request, int taskId) {
        User user = getSessionUser(request);
        WorkerTaskDetail taskDetail = taskDetailService.getWorkerTaskDetail(user, taskId);
        return JsonConfig.getGson().toJson(taskDetail);
    }
}
