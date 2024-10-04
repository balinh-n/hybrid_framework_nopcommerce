package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;


public class RegisterPageObject extends BasePage {

    WebDriver driver;

    public  RegisterPageObject(WebDriver pageObjectDriver) {
        this.driver = pageObjectDriver;
    }
    public void sendkeyToFirstName(String firstName) {
        sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX,firstName);
    }
    public void sendkeyToLastName(String lastName) {
        sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX,lastName);
    }
    public void sendkeyToEmail(String email){
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }
    public void sendkeyToPassword(String password) {
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX,password);
    }
    public void sendkeyToCfmPassword (String cfmPassword){
        sendkeyToElement(driver,RegisterPageUI.CFMPASSWORD_TEXTBOX, cfmPassword);
    }
    public void clickToRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    public String getFirstNameErrorMessage() {
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }
    public String getLastNameErrorMessage() {
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
    }
    public String getEmailErrorMessage() {
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }
    public String getEmailExistenceError() {
        return  getElementText(driver, RegisterPageUI.EMAILEXISTENCE_ERROR_MESSAGE);
    }
    public String getPasswordErrorMessage() {
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }
    public String getInvalidPasswordErrorMessage() {
        return getElementText(driver, RegisterPageUI.INVALIDPASSWORD_ERROR_MESSAGE);
    }
    public String getSuccessMessage() {
        return  getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
    public void clickToNopcommerceImg () {
        clickToElement(driver, RegisterPageUI.REGISTER_NOPCOMMERCE_IMAGE);
    }
    public void clickToContinueButton() {
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
    }

}
