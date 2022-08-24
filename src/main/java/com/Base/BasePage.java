package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Utils.Constants;
import com.Utils.Environment;
import com.Utils.WebEventListener;

import customexception.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage{
	
	//public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
          
    public static Properties prop;
    public static boolean highlighElement;
    OptionsManager optionsManager;
	
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
    
    public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
    
    public Properties initializeProperties() {
    	FileInputStream fis=null;
    	prop=new Properties();
    	String envName = null;
    	
    	try {
    		//String envName= System.getenv("env");
    		envName = (System.getProperty("env"));
    		System.out.println("Running tests on environment: ---->" + envName);
    		//log.info("Running tests on environment: " + envName);
    		if (envName == null) {
    			System.out.println("No env is given ..... hence running it on QA");
    			try {
    				fis=new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/config.properties");
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			}
    		}else {
    			try {
    				switch (envName.toLowerCase()) {
    				case Environment.ENV_QA:
    					fis= new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/qa.config.properties");
    					break;
    				case Environment.ENV_DEV:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/dev.config.properties");
    					break;
    				case Environment.ENV_STAGE:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/stage.config.properties");
    					break;
    				case Environment.ENV_UAT:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/uat.config.properties");
    					break;
    				case Environment.ENV_PROD:
    					fis =new FileInputStream(System.getProperty("user.dir") + "./src/main/java/com/Config/prod.config.properties");
    					break;
    				default:
    					System.out.println("Please pass the right enviroment value ..."+ envName);
    					//log.error("please pass the right environment value..." + envName);
    					throw new FrameworkException("no env found...");
    				}
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			}catch (FrameworkException e) {
    				e.printStackTrace();
    			}				
		}
    		prop.load(fis);	         
    	} catch (FileNotFoundException e) {
			e.printStackTrace();     
		}catch (IOException io) {
			io.printStackTrace();
		}
    	System.out.println("Page URL : "+ prop.getProperty("url"));
        System.out.println("Enviroment used is :" + prop.getProperty("env"));
        
		return prop;
    }
    
	public WebDriver initializeBrowser(String browserName) {	
		
		highlighElement = prop.getProperty("highlight").equals("yes") ? true : false;
		System.out.println("browser name is : " + browserName);
		//log.info("browser name is : " + browserName);
		
		optionsManager =new OptionsManager(prop);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			}else {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			}else {
				WebDriverManager.firefoxdriver().setup();
				tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}
						
		} else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tldriver.set(new SafariDriver());
		}else {
			System.out.println(browserName + " is not found, please pass the correct browser....");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		return getDriver();
	}
    
	private void init_remoteDriver(String browserName) {
		System.out.println("Running tests on remote grid server: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			try {
				tldriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else if(browserName.equals("firefox")) {
			try {
				tldriver.set(
						 new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public static String takeScreenshot(String testMethodName, WebDriver driver) throws IOException {
    	File SourceFile= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
    	String destinationFilePath=System.getProperty("user.dir")+ "\\Execution Reports\\FailedTestScreenshots\\" + testMethodName +".png";
        try {
        	FileUtils.copyFile(SourceFile, new File (destinationFilePath));
		} catch (Exception e) {
			System.out.println("Capture Failed " + e.getMessage());
		}    	
       
       return destinationFilePath;
	}
}	