package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.statistic.RequesterStatisticDao;
import top.minecode.dao.task.RequesterTaskDao;
import top.minecode.domain.task.RequesterTaskInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/8.
 * Description:
 * @author Liao
 */
@Service
public class RequesterTaskService {

    private RequesterTaskDao requesterTaskDao;
    private RequesterStatisticDao requesterStatisticDao;

    @Autowired
    public void setRequesterStatisticDao(RequesterStatisticDao requesterStatisticDao) {
        this.requesterStatisticDao = requesterStatisticDao;
    }

    @Autowired
    public void setRequesterTaskDao(RequesterTaskDao requesterTaskDao) {
        this.requesterTaskDao = requesterTaskDao;
    }

    public List<RequesterTaskInfo> getTasksInfo(int ownerId) {
        // TODO: 2018/4/8 Change "process" here
        return requesterTaskDao.getTasks(ownerId).stream()
                .map(po -> new RequesterTaskInfo(po, requesterStatisticDao.getTaskProcess(po.getId())))
                .collect(Collectors.toList());
    }
}
