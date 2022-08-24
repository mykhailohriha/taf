package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProxyCollection {
    private final By locator;
    private final WebDriver driver;

    public ProxyCollection(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public List<String> getText() {
        return driver.findElements(locator).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void click() {
        for (WebElement webElement : driver.findElements(locator)) {
            webElement.click();
        }
    }

    public ProxyCollection waitForVisible() {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(visibilityOf(driver.findElement(locator)));
        return this;
    }
}
