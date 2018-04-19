package top.minecode.web.common;

import top.minecode.domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/4/19.
 * Description:
 *
 * @author iznauy
 */
public class ActiveUsers {

    private static final Map<String, User> nameToUser = new HashMap<>();

    public static User getUserByUserName(String userName) {
        return nameToUser.get(userName);
    }

    public static void addUser(String userName, User user) {
        nameToUser.put(userName, user);
    }

}
