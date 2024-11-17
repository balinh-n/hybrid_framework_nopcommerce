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
import pageObjects.LoginPageObject;
import pageObjects.PageGenerateManager;

public class Login extends BaseTest {
    WebDriver driver;
    private HomePageObject getHomePage;
    private LoginPageObject getLoginPage;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_URL);
        getHomePage = PageGenerateManager.getHomePage(driver);
    }

    @Test
    public void TC1_Login_EmptyData() {
        getLoginPage = getHomePage.clickLogInLink();
        getLoginPage.clickLoginButton();
        Assert.assertEquals(getLoginPage.getEmailErrorMessage(), "Please enter your email");
    }

    @Test
    public void TC2_Login_InvalidEmail() {
        getHomePage = getLoginPage.clickNopImage();
        getLoginPage = getHomePage.clickLogInLink();

        getLoginPage.sendTextToEmail("abcd@gmail");
        getLoginPage.sendTextToPassword(GlobalConstants.VALIDPASSWORD);
        getLoginPage.clickLoginButton();
        Assert.assertEquals(getLoginPage.getEmailErrorMessage(), "Wrong email");
    }

    @Test
    public void TC3_Login_EMAIL_NOT_REGISTER() {
        getHomePage = getLoginPage.clickNopImage();
        getLoginPage = getHomePage.clickLogInLink();

        getLoginPage.sendTextToEmail("notregister@gmail.com");
        getLoginPage.sendTextToPassword(GlobalConstants.VALIDPASSWORD);
        getLoginPage.clickLoginButton();
        Assert.assertEquals(getLoginPage.getMessageForEmailNotRegister(),
               "Login was unsuccessful. Please correct the errors and try again." + "\n" + "No customer account found");
    }

    @Test
    public void TC4_Login_EmptyPassword() {
        getHomePage = getLoginPage.clickNopImage();
        getLoginPage = getHomePage.clickLogInLink();
        
        getLoginPage.sendTextToEmail(GlobalConstants.VALIDEMAIL);
        getLoginPage.clickLoginButton();
        Assert.assertEquals(getLoginPage.getMessageForEmailNotRegister(),
               "Login was unsuccessful. Please correct the errors and try again." + "\n" + "The credentials provided are incorrect");
    }

    @Test
    public void TC5_Login_WrongPassword() {
        getHomePage = getLoginPage.clickNopImage();
        getLoginPage = getHomePage.clickLogInLink();
        
        getLoginPage.sendTextToEmail(GlobalConstants.VALIDEMAIL);
        getLoginPage.sendTextToPassword("notcorrectpassword");
        getLoginPage.clickLoginButton();
        Assert.assertEquals(getLoginPage.getMessageForEmailNotRegister(),
               "Login was unsuccessful. Please correct the errors and try again." + "\n" + "The credentials provided are incorrect");
    }

    @Test
    public void TC6_Login_Successfully() {
        getHomePage = getLoginPage.clickNopImage();
        getLoginPage = getHomePage.clickLogInLink();
        
        getLoginPage.sendTextToEmail(GlobalConstants.VALIDEMAIL);
        getLoginPage.sendTextToPassword(GlobalConstants.VALIDPASSWORD);
        getLoginPage.clickLoginButton();

        Assert.assertEquals(getLoginPage.getPageTitle(driver), "Your store. Home page title");
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
