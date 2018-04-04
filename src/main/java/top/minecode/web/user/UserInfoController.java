package top.minecode.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.service.user.UserService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/2.
 * Description: Worker and requester
 *
 * @author iznauy
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController extends BaseController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public @ResponseBody String getUserInfo(HttpServletRequest request) {
        return null;
    }


    // 调用逻辑层的 statistic 包中的 service 来计算得到结果
    @RequestMapping("/ability")
    @ResponseBody
    public String getAbilityGraph(HttpServletRequest request) {
        return null;
    }

}
