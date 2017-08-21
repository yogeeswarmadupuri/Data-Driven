package com.tr.sampletest;

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
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class provide TR_Eend2EndTest scripts, which can be used to create candidate Search .
 *
 * @author Dileep HE
 *
 */
public class CreateCandiateSearchTest {
	/*
	 * object Initialization
	 */
		ExcelLIb eLib;
		WebDriver driver;
		AllTabs alltabsPage;
		CandiateSearch candiateSearchPage;
		InitializationClass init;
		ExtLogger logger;
		
		
		/*
		 * Login to TR application
		 */
		@BeforeClass
		public void configBeforeClass(XmlTest config){

			logger = ExtLogger.getLogger(CreateCandiateSearchTest.class);
			init = new InitializationClass();
		    alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
		}
		
		
		@Test
		public void createCandiateSearch(XmlTest config) throws InvalidFormatException, IOException{
			
			logger.testStepLog("Step 1: get test data from excel");
			eLib = new ExcelLIb();
			String searchKeyword = eLib.getExcelData("Data", "TC_08", "SearchName");
			String jobSearchName = eLib.getExcelData("Data", "TC_08", "JobSearchName");
	
			System.out.println(searchKeyword);
			logger.testStepLog("Step 2: create candiate Search");
			candiateSearchPage = alltabsPage.navigateToCandiateSearchPage();
			candiateSearchPage.createSearch(searchKeyword,jobSearchName);
			
     }
		/*
		 * Logout From the Application
		 */
		@AfterClass
		public void configAfterclass(){
			init.logout();
			//init.quitBrowser();
		}
}
