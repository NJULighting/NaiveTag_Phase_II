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
@RequestMapping("/tag")
public class TagController extends BaseController {

    @RequestMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/next")
    @ResponseBody
    public String next(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/getLabelInfo")
    @ResponseBody
    public String getLabelInformation(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/previous")
    @ResponseBody
    public String previous(HttpServletRequest request) {

        return null;
    }

    @ResponseBody
    @RequestMapping("/commit")
    public String commit(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/taskInfo")
    @ResponseBody
    public String getTaskInformation(HttpServletRequest request) {
        return null;
    }
}
