package top.minecode.po;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class AdministratorPOListTest {

    @Test
    public void testLoad() throws Exception {
        AdministratorPOList administratorPOList = DataBase.administratorPOList;
        assertNotEquals(administratorPOList.getAdministratorPOS().size(), 0);
    }
}