package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Utils.Constants;
import com.Utils.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass{
	
    public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
          
    public static WebDriver driver;
    public Properties prop;
	
    public Properties initializeProperties() {
    	try {
			 prop=new Properties();
	         FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "./resources/data.properties");
	         prop.load(fis);
	         System.out.println(prop.getProperty("url"));
	         System.out.println(prop.getProperty("browser"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException io) {
			io.printStackTrace();
		}
		return prop;		
    }
    
	public WebDriver initializeBrowser() {		
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();			
		} else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("")) {
			WebDriverManager.phantomjs().setup();
			
		} 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		return driver;
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