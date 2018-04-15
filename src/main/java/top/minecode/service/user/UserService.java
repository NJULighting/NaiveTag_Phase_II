package top.minecode.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.user.UserDao;
import top.minecode.domain.user.GeneralUser;
import top.minecode.domain.user.User;
import top.minecode.domain.user.UserType;
import top.minecode.exception.*;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */

@Service
public class UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 该方法也会把user的id设置
    public void register(GeneralUser user) throws EmailExistedException,
            NameExistedException, UsernameExistedException {
        String userName = user.getUsername();
        String name = user.getName();
        String email = user.getEmail();

        if (userDao.getUserByUsername(userName) != null)
            throw new UsernameExistedException();
        else if (userDao.getUserByName(name) != null)
            throw new NameExistedException();
        else if (userDao.getUserByEmail(email) != null)
            throw new EmailExistedException();

        userDao.addUser(user);
    }


    public User login(User user) throws InvalidPasswordException, InvalidUserNameException {
        String userName = user.getUsername();
        String password = user.getPassword();

        User target = userDao.getUserByUsername(userName);

        // 不存在的用户
        if (target == null)
            throw new InvalidUserNameException();

        if (!target.getPassword().equals(password))
            throw new InvalidPasswordException();

        userDao.addUserLoginLog(user);

        return target;
    }

}
