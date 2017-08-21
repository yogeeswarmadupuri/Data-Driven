package com.tr.jobs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Driver;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.sampleTest;
import com.tr.workflowlib.InitializationClass;

public class CreateJobTest {
	
	/**
	 * 
	 *  object intilization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Jobs jobPage;
	InitializationClass init;
	ExtLogger logger;
    JobApplicants jobApplicantsPage;
    int count;
    boolean flag;
    
    /**
     * Login to TR application
	 * 
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config)
	{   eLib = new ExcelLIb();
		logger = ExtLogger.getLogger(sampleTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
		jobApplicantsPage=PageFactory.initElements(driver, JobApplicants.class);
	 }
	
  @Test
  public void createJob() throws InvalidFormatException, IOException, InterruptedException
      {
	    logger.testStepLog("Step 1: get test data from excel");
	    String jobTitle= eLib.getExcelData("Jobs", "TC_01", "JobTitle");
	    String recruiterName= eLib.getExcelData("Jobs", "TC_01", "RecruiterName");
	    String accountName= eLib.getExcelData("Jobs", "TC_01", "AccountName");
	    String hiringManager= eLib.getExcelData("Jobs", "TC_01", "Hiring Manager");
	    String Keywords= eLib.getExcelData("Jobs", "TC_01", "Keywords");
	    
		logger.testStepLog("Step 2: create a new  Job");
		jobPage = alltabsPage.navigateToJobsPage();
		jobPage.createJobWithAllData(jobTitle,recruiterName,hiringManager,accountName,Keywords);
		WebElement candidateSearchLink=jobPage.getCandidateSearchLink();
		while (count < 3) {
			try {
				candidateSearchLink.isDisplayed();
				flag = true;
				break;
			} catch (Exception E) {
				Driver.driver.navigate().refresh();
				Thread.sleep(5000);
				count++;
			}
		}
		
		if (flag) 
		{
			logger.testStepLog("job is successfully created with a candaidate link====>"
					+ candidateSearchLink.getText() + "");
		} else 
		{
			Assert.fail();
		}
	}
	/*
	 * Logout From the Application
	 */
	@AfterClass
	public void configAfterclass(){
		init.logout();
		init.quitBrowser();
	}
}
