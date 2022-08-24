package steps.ui;

import io.qameta.allure.Step;
import model.User;
import pages.main.MainPage;
import steps.base.BaseUiSteps;

public class MainSteps extends BaseUiSteps {
    private final MainPage mainPage;

    public MainSteps() {
        this.mainPage = new MainPage();
    }

    @Step("Login as user - {user}")
    public MainSteps loginAsUser(User user) {
        mainPage.getLoginInput().sendKeys(user.getLogin());
        mainPage.getPasswordInput().sendKeys(user.getPassword());
        mainPage.getLoginButton().click();
        mainPage.getAllDashboardTitle().waitForVisible();
        return this;
    }
}
