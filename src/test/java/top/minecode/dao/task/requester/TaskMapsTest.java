package top.minecode.dao.task.requester;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 2018/4/26.
 * Description:
 * @author Liao
 */
public class TaskMapsTest {

    @Ignore
    public void getSecondTasks() {
        TaskMaps.INSTANCE.getSecondTasks(2).forEach(System.out::println);
    }

    @Test
    public void oneThreeIdObjMap() {
    }

    @Test
    public void twoThreeIdObjMap() {
    }
}