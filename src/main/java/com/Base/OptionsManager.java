package com.Base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManager() {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co =new ChromeOptions();
		co.addExtensions(new File("/Users/naveenautomationlabs/Downloads/extension_1_3_4_0.crx"));
		co.addArguments("");
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("enableVNC", true);
			co.setBrowserVersion(prop.getProperty("browserversion"));
		}
		
		if (prop.getProperty("headless").equals("yes")) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setCapability("enableVNC", true);
			fo.setBrowserVersion(prop.getProperty("browserversion"));
		}
		if (prop.getProperty("headless").equals("yes")) fo.addArguments("--incognito");
		return fo;
	}
}
