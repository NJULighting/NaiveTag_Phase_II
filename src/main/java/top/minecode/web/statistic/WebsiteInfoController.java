package top.minecode.web.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.statistic.WebStatisticInfo;
import top.minecode.json.JsonConfig;
import top.minecode.service.statistic.WebStatisticService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/admin")
public class WebsiteInfoController extends BaseController {

    private WebStatisticService webStatisticService;

    @Autowired
    public void setWebStatisticService(WebStatisticService webStatisticService) {
        this.webStatisticService = webStatisticService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getInfo() {
        WebStatisticInfo info = webStatisticService.getWebStatistic();
        return JsonConfig.getGson().toJson(info);
    }
}
