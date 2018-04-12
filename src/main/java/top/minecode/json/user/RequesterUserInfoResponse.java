package top.minecode.json.user;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
public class RequesterUserInfoResponse extends UserInfoResponse {

    public RequesterUserInfoResponse() {
    }

    public RequesterUserInfoResponse(String username, String name, String email, Double score) {
        super(username, name, email, score);
    }
}
