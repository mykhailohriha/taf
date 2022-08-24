package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class Dropdown extends ProxyElement {
    public Dropdown(By locator, WebDriver driver) {
        super(locator, driver);
    }

    public void selectValue(String value) {
        waitForVisible().click();
        waitElementIsVisible(
                locator.findElement(driver.findElement(xpath(String.format("//div[contains(text(),'%s')]", value))))).click();
    }
}
