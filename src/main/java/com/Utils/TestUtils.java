package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Base.BaseClass;

public class TestUtils extends BaseClass{
	public static long PAGE_LOAD_TIMEOUT=60;
    public static long IMPLICIT_WAIT=30;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        FileUtils.copyFile(file, new File(currentDir + "/Execution Reports/Fail Case ScreenShots/"+ System.currentTimeMillis()+".png" ));
    }

}
