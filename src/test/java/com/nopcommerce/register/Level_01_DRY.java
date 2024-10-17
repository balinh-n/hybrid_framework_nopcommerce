package com.nopcommerce.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Level_01_DRY {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://localhost:5001/");
    }

    @Test
    public void Register_01_EmptyData() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(),
                "First name is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(),
                "Last name is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),
                "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("jack");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("sparrow");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abcd@gmail.com@");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abcd1234@");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abcd1234@");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),
                "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Less_Than_6_Character() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("jack");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("sparrow");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abcd@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abc");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for='Password']")).getText(),
                "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
