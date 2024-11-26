package commons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void moveToNextPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(WebDriver driver, String valueText) {
        driver.switchTo().alert().sendKeys(valueText);
    }

    public void waitForAlertPresent(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    public By getXpathLocator(String locator) {
        return By.xpath(locator);
    }

    public By getDynamicLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH")) {
            by = By.xpath(locatorType.substring(6));
        }
        if (locatorType.startsWith("css") || locatorType.startsWith("CSS")) {
            by = By.cssSelector(locatorType.substring(4));
        }
        if (locatorType.startsWith("class") || locatorType.startsWith("CLASS")) {
            by = By.className(locatorType.substring(6));
        }
        if (locatorType.startsWith("id") || locatorType.startsWith("ID")) {
            by = By.id(locatorType.substring(3));
        }
        if (locatorType.startsWith("name") || locatorType.startsWith("NAME")) {
            by = By.name(locatorType.substring(5));
        }
        if (locatorType.startsWith("tag") || locatorType.startsWith("TAG")) {
            by = By.tagName(locatorType.substring(4));
        }
        return by;
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getXpathLocator(locator));
    }

    public WebElement getDynamicElement(WebDriver driver, String locator) {
        return driver.findElement(getDynamicLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getXpathLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToDynamicElement(WebDriver driver, String locator) {
        getDynamicElement(driver, locator).click();
    }

    public void clickToFormatElement(WebDriver driver, String locator, String replaceText) {
        getDynamicElement(driver, stringFormat(locator, replaceText)).click();
    }

    public void sendTextToElement(WebDriver driver, String locator, String valueText) {
        getElement(driver, locator).sendKeys(valueText);
    }

    public void sendTextToDynamicElement(WebDriver driver, String locator, String valueText) {
        getDynamicElement(driver, locator).sendKeys(valueText);
    }

    public String getTextOfElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextOfDynamicElement(WebDriver driver, String locator) {
        return getDynamicElement(driver, locator).getText();
    }

    public String getAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public int getElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getXpathLocator(locator)));
    }

    public void waitForDynamicElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getDynamicLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getXpathLocator(locator)));
    }

    public void waitForDynamicElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getDynamicLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getXpathLocator(locator)));
    }

    public void waitForDynamicElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getDynamicLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getXpathLocator(locator)));
    }

    public void waitForDynamicElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getXpathLocator(locator)));
    }

    public String stringFormat(String locator, String... replaceText) {
        String replaceLocator = String.format(locator, (Object[]) replaceText);
        return replaceLocator;
    }

}
