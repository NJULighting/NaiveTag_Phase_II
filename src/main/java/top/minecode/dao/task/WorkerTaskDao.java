package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.domain.user.User;
import top.minecode.po.DataBase;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.po.WorkerFilterPO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */

@Repository
public class WorkerTaskDao {

    public List<ThirdLevelTaskPO> getAccessibleTaskList(User user) {

        // 获取用户当前排名比例
        Integer rank = DataBase.rankPO.getRankByName(user.getName());
        int totalWorkerAmount = DataBase.workerPOList.getNextWorkerId() - 1;
        double ratio = rank == null ? 1.0 : rank * 1.0 / totalWorkerAmount;

        List<ThirdLevelTaskPO> allThirdLevelTaskPOS = DataBase.thirdLevelTaskPOList.getThirdLevelTaskPOS();
        List<WorkerFilterPO> workerFilterPOS = DataBase.workerFilterPOList.getWorkerFilterList();

        // 根据任务状态、用户排名是否足够接、用户是否已经接过或者完成过进行筛选，筛选出可以接的任务
        return allThirdLevelTaskPOS.stream().filter(e -> e.getState() == ThirdLevelTaskState.doing)
                .filter( e -> workerFilterPOS.stream()
                    .filter( t -> t.getId().equals(e.getWorkerFilterId()))
                        .findFirst().get().getWorkerRankRatio() >= ratio
                ).filter(e -> e.getFinishedWorkerIds().contains(user.getId())
                    || e.getCurrentDoingWorkerIds().contains(user.getId()))
                .collect(Collectors.toList());
    }

}
