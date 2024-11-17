package com.nopcommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.HomePageObject;
import pageObjects.PageGenerateManager;
import pageObjects.RegisterPageObject;

public class Register extends BaseTest {

    WebDriver driver;
    private HomePageObject getHomePage;
    private RegisterPageObject getRegisterPage;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_URL);
        getHomePage = PageGenerateManager.getHomePage(driver);
    }

    @Test
    public void TC1__Register_EmptyData() {
        getRegisterPage = getHomePage.clickRegisterLink();
        getRegisterPage.clickRegisterButton();
        Assert.assertEquals(getRegisterPage.getFirstNameError(), "First name is required.");
        Assert.assertEquals(getRegisterPage.getLastNameError(), "Last name is required.");
        Assert.assertEquals(getRegisterPage.getEmailError(), "Email is required.");
        Assert.assertEquals(getRegisterPage.getPasswordError(), "Password is required.");
    }

    @Test
    public void TC2__Register_WrongEmail() {
        getHomePage = getRegisterPage.clickImageLink();
        getRegisterPage = getHomePage.clickRegisterLink();

        getRegisterPage.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getRegisterPage.sendTextToLastName(GlobalConstants.LASTNAME);
        getRegisterPage.sendTextToEmail(setEmail(4) + "@");
        getRegisterPage.sendTextToPassword(setPassword(6));
        getRegisterPage.sendTextToCfmPassword(getPassword());
        getRegisterPage.clickRegisterButton();

        Assert.assertEquals(getRegisterPage.getEmailError(), "Please enter a valid email address.");
    }

    @Test
    public void TC3_Register_InValidPassword() {
        getHomePage = getRegisterPage.clickImageLink();
        getRegisterPage = getHomePage.clickRegisterLink();

        getRegisterPage.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getRegisterPage.sendTextToLastName(GlobalConstants.LASTNAME);
        getRegisterPage.sendTextToEmail("mgad@gmail.com");
        getRegisterPage.sendTextToPassword("abc");
        getRegisterPage.sendTextToCfmPassword("abc");
        getRegisterPage.clickRegisterButton();

        Assert.assertEquals(getRegisterPage.getPasswordValidation(),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void TC4_Register_PassworDoNotMatch() {
        getHomePage = getRegisterPage.clickImageLink();
        getRegisterPage = getHomePage.clickRegisterLink();

        getRegisterPage.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getRegisterPage.sendTextToLastName(GlobalConstants.LASTNAME);
        getRegisterPage.sendTextToEmail("mgad@gmail.com");
        getRegisterPage.sendTextToPassword("abc");
        getRegisterPage.sendTextToCfmPassword("abcd");
        getRegisterPage.clickRegisterButton();

        Assert.assertEquals(getRegisterPage.getPasswordError(), "The password and confirmation password do not match.");
    }

    @Test
    public void TC5_Register_Successfully() {
        getHomePage = getRegisterPage.clickImageLink();
        getRegisterPage = getHomePage.clickRegisterLink();

        getRegisterPage.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getRegisterPage.sendTextToLastName(GlobalConstants.LASTNAME);
        getRegisterPage.sendTextToEmail(setEmail(6));
        getRegisterPage.sendTextToPassword(setPassword(6));
        getRegisterPage.sendTextToCfmPassword(getPassword());
        getRegisterPage.clickRegisterButton();

        Assert.assertEquals(getRegisterPage.getSuccessMessage(), "Your registration completed");
        getHomePage = getRegisterPage.clickContinueLink();
        getHomePage.clickLogOutLink();
    }

    @Test
    public void TC6_Register_DuplicateEmail() {
        getRegisterPage = getHomePage.clickRegisterLink();

        getRegisterPage.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getRegisterPage.sendTextToLastName(GlobalConstants.LASTNAME);
        getRegisterPage.sendTextToEmail(getEmail());
        getRegisterPage.sendTextToPassword(getPassword());
        getRegisterPage.sendTextToCfmPassword(getPassword());
        getRegisterPage.clickRegisterButton();

        Assert.assertEquals(getRegisterPage.getEmailValidation(), "The specified email already exists");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
