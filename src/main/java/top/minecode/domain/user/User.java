package top.minecode.domain.user;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public abstract class User {

    protected Integer id;

    protected UserType userType;

    protected String username;

    protected String name;

    protected String password;

    public User() {
    }

    public User(Integer id, UserType userType, String username, String name, String password) {
        this.id = id;
        this.userType = userType;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
