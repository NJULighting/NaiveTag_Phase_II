package top.minecode.service.taskmanage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import top.minecode.domain.task.requester.NewTaskInfo;
import top.minecode.po.TableFactory;

import java.io.File;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
@ContextConfiguration("classpath:naive-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RequesterTaskServiceTest {

    private RequesterTaskService service;

    @Autowired
    public void setService(RequesterTaskService service) {
        this.service = service;
    }

    @Test
    public void saveFile() throws Exception {
        String classPath = RequesterTaskServiceTest.class.getResource("/").getPath() + File.separator;

        // Create a file in class path
        String dirPath = classPath  + "data";
        File dir = new File(dirPath);
        assertTrue(dir.mkdir());


        Resource datasetRes = new ClassPathResource("dataForTest.zip");
        Resource taskJsonRes = new ClassPathResource("task.json");
        MultipartFile dataSet = new MockMultipartFile("dataset", datasetRes.getFilename(),
                "text/plain", datasetRes.getInputStream());
        MultipartFile taskJson = new MockMultipartFile("taskJson", taskJsonRes.getFilename(),
                "text/plain", taskJsonRes.getInputStream());

        // Set worker filter
        NewTaskInfo.WorkerFilter filter = new NewTaskInfo.WorkerFilter();
        filter.setAverageScore(1.0);
        filter.setWorkerRankRate(0.5);

        // Set new task info
        NewTaskInfo newTaskInfo = new NewTaskInfo(123, "frog", filter, LocalDate.now(), 100000.0);


        service.saveFile(dataSet, taskJson, dirPath + File.separator, newTaskInfo);
        // Check table's data
        TableFactory.printAll();

        assertTrue(FileSystemUtils.deleteRecursively(dir));
    }
}