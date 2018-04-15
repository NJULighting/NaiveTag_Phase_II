package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.json.JsonConfig;
import top.minecode.json.task.AcceptResponse;
import top.minecode.json.task.CommitResponse;
import top.minecode.service.taskmanage.TaskAcceptAndCommitService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
@Controller
@RequestMapping(value = "/task")
public class TaskAcceptAndCommitController extends BaseController {

    private TaskAcceptAndCommitService taskAcceptAndCommitService;

    public TaskAcceptAndCommitService getTaskAcceptAndCommitService() {
        return taskAcceptAndCommitService;
    }

    @Autowired
    public void setTaskAcceptAndCommitService(TaskAcceptAndCommitService taskAcceptAndCommitService) {
        this.taskAcceptAndCommitService = taskAcceptAndCommitService;
    }

    @ResponseBody
    @RequestMapping(value = "/accept")
    public String acceptTask(HttpServletRequest request, int taskId) {
        boolean result = taskAcceptAndCommitService.acceptTask(getSessionUser(request), taskId);
        return JsonConfig.getGson().toJson(new AcceptResponse(result));
    }


    @ResponseBody
    @RequestMapping("/commit")
    public String commit(HttpServletRequest request, int taskId) {
        boolean result = taskAcceptAndCommitService.commit(getSessionUser(request), taskId);
        return JsonConfig.getGson().toJson(new CommitResponse(result));
    }


}
