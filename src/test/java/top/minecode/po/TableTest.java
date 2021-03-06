package top.minecode.po;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import top.minecode.domain.task.ThirdLevelTaskState;
import top.minecode.po.AdministratorPO;
import top.minecode.po.Table;
import top.minecode.po.TableFactory;
import top.minecode.po.ThirdLevelTaskPO;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class TableTest {

//    private Table<AdministratorPO> adminTable;
//    private int size;

//    @BeforeMethod
//    public void setUp() throws Exception {
//        adminTable = TableFactory.administratorTable();
//        size = adminTable.size();
//    }
//
//    @Test(priority = 3)
//    public void testLoad() throws Exception {
//        assertNotEquals(size, 0);
//    }
//
//    @Test(priority = 2)
//    public void testSave() throws Exception {
//        adminTable.add(new AdministratorPO(11, "frog", "frog", "frog"));
//        Method loadMethod = adminTable.getClass().getDeclaredMethod("load");
//        loadMethod.setAccessible(true);
//        //noinspection JavaReflectionInvocation
//        loadMethod.invoke(adminTable);
//        loadMethod.setAccessible(false);
//        assertEquals(size + 1, adminTable.size());
//    }

  //  @Test(priority = 1)
    public void testFilterAndGet() throws Exception {
        Table<ThirdLevelTaskPO> tasks = TableFactory.thirdLevelTaskTable();
        Predicate<ThirdLevelTaskPO> filter = e -> e.getState() == ThirdLevelTaskState.doing;
        List<ThirdLevelTaskPO> resultList = tasks.filter(filter);
        assertNotNull(resultList);

        // Delete the created file
        String path = Table.class.getResource("/").getPath() + "tasks.json";
        File file = new File(path);
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }
}