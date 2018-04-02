package top.minecode.web.common;

import top.minecode.domain.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class BaseController {

    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(
                CommonConstant.USER_CONTEXT);
    }

    protected void setSessionUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
                user);
    }

    public final String getAppBaseUrl(HttpServletRequest request, String url) {
        return request.getContextPath() + url;
    }

}
