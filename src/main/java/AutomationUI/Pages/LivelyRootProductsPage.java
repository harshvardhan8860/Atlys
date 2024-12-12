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


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public String getSearchText() {
        String text = "";
        try{
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

        return showMore.getText();
    }

    public String getNoResultText() {

        if(noSearchFound.isDisplayed()) {
            return "Empty page";
        }
        else {
            return "Products present";
        }
    }
}
