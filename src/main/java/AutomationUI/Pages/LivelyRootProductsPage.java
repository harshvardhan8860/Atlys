package AutomationUI.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LivelyRootProductsPage {

    public WebDriver driver;

    public LivelyRootProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='snize-no-products-found-link']")
    WebElement searchProduct;

    @FindBy(xpath = "//ul[@class='snize-search-results-content clearfix']/child::li")
    List<WebElement> searchList;

    @FindBy(xpath = "//a[@class='snize-pagination-load-more']")
    WebElement showMore;

    @FindBy(xpath = "//div[@class='snize-no-products-found-text']")
    WebElement noSearchFound;

    @FindBy(xpath = "//div[@class='snize-search-results-header']/b")
    WebElement searchResultCount;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    public String getSearchText() {
        String text = "";
        try {
            wait.until(ExpectedConditions.visibilityOf(searchProduct));
            text = searchProduct.getText();
        } catch (Exception e) {
            System.out.println("Empty string");
        }
        return text;
    }

    public int getListCount() {

        try {
            return searchList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getShowMoreText() {

        try {
            wait.until(ExpectedConditions.visibilityOf(showMore));
            return showMore.getText();
        } catch (Exception e) {
            System.out.println("Show more button not present");
            return "";
        }
    }

    public String getNoResultText() {

        wait.until(ExpectedConditions.visibilityOf(noSearchFound));
        if(noSearchFound.isDisplayed()) {
            return "Empty page";
        }
        else {
            return "Products present";
        }
    }

    public int getSearchResultCount() {

        try {
            wait.until(ExpectedConditions.visibilityOf(searchResultCount));
            String str = searchResultCount.getText();
            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Search count element not found");
            return 0;
        }
    }
}
