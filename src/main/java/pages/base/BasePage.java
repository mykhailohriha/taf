package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Dropdown;
import wrappers.ProxyCollection;
import wrappers.ProxyElement;

import static common.DriverManager.getDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }

    public ProxyElement findElementBy(By locator) {
        return new ProxyElement(locator, driver);
    }

    public ProxyCollection findCollectionBy(By locator) {
        return new ProxyCollection(locator, driver);
    }

    public Dropdown findDropdownBy(By locator) {
        return new Dropdown(locator, driver);
    }

    public void refresh(){
        driver.navigate().refresh();
    }
}
