package top.minecode.service.taskexecute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.TagDao;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.user.User;

/**
 * Created on 2018/4/3.
 * Description:
 * @author Liao
 */
@Service
public class TagService {

    private TagDao tagDao;

    public TagDao getTagDao() {
        return tagDao;
    }

    @Autowired
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public void saveTag(int taskId, User user, String url, TagResult tagResult) {
        tagDao.saveTag(taskId, user, url, tagResult);
    }

    public TagResult getTagResult(int taskId, User user, String url) {
        return tagDao.getTagResult(taskId, user, url);
    }

    public String getNextPic(int taskId, String currentUrl) {
        return tagDao.getNextPic(taskId, currentUrl);
    }

    public String getPreviousPic(int taskId, String currentUrl) {
        return tagDao.getPreviousPic(taskId, currentUrl);
    }

    public String getTaskInfo(int taskId) {
        return tagDao.getTaskInfo(taskId);
    }


}
