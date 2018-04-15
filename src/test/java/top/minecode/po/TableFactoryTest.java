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

    @Test
    public void testSaveAll() throws Exception {
        FirstLevelTaskPO newTask = new FirstLevelTaskPO();
        newTask.setTaskName("Excited");
        TableFactory.firstLevelTaskTable().add(newTask);

        WorkerPO newWorker = new WorkerPO();
        newWorker.setName("Frog");
        TableFactory.workerTable().add(new WorkerPO());

        TableFactory.saveAll();
    }
}