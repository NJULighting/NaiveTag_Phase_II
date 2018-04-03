package top.minecode.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/task")
public class TaskDetailController {

    @RequestMapping("/detail")
    @ResponseBody
    public String getTaskDetail(HttpServletRequest request) {
        return null;
    }
}
