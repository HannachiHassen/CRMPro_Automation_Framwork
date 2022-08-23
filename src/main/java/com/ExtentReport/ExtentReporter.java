package com.ExtentReport;

import java.io.File;
import java.net.InetAddress;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	private static ExtentSparkReporter reporter;
	static ExtentReports extentReport;
	static String outputDirectory;
	static String extentReportPath;

	public static ExtentReports getExtentReport() {
		try {
			 outputDirectory = System.getProperty("user.dir") + "\\Execution Reports\\";
			 new File(outputDirectory).mkdir();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
		
		extentReportPath = outputDirectory + File.separator + ".\\Graphic Reports\\HTMLExtentReportTestNG.html";
		reporter = new ExtentSparkReporter(extentReportPath);	    
		
		extentReport = new ExtentReports();
		
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("ExtentReports - CRMPro Automation");
		reporter.config().setTheme(Theme.STANDARD);	
		reporter.config().setEncoding("utf-8");
        reporter.config().setProtocol(Protocol.HTTPS);
		
		extentReport.attachReporter(reporter);
		
		extentReport.setSystemInfo("Tested By","Hassen Hannachi");		
        extentReport.setSystemInfo("GUI Testing", "QA");
        extentReport.setSystemInfo("Application","crmpro.com/index.html");
        extentReport.setSystemInfo("Browser", "Chrome");
        extentReport.setSystemInfo("OS Architecture", "Microsoft");
        extentReport.setSystemInfo("Operating System","Windows");        
        
        try {        	
        	extentReport.setSystemInfo("OS Version", System.getProperty("os.version"));
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
