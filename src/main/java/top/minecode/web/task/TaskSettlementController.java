package top.minecode.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import top.minecode.service.taskmanage.TaskSettlementService;

/**
 * Created on 2018/4/13.
 * Description:
 * 每日自动结算
 * @author iznauy
 */

@Controller
public class TaskSettlementController {

    private TaskSettlementService taskSettlementService;

    public TaskSettlementService getTaskSettlementService() {
        return taskSettlementService;
    }

    public void setTaskSettlementService(TaskSettlementService taskSettlementService) {
        this.taskSettlementService = taskSettlementService;
    }

    @Scheduled(cron = "0 5 0 * * ?")  // 每天早上0点5分执行
    public void settleTasks() {
        taskSettlementService.settle();
    }

}
