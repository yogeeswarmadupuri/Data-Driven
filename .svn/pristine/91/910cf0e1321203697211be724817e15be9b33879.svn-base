package com.tr.jobapplicants;

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
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;

public class CloneJobApplForDiffJobTest {
	
	/**
	 * Object initialization Steps to create scripts
     */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	JobApplicants jobapplicantPage;
	
	
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		/**
		 * Login and navigate to all tabs page
		 */
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
	}
  @Test
  public void cloneJobApplForDiffJob() throws InvalidFormatException, IOException
  { logger.testStepLog("Step 1: get test data from excel");
  String jobApplicantID = eLib.getExcelData("JobApplicants", "TC_03", "JobApplicantID");
  String expValidErrorMsg = eLib.getExcelData("JobApplicants", "TC_03", "Validation error message");
  String jobID = eLib.getExcelData("JobApplicants", "TC_03", "JobId");
  
  logger.testStepLog("Step 2:Navigate to job applicant page");
  jobapplicantPage=alltabsPage.navigateToJobApplicantsPage();
  
  logger.testStepLog("Step 3: Select any job applicant record from the List");
  jobapplicantPage.selectJobapplicantRecord(jobApplicantID);
  
  logger.testStepLog("Step 4: clone a jobapplicant record and select d/f job to create job applicant");
  jobapplicantPage.cloneJobAppForDiffJob(expValidErrorMsg,jobID);
  
  logger.testStepLog("Step 5: job applicant is succefully created");

  }
  
  /**
   * Logout from the application
   */
  @AfterClass
	public void configAfterclass()
	{
		init.logout();
		init.quitBrowser();
	}
}
