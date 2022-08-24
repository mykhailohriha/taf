package steps.ui;

import io.qameta.allure.Step;
import pages.dashboard.DashboardDetailsPage;
import steps.base.BaseUiSteps;

public class DashboardDetailsSteps extends BaseUiSteps {
    private final DashboardDetailsPage dashboardDetailsPage;

    public DashboardDetailsSteps() {
        this.dashboardDetailsPage = new DashboardDetailsPage();
    }

    @Step("Click on 'Delete' button")
    public DashboardDetailsSteps clickDeleteButton() {
        dashboardDetailsPage.getDeleteButton().click();
        dashboardDetailsPage.getDeleteButtonOnWidget().click();
        return this;
    }
    @Step("Click on 'Edit' button")
    public DashboardDetailsSteps clickEditButton() {
        dashboardDetailsPage.getEditButton().click();
        return this;
    }
}
