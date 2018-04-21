package top.minecode.web.task;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
public class RequesterTasksControllerTest {

    private RequesterTasksController controller = new RequesterTasksController();

    @Test
    public void testCheckJsonFile() throws Exception {
        Resource resource = new ClassPathResource("task.json");
        MockMultipartFile multipartFile = new MockMultipartFile("taskconf", resource.getFilename(),
                "text/plain", resource.getInputStream());

        assertTrue(controller.checkJsonFile(multipartFile).contains("valid"));
    }

    @Test
    public void testCheckInvalidJsonFile() throws Exception {
        Resource resource = new ClassPathResource("invalidtask.json");
        MultipartFile multipartFile = new MockMultipartFile("task", resource.getFilename(),
                "text/plain", resource.getInputStream());

        assertTrue(controller.checkJsonFile(multipartFile).contains("invalid"));
    }
}