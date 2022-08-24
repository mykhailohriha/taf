package pages.dashboard;

import lombok.Data;
import pages.base.BasePage;
import wrappers.ProxyCollection;
import wrappers.ProxyElement;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

@Data
public class DashboardPage extends BasePage {
    private final ProxyCollection messagesWidget = findCollectionBy(cssSelector("[class='notification-transition-enter-done'] p"));
    private final ProxyElement userBlock = findElementBy(cssSelector("[alt='avatar']"));
    private final ProxyElement dashboardNameInput = findElementBy(cssSelector("[placeholder='Enter dashboard name']"));
    private final ProxyElement dashboardDescriptionInput = findElementBy(cssSelector("[placeholder='Enter dashboard description']"));
    private final ProxyElement searchByNameInput = findElementBy(cssSelector("[placeholder='Search by name']"));
    private final ProxyElement shareSwitcher = findElementBy(cssSelector("[class*=inputBigSwitcher]"));
    private final ProxyElement logoutButton = findElementBy(xpath("//div[contains(text(),'Logout')]"));
    private final ProxyElement addNewDashboardButton = findElementBy(xpath("//span[contains(text(),'Add New Dashboard')]"));
    private final ProxyElement addButton = findElementBy(xpath("//button[contains(text(),'Add')]"));
    private final ProxyElement updateButton = findElementBy(xpath("//button[contains(text(),'Update')]"));
    private final String dashboardTitleTemplate = "//div[contains(@class, 'dashboardTable')]//a[contains(text(),'%s')]";

    public ProxyElement getDashboardTitleByName(String dashboardName) {
        return findElementBy(xpath(String.format(dashboardTitleTemplate, dashboardName)));
    }
}
