package top.minecode.utils;

import top.minecode.domain.user.UserType;
import top.minecode.po.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created on 2018/5/5.
 * Description:
 * @author Liao
 */
public class DataGenerator {

    private Random rand;

    public DataGenerator() {
        rand = new Random();
    }

    public DataGenerator(long seed) {
        rand = new Random(seed);
    }

    // Generate workerPO, requesterPO
    public void generateData() {
        Table<WorkerPO> workers = TableFactory.workerTable();
        Table<RegisterLogPO> registerLogs = TableFactory.registerLogTable();
        Table<RequesterPO> requesters = TableFactory.requesterTable();
        Table<LoginLogPO> loginLogs = TableFactory.loginLogTable();

        for (int i = 0; i < 1000; i++) {

            LoginLogPO loginPO = new LoginLogPO(i, rand.nextInt(1000) > 200 ? UserType.worker : UserType.requester,
                    LocalDateTime.of(2018, rand.nextInt(6) + 1, rand.nextInt(26) + 1, 3, 4));
            RegisterLogPO logPO = new RegisterLogPO(i, UserType.worker, LocalDate.of(2018, rand.nextInt(6) + 1, rand.nextInt(26) + 1));
            WorkerPO po = new WorkerPO(i, "frog" + i, "123456789", "frog" + i,
                    i + "@qq.com", 300 * rand.nextDouble(), 3 * rand.nextGaussian());

            if (i < 100) {
                RequesterPO requester = new RequesterPO(i, "frogRequester" + i, "excitedFrog" + i,
                        "123456789", 10000 * rand.nextDouble(), i + "@qq.com");
                RegisterLogPO log = new RegisterLogPO(i, UserType.requester, LocalDate.of(2018, rand.nextInt(6) + 1, rand.nextInt(26) + 1));
                requesters.add(requester);
                registerLogs.add(log);
            }

            workers.add(po);
            registerLogs.add(logPO);
            loginLogs.add(loginPO);
        }

        TableFactory.saveAll();
    }
}
