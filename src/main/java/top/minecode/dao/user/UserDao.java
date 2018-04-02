package top.minecode.dao.user;

import org.springframework.stereotype.Repository;
import top.minecode.domain.user.Requester;
import top.minecode.domain.user.User;
import top.minecode.domain.user.UserType;
import top.minecode.domain.user.Worker;
import top.minecode.po.AdministratorPO;
import top.minecode.po.DataBase;
import top.minecode.po.RequesterPO;
import top.minecode.po.WorkerPO;

import java.util.List;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class UserDao {

    public User getUserByUsername(String userName) {

        // 查数据库，迭代三替换成数据库查询代码
        List<WorkerPO> workerPOS = DataBase.workerPOList.getWorkerList();
        WorkerPO workerPO = workerPOS.stream()
                .filter(e -> e.getUsername().equals(userName))
                .findFirst().orElse(null);
        if (workerPO != null)
            return workerPO.toWorker();

        List<AdministratorPO> administratorPOS = DataBase.administratorPOList.getAdministratorPOS();
        AdministratorPO administratorPO = administratorPOS.stream()
                .filter(e -> e.getUserName().equals(userName))
                .findFirst().orElse(null);
        if (administratorPO != null)
            return administratorPO.toAdministrator();

        List<RequesterPO> requesterPOS = DataBase.requesterPOList.getRequesterPOS();
        RequesterPO requesterPO = requesterPOS.stream()
                .filter(e -> e.getUserName().equals(userName))
                .findFirst().orElse(null);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public User getUserByName(String name) {

        // 查数据库，迭代三替换成数据库查询代码
        List<WorkerPO> workerPOS = DataBase.workerPOList.getWorkerList();
        WorkerPO workerPO = workerPOS.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
        if (workerPO != null)
            return workerPO.toWorker();

        List<AdministratorPO> administratorPOS = DataBase.administratorPOList.getAdministratorPOS();
        AdministratorPO administratorPO = administratorPOS.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
        if (administratorPO != null)
            return administratorPO.toAdministrator();

        List<RequesterPO> requesterPOS = DataBase.requesterPOList.getRequesterPOS();
        RequesterPO requesterPO = requesterPOS.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public User getUserByEmail(String email) {

        // 查数据库，迭代三替换成数据库查询代码
        List<WorkerPO> workerPOS = DataBase.workerPOList.getWorkerList();
        WorkerPO workerPO = workerPOS.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst().orElse(null);
        if (workerPO != null)
            return workerPO.toWorker();

        List<RequesterPO> requesterPOS = DataBase.requesterPOList.getRequesterPOS();
        RequesterPO requesterPO = requesterPOS.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst().orElse(null);
        if (requesterPO != null)
            return requesterPO.toRequester();

        return null;
    }

    public void addUser(User user) {
        if (user.getUserType() == UserType.requester) {
            Requester requester = (Requester) user;
            RequesterPO requesterPO = requester.toRequesterPO();
            Integer id = DataBase.requesterPOList.getNextRequesterId();
            requesterPO.setId(id);
            requester.setId(id);
            DataBase.requesterPOList.addRequesterPO(requesterPO);
        } else if (user.getUserType() == UserType.worker) {
            Worker worker = (Worker) user;
            WorkerPO workerPO = worker.toWorkerPO();
            Integer id = DataBase.workerPOList.getNextWorkerId();
            worker.setId(id);
            workerPO.setId(id);
            DataBase.workerPOList.addWorkerPO(workerPO);
        }
    }

}
