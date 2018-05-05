package top.minecode.po;

import top.minecode.utils.DataGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class TableFactory {

    private static final Table<AdministratorPO> adminTable;
    private static final Table<WorkerPO> workerTable;
    private static final Table<RequesterPO> requesterTable;
    private static final Table<FirstLevelTaskPO> firstLevelTaskTable;
    private static final Table<WorkerFilterPO> workerFilterTable;
    private static final Table<SecondLevelTaskPO> secondLevelTaskTable;
    private static final Table<TaskDetailsPO> taskDetailsTable;
    private static final Table<ThirdLevelTaskPO> thirdLevelTaskTable;
    private static final Table<ThirdLevelTaskResultPO> thirdLevelTaskResultTable;
    private static final Table<LoginLogPO> loginLogTable;
    private static final Table<RegisterLogPO> registerLogTable;
    private static final Table<WorkerSettlementLogPO> workerSettlementLogTable;
    private static final RankTable rankTable;

    static {
        adminTable = new Table<>("admin");
        workerTable = new Table<>("work");
        requesterTable = new Table<>("requester");
        firstLevelTaskTable = new Table<>("firstLevelTask");
        workerFilterTable = new Table<>("workerFilter");
        secondLevelTaskTable = new Table<>("secondLevelTask");
        taskDetailsTable = new Table<>("taskDetails");
        thirdLevelTaskTable = new Table<>("thirdLevelTask");
        thirdLevelTaskResultTable = new Table<>("thirdLevelTaskResult");
        registerLogTable = new Table<>("registerLog");
        loginLogTable = new Table<>("loginLog");
        workerSettlementLogTable = new Table<>("workerSettlementLog");
        rankTable = new RankTable(); // This must be initialized after worker table's initialization

        // Add initial administrator
        if (adminTable.getPOBy(1926, AdministratorPO::getId) == null) {
            adminTable.add(new AdministratorPO(1926, "ZhangZhe", "ZhangZhe", "Excited"));
        }
    }

    public static Table<AdministratorPO> administratorTable() {
        return adminTable;
    }

    public static Table<RegisterLogPO> registerLogTable() {
        return registerLogTable;
    }

    public static Table<FirstLevelTaskPO> firstLevelTaskTable() {
        return firstLevelTaskTable;
    }

    public static Table<WorkerPO> workerTable() {
        return workerTable;
    }

    public static Table<RequesterPO> requesterTable() {
        return requesterTable;
    }

    public static Table<WorkerFilterPO> workerFilterTable() {
        return workerFilterTable;
    }

    public static Table<SecondLevelTaskPO> secondLevelTaskTable() {
        return secondLevelTaskTable;
    }

    public static Table<TaskDetailsPO> taskDetailsTable() {
        return taskDetailsTable;
    }

    public static Table<ThirdLevelTaskPO> thirdLevelTaskTable() {
        return thirdLevelTaskTable;
    }

    public static Table<ThirdLevelTaskResultPO> thirdLevelTaskResultTable() {
        return thirdLevelTaskResultTable;
    }

    public static RankTable rankTable() {
        return rankTable;
    }

    public static Table<LoginLogPO> loginLogTable() {
        return loginLogTable;
    }

    public static Table<WorkerSettlementLogPO> workerSettlementLogTable() {
        return workerSettlementLogTable;
    }

    public static void saveAll() {
        try {
            Method tableSave = Table.class.getMethod("save");
            for (Field table : TableFactory.class.getDeclaredFields()) {
                if (!table.getName().equals("rankTable"))
                    // Save table except rankTable
                    tableSave.invoke(table.get(null));
                else
                    // Save rankTable
                    RankTable.class.getMethod("save").invoke(table.get(null));
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
