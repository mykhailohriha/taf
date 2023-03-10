package com.mykhailohriha.core.base;

import static com.codeborne.selenide.Selenide.open;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;


public class BaseUiTest implements PagesForTests {

	protected SoftAssertions softAssertions;

	@BeforeMethod
	public void beforeMethod() {
		open("http://localhost:8080/ui/");
		softAssertions = new SoftAssertions();
	}

}
