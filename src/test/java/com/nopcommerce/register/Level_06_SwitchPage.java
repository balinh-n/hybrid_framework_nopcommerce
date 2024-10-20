package com.nopcommerce.register;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AddressPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageGeneratorPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_06_SwitchPage extends BaseTest {
    WebDriver driver;
    String email = getRandomText() + "@gmail.com";
    String password = getRandomText();

    private RegisterPageObject registerPage;
    private HomePageObject homePage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;

    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://localhost:5001/");
        homePage = PageGeneratorPageObject.getHomePage(driver);
    }

    @Test
    public void L01_Register() {
        homePage.clickToRegisterLink(driver);

        registerPage.sendTextToFirstName(driver, "jack");
        registerPage.sendTextToLastName(driver, "sparrow");
        registerPage.sendTextToEmail(driver, email);
        registerPage.sendTextToPassword(driver, password);
        registerPage.sendTextToConfirmPassword(driver, password);
        registerPage.clickRegisterButton(driver);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(driver),
                "Your registration completed");
    }

    public void L02_SwithcPage() {
        homePage = registerPage.clickContinueButton(driver);
        customerInfoPage = homePage.clickToMyAccountLink(driver);
        addressPage = customerInfoPage.openAddressPage(driver);
        orderPage = addressPage.openOrderPage(driver);
        rewardPointPage = orderPage.openRewardPointPage(driver);
        customerInfoPage = rewardPointPage.openCustomerInfoPage(driver);
    }

    @AfterClass
    public void afterMethod() {
        driver.close();
    }
}
