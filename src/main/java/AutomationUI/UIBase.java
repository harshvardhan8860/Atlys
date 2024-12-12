package AutomationUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UIBase {

    public static WebDriver driver;

    public void setUpDriverAndOpenUrl(String url) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(url);
        System.out.println("Url opened");

    }

    public void teardownDriver() {

        if(driver != null) {
            driver.quit();
        }
    }
}
