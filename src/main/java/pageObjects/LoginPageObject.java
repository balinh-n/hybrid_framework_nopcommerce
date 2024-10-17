package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendTextToEmail(WebDriver driver, String valueText) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TXT);
        sendTextToElement(driver, LoginPageUI.EMAIL_TXT, valueText);
    }
    public void sendTextToPassword(WebDriver driver, String valueText) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendTextToElement(driver, LoginPageUI.PASSWORD_TXT, valueText);
    }

    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
