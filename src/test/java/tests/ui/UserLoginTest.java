package tests.ui;

import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseUiTest;

import static constants.Constant.Urls.MAIN_PAGE;
import static datastrucktures.Messages.SIGNED_IN_SUCCESSFULLY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.UserUtil.getDefaultAdminUser;
import static utils.UserUtil.getDefaultRegularUser;

public class UserLoginTest extends BaseUiTest {

    @DataProvider(name = "user type")
    public Object[] users() {
        return new Object[]{getDefaultRegularUser(), getDefaultAdminUser()};
    }

    @Test(dataProvider = "user type")
    public void verifyThatUserIsAbleToLogin(User user) {
        mainSteps.open(MAIN_PAGE);
        mainSteps.loginAsUser(user);
        assertThat(dashboardSteps.getAllMessagesFromTooltip().contains(SIGNED_IN_SUCCESSFULLY))
                .as(SIGNED_IN_SUCCESSFULLY + " - message is displayed")
                .isTrue();
    }

    @AfterMethod
    public void logoutUser() {
        dashboardSteps.closeMessageWidget().logout();
    }
}
