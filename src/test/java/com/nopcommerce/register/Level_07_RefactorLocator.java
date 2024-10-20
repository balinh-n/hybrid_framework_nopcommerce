package com.nopcommerce.register;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorPageObject;
import pageObjects.RegisterPageObject;

public class Level_07_RefactorLocator extends BaseTest{

    WebDriver driver;
    String email = getRandomText() + "@gmail.com";
    String password = getRandomText();

    private RegisterPageObject registerPage;
    private HomePageObject homePage;

    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://localhost:5001/");
        homePage = PageGeneratorPageObject.getHomePage(driver);
    }

    @Test
    public void Register_01_EmptyData() {

        registerPage = homePage.clickToCRegisterLink(driver);
        registerPage.clickCRegisterButton(driver);

        Assert.assertEquals(registerPage.getCFirstNameErrorText(driver),
                "First name is required.");
        Assert.assertEquals(registerPage.getCLastNameErrorText(driver),
                "Last name is required.");
        Assert.assertEquals(registerPage.getCEmailErrorText(driver), "Email is required.");
        Assert.assertEquals(registerPage.getCPasswordErrorText(driver),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        homePage = registerPage.clickCNopcomerceImg(driver);
        registerPage = homePage.clickToCRegisterLink(driver);

        registerPage.sendTextToCFirstName(driver, "jack");
        registerPage.sendTextToCLastName(driver, "sparrow");
        registerPage.sendTextToCEmail(driver, "abcd@gmail.com@");
        registerPage.sendTextToCPassword(driver, "abcd1234@");
        registerPage.sendTextToCConfirmPassword(driver, "abcd1234@");
        registerPage.clickCRegisterButton(driver);
        Assert.assertEquals(registerPage.getCEmailErrorText(driver),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        homePage = registerPage.clickCNopcomerceImg(driver);
        registerPage = homePage.clickToCRegisterLink(driver);

        registerPage.sendTextToCFirstName(driver, "jack");
        registerPage.sendTextToCLastName(driver, "sparrow");
        registerPage.sendTextToCEmail(driver, "abcd@gmail.com");
        registerPage.sendTextToCPassword(driver, "abc");
        registerPage.sendTextToCConfirmPassword(driver, "abc");
        registerPage.clickCRegisterButton(driver);
        Assert.assertEquals(registerPage.getCPasswordValidationErrorMessage(driver),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_ConfirmPassword_Not_Match() {
        homePage = registerPage.clickCNopcomerceImg(driver);
        registerPage = homePage.clickToCRegisterLink(driver);

        registerPage.sendTextToCFirstName(driver, "jack");
        registerPage.sendTextToCLastName(driver, "sparrow");
        registerPage.sendTextToCEmail(driver, "abcd@gmail.com");
        registerPage.sendTextToCPassword(driver, "abcd1234");
        registerPage.sendTextToCConfirmPassword(driver, "abc");
        registerPage.clickCRegisterButton(driver);
        Assert.assertEquals(registerPage.getCPasswordErrorText(driver),
                "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterMethod() {
        driver.close();
    }
}
