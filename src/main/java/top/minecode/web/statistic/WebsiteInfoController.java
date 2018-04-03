package top.minecode.web.statistic;

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
@RequestMapping("/admin")
public class WebsiteInfoController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getInfo(HttpServletRequest request) {
        return null;
    }
}
