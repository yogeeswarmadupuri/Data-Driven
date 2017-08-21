package com.tr.jobs;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class CopyToJobTest {
	
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
  public void copyToJob() throws InvalidFormatException, IOException, InterruptedException 
  { 
	  logger.testStepLog("Step 1: get test data from excel");
	  String jobID1= eLib.getExcelData("Jobs", "TC_04", "JobId1");
	  String jobID2= eLib.getExcelData("Jobs", "TC_04", "JobId2");
	  
	  logger.testStepLog("Step 2: Select a job record from the Job List");
	  jobPage = alltabsPage.navigateToJobsPage();
      jobPage.selectJob(jobID1);
      Actions actions = new Actions(Driver.driver);
      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	  
      logger.testStepLog("Step 3: select a jobapplicant and copy to other job");
      int noOfJobapplicants=jobPage.getJobapplicantList().size();
      if(noOfJobapplicants>1)
        {
        jobPage.copyToJob(jobID2);
        logger.testStepLog("Step 4: Copy To Job Successfully Done");
        }
      else
       {
       logger.error("For a selected job there is no job applicants");
       }  
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
