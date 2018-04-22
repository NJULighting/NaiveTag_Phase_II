package top.minecode.po;

import top.minecode.domain.user.UserType;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
public class RegisterLogPO implements Serializable {

    private Integer userId;
    private UserType userType;
    private LocalDate date;

    public RegisterLogPO(Integer userId, UserType userType, LocalDate date) {
        this.userId = userId;
        this.userType = userType;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public LocalDate getDate() {
        return date;
    }
}
