package com.Automation.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
    
	//This helper Class is to handle SCREENSHOTS,ALERTS, 
	//FRAMES SYNC ISSUES,JAVA SCRIPT EXCEUTOR etc. 
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/NewTours_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src,new File(screenshotPath));
			
			System.out.println("Screenshot captured");
			
		} catch (Exception e) {
			
			System.out.println("Unable to capture ScreenShot "+e.getMessage());
		}
		return screenshotPath;
		
	}
	
	public static String getCurrentDateTime() 
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
	}
}
