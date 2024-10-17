package pageUIs;


public class RegisterPageUI {

    public static final String FIRSTNAME_TXT = "//input[@id='FirstName']";
    public static final String LASTNAME_TXT = "//input[@id='LastName']";
    public static final String EMAIL_TXT = "//input[@id='Email']";
    public static final String PASSWORD_TXT = "//input[@id='Password']";
    public static final String CFMPASSWORD_TXT = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//button[@id='register-button']";
    public static final String NOPCOMMERCE_IMG_LINK = "//img[@alt='Your store name']";

    public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
    public static final String EXIST_EMAIL_VALIDATION_MESSAGE = "//div[@class='message-error validation-summary-errors']//li";
    public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
    public static final String PASSWORD_VALIDATION_ERROR_MESSAGE = "//span[@data-valmsg-for='Password']";

    public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
    public static final String CONTINUE_BUTTON = "//a[@class='button-1 register-continue-button']";
}