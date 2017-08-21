package com.tr.jobs;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.CandiateSearch;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.sampleTest;
import com.tr.workflowlib.InitializationClass;

public class CreateCandidateSearchFroJobRecordTest {
	
	/**
	 * 
	 * object intilization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Jobs jobPage;
	InitializationClass init;
	ExtLogger logger;
    CandiateSearch candiateSearchPage;
    
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
  public void createCandidateSearchFroJobRecord() throws InvalidFormatException, IOException 
  {
	    logger.testStepLog("Step 1: get test data from excel");
	    String jobTitle= eLib.getExcelData("Jobs", "TC_08", "JobTitle");
	    String recruiterName= eLib.getExcelData("Jobs", "TC_08", "RecruiterName");
	    String accountName= eLib.getExcelData("Jobs", "TC_08", "AccountName");
	    String hiringManager= eLib.getExcelData("Jobs", "TC_08", "Hiring Manager");
	    String Keywords= eLib.getExcelData("Jobs", "TC_08", "Keywords");
	    String expectedtitle= eLib.getExcelData("Jobs", "TC_08", "Expected Page");
	    
	    
	    logger.testStepLog("Step 2: Create a job with valid details");
	    jobPage = alltabsPage.navigateToJobsPage();
	    jobPage.createJobWithAllData(jobTitle, recruiterName, hiringManager, accountName, Keywords);
	    
	    logger.testStepLog("Step 2: create a candidate search for the created job");
	    candiateSearchPage=jobPage.clickOnSearchCandidatesBtn();
	    
	    logger.testStepLog("Step 3: Verify whether its properly navigated to candidate search page or not");
	    String actualtitle= candiateSearchPage.getpagetitle();
	    Assert.assertEquals(actualtitle, expectedtitle, "its navigated to d/f page");
	   
	    logger.testStepLog("Step 4: get the nor of candidates available for this job");
	    List<WebElement>norOfCandidates= candiateSearchPage.getTotalNorOfCandidadates();
	    
	    if(norOfCandidates.size()>1)
	    {   int count=norOfCandidates.size()-1;
	    	logger.info("Total nor of candidates for the current job ==="+count);
	    }
	    else
	    {
	    	logger.info("Total nor of candidate for the current job==="+norOfCandidates.size());
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
