package com.Base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;

	public OptionsManager() {
	}
	
	public ChromeOptions getChromeOptions() {
		co =new ChromeOptions();
		co.addExtensions(new File("/Users/naveenautomationlabs/Downloads/extension_1_3_4_0.crx"));
		co.addArguments("");
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("enableVNC", true);
			co.setBrowserVersion(prop.getProperty("browserversion"));
		}
		
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.setHeadless(true);
			co.addArguments("");			
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			co.addArguments("--incognito");
		return co;
	}
	

}
