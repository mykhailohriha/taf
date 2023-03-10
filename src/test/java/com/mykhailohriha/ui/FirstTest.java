package com.mykhailohriha.ui;

import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.mykhailohriha.core.base.BaseUiTest;


public class FirstTest extends BaseUiTest {

	@Test
	public void verifyUserIsAbleToLogin() {
		loginPage.login("superadmin", "erebus");
		softAssertions.assertThat(loginPage.getNotification().should(Condition.visible).isDisplayed()).isTrue();
		softAssertions.assertAll();
	}
}
