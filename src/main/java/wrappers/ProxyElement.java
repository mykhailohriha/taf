package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProxyElement {
    protected final By locator;
    protected final WebDriver driver;

    public ProxyElement(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public void click() {
        waitElementIsVisible(driver.findElement(locator)).click();
    }

    public void sendKeys(String keys) {
        waitElementIsVisible(driver.findElement(locator)).sendKeys(keys);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(visibilityOf(element));
        return element;
    }

    public ProxyElement waitForVisible() {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(visibilityOf(driver.findElement(locator)));
        return this;
    }

    public void fillInputIfValueIsNotNull(String value) {
        if (value != null) waitForVisible().sendKeys(value);
    }
}
