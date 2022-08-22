package com.Base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	BasePage base;
	public WebDriver driver;
	protected Properties prop;
	public Logger log;
	
	protected SoftAssert softAssert;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters(value={"browser"})
	public void setUp(String browser) {
		String browserName = null;
		base=new BasePage();
		prop=base.initializeProperties();
		log = LogManager.getLogger(BaseTest.class.getName());
		
		if (browser == null) {
			prop.setProperty("browser", browser);
		}else {
			browserName = browser;		
		}
	 driver=base.initializeBrowser(browserName);
	 log.debug("Browser got launched");
	 driver.get(prop.getProperty("url"));
	 log.debug("Navigated to application URL");
	 
	 softAssert=new SoftAssert();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		if (driver != null) {
			driver.close();;
		}		
	}

}
