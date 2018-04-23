package top.minecode.po;

import top.minecode.domain.user.UserType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created on 2018/4/14.
 * Description:
 *
 * @author iznauy
 */
public class LoginLogPO implements Serializable {

    private Integer userId;
    private UserType userType;
    private LocalDateTime loginTime;

    public LoginLogPO() {
        loginTime = LocalDateTime.now();
    }

    public LoginLogPO(Integer userId, UserType userType) {
        this();
        this.userId = userId;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginLogPO{" +
                "userId=" + userId +
                ", userType=" + userType +
                ", loginTime=" + loginTime +
                '}';
    }
}
