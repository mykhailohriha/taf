package utils;

import model.User;

import static java.lang.System.getProperty;

public class UserUtil {

    private UserUtil() {
    }

    public static User getDefaultRegularUser() {
        return User.builder()
                .login(getProperty("defaultRegularUserLogin"))
                .password(getProperty("defaultRegularUserPassword")).build();
    }

    public static User getDefaultAdminUser() {
        return User.builder()
                .login(getProperty("defaultAdminUserLogin"))
                .password(getProperty("defaultAdminUserPassword")).build();
    }
}
