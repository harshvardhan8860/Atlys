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

    //Searching for valid product name
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validProductNameSearch() {

        homePage.setSearchBar("black anthurium");

        //Verifying searched product name text
        Assert.assertEquals(productsPage.getSearchText(), "black anthurium");
        System.out.println(productsPage.getSearchText());

        //Verifying searched product name count it should be same throughout
        Assert.assertEquals(productsPage.getListCount(), productsPage.getSearchResultCount());
        System.out.println("List of products: " + productsPage.getListCount());
    }

    //Searching for non-existent product name
    @Test
    public void invalidProductSearch() {

        homePage.setSearchBar("Test123");

        //Verifying if noSearchFound element is visible or not in getNoResultText method
        Assert.assertEquals(productsPage.getNoResultText(), "Empty page");
        System.out.println("Page is empty no matches found");
    }

    //Searching for empty input
    @Test
    public void emptyInputTest() {

        homePage.setSearchBar("");

        //Verifying searched product name text
        Assert.assertEquals(productsPage.getSearchText(), "");

        //Verifying count it should be same throughout
        Assert.assertEquals(productsPage.getSearchResultCount(), 765);
        System.out.println("List of products: " + productsPage.getSearchResultCount());

        //Verifying if show more element is visible or not in getShowMoreText method
        Assert.assertEquals(productsPage.getShowMoreText(), "Show more");
        System.out.println("Show more text visible");
    }

    @AfterTest
    public void endBrowser() {

        teardownDriver();
    }
}
