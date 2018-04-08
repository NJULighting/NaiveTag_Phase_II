package top.minecode.service.taskmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    public void setRequesterTaskDao(RequesterTaskDao requesterTaskDao) {
        this.requesterTaskDao = requesterTaskDao;
    }

    public List<RequesterTaskInfo> getTasksInfo() {
        // TODO: 2018/4/8 Change "process" here
        return requesterTaskDao.getTasks().stream()
                .map(po -> new RequesterTaskInfo(po, 0))
                .collect(Collectors.toList());
    }
}
