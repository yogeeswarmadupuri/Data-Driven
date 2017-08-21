package com.tr.jobs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class CloneJobTest
  {
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
    int count;
    boolean flag;
    
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
   public void cloneAJob() throws InvalidFormatException, IOException, InterruptedException
   { 
	  logger.testStepLog("Step 1: get test data from excel");
	  String jobID= eLib.getExcelData("Jobs", "TC_02", "JobId");
	  String jobTitle= eLib.getExcelData("Jobs", "TC_02", "JobTitle");
	  String keywords= eLib.getExcelData("Jobs", "TC_02", "Keywords");
	  
	  jobPage = alltabsPage.navigateToJobsPage();
	  
	  logger.testStepLog("Step 2: clone an exisisting job");
	  jobPage.cloneJob(jobID, jobTitle, keywords);
	  
	  logger.testStepLog("Step 3: verify wheather CandidtaeSearchlink is displayed or not"
	  		           + "Step 4: verify wheather CandidatesList is displayed or not");
	   
	  WebElement candidateSearchLink=jobPage.getCandidateSearchLink();
		while (count < 3) {
			try {
				candidateSearchLink.isDisplayed();
				Assert.assertTrue(candidateSearchLink.getText().contains(jobTitle), "candidate search link not properly created wrt expected jobtitle");
				Assert.assertTrue(jobPage.getCandidateListFrame().isDisplayed(), "candidate list region not displayed");
				flag = true;
				break;
			    }  
		    catch (Exception E) 
		   {
				Driver.driver.navigate().refresh();
				Thread.sleep(5000);
				count++;
			}
	    	}
		
		if (flag) 
		{
			logger.info("job is successfully created with a candaidate link====>"
					+ candidateSearchLink.getText() + "");
			logger.testStepLog("Step 4: Job record created succefully thriugh clone button");
		} else 
		{
			Assert.fail();
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
