package com.ExtentReport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	private static ExtentReports extentReport;
	private static String outputDirectory;
		
	public static ExtentReports generateReport() {
		try {
			outputDirectory = System.getProperty("user.dir") + "\\ExtentReports\\";
			new File(outputDirectory).mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
				 
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html");
	    htmlReporter.config().setDocumentTitle("ExtentReports - CRMPro Automation");
	    htmlReporter.config().setReportName("Test Results");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	     
	    extentReport = new ExtentReports();
	    extentReport.attachReporter(htmlReporter);
	    extentReport.setReportUsesManualConfiguration(true);
	     
	    extentReport.setSystemInfo("Operating System","Windows 10");
		extentReport.setSystemInfo("Tested By","Hassen Hannachi");
		                        
		System.out.println("Test Report Path - " + outputDirectory);
		
		System.out.println(("Extent Reports Test Suite is ending!"));
		
		return extentReport;			
	}
}