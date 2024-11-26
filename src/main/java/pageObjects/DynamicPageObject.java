package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DynamicPageUI;

public class DynamicPageObject extends BasePage{
    WebDriver driver;

    public DynamicPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        waitForDynamicElementClickable(driver, DynamicPageUI.REGISTER_LINK);
        clickToDynamicElement(driver, DynamicPageUI.REGISTER_LINK);
    }

    public void sendTextToFirstName(String value) {
        waitForDynamicElementVisible(driver, DynamicPageUI.FIRSTNAME_TEXTBOX);
        sendTextToDynamicElement(driver, DynamicPageUI.FIRSTNAME_TEXTBOX, value);
    }

    public void sendTextToLastName(String value) {
        waitForDynamicElementVisible(driver, DynamicPageUI.LASTNAME_TEXTBOX);
        sendTextToDynamicElement(driver, DynamicPageUI.LASTNAME_TEXTBOX, value);
    }

    public void sendTextToEmail(String value) {
        waitForDynamicElementVisible(driver, DynamicPageUI.EMAIL_TEXTBOX);
        sendTextToDynamicElement(driver, DynamicPageUI.EMAIL_TEXTBOX, value);
    }

    public void sendTextToPassword(String value) {
        waitForDynamicElementVisible(driver, DynamicPageUI.PASSWORD_TEXTBOX);
        sendTextToDynamicElement(driver, DynamicPageUI.PASSWORD_TEXTBOX, value);
    }

    public void sendTextToCfmPassword(String value) {
        waitForDynamicElementVisible(driver, DynamicPageUI.CFMPASSWORD_TEXTBOX);
        sendTextToDynamicElement(driver, DynamicPageUI.CFMPASSWORD_TEXTBOX, value);
    }

    public void clickRegisterButton() {
        waitForDynamicElementClickable(driver, DynamicPageUI.REGISTER_BUTTON);
        clickToDynamicElement(driver, DynamicPageUI.REGISTER_BUTTON);
    }

    public HomePageObject clickImageLink() {
        waitForDynamicElementClickable(driver, DynamicPageUI.IMG_LINK);
        clickToDynamicElement(driver, DynamicPageUI.IMG_LINK);
        return PageGenerateManager.getHomePage(driver);
    }

    public HomePageObject clickContinueLink() {
        waitForDynamicElementClickable(driver, DynamicPageUI.CONTINUE_LINK);
        clickToDynamicElement(driver, DynamicPageUI.CONTINUE_LINK);
        return PageGenerateManager.getHomePage(driver);
    }

    public String getFirstNameError() {
        return getTextOfDynamicElement(driver, DynamicPageUI.FIRSTNAME_ERROR);
    }

    public String getLastNameError() {
        return getTextOfDynamicElement(driver, DynamicPageUI.LASTNAME_ERROR);
    }

    public String getEmailError() {
        return getTextOfDynamicElement(driver, DynamicPageUI.EMAIL_ERROR);
    }

    public String getPasswordError() {
        return getTextOfDynamicElement(driver, DynamicPageUI.PASSWORD_ERROR);
    }

    public String getPasswordValidation() {
        return getTextOfDynamicElement(driver, DynamicPageUI.PASSWORD_VALIDATION_ERROR);
    }

    public String getEmailValidation() {
        return getTextOfDynamicElement(driver, DynamicPageUI.EMAIL_VALIDATION);
    }

    public String getSuccessMessage() {
        return getTextOfDynamicElement(driver, DynamicPageUI.REGISTER_SUCCESSFULL_MESSAGE);
    }
}

