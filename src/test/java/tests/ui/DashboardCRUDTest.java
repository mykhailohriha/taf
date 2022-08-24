package tests.ui;

import model.Dashboard;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseUiTest;

import static constants.Constant.Urls.DASHBOARD_PAGE;
import static constants.Constant.Urls.MAIN_PAGE;
import static datastrucktures.Messages.DASHBOARD_HAS_BEEN_ADDED;
import static datastrucktures.Messages.DASHBOARD_HAS_BEEN_DELETED;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static utils.UserUtil.getDefaultRegularUser;

public class DashboardCRUDTest extends BaseUiTest {

    private Dashboard dashboard;
    private String updatedName;

    @BeforeClass
    public void initData() {
        dashboard = Dashboard.builder()
                .name("Test name" + randomNumeric(5))
                .description("Test description" + randomNumeric(5))
                .share(true).build();
        updatedName = "Test name" + randomNumeric(5);
    }

    @Test
    public void verifyThatUserIsAbleToCRUDDashboard() {
        mainSteps.open(MAIN_PAGE);
        mainSteps.loginAsUser(getDefaultRegularUser());
        dashboardSteps.closeMessageWidget()
                .clickAddNewDashboardButton()
                .fillDashboard(dashboard)
                .clickAddButton();
        softAssertion.assertThat(dashboardSteps.getAllMessagesFromTooltip().contains(DASHBOARD_HAS_BEEN_ADDED))
                .as(DASHBOARD_HAS_BEEN_ADDED + " - message is displayed")
                .isTrue();
        dashboardSteps.closeMessageWidget();
        dashboardSteps.open(DASHBOARD_PAGE);
        dashboardSteps.searchAndOpenDashboardByName(dashboard.getName());
        dashboard.setName(updatedName);
        dashboardDetailsSteps.clickEditButton();
        dashboardSteps.fillDashboard(dashboard).clickUpdateButton();
        dashboardDetailsSteps.clickDeleteButton();
        softAssertion.assertThat(dashboardSteps.getAllMessagesFromTooltip().contains(DASHBOARD_HAS_BEEN_DELETED))
                .as(DASHBOARD_HAS_BEEN_DELETED + " - message is displayed")
                .isTrue();
        softAssertion.assertAll();
    }
}
