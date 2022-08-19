package com.ExtentReport;

import java.io.File;
import java.net.InetAddress;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	static ExtentReports extentReport;
	static String outputDirectory;

	public static ExtentReports getExtentReport() {
		try {
			 outputDirectory = System.getProperty("user.dir") + "/Execution Reports/";
			 new File(outputDirectory).mkdir();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
		
		String extentReportPath = outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		extentReport = new ExtentReports();
		
		reporter.config().setDocumentTitle("ExtentReports - CRMPro Automation");
		reporter.config().setReportName("Test Results");
		reporter.config().setTheme(Theme.STANDARD);	
		reporter.config().setEncoding("utf-8");
        reporter.config().setProtocol(Protocol.HTTPS);
		
		extentReport.attachReporter(reporter);
		
		extentReport.setSystemInfo("Tested By","Hassen Hannachi");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Operating System","Windows");
		extentReport.setSystemInfo("OS Version", "10");
		extentReport.setSystemInfo("OS Architecture", "Microsoft");
        extentReport.setSystemInfo("GUI Testing", "QA");
        extentReport.setSystemInfo("Application","crmpro.com/index.html");
        
        
        try {
        	extentReport.setSystemInfo("JAVA Version", System.getProperty("java.version")); 
            extentReport.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
		System.out.println("Test Report Path - " + outputDirectory);
		System.out.println(("Extent Reports Test Suite is ending!"));

		return extentReport;
	}
}
