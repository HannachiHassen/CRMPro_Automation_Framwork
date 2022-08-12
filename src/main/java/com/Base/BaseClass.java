package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Utilites.WebEventListener;

public class BaseClass {
	public static WebDriver driver;
    public static Properties props;
    public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
    public static long PAGE_LOAD_TIMEOUT=60;
    public static long IMPLICIT_WAIT=30;
    
    public BaseClass() {
        try {
            props=new Properties();
            FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "./resources/config.properties");
            props.load(ip);
            System.out.println(props.getProperty("url"));
            System.out.println(props.getProperty("browser"));

        } catch (FileNotFoundException ip) {
            ip.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    @BeforeClass
    public static void initialization(){
        if (props.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }else if (props.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "./Drivers/geckodriver.exe");
            driver =new FirefoxDriver();
        } else if (props.getProperty("browser").equals("edge")) {
            System.setProperty("webdriver.edge.driver","./FreeCRMAutomationTest/Drivers/msedgedriver.exe");
            driver =new EdgeDriver();
        }else {
            System.out.println("Path of Driver Executable is not set for any Browser");
        }
        e_driver =new EventFiringWebDriver(driver);

        // Now create object of WebEventListener handler to register it with EventFiringWebDriver
        eventListener =new WebEventListener();
        e_driver.register(eventListener);

        driver =e_driver;    //Assign that to event listener driver to WebDriver.

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(props.getProperty("url"));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


