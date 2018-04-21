package top.minecode.po;

import org.testng.annotations.Test;
import top.minecode.domain.user.Worker;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.TableFactory;
import top.minecode.po.WorkerPO;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/14.
 * Description:
 * @author Liao
 */
public class TableFactoryTest {

 //   @Test
    public void testSaveAll() throws Exception {
        FirstLevelTaskPO taskPO = new FirstLevelTaskPO();
        taskPO.setTaskName("Excited");
        TableFactory.firstLevelTaskTable().add(taskPO);
        TableFactory.firstLevelTaskTable()
                .getPOBy("Excited", FirstLevelTaskPO::getTaskName).setTaskName("ExcitedTask");

        WorkerPO workerPO = new WorkerPO();
        workerPO.setName("Frog");
        TableFactory.workerTable().add(workerPO);
        TableFactory.workerTable().getPOBy("Frog", WorkerPO::getName).setName("ExcitedFrog");

        TableFactory.saveAll();
    }
}