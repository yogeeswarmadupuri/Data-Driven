package com.tr.jobs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.sampleTest;
import com.tr.workflowlib.InitializationClass;

public class UpdateJobLocationFromHMTest {
	
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
	 }
  @Test
  public void updateJobLocationFromHM() throws InvalidFormatException, IOException 
  {
	    logger.testStepLog("Step 1: get test data from excel");
	    String jobTitle= eLib.getExcelData("Jobs", "TC_07", "JobTitle");
	    String recruiterName= eLib.getExcelData("Jobs", "TC_07", "RecruiterName");
	    String accountName= eLib.getExcelData("Jobs", "TC_07", "AccountName");
	    String hiringManager= eLib.getExcelData("Jobs", "TC_07", "Hiring Manager");
	    String Keywords= eLib.getExcelData("Jobs", "TC_07", "Keywords");
	    
	    logger.testStepLog("Step 2: Creating a job with valid data");
	    jobPage = alltabsPage.navigateToJobsPage();
	    jobPage.createJobWithAllData(jobTitle, recruiterName, hiringManager, accountName, Keywords);
	    
	    logger.testStepLog("Step 3: Verify whether Location details properly"
	    		+ " displayed or not once we selected the hiring manager");
	    jobPage.jobLocationDetailVerification();
	    
	    logger.testStepLog("Step 4: All adress information auto populating properly");
	  
  }
  /**
   * Logout From the Application
   */
  @AfterClass
  public void configAfterclass(){
  	init.logout();
  	init.quitBrowser();
  }
}
