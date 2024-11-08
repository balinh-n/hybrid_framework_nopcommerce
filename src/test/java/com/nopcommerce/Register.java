package com.nopcommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.GlobalConstants;
import pageObjects.HomePageObject;
import pageObjects.PageGenerateManager;
import pageObjects.RegisterPageObject;

public class Register {
    
    WebDriver driver;
    private HomePageObject getHomePage;
    private RegisterPageObject getRegisterPage;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_URL);
        getHomePage = PageGenerateManager.getHomePageObject(driver);
    }

    @Test
    public void TC1_EmptyData() {
        getRegisterPage = getHomePage.clickRegisterLink();
        getRegisterPage.clickRegisterButton();
        Assert.assertEquals(getRegisterPage.getFirstNameError(), "First name is required.");
        Assert.assertEquals(getRegisterPage.getLastNameError(), "Last name is required.");
        Assert.assertEquals(getRegisterPage.getEmailError(), "Email is required.");
        Assert.assertEquals(getRegisterPage.getPasswordError(), "Password is required.");
    }


    public void TC2_WrongEmail() {
        getHomePage = getRegisterPage.clickImageLink();
        
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
