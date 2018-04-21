package top.minecode.po;

import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.user.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        rankTable = new RankTable();
        loginLogTable = new Table<>("loginLog");
        workerSettlementLogTable = new Table<>("workerSettlementLog");

        SecondLevelTaskPO secondLevelTaskPO = new SecondLevelTaskPO();
        secondLevelTaskPO.setId(1);
        secondLevelTaskPO.setTaskName("Boy ♂ Next ♂ Door");
        secondLevelTaskPO.setEndDate(LocalDate.now().plusDays(5));
        secondLevelTaskPO.setTaskDetailsId(1);
        secondLevelTaskPO.setTotalScore(2000.0);

        // 编号为1的二级任务的任务详细信息
        TaskDetailsPO taskDetailsPO = new TaskDetailsPO();
        taskDetailsPO.setId(1);
        taskDetailsPO.setSLTaskId(1);
        taskDetailsPO.setDescription("Deep Dark Fantasy");
        taskDetailsPO.setTaskType(101);
        taskDetailsPO.setClasses(null);

        // 编号为2的二级任务
        SecondLevelTaskPO secondLevelTaskPO2 = new SecondLevelTaskPO();
        secondLevelTaskPO.setId(2);
        secondLevelTaskPO.setTaskName("Are you OK");
        secondLevelTaskPO.setEndDate(LocalDate.now().plusDays(5));
        secondLevelTaskPO.setTaskDetailsId(2);
        secondLevelTaskPO.setTotalScore(2000.0);

        // 编号为2的二级任务的详细信息
        TaskDetailsPO taskDetailsPO2 = new TaskDetailsPO();
        taskDetailsPO2.setId(2);
        taskDetailsPO2.setSLTaskId(2);
        taskDetailsPO2.setDescription("Deep Dark Fantasy");
        taskDetailsPO2.setTaskType(201);
        taskDetailsPO2.setClasses(null);

        TableFactory.secondLevelTaskTable().getAll().add(secondLevelTaskPO);
        TableFactory.secondLevelTaskTable().getAll().add(secondLevelTaskPO2);
        TableFactory.taskDetailsTable().getAll().add(taskDetailsPO);
        TableFactory.taskDetailsTable().getAll().add(taskDetailsPO2);

        // 编号为1的一个二级任务的子任务
        ThirdLevelTaskPO thirdLevelTaskPO1 = new ThirdLevelTaskPO();
        thirdLevelTaskPO1.setId(1);
        thirdLevelTaskPO1.setSecondLevelTaskId(1);
        thirdLevelTaskPO1.setTaskName("Boy ♂ Next ♂ Door_1");
        thirdLevelTaskPO1.setStandardScore(200.0);
        thirdLevelTaskPO1.setEndDate(LocalDate.now().plusDays(5));
        thirdLevelTaskPO1.setTaskDetailsId(1);

        thirdLevelTaskPO1.setState(ThirdLevelTaskState.doing);

        List<String> picList1 = new ArrayList<>();
        picList1.add("iznauy/佟大为.jpg");

        thirdLevelTaskPO1.setPicList(picList1);
        thirdLevelTaskPO1.setTaskDescription("Deep Dark Fantasy");
        thirdLevelTaskPO1.setCurrentDoingWorkerIds(new ArrayList<>());
        thirdLevelTaskPO1.setFinishedWorkerIds(new ArrayList<>());

        thirdLevelTaskPO1.setTaskType(101);
        thirdLevelTaskPO1.setWorkerFilterId(1);

        // 标号为1的一个二级任务的第二个子任务
        ThirdLevelTaskPO thirdLevelTaskPO2 = new ThirdLevelTaskPO();
        thirdLevelTaskPO2.setId(2);
        thirdLevelTaskPO2.setSecondLevelTaskId(1);
        thirdLevelTaskPO2.setTaskName("Are you OK?");
        thirdLevelTaskPO2.setStandardScore(200.0);
        thirdLevelTaskPO2.setEndDate(LocalDate.now().plusDays(5));
        thirdLevelTaskPO2.setTaskDetailsId(1);

        thirdLevelTaskPO2.setState(ThirdLevelTaskState.doing);

        List<String> picList2 = new ArrayList<>();
        picList2.add("iznauy/Van.jpg");

        thirdLevelTaskPO2.setPicList(picList2);
        thirdLevelTaskPO2.setTaskDescription("Deep Dark Fantasy");
        thirdLevelTaskPO2.setCurrentDoingWorkerIds(new ArrayList<>());
        thirdLevelTaskPO2.setFinishedWorkerIds(new ArrayList<>());

        thirdLevelTaskPO2.setTaskType(101);
        thirdLevelTaskPO2.setWorkerFilterId(1);

        // 标号为2的一个二级任务的第一个子任务
        ThirdLevelTaskPO thirdLevelTaskPO2_1 = new ThirdLevelTaskPO();
        thirdLevelTaskPO2_1.setId(3);
        thirdLevelTaskPO2_1.setSecondLevelTaskId(2);
        thirdLevelTaskPO2_1.setTaskName("Indian Mi Fans");
        thirdLevelTaskPO2_1.setStandardScore(200.0);
        thirdLevelTaskPO2_1.setEndDate(LocalDate.now().plusDays(5));
        thirdLevelTaskPO2_1.setTaskDetailsId(1);

        thirdLevelTaskPO2_1.setState(ThirdLevelTaskState.doing);

        List<String> picList2_1 = new ArrayList<>();
        picList2_1.add("iznauyVan.jpg");

        thirdLevelTaskPO2_1.setPicList(picList2_1);
        thirdLevelTaskPO2_1.setTaskDescription("Are you OK?");
        thirdLevelTaskPO2_1.setCurrentDoingWorkerIds(new ArrayList<>());
        thirdLevelTaskPO2_1.setFinishedWorkerIds(new ArrayList<>());

        thirdLevelTaskPO2_1.setTaskType(201);
        thirdLevelTaskPO2_1.setWorkerFilterId(2);

        // 编号为1的用户过滤器 对应第一个二级任务
        WorkerFilterPO workerFilterPO = new WorkerFilterPO();
        workerFilterPO.setWorkerRankRatio(1.1);
        workerFilterPO.setId(1);

        // 编号为2的用户过滤器 对应第二个二级任务
        WorkerFilterPO workerFilterPO2 = new WorkerFilterPO();
        workerFilterPO2.setWorkerRankRatio(0.1);
        workerFilterPO2.setId(2);

        TableFactory.workerFilterTable().getAll().add(workerFilterPO);
        TableFactory.workerFilterTable().getAll().add(workerFilterPO2);
        TableFactory.thirdLevelTaskTable().getAll().add(thirdLevelTaskPO1);
        TableFactory.thirdLevelTaskTable().getAll().add(thirdLevelTaskPO2);
        TableFactory.thirdLevelTaskTable().getAll().add(thirdLevelTaskPO2_1);

        WorkerPO workerPO = new WorkerPO();
        workerPO.setScores(100.0);
        workerPO.setId(1);
        workerPO.setEmail("zy05160516@126.com");
        workerPO.setUsername("iznauy");
        workerPO.setPassword("iznauy");

        TableFactory.workerTable().getAll().add(workerPO);


        SecondLevelTaskPO girlFriendsSLTask = new SecondLevelTaskPO();
        girlFriendsSLTask.setTotalScore(10000.0);
        girlFriendsSLTask.setId(10);
        girlFriendsSLTask.setFirstLevelTaskId(10);
        girlFriendsSLTask.setTaskName("续命游戏");
        girlFriendsSLTask.setEndDate(LocalDate.now().plusDays(10));
        girlFriendsSLTask.setTaskDetailsId(5);

        TaskDetailsPO girlFriendTaskDetail = new TaskDetailsPO();
        girlFriendTaskDetail.setId(5);
        girlFriendTaskDetail.setSLTaskId(10);
        girlFriendTaskDetail.setTaskType(100);
        girlFriendTaskDetail.setDescription("这张图片写的是谁？");
        List<String> classes = new ArrayList<>();
        classes.add("伊丽莎白");
        classes.add("江泽民");
        classes.add("华莱士");
        classes.add("董建华");
        girlFriendTaskDetail.setClasses(classes);

        TableFactory.secondLevelTaskTable().getAll().add(girlFriendsSLTask);
        TableFactory.taskDetailsTable().getAll().add(taskDetailsPO);

        ThirdLevelTaskPO gfTask = new ThirdLevelTaskPO();
        gfTask.setId(10);
        gfTask.setSecondLevelTaskId(10);
        gfTask.setTaskName("黎明杀机_1");
        gfTask.setStandardScore(100.0);
        gfTask.setEndDate(girlFriendsSLTask.getEndDate());
        gfTask.setTaskDetailsId(5);

        List<String> picList = new ArrayList<>();
        picList.add("iznauy/董建华.jpg");
        picList.add("iznauy/伊丽莎白.jpg");
        picList.add("iznauy/华莱士.jpg");
        picList.add("iznauy/江泽民.jpg");

        gfTask.setPicList(picList);
        gfTask.setTaskDescription("这张图片写的是谁？");
        gfTask.setCurrentDoingWorkerIds(new ArrayList<>());
        gfTask.setFinishedWorkerIds(new ArrayList<>());
        gfTask.setWorkerFilterId(1);
        gfTask.setTaskType(100);
        gfTask.setState(ThirdLevelTaskState.doing);

        TableFactory.thirdLevelTaskTable().getAll().add(gfTask);

        TableFactory.saveAll();

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
