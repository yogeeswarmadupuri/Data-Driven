package com.tr.e2etest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Contacts;
import com.tr.pageLib.Interviews;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;


public class AcccToPlacementTest  {
	/**
	 * Object initialization To create an account
	 * 
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Accounts accountPage;
	Contacts contactPage;
	Jobs jobsPage;
	JobApplicants jobApplicantpage;
	Interviews interviewPage;
	
	/**
	 * Login and navigate to all tabs page
	 * 
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		contactPage = new Contacts(driver);
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
		
    @Test
    public void accToPlacement() throws InvalidFormatException, IOException {
	  
	  
	    logger.testStepLog("Step 1: get test data from excel");	
	    
		String accName = eLib.getExcelData("Data", "TC_01", "Account Name");
	    String contactName = eLib.getExcelData("Data", "TC_01", "ContactName");
   	    String jobTitle = eLib.getExcelData("Data", "TC_01", "JobName");
        String typeOfInterview=eLib.getExcelData("Data", "TC_01", "TypeOfInterview");
        
        logger.testStepLog("Step 2: create account");
        accountPage=alltabsPage.navigateToAccountsPage();
        accountPage.createAccount(accName);
        
        logger.testStepLog("Step 3: create contact From Account");
        contactPage=accountPage.selContactLink();
		contactPage.createContactFromAcc(contactName,accName);
		
		logger.testStepLog("Step 4: create job From contact");
		jobsPage=contactPage.selectJob(accName);
		jobsPage.createJobFromContact(jobTitle);
		
		logger.testStepLog("Step 5: create jobapplicant  From job");
		jobApplicantpage=jobsPage.creatJobApplicantFromJob();
		jobApplicantpage.selectCandidate(contactName);
		
		logger.testStepLog("Step 6: Schedule Interview");
	    jobApplicantpage.scheduleInterviewthroughJobapplicantPage(typeOfInterview);
		
		
		logger.testStepLog("Step 6: Convert To Placement");
		jobApplicantpage.convertToPlacement();
		
  }
  

	@AfterClass
	public void configAfterclass()
	{
		init.logout();
		init.quitBrowser();
	}
}
