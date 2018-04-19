package top.minecode.service.taskmanage;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.dao.task.requester.RequesterTaskDao;
import top.minecode.dao.task.requester.TaskDeliveryDao;
import top.minecode.domain.task.TaskConfig;
import top.minecode.domain.task.TaskInfo;
import top.minecode.domain.task.requester.NewTaskInfo;
import top.minecode.domain.task.requester.RequesterTaskDetails;
import top.minecode.domain.task.requester.RequesterTaskInfo;
import top.minecode.domain.task.requester.TaskParticipant;
import top.minecode.po.FirstLevelTaskPO;
import top.minecode.po.SecondLevelTaskPO;
import top.minecode.utils.unzip.ZipHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2018/4/8.
 * Description:
 * @author Liao
 */
@Service
public class RequesterTaskService {

    private RequesterTaskDao requesterTaskDao;
    private RequesterStatisticDao requesterStatisticDao;
    private TaskDeliveryDao taskDeliveryDao;

    @Autowired
    public void setRequesterStatisticDao(RequesterStatisticDao requesterStatisticDao) {
        this.requesterStatisticDao = requesterStatisticDao;
    }

    @Autowired
    public void setTaskDeliveryDao(TaskDeliveryDao taskDeliveryDao) {
        this.taskDeliveryDao = taskDeliveryDao;
    }

    @Autowired
    public void setRequesterTaskDao(RequesterTaskDao requesterTaskDao) {
        this.requesterTaskDao = requesterTaskDao;
    }

    public List<RequesterTaskInfo> getTasksInfo(int ownerId) {

        List<FirstLevelTaskPO> tasks = requesterTaskDao.getTasks(ownerId);
        Map<Integer, Double> tasksProcess = requesterStatisticDao.getTaskTotalProcess(ownerId);

        return tasks.stream().map(po -> new RequesterTaskInfo(po, tasksProcess.get(po.getId())))
                .collect(Collectors.toList());
    }

    public List<RequesterTaskDetails> getTaskDetails(int taskId) {
        // Get task information and participants
        Map<Integer, Double> processes = requesterStatisticDao.getSecondLevelTaskProcess(taskId);
        Map<Integer, List<TaskParticipant>> participants = requesterTaskDao.getParticipants(taskId);
        Map<Integer, TaskInfo> taskInfoMap = requesterTaskDao.secondLevelTaskInfo(taskId);

        // Combine them to RequesterTaskDetails list
        List<RequesterTaskDetails> details = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : processes.entrySet()) {
            int secondLvTaskId = entry.getKey();
            details.add(new RequesterTaskDetails(entry.getValue(),
                    participants.get(secondLvTaskId), taskInfoMap.get(secondLvTaskId)));
        }

        return details;
    }

    public void saveFile(MultipartFile dataSet, MultipartFile taskJson, String dataPath, NewTaskInfo newTaskInfo) throws IOException {
        String dataSetPath = dataPath + dataSet.getOriginalFilename();
        String taskJsonPath = dataPath + "task.json";
        dataSet.transferTo(new File(dataSetPath));
        taskJson.transferTo(new File(taskJsonPath));

        FirstLevelTaskPO flTask = taskDeliveryDao.addFirstLevelTask(dataPath, newTaskInfo);
        String imageFilePath = unZip(dataPath, dataSetPath);

        TaskConfig taskConfig = new TaskConfig(taskJsonPath);
        // Calculate how many third level tasks a second level task should keep
        double score = newTaskInfo.getScore() / taskConfig.size();
        for (TaskInfo info : taskConfig) {
            SecondLevelTaskPO secondLevelTask = taskDeliveryDao.addSecondLevelTask(info, flTask, score);
            taskDeliveryDao.addThirdLevelTask(imageFilePath, secondLevelTask, info, flTask);
        }
    }

    @NotNull
    private String unZip(String dataPath, String dataSetPath) throws IOException {
        // Unzip the file
        ZipHelper zipper = new ZipHelper();
        String unZipPath = dataPath + "images";
        return zipper.unZip(dataSetPath, unZipPath);
    }

    public int getNewTaskSequenceNumber(int ownerId) {
        return requesterTaskDao.getTasks(ownerId).size() + 1;
    }

    private List<String> getImages(String unZipPath) {
        // Go into the folder until find the images
        File imageFile = new File(unZipPath);
        while (imageFile.isDirectory()) {
            File[] files = imageFile.listFiles();
            assert files != null && files[0] != null;
            if (files[0].isDirectory()) {
                imageFile = files[0];
            } else {
                break;
            }
        }
        File[] images = imageFile.listFiles();
        assert images != null;
        return Stream.of(images).map(File::getName).collect(Collectors.toList());
    }
}
