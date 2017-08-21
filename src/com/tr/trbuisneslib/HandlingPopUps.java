package com.tr.trbuisneslib;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tr.genericlib.Common;

public class HandlingPopUps {
	
	
	WebDriver driver;
	public Common common;
	int count;
	boolean b;
	  
	
	public HandlingPopUps(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
	}

	public void lookUpPopupHandling(WebElement lookupBtn,String windowTitle,WebElement firstFrame
			                        ,WebElement searchEdt,String searchData,WebElement goBtn,
			                        WebElement secondFrame,String reqName)
	{
		  lookupBtn.click();
		  String childId=common.expectedWindow(windowTitle);
		  driver.switchTo().window(childId);
		  common.switchToFrame(firstFrame);
		  searchEdt.clear();
		  searchEdt.sendKeys(searchData);
		  goBtn.click();
		  driver.switchTo().defaultContent();
		  common.switchToFrame(secondFrame);
		  common.selectLink(reqName).click();
		  driver.switchTo().window(common.currentWindow);
		  common.waitForPageToLoad();
	}
	public void defaultPopUp() throws InterruptedException
	{
		
		while(count<3)
		{
		try
		{
		HashMap<String, String> map=common.getwindowIDs();
		driver.switchTo().window(map.get("childWindow"));
		driver.close();
		driver.switchTo().window(map.get("parentWindow"));
		b=true;
		break;
		}
		catch(Exception E)
		{
			Thread.sleep(5000);
			count++;
			System.out.println("no popup");
		 }
	}
		}
	
}
