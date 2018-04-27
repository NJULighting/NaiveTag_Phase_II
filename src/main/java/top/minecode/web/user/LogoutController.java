package top.minecode.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.web.common.ActiveUsers;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController extends BaseController {


    //登出
    @RequestMapping(value = "/lgo", method = RequestMethod.POST)
    public @ResponseBody void logout(HttpServletRequest request, String username) {
        ActiveUsers.removeUserByUsername(username);
    }

}
