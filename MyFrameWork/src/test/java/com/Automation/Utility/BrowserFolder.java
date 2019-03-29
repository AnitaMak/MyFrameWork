package com.Automation.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFolder {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{
		   System.setProperty("webdriver.chrome.driver","./DriversFolder/chromedriver.exe");
			
		  driver=new ChromeDriver();
		 
			
		}
		else if(browserName.equals("Firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","./DriversFolder/geckodriver.exe");
				
			  driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			 System.setProperty("webdriver.ie.driver","./DriversFolder/IEdriverServer.exe");
				
			  driver=new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("We do not support this browser");
		}
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
		 driver.manage().window().maximize();
		 driver.get(appURL);
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		 
		 return driver;
		
	}
	
	public static void quitBrouwser(WebDriver driver)
	{
		driver.quit();
	}

}
