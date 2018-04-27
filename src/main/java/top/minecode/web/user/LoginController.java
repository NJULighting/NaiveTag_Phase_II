package top.minecode.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.user.User;
import top.minecode.exception.InvalidPasswordException;
import top.minecode.exception.InvalidUserNameException;
import top.minecode.json.JsonConfig;
import top.minecode.json.user.LoginResponse;
import top.minecode.po.Table;
import top.minecode.po.TableFactory;
import top.minecode.po.WorkerPO;
import top.minecode.service.user.UserService;
import top.minecode.web.common.ActiveUsers;
import top.minecode.web.common.BaseController;
import top.minecode.web.common.CommonConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
@Controller
public class LoginController extends BaseController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(HttpServletRequest request, User user) {
        Table<WorkerPO> table = TableFactory.workerTable();
        LoginResponse loginResponse = new LoginResponse();
        try {
            user = userService.login(user);
            System.out.println(JsonConfig.getGson().toJson(user));
            loginResponse.setResult(LoginResponse.SUCCESS);
            loginResponse.setUserType(user.getUserType().toString());
            setSessionUser(request, user);
        } catch (InvalidUserNameException e) {
            loginResponse.setResult(LoginResponse.INVALID_NAME);
        } catch (InvalidPasswordException e) {
            loginResponse.setResult(LoginResponse.INVALID_PASSWORD);
        }
        return JsonConfig.getGson().toJson(loginResponse);
    }


    //登出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(String username) {
        ActiveUsers.removeUserByUsername(username);
    }


}
