package top.minecode.service.taskexecute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minecode.dao.task.TagDao;
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

    public void saveTag(int taskId, User user, String url) {

    }



}
