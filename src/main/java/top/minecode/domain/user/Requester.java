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
        return new RequesterPO(id, username, name, password, score, email);
    }
}
