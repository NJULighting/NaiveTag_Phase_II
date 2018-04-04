package top.minecode.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.service.taskmanage.WorkerHistoryTaskService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description: 工人历史任务
 * @author Liao
 */
@Controller
@RequestMapping("/worker")
public class WorkerHistoryTaskController extends BaseController {

    private WorkerHistoryTaskService service;

    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    @ResponseBody
    public String getRecentTasks(HttpServletRequest request) {
        return null;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody
    public String getAllHistoryTasks(HttpServletRequest request) {
        return null;
    }
}
