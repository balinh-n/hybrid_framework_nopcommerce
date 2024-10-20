package commons;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static BasePage basePage() {
        return new BasePage();
    }

    public void openUrl(WebDriver driver, String Url) {
        driver.get(Url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    public void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresent(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresent(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitForAlertPresent(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String writeAlertText) {
        waitForAlertPresent(driver).sendKeys(writeAlertText);
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchWindowByID(WebDriver driver, String pageID) {
        Set<String> Ids = driver.getWindowHandles();
        for (String id : Ids) {
            if (!id.equals(pageID)) {
                driver.switchTo().window(id);
                sleepInSecond(3000);
            }
        }
    }

    public void switchWindowById(WebDriver driver, String pageTitle) {
        Set<String> allIds = driver.getWindowHandles();
        for (String id : allIds) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(pageTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParentId(WebDriver driver, String parentId) {
        Set<String> allIds = driver.getWindowHandles();
        for (String id : allIds) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentId);
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookie(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public Set<Cookie> getBrowserCookie(WebDriver driver, Cookie cookie) {
        return driver.manage().getCookies();
    }

    public By getByDiffLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("xpath") || locatorType.startsWith("XPath") || locatorType.startsWith("XPATH")) {
            by = By.xpath(locatorType.substring(6));
        } else if (locatorType.startsWith("css") || locatorType.startsWith("Css") || locatorType.startsWith("CSS")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("id") || locatorType.startsWith("Id") || locatorType.startsWith("ID")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("name") || locatorType.startsWith("Name") || locatorType.startsWith("NAME")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("class") || locatorType.startsWith("Class")
                || locatorType.startsWith("CLASS")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("tagname") || locatorType.startsWith("Tagname")
                || locatorType.startsWith("TAGNAME")) {
            by = By.tagName(locatorType.substring(8));
        } else {
            throw new RuntimeException("Locator is not valid.");
        }
        return by;
    }
    // public By getByLocator(String locator) {
    //     return By.xpath(locator);
    // }
    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByDiffLocator(locator));
    }

    public List<WebElement> getWebElements(WebDriver driver, String locator) {
        return driver.findElements(getByDiffLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void sendTextToElement(WebDriver driver, String locator, String valueToSend) {
        getWebElement(driver, locator).sendKeys(valueToSend);
    }

    public void selectItemDefaultDropDown(WebDriver driver, String locator, String itemValue) {
        new Select(getWebElement(driver, locator)).selectByValue(itemValue);
    }

    public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropDownMiltiple(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustiomDropdown(WebDriver driver, String parentLocator, String childLocator,
            String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(2000);

        List<WebElement> dropdownItems = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByDiffLocator(childLocator)));
        for (WebElement dropdownItem : dropdownItems) {
            if (dropdownItem.getText().trim().equals(expectedItem)) {
                dropdownItem.click();
                sleepInSecond(2000);
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeValue) {
        return getWebElement(driver, locator).getAttribute(attributeValue);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getCSSValue(WebDriver driver, String locator, String cssPropertyName) {
        return getWebElement(driver, locator).getCssValue(cssPropertyName);
    }

    public String getHexaColorFromRGBA(WebDriver driver, String locator) {
        return Color.fromString(getCSSValue(driver, locator, "background-color")).asHex().toUpperCase();
    }

    public int getElementsSize(WebDriver driver, String locator) {
        return getWebElements(driver, locator).size();
    }

    public void checkTheCheckBoxOrRadio(WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)) {
            getWebElement(driver, locator).click();
        }
    }

    public void uncheckTheCheckBoxOrRadio(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            getWebElement(driver, locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator))
                .perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getWebElement(driver, locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public Object executeJavascriptToBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText")
                .toString();
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textEpected) {
        String actualText = (String) ((JavascriptExecutor) driver)
                .executeScript("return document.documentElement.innerText.match('" + textEpected + "');");
        return textEpected.equals(actualText);
    }

    public Object scrollToBottomPage(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToURL(WebDriver driver, String Url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + Url + "')");
    }

    public void highlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
                originalStyle);
    }

    public Object clickToElementByJS(WebDriver driver, String locator) {
        return ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                getWebElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
                getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
                getWebElement(driver, locator));
    }

    public void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
                getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(getByDiffLocator(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElements(getWebElements(driver, locator)));
    }

    public void waitForElementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByDiffLocator(locator)));
    }

    public void waitForListElementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(getByDiffLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeSelected(getByDiffLocator(locator)));
    }

}
