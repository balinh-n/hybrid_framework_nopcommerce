package com.nopcommerce.register;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Nopcommerce_Register extends BaseTest {

    private WebDriver driver;
    String projectPath = System.getProperty("user.driver");
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private String randomEmail = randomEmail() + "@gmail.com";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
       driver = getBrowserDriver(browserName);
       homePage = new HomePageObject(driver);
    }
    @Test
    public void Register_01_EmptyData() {
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(),"Last name is required.");
        Assert.assertEquals( registerPage.getEmailErrorMessage(),"Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(),"Password is required.");
    }
    @Test
    public void Register_02_InvalidEmail() {
        registerPage.clickToNopcommerceImg();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.sendkeyToFirstName("Jack");
        registerPage.sendkeyToLastName("Sparrow");
        registerPage.sendkeyToEmail(randomEmail());
        registerPage.sendkeyToPassword("abcd1234");
        registerPage.sendkeyToCfmPassword("abcd1234");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getEmailErrorMessage(),"Please enter a valid email address.");
    }
    
    @Test
    public void Register_03_ValidInformation() {
        registerPage.clickToNopcommerceImg();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.sendkeyToFirstName("Jack");
        registerPage.sendkeyToLastName("Sparrow");
        registerPage.sendkeyToEmail(randomEmail);
        registerPage.sendkeyToPassword("abcd1234");
        registerPage.sendkeyToCfmPassword("abcd1234");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessMessage().trim(),"Your registration completed");
    }

    @Test
    public void Register_04_ExistedEmail() {
        loginPage = new LoginPageObject(driver);
        loginPage.clickToLogOutLink();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.sendkeyToFirstName("Jack");
        registerPage.sendkeyToLastName("Sparrow");
        registerPage.sendkeyToEmail(randomEmail);
        registerPage.sendkeyToPassword("abcd1234");
        registerPage.sendkeyToCfmPassword("abcd1234");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getEmailExistenceError().trim(),"The specified email already exists");

    }

    @Test
    public void Register_05_Password_Under_6_Charcter() {
        registerPage.clickToNopcommerceImg();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.sendkeyToFirstName("Jack");
        registerPage.sendkeyToLastName("Sparrow");
        registerPage.sendkeyToEmail(randomEmail);
        registerPage.sendkeyToPassword("abcd");
        registerPage.sendkeyToCfmPassword("abcd");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getInvalidPasswordErrorMessage(),"<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }
    @Test
    public void Register_06_CfmPassword_Not_Match_Password() {
        registerPage.clickToNopcommerceImg();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.sendkeyToFirstName("Jack");
        registerPage.sendkeyToLastName("Sparrow");
        registerPage.sendkeyToEmail(randomEmail);
        registerPage.sendkeyToPassword("abcd1234");
        registerPage.sendkeyToCfmPassword("abcd");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getPasswordErrorMessage(),"The password and confirmation password do not match.");
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }

    public String randomEmail() {
        return "abcd" +new Random().nextInt(9999);
    }
}