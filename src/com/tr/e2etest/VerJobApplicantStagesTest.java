package com.tr.e2etest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Common;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.CandiateSearch;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.sampleTest;
import com.tr.workflowlib.InitializationClass;
/**
 * Test script is used to create  job and verifying the different stages of job applicants
 * 
 */

public class VerJobApplicantStagesTest {

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
	CandiateSearch candidatesearchPage;
	Common common;
    JobApplicants jobApplicantsPage;
    
    /**
     * Login to TR application
	 * 
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config)
	{
		logger = ExtLogger.getLogger(sampleTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		eLib = new ExcelLIb();
		jobApplicantsPage=PageFactory.initElements(driver, JobApplicants.class);
	 }
      @Test
      public void verJobApplicantStagesTest() throws InvalidFormatException, IOException, InterruptedException 
      { 
	    logger.testStepLog("Step 1: get test data from excel");
		
		String jobTitle= eLib.getExcelData("Data", "TC_04", "JobTittle");
		String keywords=eLib.getExcelData("Data", "TC_04", "Keywords");
		String folderName=eLib.getExcelData("Data", "TC_04", "FolderName");
		String JobappStage=eLib.getExcelData("Data", "TC_04", "JobApplicantStage");
		String JobappType=eLib.getExcelData("Data", "TC_04", "JobApplicantType");
		String recipent=eLib.getExcelData("Data", "TC_04", "RecipentName");
		
		
		logger.testStepLog("Step 2: create a new  Job");
		jobPage = alltabsPage.navigateToJobsPage();
		jobPage.createJob(jobTitle, keywords);
		
		logger.testStepLog("Step 3: create Jobapplicant By selecting a Candidate");
		jobPage.createJobappFromJob();
		jobApplicantsPage=alltabsPage.navigateToJobApplicantsPage();
		jobApplicantsPage.getSelFirstJobappRec().click();
		
		logger.testStepLog("Step 4: Submit a candidate to job");
		jobApplicantsPage.submitCandidate(folderName,recipent);
		jobApplicantsPage.verJobAppStages(JobappStage, JobappType);

      }
      
      @AfterClass
		public void configAfterclass()
		{
			init.logout();
			init.quitBrowser();
		}
}
