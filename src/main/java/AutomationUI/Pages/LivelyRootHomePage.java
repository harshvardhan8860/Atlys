package AutomationUI.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LivelyRootHomePage {

    public WebDriver driver;

    public LivelyRootHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='search-form__input js-homepage-search-input']")
    WebElement searchBar;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void setSearchBar(String input) {

        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.click();
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

}
