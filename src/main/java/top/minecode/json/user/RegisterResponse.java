package top.minecode.json.user;

import com.google.gson.Gson;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class RegisterResponse {

    public static final String SUCCESS = "success";

    public static final String REPEATED_USER_NAME = "repeatedUsername";

    public static final String REPEATED_NAME = "repeatedName";

    public static final String REPEATED_EMAIL = "repeatedEmail";

    private String result;

    private String userType;

    public RegisterResponse() {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
