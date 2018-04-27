package top.minecode.utils.unzip;

import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created on 2018/4/19.
 * Description:
 * @author Liao
 */
public class ZipHelperTest {
//    @Test
    public void testUnzip() throws Exception {
        File zipFile = new File(ZipHelperTest.class.getResource("/").getPath() + "test.zip");
        assertTrue(zipFile.createNewFile());

        ZipHelper zipHelper = new ZipHelper();
        String targetPath = zipFile.getParent();
        String sourcePath = zipFile.getPath();
        String resultPath = zipHelper.unZip(sourcePath, targetPath);

        assertEquals(resultPath, targetPath + File.separator + "test");
        assertTrue(zipFile.delete());
        assertTrue(new File(resultPath).delete());
    }
}