package com.nopcommerce.register;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Static {
    WebDriver driver;
    private BasePage basePage = BasePage.basePage();

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        basePage.openUrl(driver, "https://localhost:5001/");
    }

    @Test
    public void Register_01_EmptyData() {
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='FirstName-error']"),
                "First name is required.");
        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='LastName-error']"),
                "Last name is required.");
        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='ConfirmPassword-error']"),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.sendTextToElement(driver, "//input[@id='FirstName']", "jack");
        basePage.sendTextToElement(driver, "//input[@id='LastName']", "sparrow");
        basePage.sendTextToElement(driver, "//input[@id='Email']", "abcd@gmail.com@");
        basePage.sendTextToElement(driver, "//input[@id='Password']", "abcd1234@");
        basePage.sendTextToElement(driver, "//input[@id='ConfirmPassword']", "abcd1234@");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='Email-error']"),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.sendTextToElement(driver, "//input[@id='FirstName']", "jack");
        basePage.sendTextToElement(driver, "//input[@id='LastName']", "sparrow");
        basePage.sendTextToElement(driver, "//input[@id='Email']", "abcd@gmail.com");
        basePage.sendTextToElement(driver, "//input[@id='Password']", "abc");
        basePage.sendTextToElement(driver, "//input[@id='ConfirmPassword']", "abc");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@data-valmsg-for='Password']"),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
