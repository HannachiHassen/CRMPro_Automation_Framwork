package com.driver;

import java.util.Objects;

import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {

	private Driver() {
	}
	
	public static void initDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("", "");
		}
		DriverManager.setDriver(new FirefoxDriver());
		DriverManager.getDriver().get(null);
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
