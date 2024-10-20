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

public class Level_05_PageManager extends BaseTest{
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
        
        registerPage = homePage.clickToRegisterLink(driver);
        registerPage.clickRegisterButton(driver);

        Assert.assertEquals(registerPage.getFirstNameErrorText(driver),
                "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorText(driver),
                "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorText(driver), "Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorText(driver),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        homePage = registerPage.clickNopcomerceImg(driver);
        registerPage = homePage.clickToRegisterLink(driver);

        registerPage.sendTextToFirstName(driver, "jack");
        registerPage.sendTextToLastName(driver, "sparrow");
        registerPage.sendTextToEmail(driver, "abcd@gmail.com@");
        registerPage.sendTextToPassword(driver, "abcd1234@");
        registerPage.sendTextToConfirmPassword(driver, "abcd1234@");
        registerPage.clickRegisterButton(driver);
        Assert.assertEquals(registerPage.getEmailErrorText(driver),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        homePage = registerPage.clickNopcomerceImg(driver);
        registerPage = homePage.clickToRegisterLink(driver);

        registerPage.sendTextToFirstName(driver, "jack");
        registerPage.sendTextToLastName(driver, "sparrow");
        registerPage.sendTextToEmail(driver, "abcd@gmail.com");
        registerPage.sendTextToPassword(driver, "abc");
        registerPage.sendTextToConfirmPassword(driver, "abc");
        registerPage.clickRegisterButton(driver);
        Assert.assertEquals(registerPage.getPasswordValidationErrorMessage(driver),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_ConfirmPassword_Not_Match() {
        homePage = registerPage.clickNopcomerceImg(driver);
        registerPage = homePage.clickToRegisterLink(driver);

        registerPage.sendTextToFirstName(driver, "jack");
        registerPage.sendTextToLastName(driver, "sparrow");
        registerPage.sendTextToEmail(driver, "abcd@gmail.com");
        registerPage.sendTextToPassword(driver, "abcd1234");
        registerPage.sendTextToConfirmPassword(driver, "abc");
        registerPage.clickRegisterButton(driver);
        Assert.assertEquals(registerPage.getPasswordErrorText(driver),
                "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterMethod() {
        driver.close();
    }

}
