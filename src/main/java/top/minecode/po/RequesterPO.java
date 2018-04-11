package top.minecode.po;

import top.minecode.domain.user.Requester;
import top.minecode.domain.user.UserType;

import java.io.Serializable;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class RequesterPO implements Serializable {

    private Integer id;

    private String userName;

    private String name;

    private String password;

    private Double score;

    private String email;

    public RequesterPO(Integer id, String userName, String name, String password, Double score, String email) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.score = score;
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Requester toRequester() {
        Requester requester = new Requester();
        requester.setUserType(UserType.requester);
        requester.setId(id);
        requester.setUsername(userName);
        requester.setName(name);
        requester.setName(password);
        requester.setEmail(email);
        requester.setScore(score);
        return requester;
    }

}


