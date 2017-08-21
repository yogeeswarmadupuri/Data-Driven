package com.tr.candidatesTest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.tr.accountTest.CreateCandiateSearchTest;
import com.tr.e2etest.AddResumeFromCandidateTest;
import com.tr.genericlib.Common;
import com.tr.genericlib.Driver;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.CandiateSearch;
import com.tr.pageLib.Candidates;
import com.tr.pageLib.Contacts;
import com.tr.pageLib.HomePage;
import com.tr.workflowlib.CandidateWorkFlowLib;
import com.tr.workflowlib.InitializationClass;

public class addResumeTest {
 
	/*
	 * object Initialization
	 */
		ExcelLIb eLib;
		WebDriver driver;
		AllTabs alltabsPage;
		HomePage homePage;
		InitializationClass init;
		ExtLogger logger;
		Candidates candidatePage;
		Common common;
		CandidateWorkFlowLib cLib;
	
	@BeforeClass
		public void configBeforeClass(XmlTest config){

			logger = ExtLogger.getLogger(addResumeTest.class);
			init = new InitializationClass();
		    alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));	
		}
	
	@Test
  public void test() throws IOException, InvalidFormatException {
  
		logger.testStepLog("Step:1");
		eLib = new ExcelLIb();
		
		String filepath = eLib.getExcelData("Candidates", "TC_01", "File Path");
		homePage = alltabsPage.navigateToHomePage();
		cLib.candidate(homePage, filepath);
	}
}
