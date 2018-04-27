package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
@ContextConfiguration("classpath:naive-context.xml")
public class RequesterTasksControllerTest extends AbstractTestNGSpringContextTests {
//
//    private RequesterTasksController controller;
//
////    @Autowired
//    public void setController(RequesterTasksController controller) {
//        this.controller = controller;
//    }
//
////    @Test
//    public void testCheckJsonFile() throws Exception {
//        Resource resource = new ClassPathResource("task.json");
//        MockMultipartFile multipartFile = new MockMultipartFile("taskconf", resource.getFilename(),
//                "text/plain", resource.getInputStream());
//
//        assertTrue(controller.checkJsonFile(multipartFile).contains("valid"));
//    }
//
////    @Test
//    public void testCheckInvalidJsonFile() throws Exception {
//        Resource resource = new ClassPathResource("invalidtask.json");
//        MultipartFile multipartFile = new MockMultipartFile("task", resource.getFilename(),
//                "text/plain", resource.getInputStream());
//
//        assertTrue(controller.checkJsonFile(multipartFile).contains("invalid"));
//    }
}