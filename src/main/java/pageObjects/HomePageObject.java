package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLogInLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public void clickToLogOutLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public void clickToMyAccountLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
    }
}