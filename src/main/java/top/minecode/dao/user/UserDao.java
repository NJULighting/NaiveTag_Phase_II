package top.minecode.dao.user;

import org.springframework.stereotype.Repository;
import top.minecode.domain.user.Requester;
import top.minecode.domain.user.User;
import top.minecode.domain.user.UserType;
import top.minecode.domain.user.Worker;
import top.minecode.json.JsonConfig;
import top.minecode.po.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 2018/4/2.
 * Description:
 * @author iznauy
 */
@Repository
public class UserDao {

    public void addUserLoginLog(User user) {
        Table<LoginLogPO> loginLogPOTable = TableFactory.loginLogTable();
        if (user.getUserType() == UserType.admin)
            return;
        LoginLogPO loginLog = new LoginLogPO();
        loginLog.setUserId(user.getId());
        loginLog.setUserType(user.getUserType());
        loginLog.setLoginTime(LocalDateTime.now());
        loginLogPOTable.add(loginLog);
    }

    public void updateUserScore(User user, double score) {
        if (user.getUserType() == UserType.worker) {
            Table<WorkerPO> workerTable = TableFactory.workerTable();
            WorkerPO target = workerTable.getPOBy(user.getUsername(), WorkerPO::getUsername);
            target.setScores(target.getScores() + score);
            workerTable.save();
        } else if (user.getUserType() == UserType.requester) {
            Table<RequesterPO> requesterTable = TableFactory.requesterTable();
            RequesterPO target = requesterTable.getPOBy(user.getUsername(), RequesterPO::getUserName);
            target.setScore(target.getScore() + score);
            requesterTable.save();
        }
    }


    public User getUserByUsername(String userName) {

        // 查数据库，迭代三替换成数据库查询代码
        WorkerPO workerPO = TableFactory.workerTable().getPOBy(userName, WorkerPO::getUsername);
        if (workerPO != null)
            return workerPO.toWorker();

        AdministratorPO administratorPO = TableFactory.administratorTable()
                .getPOBy(userName, AdministratorPO::getUserName);
        if (administratorPO != null)
            return administratorPO.toAdministrator();

        RequesterPO requesterPO = TableFactory.requesterTable().getPOBy(userName, RequesterPO::getUserName);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public User getUserByName(String name) {


        AdministratorPO administratorPO = TableFactory.administratorTable().getPOBy(name, AdministratorPO::getName);
        if (administratorPO != null)
            return administratorPO.toAdministrator();

        // 查数据库，迭代三替换成数据库查询代码
        WorkerPO workerPO = TableFactory.workerTable().getPOBy(name, WorkerPO::getName);
        if (workerPO != null)
            return workerPO.toWorker();

        RequesterPO requesterPO = TableFactory.requesterTable().getPOBy(name, RequesterPO::getName);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public User getUserByEmail(String email) {

        // 查数据库，迭代三替换成数据库查询代码
        WorkerPO workerPO = TableFactory.workerTable().getPOBy(email, WorkerPO::getEmail);
        if (workerPO != null)
            return workerPO.toWorker();

        RequesterPO requesterPO = TableFactory.requesterTable().getPOBy(email, RequesterPO::getEmail);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public void addUser(User user) {
        if (user.getUserType() == UserType.requester) {
            Requester requester = (Requester) user;
            RequesterPO requesterPO = requester.toRequesterPO();
            Integer id = TableFactory.requesterTable().getNextId();
            requesterPO.setId(id);
            requester.setId(id);
            TableFactory.requesterTable().add(requesterPO);
        } else if (user.getUserType() == UserType.worker) {
            Worker worker = (Worker) user;
            WorkerPO workerPO = worker.toWorkerPO();
            Integer id = TableFactory.workerTable().getNextId();
            worker.setId(id);
            workerPO.setId(id);
            TableFactory.workerTable().add(workerPO);
        }
        addRegisterLoginLog(user);
    }

    private void addRegisterLoginLog(User user) {
        Table<RegisterLogPO> registerLogTable = TableFactory.registerLogTable();
        if (user.getUserType() == UserType.admin)
            return;
        RegisterLogPO log = new RegisterLogPO(user.getId(), user.getUserType(), LocalDate.now());
        registerLogTable.add(log);
    }
}
