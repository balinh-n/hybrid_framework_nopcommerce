package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorPageObject {

    WebDriver driver;

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
}
