package top.minecode.po;

import org.testng.annotations.Test;
import top.minecode.domain.task.TaskInfo;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.user.User;

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

    @Test
    public void addSecondTask() {
        SecondLevelTaskPO secondLevelTaskPO = new SecondLevelTaskPO();
        secondLevelTaskPO.setId(1);
        secondLevelTaskPO.setTaskName("Boy ♂ Next ♂ Door");
        secondLevelTaskPO.setEndDate(LocalDate.now().plusDays(5));
        secondLevelTaskPO.setTaskDetailsId(1);
        secondLevelTaskPO.setTotalScore(2000.0);

        TaskDetailsPO taskDetailsPO = new TaskDetailsPO();
        taskDetailsPO.setId(1);
        taskDetailsPO.setSLTaskId(1);
        taskDetailsPO.setDescription("Deep Dark Fantasy");
        taskDetailsPO.setTaskType(100);
        taskDetailsPO.setClasses(null);

        TableFactory.secondLevelTaskTable().getAll().add(secondLevelTaskPO);
        TableFactory.taskDetailsTable().getAll().add(taskDetailsPO);

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

        thirdLevelTaskPO1.setTaskType(100);
        thirdLevelTaskPO1.setWorkerFilterId(1);

        WorkerFilterPO workerFilterPO = new WorkerFilterPO();
        workerFilterPO.setWorkerRankRatio(1.1);

        ThirdLevelTaskPO thirdLevelTaskPO2 = new ThirdLevelTaskPO();
        thirdLevelTaskPO2.setId(2);
        thirdLevelTaskPO2.setSecondLevelTaskId(1);
        thirdLevelTaskPO2.setTaskName("Boy ♂ Next ♂ Door_2");
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

        thirdLevelTaskPO2.setTaskType(100);
        thirdLevelTaskPO2.setWorkerFilterId(1);

        TableFactory.workerFilterTable().getAll().add(workerFilterPO);
        TableFactory.thirdLevelTaskTable().getAll().add(thirdLevelTaskPO1);
        TableFactory.thirdLevelTaskTable().getAll().add(thirdLevelTaskPO2);

        WorkerPO workerPO = new WorkerPO();
        workerPO.setScores(100.0);
        workerPO.setId(1);
        workerPO.setEmail("zy05160516@126.com");
        workerPO.setUsername("iznauy");
        workerPO.setPassword("iznauy");

        TableFactory.workerTable().getAll().add(workerPO);
        TableFactory.saveAll();

    }

}
