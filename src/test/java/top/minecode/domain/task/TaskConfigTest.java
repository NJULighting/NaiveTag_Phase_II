package top.minecode.domain.task;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created on 2018/4/19.
 * Description:
 * @author Liao
 */
public class TaskConfigTest {

//    @Test
    public void testCheck() throws Exception {
        Resource resource = new ClassPathResource("task.json");
        TaskConfig taskConfig = new TaskConfig(resource.getFile().getPath());
        assertNotNull(taskConfig);

        taskConfig.forEach(System.out::println);

        assertEquals(taskConfig.check(), TaskConfig.Result.valid);
    }
}