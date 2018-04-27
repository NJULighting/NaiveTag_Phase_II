package top.minecode.web.common;

import top.minecode.domain.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class BaseController {

    protected User getSessionUser(HttpServletRequest request) {
        return ActiveUsers.getUserByUserName(request.getParameter("username"));
    }

    protected void setSessionUser(HttpServletRequest request, User user) {
        if (ActiveUsers.getUserByUserName(user.getName()) == null)
            ActiveUsers.addUser(user.getUsername(), user);
    }

    public final String getAppBaseUrl(HttpServletRequest request, String url) {
        return request.getContextPath() + url;
    }

}
