package top.minecode.web.task;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.minecode.domain.task.requester.NewTaskInfo;
import top.minecode.domain.task.requester.RequesterTaskDetails;
import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.service.taskmanage.RequesterTaskService;
import top.minecode.utils.Config;
import top.minecode.domain.task.TaskConfig;
import top.minecode.web.common.BaseController;

import javax.servlet.http.HttpServletRequest;
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
        } catch (IOException e) {
            e.printStackTrace();
            result.addProperty("result", "failure");
            return gson.toJson(result);
        }


        return null;
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

    private String getPath(String basePath, HttpServletRequest request) {
        User user = getSessionUser(request);
        String separator = File.separator;
        int taskSequenceNumber = service.getNewTaskSequenceNumber(user.getId());

        // Change the file path to standard from which is like 'servletContextPath/basePath/userId/taskSequenceNumber/'
        String filePath =  request.getSession().getServletContext().getRealPath(basePath) + separator
                + user.getId() + separator + taskSequenceNumber + separator;
        File file = new File(filePath);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }

        return filePath;
    }
}
