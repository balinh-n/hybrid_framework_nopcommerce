package commons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static BasePage basePage() {
        return new BasePage();
    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getWebTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public By getByXpath(WebDriver driver, String locator) {
        return By.xpath(locator);
    }

    public By getDifferentLocator(String locator) {
        By by = null;
        if (locator.startsWith("xpath")) {
            by = By.xpath(locator.substring(6));
        } else if (locator.startsWith("css")) {
            by = By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("id")) {
            by = By.id(locator.substring(3));
        } else if (locator.startsWith("name")) {
            by = By.name(locator.substring(5));
        } else if (locator.startsWith("class")) {
            by = By.className(locator.substring(6));
        }
        return by;
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(driver, locator));
    }

    public WebElement getDifferentWebElement(WebDriver driver, String locator) {
        return driver.findElement(getDifferentLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToDifferentElement(WebDriver driver, String locator) {
        getDifferentWebElement(driver, locator).click();
    }

    public void sendTextToElement(WebDriver driver, String locator, String valueText) {
        getWebElement(driver, locator).sendKeys(valueText);
    }

    public void sendTextToDifferentElement(WebDriver driver, String locator, String valueText) {
        getDifferentWebElement(driver, locator).sendKeys(valueText);
    }

    public String getTextOfElement(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getTextOfDifferentElement(WebDriver driver, String locator) {
        return getDifferentWebElement(driver, locator).getText();
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(driver, locator)));
    }

    public void waitForDifferentElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.visibilityOfElementLocated(getDifferentLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.elementToBeClickable(getByXpath(driver, locator)));
    }

    public void waitForDifferentElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.elementToBeClickable(getDifferentLocator(locator)));
    }

    public String getDynamicLocator(String locator, String... locatorValue) {
        locator = String.format(locator, (Object[]) locatorValue);
        return locator;
    }

    public void clickToElement(WebDriver driver, String locator, String... locatorValue) {
        getWebElement(driver, getDynamicLocator(locator, locatorValue)).click();
    }

    long longTimeout = GlobalConstants.Long_TIMEOUT;
}
