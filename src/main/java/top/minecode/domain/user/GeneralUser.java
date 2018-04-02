package top.minecode.domain.user;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class GeneralUser extends User {

    protected String email;

    protected Double score = 0.0;

    public GeneralUser() {
    }

    public GeneralUser(Integer id, UserType userType,
                       String userName, String name,
                       String password, String email, Double score) {
        super(id, userType, userName, name, password);
        this.email = email;
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
