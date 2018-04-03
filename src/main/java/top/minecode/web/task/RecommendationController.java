package top.minecode.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/recommendation")
public class RecommendationController extends BaseController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String getRecommendation(HttpServletRequest request) {
        return null;
    }
}
