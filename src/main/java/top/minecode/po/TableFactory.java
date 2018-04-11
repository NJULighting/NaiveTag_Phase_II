package top.minecode.po;

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
        rankTable = new RankTable();
    }

    public static Table<AdministratorPO> administratorTable() {
        return adminTable;
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
}
