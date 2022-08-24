package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class DriverManager {

    private DriverManager() {

    }

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) return createDriver();
        else return driver;
    }

    private static WebDriver createDriver() {
        switch (BROWSER) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect browser name: " + BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
