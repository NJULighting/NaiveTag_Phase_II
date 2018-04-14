package top.minecode.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.minecode.domain.user.*;
import top.minecode.exception.EmailExistedException;
import top.minecode.exception.NameExistedException;
import top.minecode.exception.UsernameExistedException;
import top.minecode.json.JsonConfig;
import top.minecode.json.user.RegisterResponse;
import top.minecode.service.user.UserService;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/join")
public class RegisterController extends BaseController{

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String register(HttpServletRequest request, GeneralUser user) {
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            userService.register(user);
            UserType userType = user.getUserType();
            registerResponse.setUserType(userType.toString());
            user.setScore(0.0);
            setSessionUser(request, user);
        } catch (EmailExistedException e) {
            registerResponse.setResult(RegisterResponse.REPEATED_EMAIL);
        } catch (NameExistedException e) {
            registerResponse.setResult(RegisterResponse.REPEATED_NAME);
        } catch (UsernameExistedException e) {
            registerResponse.setResult(RegisterResponse.REPEATED_USER_NAME);
        }
        return JsonConfig.getGson().toJson(registerResponse);
    }

    @RequestMapping(value = "/worker", method = RequestMethod.POST)
    public @ResponseBody String createWorkerId(HttpServletRequest request, Worker worker) {
        worker.setUserType(UserType.worker);
        String temp = register(request, worker);
        System.out.println(temp);
     //   return register(request, worker);

        return temp;
    }

    @RequestMapping(value = "/requester", method = RequestMethod.POST)
    public @ResponseBody String createRequesterId(HttpServletRequest request, Requester requester) {
        requester.setUserType(UserType.requester);
        return register(request, requester);
    }



}
