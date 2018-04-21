package top.minecode.dao.task.requester;

import org.springframework.stereotype.Repository;
import top.minecode.domain.task.TaskInfo;
import top.minecode.domain.task.requester.NewTaskInfo;
import top.minecode.exception.InvalidFileStructureException;
import top.minecode.po.*;
import top.minecode.utils.ImagesSet;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2018/4/19.
 * Description:
 * @author Liao
 */
@Repository
public class TaskDeliveryDao {

    public FirstLevelTaskPO addFirstLevelTask(String dataDirectory, NewTaskInfo taskInfo) throws IOException {
        // Create FirstLevelTaskPO
        Table<FirstLevelTaskPO> flTaskTable = TableFactory.firstLevelTaskTable();
        // Create result file for the task
        File resultFile = new File(dataDirectory + "result");
        if (!resultFile.mkdir())
            throw new IOException("make directory failed");
        // Add worker filter
        Table<WorkerFilterPO> filterTable = TableFactory.workerFilterTable();
        WorkerFilterPO filterPO = new WorkerFilterPO(taskInfo.getWorkerFilter(), filterTable.getNextId());
        filterTable.add(filterPO);

        // Add first level task
        FirstLevelTaskPO flTask = new FirstLevelTaskPO(taskInfo, flTaskTable.getNextId(),
                resultFile.getPath(), filterPO.getId());
        flTaskTable.add(flTask);
        return flTask;
    }

    public SecondLevelTaskPO addSecondLevelTask(TaskInfo info, FirstLevelTaskPO firstLevelTask, double score) {

        Table<TaskDetailsPO> detailsTable = TableFactory.taskDetailsTable();
        Table<SecondLevelTaskPO> slTaskTable = TableFactory.secondLevelTaskTable();

        int sltId = slTaskTable.getNextId();
        int detailId = detailsTable.getNextId();

        String slTaskName = firstLevelTask.getTaskName();
        TaskDetailsPO detailPO = new TaskDetailsPO(detailId, sltId, info.getTaskType(),
                info.getDescription(), info.getClasses());
        SecondLevelTaskPO SLTask = new SecondLevelTaskPO(sltId, firstLevelTask.getId(), slTaskName,
                score, firstLevelTask.getEndDate(), detailId);
        slTaskTable.add(SLTask);
        detailsTable.add(detailPO);

        return SLTask;
    }

    public void addThirdLevelTask(String imageFilePath, SecondLevelTaskPO secondLevelTaskPO, TaskInfo taskInfo, FirstLevelTaskPO firstLevelTaskPO) {
        Table<ThirdLevelTaskPO> taskTable = TableFactory.thirdLevelTaskTable();
        ImagesSet images = new ImagesSet(imageFilePath, secondLevelTaskPO.getTotalScore());
        for (ImagesSet.SubImageSet image : images) {
            ThirdLevelTaskPO thirdLevelTaskPO = new ThirdLevelTaskPO(taskTable.getNextId(), secondLevelTaskPO.getId(),
                    secondLevelTaskPO.getTaskName(), image.getScores() / 3, secondLevelTaskPO.getEndDate(),
                    secondLevelTaskPO.getTaskDetailsId(), image.getImages(), taskInfo.getDescription(),
                    firstLevelTaskPO.getWorkerFilterId(), taskInfo.getTaskType());
            taskTable.add(thirdLevelTaskPO);
        }
    }
}