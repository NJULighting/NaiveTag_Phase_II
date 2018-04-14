package top.minecode.domain.task.requester;

import java.time.LocalDate;

/**
 * Created on 2018/4/14.
 * Description:
 * @author Liao
 */
public class NewTaskInfo {
    private String taskName; // Task
    private WorkerFilter workerFilter; // The limit set for worker
    private LocalDate startTime; // Start time of the task
    private LocalDate endTime; // DDL of the task
    private Double score; // Score provided for the workers

    private static class WorkerFilter {
        private Double workerRankRate;
        private Double averageScore;
    }
}
