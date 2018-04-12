package top.minecode.json.user;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
public class UserInfoResponse {

    private String username;

    private String name;

    private String email;

    private Double score;

    public UserInfoResponse() {

    }

    public UserInfoResponse(String username, String name, String email, Double score) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.score = score;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
