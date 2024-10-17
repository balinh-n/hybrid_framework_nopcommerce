package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendTextToFirstName(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TXT);
        sendTextToElement(driver, RegisterPageUI.FIRSTNAME_TXT, valueText);
    }

    public void sendTextToLastName(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TXT);
        sendTextToElement(driver, RegisterPageUI.LASTNAME_TXT, valueText);
    }

    public void sendTextToEmail(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT);
        sendTextToElement(driver, RegisterPageUI.EMAIL_TXT,valueText);
    }

    public void sendTextToPassword(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TXT);
        sendTextToElement(driver, RegisterPageUI.PASSWORD_TXT,valueText);
    }

    public void sendTextToConfirmPassword(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CFMPASSWORD_TXT);
        sendTextToElement(driver, RegisterPageUI.CFMPASSWORD_TXT,valueText);
    }

    public void clickRegisterButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public void clickNopcomerceImg(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.NOPCOMMERCE_IMG_LINK);
        clickToElement(driver, RegisterPageUI.NOPCOMMERCE_IMG_LINK);
    }

    public String getFirstNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
    }

    public String getEmailErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getPasswordErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getPasswordValidationErrorMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MESSAGE);
    }

    public String getRegisterSuccessMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickContinueButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
    }

    public String getExitEmailValidationMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_VALIDATION_MESSAGE);
        return getElementText(driver, RegisterPageUI.EXIST_EMAIL_VALIDATION_MESSAGE);
    }
}
