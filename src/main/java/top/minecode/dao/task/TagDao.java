package top.minecode.dao.task;

import org.springframework.stereotype.Repository;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.user.User;
import top.minecode.po.TableCandidate;
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

    private TableCandidate<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTableCandidate
             = TableFactory.thirdLevelTaskResultTable();

    private TableCandidate<ThirdLevelTaskPO> thirdLevelTaskPOTableCandidate
             = TableFactory.thirdLevelTaskTable();

    private ThirdLevelTaskResultPO getResultPOByUserIdAndTaskId(int userId, int taskId) {
         return thirdLevelTaskResultPOTableCandidate
                .getAll().stream().filter(e -> e.getDoerId().equals(userId)
                        && e.getThirdLevelTaskId().equals(taskId)).findFirst()
                .get();
    }

    public void saveTag(int taskId, User user, String url, TagResult tagResult) {
        ThirdLevelTaskResultPO resultPO = getResultPOByUserIdAndTaskId(user.getId(), taskId);
        resultPO.getTagResults().put(url, tagResult);
        thirdLevelTaskResultPOTableCandidate.save();
    }

    public TagResult getTagResult(int taskId, User user, String url) {
        ThirdLevelTaskResultPO resultPO = getResultPOByUserIdAndTaskId(user.getId(), taskId);
        return resultPO.getTagResults().get(url);
    }

    public String getNextPic(int taskId, String currentUrl) {
        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTableCandidate
                .getPOBy(taskId, ThirdLevelTaskPO::getId);
        List<String> picList = thirdLevelTaskPO.getPicList();
        int index = picList.indexOf(currentUrl);
        if (index == picList.size() - 1)
            return null;
        return picList.get(index + 1);
    }

    public String getPreviousPic(int taskId, String currentUrl) {
        ThirdLevelTaskPO thirdLevelTaskPO = thirdLevelTaskPOTableCandidate
                .getPOBy(taskId, ThirdLevelTaskPO::getId);
        List<String> picList = thirdLevelTaskPO.getPicList();
        int index = picList.indexOf(currentUrl);
        if (index == 0)
            return null;
        return picList.get(index - 1);
    }

}
