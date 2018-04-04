package top.minecode.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/requester")
public class RequesterTasksController extends BaseController {

    @RequestMapping("/index")
    @ResponseBody
    public String getTasks(HttpServletRequest request) {
        return null;
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
