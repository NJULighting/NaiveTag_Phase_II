package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.WorkerTaskDao;
import top.minecode.domain.task.*;
import top.minecode.domain.user.User;
import top.minecode.json.JsonConfig;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.po.ThirdLevelTaskResultPO;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class TaskDetailService {

    private WorkerTaskDao workerTaskDao;

    public WorkerTaskDao getWorkerTaskDao() {
        return workerTaskDao;
    }

    @Autowired
    public void setWorkerTaskDao(WorkerTaskDao workerTaskDao) {
        this.workerTaskDao = workerTaskDao;
    }

    public WorkerTaskDetail getWorkerTaskDetail(User user, int taskId) {
        ThirdLevelTaskPO rawTaskPO = workerTaskDao.loadTaskByTaskId(taskId);
        ThirdLevelTaskResultPO taskResultPO = workerTaskDao.loadTaskResultByUserAndTaskId(user, taskId);
        System.out.println(JsonConfig.getGson().toJson(taskResultPO));
        if (taskResultPO == null) { //此前没接过这个任务

            UnacceptedTaskDetail unacceptedTaskDetail = new UnacceptedTaskDetail();
            unacceptedTaskDetail.setAverageScore(rawTaskPO.getStandardScore());
            unacceptedTaskDetail.setCanAccept(workerTaskDao.canAcceptTask(user, taskId));
            unacceptedTaskDetail.setTaskType(rawTaskPO.getTaskType());
            unacceptedTaskDetail.setState(WorkerTaskState.unaccept);
            unacceptedTaskDetail.setTaskName(rawTaskPO.getTaskName());
            unacceptedTaskDetail.setTaskDescription(rawTaskPO.getTaskDescription());
            unacceptedTaskDetail.setPicList(rawTaskPO.getPicList());
            unacceptedTaskDetail.setCover(rawTaskPO.getCover());
            return unacceptedTaskDetail;

        } else {
            if (taskResultPO.getState() == ThirdLevelTaskResultType.doing) {

                AcceptedTaskDetail acceptedTaskDetail = new AcceptedTaskDetail();
                acceptedTaskDetail.setState(WorkerTaskState.accept);
                acceptedTaskDetail.setTaskName(rawTaskPO.getTaskName());
                acceptedTaskDetail.setTaskType(rawTaskPO.getTaskType());
                acceptedTaskDetail.setAverageScore(rawTaskPO.getStandardScore());
                acceptedTaskDetail.setBeginDate(taskResultPO.getAcceptTime());
                acceptedTaskDetail.setEndDate(taskResultPO.getExpireTime());
                Set<String> labeledPics = taskResultPO.getTagResults().keySet();
                acceptedTaskDetail.setFinishedPicList(new ArrayList<>(labeledPics));
                acceptedTaskDetail.setUnfinishedPicList(rawTaskPO.getPicList().stream()
                        .filter(e -> !labeledPics.contains(e)).collect(Collectors.toList()));
                acceptedTaskDetail.setCover(rawTaskPO.getCover());
                return acceptedTaskDetail;

            } else if (taskResultPO.getState() == ThirdLevelTaskResultType.expired) {

                ExpiredTaskDetail expiredTaskDetail = new ExpiredTaskDetail();
                expiredTaskDetail.setState(WorkerTaskState.fail);
                expiredTaskDetail.setTaskName(rawTaskPO.getTaskName());
                expiredTaskDetail.setTaskType(rawTaskPO.getTaskType());
                expiredTaskDetail.setTaskDescription(rawTaskPO.getTaskDescription());
                expiredTaskDetail.setBeginDate(taskResultPO.getAcceptTime());
                expiredTaskDetail.setEndDate(taskResultPO.getExpireTime());
                expiredTaskDetail.setCover(rawTaskPO.getCover());
                return expiredTaskDetail;

            } else if (taskResultPO.getState() == ThirdLevelTaskResultType.unpay) {

                UnpayedTaskDetail unpayedTaskDetail = new UnpayedTaskDetail();
                unpayedTaskDetail.setState(WorkerTaskState.unpay);
                unpayedTaskDetail.setTaskName(rawTaskPO.getTaskName());
                unpayedTaskDetail.setTaskType(rawTaskPO.getTaskType());
                unpayedTaskDetail.setTaskDescription(rawTaskPO.getTaskDescription());
                unpayedTaskDetail.setBeginDate(taskResultPO.getAcceptTime());
                unpayedTaskDetail.setEndDate(taskResultPO.getExpireTime());
                unpayedTaskDetail.setPayDay(rawTaskPO.getEndDate());
                unpayedTaskDetail.setCover(rawTaskPO.getCover());
                return unpayedTaskDetail;

            } else if (taskResultPO.getState() == ThirdLevelTaskResultType.finish) {

                FinishedTaskDetail finishedTaskDetail = new FinishedTaskDetail();
                finishedTaskDetail.setState(WorkerTaskState.finish);
                finishedTaskDetail.setTaskName(rawTaskPO.getTaskName());
                finishedTaskDetail.setTaskType(rawTaskPO.getTaskType());
                finishedTaskDetail.setTaskDescription(rawTaskPO.getTaskDescription());
                finishedTaskDetail.setEarnedScore(taskResultPO.getActualScore());
                finishedTaskDetail.setBeginDate(taskResultPO.getAcceptTime());
                finishedTaskDetail.setEndDate(taskResultPO.getExpireTime());
                finishedTaskDetail.setCover(rawTaskPO.getCover());
                return finishedTaskDetail;

            }
        }
        return null;
    }

}
