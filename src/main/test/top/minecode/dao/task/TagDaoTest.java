package top.minecode.dao.task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import top.minecode.domain.tag.GlobalTagResult;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.user.User;
import top.minecode.domain.user.Worker;
import top.minecode.json.JsonConfig;
import top.minecode.po.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/11.
 * Description:
 *
 * @author iznauy
 */
public class TagDaoTest {

    private TableCandidate<ThirdLevelTaskPO> thirdLevelTaskPOTableCandidate;

    private TableCandidate<ThirdLevelTaskResultPO> thirdLevelTaskResultPOTableCandidate;

    private TagDao tagDao;

    private User user;

    @BeforeClass
    public void init() throws Exception {
        thirdLevelTaskPOTableCandidate = TableFactory.thirdLevelTaskTable();
        thirdLevelTaskResultPOTableCandidate = TableFactory.thirdLevelTaskResultTable();

        ThirdLevelTaskPO thirdLevelTaskPO = new ThirdLevelTaskPO();
        thirdLevelTaskPO.setId(1);

        List<String> picList = new ArrayList<>();
        picList.add("1.jpg");
        picList.add("2.jpg");
        picList.add("3.jpg");
        thirdLevelTaskPO.setPicList(picList);

        thirdLevelTaskPOTableCandidate.add(thirdLevelTaskPO);

        // only need userId
        user = new Worker();
        user.setId(1);

        ThirdLevelTaskResultPO thirdLevelTaskResultPO = new ThirdLevelTaskResultPO();
        thirdLevelTaskResultPO.setDoerId(1);
        thirdLevelTaskResultPO.setThirdLevelTaskId(1);

        Map<String, TagResult> resultTag = new HashMap<>();
        thirdLevelTaskResultPO.setTagResults(resultTag);

        thirdLevelTaskResultPOTableCandidate.add(thirdLevelTaskResultPO);

        tagDao = new TagDao();

    }

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @Test(priority = 0)
    public void testSaveTag() throws Exception {
        TagResult tagResult = new GlobalTagResult(0, null, "Man");
        tagDao.saveTag(1, user, "1.jpg", tagResult);
        System.out.println(JsonConfig.getGson().toJson(thirdLevelTaskResultPOTableCandidate));
    }

    @Test(priority = 1)
    public void testGetTagResult() throws Exception {
        TagResult tagResult = tagDao.getTagResult(1, user, "1.jpg");
        System.out.println(JsonConfig.getGson().toJson(tagResult));
    }

    @Test
    public void testGetNextPic() throws Exception {
        assertEquals(tagDao.getNextPic(1, "1.jpg"), "2.jpg");
        assertEquals(tagDao.getNextPic(1, "2.jpg"), "3.jpg");
        assertNull(tagDao.getNextPic(1, "3.jpg"));
    }

    @Test
    public void testGetPreviousPic() throws Exception {
        assertEquals(tagDao.getPreviousPic(1, "2.jpg"), "1.jpg");
        assertEquals(tagDao.getPreviousPic(1, "3.jpg"), "2.jpg");
        assertNull(tagDao.getPreviousPic(1, "1.jpg"));
    }

}