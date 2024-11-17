package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendTextToEmail(String valueText) {
        sendTextToElement(driver, LoginPageUI.EMAIL_TXT, valueText);
    }

    public void sendTextToPassword(String valueText) {
        sendTextToElement(driver, LoginPageUI.PASSWORD_TXT, valueText);
    }

    public void clickLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public HomePageObject clickNopImage() {
        clickToElement(driver, LoginPageUI.IMG_LINK);
        return PageGenerateManager.getHomePage(driver);
    }

    public String getEmailErrorMessage() {
        return getTextOfElement(driver, LoginPageUI.EMAIL_ERROR);
    }

    public String getMessageForEmailNotRegister() {
        return getTextOfElement(driver, LoginPageUI.INVALIDCREDENTIAL_MESSAGE);
    }
}
