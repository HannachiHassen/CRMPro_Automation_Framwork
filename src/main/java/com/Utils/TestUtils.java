package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Base.BaseClass;

public class TestUtils extends BaseClass{
	public static long PAGE_LOAD_TIMEOUT=60;
    public static long IMPLICIT_WAIT=30;

    public static String takeScreenshotAtEndOfTest(WebDriver driver, String testMethodName) throws IOException {
    	//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File sourceFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        String destinationFilePath=System.getProperty(currentDir + "/Execution Reports/Fail Case ScreenShots/"+ System.currentTimeMillis() +".png" );
        FileUtils.copyFile(sourceFile, new File (destinationFilePath));
		return destinationFilePath;   
    }
}
