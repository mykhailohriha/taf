package com.mykhailohriha.service;

import java.util.ResourceBundle;


public class PropertiesController {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));

	public static String getPropertyByKey(String key) {
		return resourceBundle.getString(key);
	}
}
