package top.minecode.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/28.
 * Description:
 * @author Liao
 */
public class ConfigTest {

    @Test
    public void testGetAbsolutePath() throws Exception {
        Config config = Config.INSTANCE;
        String logicPath = "RawImage/1/6/result.json";
        System.out.println(config.getAbsolutePath(logicPath));
    }
}