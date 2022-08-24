package common;

import steps.ui.DashboardDetailsSteps;
import steps.ui.DashboardSteps;
import steps.ui.MainSteps;
import steps.ui.SettingsSteps;

public interface StepsForUiTests {
    MainSteps mainSteps = new MainSteps();
    DashboardSteps dashboardSteps = new DashboardSteps();
    DashboardDetailsSteps dashboardDetailsSteps = new DashboardDetailsSteps();
    SettingsSteps settingsSteps = new SettingsSteps();
}
