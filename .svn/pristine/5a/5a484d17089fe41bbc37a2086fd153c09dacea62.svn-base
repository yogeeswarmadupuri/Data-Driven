package com.tr.sampletest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
import com.tr.workflowlib.InitializationClass;

public class sampleTest {
	/*
	 * object Initialization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Jobs jobPage;
	InitializationClass init;
	ExtLogger logger;
	CandiateSearch candidatesearch;
	Common common;
    JobApplicants jobApplicants;
	/*
	 * Login to TR application
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		// create object intilization

		
		logger = ExtLogger.getLogger(sampleTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
	@Test
	public void test(XmlTest config) throws InvalidFormatException, IOException{
		candidatesearch =PageFactory.initElements(driver, CandiateSearch.class);
		jobApplicants   =PageFactory.initElements(driver, JobApplicants.class);
		
		logger.testStepLog("Step 1: get test data from excel");
		eLib = new ExcelLIb();
		String jobTitle= eLib.getExcelData("Data", "TC_13", "JobTittle");
		String keywords=eLib.getExcelData("Data", "TC_13", "Keywords");
		logger.testStepLog("Step 2: create account");
		jobPage = alltabsPage.navigateToJobsPage();
		candidatesearch=jobPage.createJobAndSearchCand(jobTitle);
		candidatesearch.createCandidateSearch(keywords);
		try{
			candidatesearch.getSelectFirstCandidate().click();
		  }
		catch(Throwable T)
		{
			logger.info("candidates are not available for the above skillset");
		 }
		candidatesearch.getJobapplicantBtn().click();
		logger.info("Jobapplicant "+candidatesearch.getJobApplicantcreatedMsg().getText());
		jobApplicants=alltabsPage.navigateToJobApplicantsPage();
		jobApplicants.verifyjobapplicantRecord(jobTitle);
		
}
}







