package com.mykhailohriha.service;

import static com.mykhailohriha.service.PropertiesController.getPropertyByKey;

import com.mykhailohriha.model.User;


public class UserCreator {
	public static final String DEFAULT_USER_NAME = "default.user.name";
	public static final String ADMIN_USER_NAME = "admin.user.name";
	public static final String DEFAULT_USER_PASSWORD = "default.user.password";
	public static final String ADMIN_USER_PASSWORD = "admin.user.password";

	public static User defaultUser() {
		return new User(getPropertyByKey(DEFAULT_USER_NAME), getPropertyByKey(DEFAULT_USER_PASSWORD));
	}

	public static User adminUser() {
		return new User(getPropertyByKey(ADMIN_USER_NAME), getPropertyByKey(ADMIN_USER_PASSWORD));
	}
}
