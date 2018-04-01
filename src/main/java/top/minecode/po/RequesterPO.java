package top.minecode.po;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 *
 * @author iznauy
 */
public class RequesterPO {

    private Integer id;

    private String userName;

    private String name;

    private String password;

    private String email;

    private List<Integer> ownedFirstLevelTaskPOIdsList;

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

    public List<Integer> getOwnedFirstLevelTaskPOIdsList() {
        return ownedFirstLevelTaskPOIdsList;
    }

    public void setOwnedFirstLevelTaskPOIdsList(List<Integer> ownedFirstLevelTaskPOIdsList) {
        this.ownedFirstLevelTaskPOIdsList = ownedFirstLevelTaskPOIdsList;
    }
}


