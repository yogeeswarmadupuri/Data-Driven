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
import com.tr.pageLib.HomePage;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class implements to Add resume from the  existing candidate
 *
 *  @author dileep 
 *
 */
public class AddResumeFromCandidateTest {
	/**
	 * Object initialization
	 * 
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
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
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
	 }
    @Test
    public void addResumeFromCandidate() throws InvalidFormatException, IOException {
      
      logger.testStepLog("Step 1: get test data from excel");	
	  String contactName= eLib.getExcelData("Data", "TC_06", "Candidate Name");
	  String filePath= eLib.getExcelData("Data", "TC_06", "File Path");
	  String fileName= eLib.getExcelData("Data", "TC_06", "File Name");
	  
	  logger.testStepLog("Step 2: Naviagate to candidate page");	
	  candidatesPage= alltabsPage.navigateToCandidatesPage();
	  
	  logger.testStepLog("Step 3: Select a particular candidate from the candidate list");
	  candidatesPage.selectCandidateNameInList(contactName);
	  
	  logger.testStepLog("Step 4: add resume to the candidate");
	  candidatesPage.addResumeFromCandidate(filePath);
	  
	  logger.testStepLog("Step 5: verify whether resume is succefully added or not");
	  candidatesPage.verifyAttachedResume(fileName);
     }
  
     @AfterClass
	 public void configAfterclass()
	 {
		init.logout();
		init.quitBrowser();
	 }
}
