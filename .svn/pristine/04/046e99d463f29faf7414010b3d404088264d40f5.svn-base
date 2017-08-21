package com.tr.pageLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.TR_Eend2EndTest;
/**
 * Interviews Page Libraries.
 * class provide webdriver Interviews Page libraries , which can be used to create Interviews  etc
 *
 * @author Dileep H.E
 *
 */
public class Interviews{
	
	public WebDriver driver;
	public Common common;
	ExtLogger logger= ExtLogger.getLogger(TR_Eend2EndTest.class);
	
	public Interviews(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}
	
	
	@FindBy(xpath="//tr[th[text()='Job Applicant ID']]/following-sibling::tr/th/a[text()='007	']")
     private WebElement clkOnJobAppRecord;
	@FindBy(xpath="//td[@id='topButtonRow']/input[@value='Schedule Interview']")
	private WebElement clkOnScheduleInterview;
	@FindBy(xpath="//td[label[text()='Type Of Interview']]/following-sibling::td/div/span/select")
    private WebElement 	selectTypeOfInterview;
	@FindBy(xpath="//td[label[text()='Interview Time']]/following-sibling::td/span[@class='dateInput']/input")
	private WebElement clkOnDateBox;
	@FindBy(xpath="//a[text()='Today']")
	private WebElement selectDate;
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	@FindBy(xpath="//td[label[text()='Job Recruiter']]/following-sibling::td/span/a/img")
	private WebElement jobRecruiterLookupBtn;
	
	@FindBy(xpath="//tr[th[text()='Full Name']]/following-sibling::tr[1]/th/a")
	private WebElement selectFirstRecruiterRecord;
	@FindBy(xpath="//frame[@name='resultsFrame']")
	private WebElement ResultFrame;
	/**
	 * This method Use to create Interview
	 * @param typeOfInterview
	 */
	public void createInterview(String typeOfInterview){
		common.waitForWebElementPresent(clkOnJobAppRecord);
		clkOnJobAppRecord.click();
		scheduleInterview(typeOfInterview);
		
	}
	public void scheduleInterview(String typeOfInterview){
		common.mouseClickAtHiddenElement(clkOnScheduleInterview);
		common.select(selectTypeOfInterview, typeOfInterview);
		jobRecruiterLookupBtn.click();
		String childwindowID2 = common.expectedWindow("Search for a user ~ salesforce.com - Developer Edition");
		driver.switchTo().window(childwindowID2);
		common.waitForWebElementPresent(ResultFrame);
		driver.switchTo().frame(ResultFrame);
		selectFirstRecruiterRecord.click();
		driver.switchTo().window(common.currentWindow);
		clkOnDateBox.click();
		selectDate.click();
		saveBtn.click();
		common.waitForPageToLoad();
		try{
			String childwindow = common.expectedWindow("Calendar: New Event ~ salesforce.com - Developer Edition");
			System.out.println(driver.getTitle());
			driver.switchTo().window(childwindow);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(common.currentWindow);
			
		}
		 catch(Throwable T)
		{
			logger.info("calender pop up is not dispalayed");
		}
	
	    }
}
