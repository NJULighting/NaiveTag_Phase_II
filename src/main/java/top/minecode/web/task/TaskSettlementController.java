package top.minecode.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @Autowired
    public void setTaskSettlementService(TaskSettlementService taskSettlementService) {
        this.taskSettlementService = taskSettlementService;
    }

    @Scheduled(cron = "30 * * * * ?")  // 每天早上0点5分执行
    public void settleTasks() {
        System.out.println("Task Settlement in controller");
        taskSettlementService.settle();
    }

}
