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

public class CloneWithQuestionsTest {

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
  public void cloneWithQuestions() throws InvalidFormatException, IOException, InterruptedException
  {
	  logger.testStepLog("Step 1: get test data from excel");
	  String jobID1= eLib.getExcelData("Jobs", "TC_06", "JobId1");
	  
	  logger.testStepLog("Step 2: Select a job record from the Job List");
	  jobPage = alltabsPage.navigateToJobsPage();
	  jobPage.selectJob(jobID1);
	  
	  logger.testStepLog("Step 3: clone the job with Questions");
	  jobPage.CloneWithQuestions();
	  
	  logger.testStepLog("Step 4: clone the job with Questions succefully done");
	  
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
