package com.tr.accounts;

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

public class Create_Account_Contact_JobTest
{
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
  public void createAccount() throws InvalidFormatException, IOException 
  {
	  logger.testStepLog("Step 1: get test data from excel");	    
	  String accName = eLib.getExcelData("Account", "TC_03", "AccountName");
 	
    System.out.println(accName);
      
	  logger.testStepLog("Step 2: create account");
      accountPage=alltabsPage.navigateToAccountsPage();
      accountPage.createAccount(accName);    
  }
 @Test
 public void createContact() throws InvalidFormatException, IOException{
	 String accountName = eLib.getExcelData("Account", "TC_04", "Account Name");
	 String firstName = eLib.getExcelData("Account", "TC_04", "FirstName");
	 String contactName = eLib.getExcelData("Account", "TC_04", "ContactName");
	 String contactType = eLib.getExcelData("Account", "TC_04", "ContactType");
	 
	 contactPage= alltabsPage.navigateToContactsPage();
	 contactPage.createCandidate(firstName, contactName, accountName, contactType);
 }
 
 @Test
 public void createJob() throws InvalidFormatException, IOException
 {
	  String jobTitle = eLib.getExcelData("Account", "TC_05", "JobName");
	  String accountName = eLib.getExcelData("Account", "TC_05", "AccountName");
	  String recruiterName = eLib.getExcelData("Account", "TC_05", "RecruiterName");
	  String hrName = eLib.getExcelData("Account", "TC_05", "HiringManager");
	  String skillset = eLib.getExcelData("Account", "TC_05", "Keywords");
	  
	  jobsPage=alltabsPage.navigateToJobsPage();
	  logger.testStepLog("Step 4: create job From contact");
	  jobsPage.createJobWithAllData(jobTitle, recruiterName, hrName, accountName, skillset);
		
 }
    @AfterClass
	 public void configAfterclass()
    {
		init.logout();
		init.quitBrowser();
	}
}
