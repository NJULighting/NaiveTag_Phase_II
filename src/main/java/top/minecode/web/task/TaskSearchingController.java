package top.minecode.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/search")
public class TaskSearchingController {

    // Need annotation
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String search(HttpServletRequest request) {
        return null;
    }
}
