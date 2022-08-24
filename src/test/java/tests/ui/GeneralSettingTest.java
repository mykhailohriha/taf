package tests.ui;

import model.GeneralSetting;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseUiTest;
import utils.UserUtil;

import static constants.Constant.Urls.GENERAL_SETTINGS;
import static constants.Constant.Urls.MAIN_PAGE;
import static datastrucktures.Messages.PROJECT_SETTINGS_SUCCESSFULLY_UPDATED;

public class GeneralSettingTest extends BaseUiTest {

    private GeneralSetting generalSettings;

    @BeforeClass
    public void initData() {
        generalSettings = GeneralSetting.builder()
                .launchInactivityTimeout("3 hours")
                .keepLaunches("21 days")
                .keepLogs("21 days")
                .keepAttachments("7 days")
                .build();
    }

    @Test
    public void verifyThatUserCanChangeGeneralSettings() {
        mainSteps.open(MAIN_PAGE);
        mainSteps.loginAsUser(UserUtil.getDefaultRegularUser());
        mainSteps.open(GENERAL_SETTINGS);
        settingsSteps.setGeneralSettings(generalSettings).clickSubmitButton();
        softAssertion.assertThat(dashboardSteps.getAllMessagesFromTooltip().contains(PROJECT_SETTINGS_SUCCESSFULLY_UPDATED))
                .as(PROJECT_SETTINGS_SUCCESSFULLY_UPDATED + " - message is displayed")
                .isTrue();
    }
}
