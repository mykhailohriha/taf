package com.mykhailohriha.core.base;

import static com.codeborne.selenide.Selenide.open;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.codeborne.selenide.Configuration;


public class BaseUiTest implements PagesForTests {

	protected SoftAssertions softAssertions;

	@BeforeClass
	public void beforeClass() {
		Configuration.browserSize = "1920x1080";
		String browser = System.getProperty("browser", "chrome");
		switch (browser.toLowerCase()) {
			case "chrome":
				Configuration.browser = "chrome";
				break;
			case "firefox":
				Configuration.browser = "firefox";
				break;
			default:
				throw new IllegalArgumentException("Invalid browser: " + browser);
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		open("http://localhost:8080/ui/");
		softAssertions = new SoftAssertions();
	}

}
