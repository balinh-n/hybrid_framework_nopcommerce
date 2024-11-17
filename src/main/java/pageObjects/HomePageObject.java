package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
    
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGenerateManager.getRegisterPage(driver);
    }

    public LoginPageObject clickLogInLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGenerateManager.getLoginPage(driver);
    }

    public void clickLogOutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public void clickMyaccountLink() {
        waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);

    }
}
