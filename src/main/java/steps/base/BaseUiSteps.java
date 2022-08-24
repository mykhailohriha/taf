package steps.base;

import io.qameta.allure.Step;

import static common.DriverManager.getDriver;

public class BaseUiSteps {
    @Step("Open url - {url}")
    public BaseUiSteps open(String url) {
        getDriver().get(url);
        return this;
    }
}
