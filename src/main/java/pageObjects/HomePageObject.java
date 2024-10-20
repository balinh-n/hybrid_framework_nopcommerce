package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorPageObject.getRegisterPage(driver);
    }

    public LoginPageObject clickToLogInLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorPageObject.getLoginPage(driver);
    }

    public void clickToLogOutLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public CustomerInfoPageObject clickToMyAccountLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
        return PageGeneratorPageObject.getCustomerInfoPage(driver);
    }

    public RegisterPageObject clickToCRegisterLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.CREGISTER_LINK);
        clickToElement(driver, HomePageUI.CREGISTER_LINK);
        return PageGeneratorPageObject.getRegisterPage(driver);
    }

    public LoginPageObject clickToCLogInLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.CLOGIN_LINK);
        clickToElement(driver, HomePageUI.CLOGIN_LINK);
        return PageGeneratorPageObject.getLoginPage(driver);
    }

    public void clickToCLogOutLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.CLOGOUT_LINK);
        clickToElement(driver, HomePageUI.CLOGOUT_LINK);
    }

    public CustomerInfoPageObject clickToCMyAccountLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.CMYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.CMYACCOUNT_LINK);
        return PageGeneratorPageObject.getCustomerInfoPage(driver);
    }
}
