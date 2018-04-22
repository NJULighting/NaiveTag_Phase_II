package top.minecode.web.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created on 2018/4/22.
 * Description:
 * @author Liao
 */
@ContextConfiguration("classpath:naive-context.xml")
public class WebsiteInfoControllerTest extends AbstractTestNGSpringContextTests{

    private WebsiteInfoController controller;

    @Autowired
    public void setController(WebsiteInfoController controller) {
        this.controller = controller;
    }

    @Test
    public void getInfo() {
        System.out.println(controller.getInfo());
    }
}