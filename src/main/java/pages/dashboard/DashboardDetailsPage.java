package pages.dashboard;

import lombok.Data;
import pages.base.BasePage;
import wrappers.ProxyElement;

import static org.openqa.selenium.By.xpath;

@Data
public class DashboardDetailsPage extends BasePage {
    private final ProxyElement deleteButton = findElementBy(xpath("//span[contains(text(),'Delete')]"));
    private final ProxyElement deleteButtonOnWidget = findElementBy(xpath("//button[contains(text(),'Delete')]"));
    private final ProxyElement editButton = findElementBy(xpath("//span[contains(text(),'Edit')]"));
}
