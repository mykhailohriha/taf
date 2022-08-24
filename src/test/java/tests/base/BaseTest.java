package tests.base;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class BaseTest {
    protected SoftAssertions softAssertion;

    @BeforeMethod
    public void beforeMethod() {
        softAssertion = new SoftAssertions();
    }
}
