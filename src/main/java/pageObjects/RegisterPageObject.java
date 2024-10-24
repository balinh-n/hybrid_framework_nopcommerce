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

    public HomePageObject clickNopcomerceImg(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.NOPCOMMERCE_IMG_LINK);
        clickToElement(driver, RegisterPageUI.NOPCOMMERCE_IMG_LINK);
        return PageGeneratorPageObject.getHomePage(driver);
    }

    public String getFirstNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
    }

    public String getEmailErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getPasswordErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getPasswordValidationErrorMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.PASSWORD_VALIDATION_ERROR_MESSAGE);
    }

    public String getRegisterSuccessMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickContinueButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
        return PageGeneratorPageObject.getHomePage(driver);
    }

    public String getExitEmailValidationMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_VALIDATION_MESSAGE);
        return getTextOfElement(driver, RegisterPageUI.EXIST_EMAIL_VALIDATION_MESSAGE);
    }

    public void sendTextToCFirstName(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CFIRSTNAME_TXT);
        sendTextToElement(driver, RegisterPageUI.CFIRSTNAME_TXT, valueText);
    }

    public void sendTextToCLastName(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CLASTNAME_TXT);
        sendTextToElement(driver, RegisterPageUI.CLASTNAME_TXT, valueText);
    }

    public void sendTextToCEmail(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CEMAIL_TXT);
        sendTextToElement(driver, RegisterPageUI.CEMAIL_TXT,valueText);
    }

    public void sendTextToCPassword(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CPASSWORD_TXT);
        sendTextToElement(driver, RegisterPageUI.CPASSWORD_TXT,valueText);
    }

    public void sendTextToCConfirmPassword(WebDriver driver, String valueText) {
        waitForElementVisible(driver, RegisterPageUI.CCFMPASSWORD_TXT);
        sendTextToElement(driver, RegisterPageUI.CCFMPASSWORD_TXT,valueText);
    }

    public void clickCRegisterButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.CREGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.CREGISTER_BUTTON);
    }

    public HomePageObject clickCNopcomerceImg(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CNOPCOMMERCE_IMG_LINK);
        clickToElement(driver, RegisterPageUI.CNOPCOMMERCE_IMG_LINK);
        return PageGeneratorPageObject.getHomePage(driver);
    }

    public String getCFirstNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CFIRSTNAME_ERROR_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CFIRSTNAME_ERROR_MESSAGE);
    }

    public String getCLastNameErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CLASTNAME_ERROR_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CLASTNAME_ERROR_MESSAGE);
    }

    public String getCEmailErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CEMAIL_ERROR_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CEMAIL_ERROR_MESSAGE);
    }

    public String getCPasswordErrorText(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CPASSWORD_ERROR_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CPASSWORD_ERROR_MESSAGE);
    }

    public String getCPasswordValidationErrorMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CPASSWORD_VALIDATION_ERROR_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CPASSWORD_VALIDATION_ERROR_MESSAGE);
    }

    public String getCRegisterSuccessMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CREGISTER_SUCCESS_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CREGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickCContinueButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.CCONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CCONTINUE_BUTTON);
        return PageGeneratorPageObject.getHomePage(driver);
    }

    public String getCExitEmailValidationMessage(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.CEXIST_EMAIL_VALIDATION_MESSAGE);
        return getTextOfDifferentElement(driver, RegisterPageUI.CEXIST_EMAIL_VALIDATION_MESSAGE);
    }
}
