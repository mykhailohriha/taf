package steps.ui;

import io.qameta.allure.Step;
import model.Dashboard;
import pages.dashboard.DashboardPage;
import steps.base.BaseUiSteps;

import java.util.List;

public class DashboardSteps extends BaseUiSteps {
    private final DashboardPage dashboardPage;

    public DashboardSteps() {
        this.dashboardPage = new DashboardPage();
    }

    @Step("Logout")
    public DashboardSteps logout() {
        dashboardPage.refresh();
        dashboardPage.getUserBlock().click();
        dashboardPage.getLogoutButton().click();
        return this;
    }

    @Step("Click on 'Add new dashboard' button")
    public DashboardSteps clickAddNewDashboardButton() {
        dashboardPage.getAddNewDashboardButton().click();
        return this;
    }

    @Step("Fill dashboard - {dashboard}")
    public DashboardSteps fillDashboard(Dashboard dashboard) {
        dashboardPage.getDashboardNameInput().fillInputIfValueIsNotNull(dashboard.getName());
        dashboardPage.getDashboardDescriptionInput().fillInputIfValueIsNotNull(dashboard.getDescription());
        if (dashboard.isShare()) dashboardPage.getShareSwitcher().click();
        return this;
    }

    @Step("Click 'Add' button")
    public DashboardSteps clickAddButton() {
        dashboardPage.getAddButton().click();
        return this;
    }

    @Step("Click 'Update' button")
    public DashboardSteps clickUpdateButton() {
        dashboardPage.getUpdateButton().click();
        return this;
    }

    @Step("Close message widget")
    public DashboardSteps closeMessageWidget() {
        dashboardPage.getMessagesWidget().click();
        return this;
    }

    @Step("Search and open dashboard by name - {dashboardName}")
    public DashboardSteps searchAndOpenDashboardByName(String dashboardName) {
        this.searchDashboardByName(dashboardName).openDashboardByName(dashboardName);
        return this;
    }

    @Step("Search dashboard by name - {dashboardName}")
    public DashboardSteps searchDashboardByName(String dashboardName) {
        dashboardPage.getSearchByNameInput().sendKeys(dashboardName);
        return this;
    }

    @Step("Open dashboard by name - {dashboardName}")
    public DashboardSteps openDashboardByName(String dashboardName) {
        dashboardPage.getDashboardTitleByName(dashboardName).click();
        return this;
    }

    @Step("Get all messages from tooltip")
    public List<String> getAllMessagesFromTooltip() {
        return dashboardPage.getMessagesWidget().waitForVisible().getText();
    }
}
