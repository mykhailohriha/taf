package tests.api;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseApiTest;

import static org.apache.http.HttpStatus.SC_OK;

public class ReportPortalServicesApiTest extends BaseApiTest {
    private String expectedApiServiceName;
    private String expectedApiServiceVersion;
    private String expectedJobsServiceName;
    private String expectedJobsServiceVersion;
    private String expectedUatServiceName;
    private String expectedUatServiceVersion;
    private String expectedUiServiceName;
    private String expectedUiServiceVersion;

    @BeforeClass
    public void initData() {
        expectedApiServiceName = "API Service";
        expectedApiServiceVersion = "5.7.2";
        expectedJobsServiceName = "Jobs Service";
        expectedJobsServiceVersion = "5.7.2";
        expectedUatServiceName = "Authorization Service";
        expectedUatServiceVersion = "5.7.0";
        expectedUiServiceName = "Service UI";
        expectedUiServiceVersion = "5.7.2";
    }

    @Test
    public void verifyThatReportPortalServicesAreRunning() {
        Response reportPortalInfoResponse = reportPortalServicesSteps.sendGetReportPortalInfo(SC_OK);
        assertThatServiceIsUpAndRunning(reportPortalInfoResponse, "api.build.name", "api.build.version",
                expectedApiServiceName, expectedApiServiceVersion);
        assertThatServiceIsUpAndRunning(reportPortalInfoResponse, "jobs.build.name", "jobs.build.version",
                expectedJobsServiceName, expectedJobsServiceVersion);
        assertThatServiceIsUpAndRunning(reportPortalInfoResponse, "uat.build.name", "uat.build.version",
                expectedUatServiceName, expectedUatServiceVersion);
        assertThatServiceIsUpAndRunning(reportPortalInfoResponse, "ui.build.name", "ui.build.version",
                expectedUiServiceName, expectedUiServiceVersion);
        softAssertion.assertAll();
    }

    private void assertThatServiceIsUpAndRunning(Response reportPortalInfoResponse, String pathToServiceName,
                                                 String pathToServiceVersion, String expectedServiceName,
                                                 String expectedServiceVersion) {
        String serviceName = reportPortalServicesSteps
                .getBodyElementValueFromResponse(reportPortalInfoResponse, pathToServiceName);
        String serviceVersion = reportPortalServicesSteps
                .getBodyElementValueFromResponse(reportPortalInfoResponse, pathToServiceVersion);
        softAssertion.assertThat(serviceName)
                .as("Service name is as expected")
                .isEqualTo(expectedServiceName);
        softAssertion.assertThat(serviceVersion)
                .as("Service version is as expected")
                .isEqualTo(expectedServiceVersion);
    }

}
