package top.minecode.po;

import top.minecode.domain.user.Administrator;
import top.minecode.domain.user.UserType;

import java.io.Serializable;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class AdministratorPO implements Serializable {

    private Integer id;

    private String userName;

    private String name;

    private String password;

    public AdministratorPO() {
    }

    public AdministratorPO(Integer id, String userName, String name, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrator toAdministrator() {
        Administrator administrator = new Administrator();
        administrator.setId(id);
        administrator.setName(name);
        administrator.setUsername(userName);
        administrator.setPassword(password);
        administrator.setUserType(UserType.admin);
        return administrator;
    }

    @Override
    public String toString() {
        return "AdministratorPO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
