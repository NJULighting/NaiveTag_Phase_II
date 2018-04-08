package top.minecode.po;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class TableFactory {

    private static final TableCandidate<AdministratorPO> adminTable;
    private static final TableCandidate<WorkerPO> workerTable;
    private static final TableCandidate<RequesterPO> requesterTable;
    private static final TableCandidate<FirstLevelTaskPO> firstLevelTaskTable;
    private static final TableCandidate<WorkerFilterPO> workerFilterTable;
    private static final TableCandidate<SecondLevelTaskPO> secondLevelTaskTable;
    private static final TableCandidate<TaskDetailsPO> taskDetailsTable;
    private static final TableCandidate<ThirdLevelTaskPO> thirdLevelTaskTable;
    private static final TableCandidate<ThirdLevelTaskResultPO> thirdLevelTaskResultTable;
    private static final RankPO rank;

    static {
        adminTable = new TableCandidate<>("admin");
        workerTable = new TableCandidate<>("work");
        requesterTable = new TableCandidate<>("requester");
        firstLevelTaskTable = new TableCandidate<>("firstLevelTask");
        workerFilterTable = new TableCandidate<>("workerFilter");
        secondLevelTaskTable = new TableCandidate<>("secondLevelTask");
        taskDetailsTable = new TableCandidate<>("taskDetails");
        thirdLevelTaskTable = new TableCandidate<>("thirdLevelTask");
        thirdLevelTaskResultTable = new TableCandidate<>("thirdLevelTaskResult");
        rank = new RankPO();
    }

    public static TableCandidate<AdministratorPO> administratorTable() {
        return adminTable;
    }

    public static TableCandidate<FirstLevelTaskPO> firstLevelTaskTable() {
        return firstLevelTaskTable;
    }

    public static TableCandidate<WorkerPO> workerTable() {
        return workerTable;
    }

    public static TableCandidate<RequesterPO> requesterTable() {
        return requesterTable;
    }

    public static TableCandidate<WorkerFilterPO> workerFilterTable() {
        return workerFilterTable;
    }

    public static TableCandidate<SecondLevelTaskPO> secondLevelTaskTable() {
        return secondLevelTaskTable;
    }

    public static TableCandidate<TaskDetailsPO> taskDetailsTable() {
        return taskDetailsTable;
    }

    public static TableCandidate<ThirdLevelTaskPO> thirdLevelTaskTable() {
        return thirdLevelTaskTable;
    }

    public static TableCandidate<ThirdLevelTaskResultPO> thirdLevelTaskResultTable() {
        return thirdLevelTaskResultTable;
    }

    public static RankPO rank() {
        return rank;
    }
}
