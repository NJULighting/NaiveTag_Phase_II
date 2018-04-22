package top.minecode.web.task;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.minecode.domain.task.TaskConfig;
import top.minecode.domain.task.requester.NewTaskInfo;
import top.minecode.domain.task.requester.RequesterTaskDetails;
import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.exception.InvalidFileStructureException;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.RequesterTaskService;
import top.minecode.utils.Config;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Controller
@RequestMapping("/requester")
public class RequesterTasksController extends BaseController {

    private static final String RESULT = "result";
    private RequesterTaskService service;

    @Autowired
    public void setService(RequesterTaskService service) {
        this.service = service;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String getTasks(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<RequesterTaskInfo> tasks = service.getTasksInfo(user.getId());
        return JsonConfig.getGson().toJson(tasks);
    }

    @RequestMapping("/details")
    @ResponseBody
    public String getTaskDetail(@RequestParam("taskId") int taskId) {
        List<RequesterTaskDetails> details = service.getTaskDetails(taskId);
        return JsonConfig.getGson().toJson(details);
    }

    /**
     * Process requester's creating tasks request.
     * @param taskInfo new task's information
     * @param dataset data set (image set)
     * @param taskconf task.json which is the configuration file of the task
     * @return see details in the documents
     */
    @RequestMapping("/new")
    @ResponseBody
    public String newTask(HttpServletRequest request, NewTaskInfo taskInfo,
                          @RequestParam("dataset") MultipartFile dataset,
                          @RequestParam("taskconf") MultipartFile taskconf) {

        JsonObject result = new JsonObject();
        Gson gson = JsonConfig.getGson();
        Config config = Config.INSTANCE;

        String rawDataSetPath = getPath(config.getRawFilePath(), request);

        // Save the file
        try {
            User user = getSessionUser(request);
            taskInfo.setOwnerId(user.getId());
            service.saveFile(dataset, taskconf, rawDataSetPath, taskInfo);
        } catch (InvalidFileStructureException e) {
            e.printStackTrace();
            result.addProperty("result", "failure");
        } catch (IOException e) {
            e.printStackTrace();
            result.addProperty("result", "failure");
            return gson.toJson(result);
        }

        result.addProperty("result", "success");
        return gson.toJson(result);
    }

    /**
     * Check the task.json file
     * @param taskconf the task.json file uploaded
     * @return {"result" : "valid"} if the file's content is valid, otherwise
     * {"result" : "invalid"} will be returned.
     */
    @RequestMapping("/check")
    @ResponseBody
    public String checkJsonFile(@RequestParam("taskconf") MultipartFile taskconf) {
        JsonObject result = new JsonObject();
        Gson gson = JsonConfig.getGson();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(taskconf.getInputStream()))) {
            TaskConfig taskConfig = new TaskConfig(reader);
            result.addProperty(RESULT, taskConfig.check().toString());
            return gson.toJson(result);
        } catch (IOException e) {
            e.printStackTrace();
            result.addProperty(RESULT, TaskConfig.Result.invalid.toString());
            return gson.toJson(result);
        }
    }

    /**
     * Download the result file
     * @param taskId id of the task
     * @param response http response
     */
    @RequestMapping("/download")
    public void download(@RequestParam("taskId") int taskId, HttpServletResponse response) {
        // Check state of the task
        if (!service.isDone(taskId))
            return;

        String resultPath = service.getResult(taskId);
        Resource resource = new FileSystemResource(resultPath);
        try {
            IOUtils.copy(resource.getInputStream(), response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the path to which the dataset and task.json will save to.
     * @param basePath base path
     * @param request request of some user which is used to get the information about the user
     * @return a path which is like 'servletContextPath/basePath/1(userId)/123(sequence number)/'
     */
    private String getPath(String basePath, HttpServletRequest request) {
        User user = getSessionUser(request);
        String separator = File.separator;
        int taskSequenceNumber = service.getNewTaskSequenceNumber(user.getId());

        // Change the file path to standard from which is like 'servletContextPath/basePath/userId/taskSequenceNumber/'
        String filePath = request.getSession().getServletContext().getRealPath(basePath) + separator
                + user.getId() + separator + taskSequenceNumber + separator;
        File file = new File(filePath);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }

        return filePath;
    }
}
