package pageUIs;

public class RegisterPageUI {

    public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String CFMPASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//button[@id='register-button']";
    public static final String IMG_LINK = "//img[@alt='Your store name']";

    public static final String FIRSTNAME_ERROR = "//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR = "//span[@id='LastName-error']";
    public static final String EMAIL_ERROR = "//span[@id='Email-error']";
    public static final String PASSWORD_ERROR = "//span[@id='ConfirmPassword-error']";
    public static final String PASSWORD_VALIDATION_ERROR = "//span[@class='field-validation-error']";

    String firstNameError = "First name is required.";
    String lastNameError = "Last name is required.";
    String emailError = "Email is required.";
    String passwordError = "Password is required.";
    String emailValidation = "Please enter a valid email address.";
    String passwordValidation = "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>";
    String passwordNotMatch = "The password and confirmation password do not match.";
}
