package steps.base;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BaseApiSteps extends BaseRequests {
    @Step
    public String getBodyElementValueFromResponse(Response resp, String pathToElement) {
        return resp.getBody().jsonPath().getString(pathToElement);
    }
}
