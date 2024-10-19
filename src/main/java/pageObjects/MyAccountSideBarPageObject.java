package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAcountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage{
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementVisible(driver, MyAcountSideBarPageUI.CUSTOMERINFO_LINK);
        clickToElement(driver, MyAcountSideBarPageUI.CUSTOMERINFO_LINK);
        return PageGeneratorPageObject.getCustomerInfoPage(driver);
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementVisible(driver, MyAcountSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, MyAcountSideBarPageUI.ADDRESS_LINK);
        return PageGeneratorPageObject.getAddressPage(driver);
    }
    public OrderPageObject openOrderPage(WebDriver driver) {
        waitForElementVisible(driver, MyAcountSideBarPageUI.ORDER_LINK);
        clickToElement(driver, MyAcountSideBarPageUI.ORDER_LINK);
        return PageGeneratorPageObject.getOrderPage(driver);
    }
    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementVisible(driver, MyAcountSideBarPageUI.REWARDPOINT_LINK);
        clickToElement(driver, MyAcountSideBarPageUI.REWARDPOINT_LINK);
        return PageGeneratorPageObject.getRewardPointPage(driver);
    }
}
