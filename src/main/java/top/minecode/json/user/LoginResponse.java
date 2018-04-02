package top.minecode.json.user;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class LoginResponse {

    public static final String SUCCESS = "success";

    public static final String INVALID_NAME = "invalid username";

    public static final String INVALID_PASSWORD = "invalid password";

    private String result;

    private String userType;

    public LoginResponse() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
