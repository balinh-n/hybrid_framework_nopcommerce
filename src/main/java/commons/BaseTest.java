package commons;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    WebDriver driver;

    public WebDriver getBrowserDriver(String browserName) {
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
        return driver;
    }

    public String getRandomText() {
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
