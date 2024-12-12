package AutomationUI;

import AutomationUI.Pages.LivelyRootHomePage;
import AutomationUI.Pages.LivelyRootProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class UITest extends UIBase{

    String url = "https://www.livelyroot.com/";

    LivelyRootHomePage homePage;
    LivelyRootProductsPage productsPage;

    @BeforeTest
    public void startBrowser() {

        setUpDriverAndOpenUrl(url);

        homePage = new LivelyRootHomePage(UIBase.driver);
        productsPage = new LivelyRootProductsPage(UIBase.driver);
    }

    @Test
    public void positiveSearchTest() {

        homePage.setSearchBar("black anthurium");

        Assert.assertEquals(productsPage.getSearchText(), "black anthurium");
        System.out.println(productsPage.getSearchText());

        Assert.assertEquals(productsPage.getListCount(), 4);
        System.out.println("List of products: " + productsPage.getListCount());
    }

    @Test
    public void negativeSearchTest() {

        homePage.setSearchBar("Test123");

//        Assert.assertEquals(productsPage.getListCount(), 0);
//        System.out.println("List of products: " + productsPage.getListCount());

        Assert.assertEquals(productsPage.getNoResultText(), "Empty page");
        System.out.println("Page is empty no results present");
    }

    @Test
    public void emptySearchTest() {

        homePage.setSearchBar("");

        Assert.assertEquals(productsPage.getSearchText(), "");

        Assert.assertEquals(productsPage.getListCount(), 30);
        System.out.println("List of products: " + productsPage.getListCount());

        Assert.assertEquals(productsPage.getShowMoreText(), "Show more");
        System.out.println("Show more text visible");
    }

    @AfterTest
    public void endBrowser() {

        teardownDriver();
    }
}
