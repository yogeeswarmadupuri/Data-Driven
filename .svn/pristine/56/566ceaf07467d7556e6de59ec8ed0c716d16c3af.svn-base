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
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Candidates;
import com.tr.pageLib.Contacts;
import com.tr.pageLib.HomePage;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class implements to clone the candidates details
 *
 *  @author dileep 
 *
 */
   public class CloneCandidateTest {
	/**
	 * Object initialization
	 * 
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Contacts contactPage;
	HomePage homepage;
	Candidates candidatesPage;
	
	@BeforeClass
	public void configBeforeClass(XmlTest config)
	{
		/**
		 * Login and navigate to all tabs page
		 * 
		 */
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		contactPage = new Contacts(driver);
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
	 }
	
    @Test
    public void cloneCandidate() throws InvalidFormatException, IOException {
	  logger.testStepLog("Step 1: get test data from excel");	
	  String contactName= eLib.getExcelData("Data", "TC_05", "Candidate Name");
	  String candFirstName= eLib.getExcelData("Data", "TC_05", "CandaidateFirstName");
	  String candLastName= eLib.getExcelData("Data", "TC_05", "CandidateLastName");
	 
	  logger.testStepLog("Step 2: Navigate to contact page");	
	  contactPage= alltabsPage.navigateToContactsPage();
	  
	  logger.testStepLog("Step 3: Select a candidate and clone it");	
	  contactPage.cloneCandidate(contactName, candFirstName, candLastName);
	  
	  logger.testStepLog("Step 4: Verify the cloned candidate details");	
	   homepage=contactPage.verifyCandDetails();
	   homepage.getCandidateDetailsFromResume();
	   candidatesPage=homepage.returnToCandidatePage();
	   candidatesPage.verCandidateDetails();
	   
	  
  }
  /**
   * method to logout and quit the browser
   * 
   */
  @AfterClass
	public void configAfterclass()
	{
		init.logout();
		init.quitBrowser();
	}
}
