package commons;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public WebDriver getBrowserDriver(WebDriver driver, String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        if (browserList == BrowserList.CHROME) {
            driver = new ChromeDriver();
        } else if (browserList == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else if (browserList == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Not a valid browser name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://localhost:5001/");
        return driver;
    }

    public String getRandomText() {
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
