package com.nopcommerce.register;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Inherit extends BasePage {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        openUrl(driver, "https://localhost:5001/");
    }

    @Test
    public void Register_01_EmptyData() {
        clickToElement(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getTextOfElement(driver, "//span[@id='FirstName-error']"),
                "First name is required.");
        Assert.assertEquals(getTextOfElement(driver, "//span[@id='LastName-error']"),
                "Last name is required.");
        Assert.assertEquals(getTextOfElement(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(getTextOfElement(driver, "//span[@id='ConfirmPassword-error']"),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        clickToElement(driver,"//a[@class='ico-register']");
        sendTextToElement(driver,"//input[@id='FirstName']","jack");
        sendTextToElement(driver,"//input[@id='LastName']","sparrow");
        sendTextToElement(driver, "//input[@id='Email']","abcd@gmail.com@");
        sendTextToElement(driver,"//input[@id='Password']","abcd1234@");
        sendTextToElement(driver, "//input[@id='ConfirmPassword']","abcd1234@");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getTextOfElement(driver,"//span[@id='Email-error']"),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        clickToElement(driver,"//a[@class='ico-register']");
        sendTextToElement(driver,"//input[@id='FirstName']","jack");
        sendTextToElement(driver,"//input[@id='LastName']","sparrow");
        sendTextToElement(driver, "//input[@id='Email']","abcd@gmail.com");
        sendTextToElement(driver,"//input[@id='Password']","abc");
        sendTextToElement(driver, "//input[@id='ConfirmPassword']","abc");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getTextOfElement(driver,"//span[@data-valmsg-for='Password']"),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
