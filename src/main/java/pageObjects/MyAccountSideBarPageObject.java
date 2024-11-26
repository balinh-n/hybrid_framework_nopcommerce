package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage{
    
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerInfoPageObject clickCustomerInfoLink() {
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMERINFO_LINK);
        return PageGenerateManager.getCustomerInfoPage(driver);
    }

    public void name(String pageName) {
        clickToElement(driver, stringFormat(MyAccountSideBarPageUI.formatElement, pageName));
        
    }
}
