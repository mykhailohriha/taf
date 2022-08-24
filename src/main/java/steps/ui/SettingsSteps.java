package steps.ui;

import io.qameta.allure.Step;
import model.GeneralSetting;
import pages.settings.SettingsPage;
import steps.base.BaseUiSteps;

public class SettingsSteps extends BaseUiSteps {
    private final SettingsPage settingsPage;

    public SettingsSteps() {
        this.settingsPage = new SettingsPage();
    }

    @Step("Set general settings - {generalSettings}")
    public SettingsSteps setGeneralSettings(GeneralSetting generalSettings) {
        selectValueInLaunchInactivityTimeoutDropdown(generalSettings.getLaunchInactivityTimeout());
        selectValueInKeepLaunchesDropdown(generalSettings.getKeepLaunches());
        selectValueInKeepAttachmentsDropdown(generalSettings.getKeepAttachments());
        selectValueInKeepLogsDropdown(generalSettings.getKeepLogs());
        return this;
    }

    @Step("Select value in launch inactivity dropdown - {value}")
    public SettingsSteps selectValueInLaunchInactivityTimeoutDropdown(String value) {
        settingsPage.getLaunchInactivityTimeoutDropdown().selectValue(value);
        return this;
    }

    @Step("Select value in keep launches dropdown - {value}")
    public SettingsSteps selectValueInKeepLaunchesDropdown(String value) {
        settingsPage.getKeepLaunchesDropdown().selectValue(value);
        return this;
    }

    @Step("Select value in keep logs dropdown - {value}")
    public SettingsSteps selectValueInKeepLogsDropdown(String value) {
        settingsPage.getKeepLogsDropdown().selectValue(value);
        return this;
    }

    @Step("Select value in keep attachments dropdown - {value}")
    public SettingsSteps selectValueInKeepAttachmentsDropdown(String value) {
        settingsPage.getKeepAttachmentsDropdown().selectValue(value);
        return this;
    }

    @Step("Click 'Submit' button")
    public SettingsSteps clickSubmitButton() {
        settingsPage.getSubmitButton().click();
        return this;
    }
}
