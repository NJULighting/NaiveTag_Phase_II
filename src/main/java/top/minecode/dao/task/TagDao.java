package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.user.User;
import top.minecode.po.Table;
import top.minecode.po.TableFactory;
import top.minecode.po.ThirdLevelTaskPO;
import top.minecode.po.ThirdLevelTaskResultPO;

import java.util.List;

/**
 * Created on 2018/4/8.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class TagDao {

    private WorkerTaskUtils workerTaskUtils = new WorkerTaskUtils();

    public void saveTag(int taskId, User user, String url, TagResult tagResult) {
        Table<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTable
                = TableFactory.thirdLevelTaskResultTable();
        ThirdLevelTaskResultPO resultPO = workerTaskUtils.getResultPOByUserIdAndTaskId(user.getId(), taskId);
        resultPO.getTagResults().put(url, tagResult);
        thirdLevelTaskResultPOTable.save();
    }

    public TagResult getTagResult(int taskId, User user, String url) {
        ThirdLevelTaskResultPO resultPO = workerTaskUtils.getResultPOByUserIdAndTaskId(user.getId(), taskId);
        return resultPO.getTagResults().get(url);
    }

    public String getNextPic(int taskId, String currentUrl) {
        Table<ThirdLevelTaskPO> thirdLevelTaskPOTable
                = TableFactory.thirdLevelTaskTable();
        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTable
                .getPOBy(taskId, ThirdLevelTaskPO::getId);
        List<String> picList = thirdLevelTaskPO.getPicList();
        int index = picList.indexOf(currentUrl);
        if (index == picList.size() - 1)
            return null;
        return picList.get(index + 1);
    }

    public String getPreviousPic(int taskId, String currentUrl) {
        Table<ThirdLevelTaskPO> thirdLevelTaskPOTable
                = TableFactory.thirdLevelTaskTable();
        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTable
                .getPOBy(taskId, ThirdLevelTaskPO::getId);
        List<String> picList = thirdLevelTaskPO.getPicList();
        int index = picList.indexOf(currentUrl);
        if (index == 0)
            return null;
        return picList.get(index - 1);
    }



}
