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

public class CreateJobApplicantTest {
	
	
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
  public void createJobApplicant() throws InvalidFormatException, IOException, InterruptedException
  {
	  logger.testStepLog("Step 1: get test data from excel");
	  String candidateName = eLib.getExcelData("JobApplicants", "TC_01", "Candidate Name");
	  String JobID = eLib.getExcelData("JobApplicants", "TC_01", "JobID");
	  String expJobApplicantStage = eLib.getExcelData("JobApplicants", "TC_01", "JobApplicantStage");
	  String expJobapplicantType = eLib.getExcelData("JobApplicants", "TC_01", "JobapplicantType");
	 
	  logger.testStepLog("Step 2:Navigate to job applicant page");
	  jobapplicantPage=alltabsPage.navigateToJobApplicantsPage();
	  
	  logger.testStepLog("Step 3: create a new  Jobapplicant through new tab");
	  String jobapplicantId= jobapplicantPage.createJobAplicant(JobID, candidateName);
	  
	  logger.testStepLog("Step 4: Verify job applicant stage and type once we created");
	  jobapplicantPage.verJobAppStages(expJobApplicantStage, expJobapplicantType);
	  System.out.println(jobapplicantId);
	  
	  logger.testStepLog("Step 5:New Job applicant succefully created and verified");
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
