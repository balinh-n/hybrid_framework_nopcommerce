package commons;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private String email;
    private String password;

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

    public String getEmail() {
        return email;
    }

    public String setEmail(int number) {
        return this.email = getRandomText(number) + "@gmail.com";
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(int number) {
        return this.password = getRandomText(number);
    }

    public String getRandomText(int number) {
        return RandomStringUtils.randomAlphanumeric(number);
    }
}
