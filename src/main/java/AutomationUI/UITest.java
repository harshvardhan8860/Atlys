package AutomationUI;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.*;

public class UITest extends UIBase{

    String url = "https://www.livelyroot.com/";

    @BeforeTest
    public void startBrowser() {
        setUpDriverAndOpenUrl(url);
    }

    @Test
    public void test() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Buy Plants Online | Order Live Plants for Sale | Lively Root");
    }

    @AfterTest
    public void endBrowser() {
        teardownDriver();
    }
}
