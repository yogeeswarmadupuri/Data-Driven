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
import com.tr.pageLib.CandiateSearch;
import com.tr.pageLib.HomePage;
import com.tr.sampletest.CreateCandiateSearchTest;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class implements to create a candidate through add resume
 *
 *  @author dileep 
 *
 */
     public class AddResumeTest {
	
	 /**
	  * object Initialization
	  * 
	  */
		ExcelLIb eLib;
		WebDriver driver;
		AllTabs alltabsPage;
		HomePage homePage;
		CandiateSearch candiateSearchPage;
		InitializationClass init;
		ExtLogger logger;
		
	 /**
	  * Login to TR application
	  * 
	  */
		@BeforeClass
		public void configBeforeClass(XmlTest config){
			logger = ExtLogger.getLogger(CreateCandiateSearchTest.class);
			init = new InitializationClass();
	        alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
		    eLib = new ExcelLIb();
		}

        @Test
        public void CreateCandidate(XmlTest config) throws InvalidFormatException, IOException 
        {
	    logger.testStepLog("Step 1: get test data from excel");
	    String filePath=eLib.getExcelData("Data", "TC_02", "FilePath");
	    
	    logger.testStepLog("Step 2: navigate to home page");
	    homePage=alltabsPage.navigateToHomePage();
	    
	    logger.testStepLog("Step 3: Create candidate Through Add resume");
	    homePage.createCandidate(filePath);
	    
	    logger.testCaseLog("Step 4: verify the Candidate details ");
	    homePage.getCandidateDetailsFromResume();
	    }
       
        /** 
	     * Logout from TR application
	     * 
	     */
	    @AfterClass
	    public void configAfterclass()
	    {
		init.logout();
		init.quitBrowser();
	    }
     }
