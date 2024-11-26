package pageUIs;

public class DynamicPageUI {
    public static final String REGISTER_LINK  = "class=ico-register";

    public static final String FIRSTNAME_TEXTBOX = "id=FirstName";
    public static final String LASTNAME_TEXTBOX = "ID=LastName";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "XPATH=//input[@id='Password']";
    public static final String CFMPASSWORD_TEXTBOX = "name=ConfirmPassword";
    public static final String REGISTER_BUTTON = "name=register-button";
    public static final String IMG_LINK = "xpath=//img[@alt='Your store name']";
    public static final String CONTINUE_LINK = "xpath=//a[text() ='Continue']";

    public static final String FIRSTNAME_ERROR = "id=FirstName-error";
    public static final String LASTNAME_ERROR = "id=LastName-error";
    public static final String EMAIL_ERROR = "id=Email-error";
    public static final String PASSWORD_ERROR = "id=ConfirmPassword-error";
    public static final String PASSWORD_VALIDATION_ERROR = "class=field-validation-error";
    public static final String REGISTER_SUCCESSFULL_MESSAGE = "class=result";
    public static final String EMAIL_VALIDATION = "xpath=//div[@class='message-error validation-summary-errors']//li";
}
