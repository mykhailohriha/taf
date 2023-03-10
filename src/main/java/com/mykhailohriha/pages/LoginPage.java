package com.mykhailohriha.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

import com.codeborne.selenide.SelenideElement;
import com.mykhailohriha.model.User;


public class LoginPage {
	private final SelenideElement loginField = $("[name='login']");
	private final SelenideElement passwordField = $("[name='password']");
	private final SelenideElement loginButton = $("[type='submit']");
	private final SelenideElement notification = $(xpath("//p[text()='Signed in successfully']"));

	public LoginPage login(User user) {
		loginField.setValue(user.getName());
		passwordField.setValue(user.getPassword());
		loginButton.click();
		return this;
	}

	public SelenideElement getNotification() {
		return notification;
	}
}
