package pages.main;

import lombok.Data;
import pages.base.BasePage;
import wrappers.ProxyElement;

import static org.openqa.selenium.By.cssSelector;

@Data
public class MainPage extends BasePage {
    private final ProxyElement loginInput = findElementBy(cssSelector("[name=login]"));
    private final ProxyElement passwordInput = findElementBy(cssSelector("[name=password]"));
    private final ProxyElement loginButton = findElementBy(cssSelector("[type=submit]"));
    private final ProxyElement allDashboardTitle = findElementBy(cssSelector("[title='All Dashboards']"));
}
