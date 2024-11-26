package com.nopcommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.GlobalConstants;
import pageObjects.DynamicPageObject;
import pageObjects.PageGenerateManager;

public class DynamicLocatorRegister {
    
    WebDriver driver;
    private DynamicPageObject getDynamicPageObject;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_URL);
        getDynamicPageObject = PageGenerateManager.getDynamicPage(driver);
    }
     @Test
    public void TC3_Register_InValidPassword() {
        getDynamicPageObject.clickLoginLink();
        getDynamicPageObject.sendTextToFirstName(GlobalConstants.FIRSTNAME);
        getDynamicPageObject.sendTextToLastName(GlobalConstants.LASTNAME);
        getDynamicPageObject.sendTextToEmail("mgad@gmail.com");
        getDynamicPageObject.sendTextToPassword("abc");
        getDynamicPageObject.sendTextToCfmPassword("abc");
        getDynamicPageObject.clickRegisterButton();

        Assert.assertEquals(getDynamicPageObject.getPasswordValidation(),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
