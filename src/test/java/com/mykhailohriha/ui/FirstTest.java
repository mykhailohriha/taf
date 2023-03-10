package com.mykhailohriha.ui;

import static com.mykhailohriha.service.UserCreator.defaultUser;

import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.mykhailohriha.core.base.BaseUiTest;


public class FirstTest extends BaseUiTest {

	@Test
	public void verifyUserIsAbleToLogin() {
		loginPage.login(defaultUser());
		softAssertions.assertThat(loginPage.getNotification().should(Condition.visible).isDisplayed()).isTrue();
		softAssertions.assertAll();
	}
}
