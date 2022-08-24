package pages.settings;

import lombok.Data;
import pages.base.BasePage;
import wrappers.Dropdown;
import wrappers.ProxyElement;

import static org.openqa.selenium.By.xpath;

@Data
public class SettingsPage extends BasePage {
    private final Dropdown launchInactivityTimeoutDropdown = findDropdownBy(
            xpath("//span[contains(text(),'Launch inactivity timeout')]/parent::div/div/div"));
    private final Dropdown keepLaunchesDropdown = findDropdownBy(
            xpath("//span[contains(text(),'Keep launches')]/parent::div/div/div"));
    private final Dropdown keepLogsDropdown = findDropdownBy(
            xpath("//span[contains(text(),'Keep logs')]/parent::div/div/div"));
    private final Dropdown keepAttachmentsDropdown = findDropdownBy(
            xpath("//span[contains(text(),'Keep attachments')]/parent::div/div/div"));
    private final ProxyElement submitButton = findElementBy(xpath("//button[contains(text(),'Submit')]"));
}
