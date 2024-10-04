package pageUIs;

public class RegisterPageUI {
    public static final String FIRSTNAME_TEXTBOX = "//input[@name='FirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@name='LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@name='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@name='Password']";
    public static final String CFMPASSWORD_TEXTBOX = "//input[@name='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//button[@name='register-button']";
    
    public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
    public static final String EMAILEXISTENCE_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']";
    public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
    public static final String INVALIDPASSWORD_ERROR_MESSAGE = "//span[@class='field-validation-error']";
    public static final String REGISTER_NOPCOMMERCE_IMAGE = "//img[@alt='Your store name']";

    public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
    public static final String CONTINUE_BUTTON = "//a[text()='Continue']";
}
