package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public  LoginPageObject (WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLogOutLink() {
        clickToElement(driver, LoginPageUI.LOGOUT_LINK);
    }
}
