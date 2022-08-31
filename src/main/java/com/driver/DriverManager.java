package com.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
	
	}
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

}
