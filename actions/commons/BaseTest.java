package commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver (String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            System.getProperty("webdriver.gecko.driver", projectPath +"\\browserDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            System.getProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgeriver.exe");
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("chrome")) {
            System.getProperty("webdriver.chrome.driver", projectPath +"\\browserDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://localhost:44304/");

        return driver;
    }
    
}
