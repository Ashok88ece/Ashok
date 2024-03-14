package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots,alerts,multiple windows,sync issues,javascript executor
	
	
	public static void captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("./Screenshots/HRM" + getCurrentDateTime()  + ".png"));
			
			System.out.println("Screenshot Captured");
		} 
		catch (IOException e) {
			System.out.println("Unable to get the screenshot :"+e.getMessage());
		}
		
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customformat.format(currentDate);
		
	}

}
