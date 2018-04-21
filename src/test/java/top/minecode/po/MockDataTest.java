package top.minecode.po;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.TaskInfo;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.user.User;
import top.minecode.domain.user.Worker;
import top.minecode.json.JsonConfig;


import static org.testng.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/19.
 * Description:
 *
 * @author iznauy
 */
public class MockDataTest {

    private User user;

    private WorkerTaskDao workerTaskDao = new WorkerTaskDao();

   // @BeforeTest
    public void addSecondTask() {

        // 编号为1的二级任务
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
        picList1.add("佟大为.jpg");

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
        picList2.add("佟大为.jpg");

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
        picList2_1.add("佟大为.jpg");

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

        user = new User();
        user.setId(1);
        user.setName("ok");
        user.setUsername("iznauy");

    }

 //   @Test
    public void workerAccessTest() {
        List<ThirdLevelTaskPO> thirdLevelTaskPOS = workerTaskDao.getAccessibleTaskList(user);
        System.out.println(JsonConfig.getGson().toJson(thirdLevelTaskPOS));
        assertEquals(thirdLevelTaskPOS.size(), 2);
    }

  //  @Test
    public void workerSearchTest() {
        List<ThirdLevelTaskPO> thirdLevelTaskPOS = workerTaskDao.searchingTaskByKey(user, "OK");
        assertEquals(thirdLevelTaskPOS.size(), 1);
        System.out.println(JsonConfig.getGson().toJson(thirdLevelTaskPOS));
    }

}
