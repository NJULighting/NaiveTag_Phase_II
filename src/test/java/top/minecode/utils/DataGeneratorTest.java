package top.minecode.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2018/5/5.
 * Description:
 * @author Liao
 */
public class DataGeneratorTest {

    @Test
    public void testGenerateData() {
        DataGenerator generator = new DataGenerator(1926);
        generator.generateData();
    }
}