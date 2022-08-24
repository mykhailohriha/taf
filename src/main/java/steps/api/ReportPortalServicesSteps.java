package steps.api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.base.BaseApiSteps;

import static datastrucktures.webapi.RequestPaths.BASE_URL;
import static datastrucktures.webapi.RequestPaths.REPORT_PORTAL_SERVICES;

public class ReportPortalServicesSteps extends BaseApiSteps {
    @Step
    public Response sendGetReportPortalInfo(int expectedStatusCode) {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(BASE_URL.getPath()
                + REPORT_PORTAL_SERVICES.getPath()).build();
        return sendGetRequest(spec, expectedStatusCode);
    }
}
