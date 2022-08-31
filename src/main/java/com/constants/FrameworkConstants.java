package com.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}	

	private static final int PAGELOADTIMEOUT=60;
	private static final int IMPLICITWAIT=30;    
	
	private static final String RESOURCESPATH= System.getProperty("user.dir") +"/CRM_Automation_Framework/";
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/src/main/java/com/Config/config.properties";
	private static final String EXCELFILEPATH = RESOURCESPATH + "/testdata/HubSpotTestData.xlsx";
	
	public static final int SHORT_WAIT = 3000;
	public static final int MEDIUM_WAIT = 6000;
	public static final int LONG_WAIT = 10000;
	
	public static long getPageLoadTimeout() {
		return PAGELOADTIMEOUT;
	}

	public static long getImplicitWait() {
		return IMPLICITWAIT;
	}
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getTestdatasheetpath() {
		return EXCELFILEPATH;
	}
}
