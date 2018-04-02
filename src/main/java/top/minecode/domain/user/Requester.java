package top.minecode.domain.user;

import top.minecode.po.RequesterPO;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class Requester extends GeneralUser{

    public Requester() {
    }

    public Requester(Integer id, UserType userType,
                     String userName, String name, String password,
                     String email, Double score) {
        super(id, userType, userName, name, password, email, score);
    }

    public RequesterPO toRequesterPO() {

        RequesterPO requester = new RequesterPO();
        requester.setId(id);
        requester.setUserName(username);
        requester.setName(name);
        requester.setName(password);
        requester.setEmail(email);
        requester.setScore(score);
        return requester;
    }
}
