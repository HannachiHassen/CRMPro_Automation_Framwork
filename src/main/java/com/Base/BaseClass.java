package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Utils.Constants;
import com.Utils.Environment;
import com.Utils.WebEventListener;

import customexception.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
    public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
          
    //public static WebDriver driver;
    public static Properties prop;
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
    				fis=new FileInputStream(System.getProperty("user.dir") + "./resources/config.properties");
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			}
    		}else {
    			try {
    				switch (envName.toLowerCase()) {
    				case Environment.ENV_QA:
    					fis= new FileInputStream(System.getProperty("user.dir") + "./resources/qa.config.properties");
    					break;
    				case Environment.ENV_DEV:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./resources/dev.config.properties");
    					break;
    				case Environment.ENV_STAGE:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./resources/stage.config.properties");
    					break;
    				case Environment.ENV_UAT:
    					fis = new FileInputStream(System.getProperty("user.dir") + "./resources/uat.config.properties");
    					break;
    				case Environment.ENV_PROD:
    					fis =new FileInputStream(System.getProperty("user.dir") + "./resources/prod.config.properties");
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
    
	public WebDriver initializeBrowser() {		
		
		String browserName=prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		System.out.println("browser name is : " + browserName);
		//log.info("browser name is : " + browserName);
		
		optionsManager =new OptionsManager();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			}else {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			if (headless.equalsIgnoreCase("yes")) {
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--headless");
				driver=new ChromeDriver(co);				
			}else {
			   driver=new ChromeDriver();
			}
		}
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headless.equalsIgnoreCase("yes")) {
				FirefoxOptions fo=new FirefoxOptions();
				fo.addArguments("--headless");
				driver =new FirefoxDriver(fo);
			}else {
				driver=new FirefoxDriver();
			}
						
		} else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new SafariDriver();
		}else {
			System.out.println(browserName + " is not found, please pass the correct browser....");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		return getDriver();
	}
    
	private void init_remoteDriver(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public static String takeScreenshot(String testMethodName, WebDriver driver) throws IOException {
    	File SourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String destinationFilePath=System.getProperty("user.dir")+ "\\Execution Reports\\FailedTestScreenshots\\" + testMethodName +".png";
        try {
        	FileUtils.copyFile(SourceFile, new File (destinationFilePath));
		} catch (Exception e) {
			System.out.println("Capture Failed " + e.getMessage());
		}    	
       
       return destinationFilePath;
	}
}	