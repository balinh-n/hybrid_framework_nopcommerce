package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_04_MultiBrowser extends BaseTest {
    WebDriver driver;
    String email = getRandomText() + "@gmail.com";
    String password = getRandomText();

    private RegisterPageObject regiterPage;
    private HomePageObject homePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeMethod(String browserName) {
        driver = getBrowserDriver(driver,browserName);
    }

    @Test
    public void Register_01_EmptyData() {
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink(driver);
        regiterPage = new RegisterPageObject(driver);
        regiterPage.clickRegisterButton(driver);

        Assert.assertEquals(regiterPage.getFirstNameErrorText(driver),
                "First name is required.");
        Assert.assertEquals(regiterPage.getLastNameErrorText(driver),
                "Last name is required.");
        Assert.assertEquals(regiterPage.getEmailErrorText(driver), "Email is required.");
        Assert.assertEquals(regiterPage.getPasswordErrorText(driver),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        regiterPage.clickNopcomerceImg(driver);
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink(driver);

        regiterPage = new RegisterPageObject(driver);
        regiterPage.sendTextToFirstName(driver, "jack");
        regiterPage.sendTextToLastName(driver, "sparrow");
        regiterPage.sendTextToEmail(driver, "abcd@gmail.com@");
        regiterPage.sendTextToPassword(driver, "abcd1234@");
        regiterPage.sendTextToConfirmPassword(driver, "abcd1234@");
        regiterPage.clickRegisterButton(driver);
        Assert.assertEquals(regiterPage.getEmailErrorText(driver),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        regiterPage.clickNopcomerceImg(driver);
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink(driver);

        regiterPage = new RegisterPageObject(driver);
        regiterPage.sendTextToFirstName(driver, "jack");
        regiterPage.sendTextToLastName(driver, "sparrow");
        regiterPage.sendTextToEmail(driver, "abcd@gmail.com");
        regiterPage.sendTextToPassword(driver, "abc");
        regiterPage.sendTextToConfirmPassword(driver, "abc");
        regiterPage.clickRegisterButton(driver);
        Assert.assertEquals(regiterPage.getPasswordValidationErrorMessage(driver),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_ConfirmPassword_Not_Match() {
        regiterPage.clickNopcomerceImg(driver);
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink(driver);

        regiterPage = new RegisterPageObject(driver);
        regiterPage.sendTextToFirstName(driver, "jack");
        regiterPage.sendTextToLastName(driver, "sparrow");
        regiterPage.sendTextToEmail(driver, "abcd@gmail.com");
        regiterPage.sendTextToPassword(driver, "abcd1234");
        regiterPage.sendTextToConfirmPassword(driver, "abc");
        regiterPage.clickRegisterButton(driver);
        Assert.assertEquals(regiterPage.getPasswordErrorText(driver),
                "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterMethod() {
        driver.close();
    }
}
