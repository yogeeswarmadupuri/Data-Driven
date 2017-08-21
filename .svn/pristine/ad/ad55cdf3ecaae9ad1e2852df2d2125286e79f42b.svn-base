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
import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Contacts;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.workflowlib.InitializationClass;

public class VerifyCandidatesTest {
	
	//object declaration
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Accounts accountPage;
	Jobs jobPage;
	InitializationClass init;
	ExtLogger logger;
	JobApplicants jobapplicantPage;
	
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		// create object intilization
		logger = ExtLogger.getLogger(VerifyCandidatesTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
	
	
	@Test
	public void test(XmlTest config) throws InvalidFormatException, IOException{
		
		logger.testStepLog("Step 1: get test data from excel");
		eLib = new ExcelLIb();
		String accName = eLib.getExcelData("Data", "TC_01", "Account Name");
		String candidateFirstName = eLib.getExcelData("Data", "TC_01", "CandidateFirstName");
		String candidateLastName = eLib.getExcelData("Data", "TC_01", "CandidateLastName");
		String empId = eLib.getExcelData("Data", "TC_01", "EmpId");		
		String jobTitle = eLib.getExcelData("Data", "TC_01", "jobTitle");
		String overallExp = eLib.getExcelData("Data", "TC_01", "OverallExp");
		String salRange = eLib.getExcelData("Data", "TC_01", "salRange");
		String jobBoard = eLib.getExcelData("Data", "TC_01", "jobBoard");
		String jobcity = eLib.getExcelData("Data", "TC_01", "jobCity");
		String canRecEmailID = eLib.getExcelData("Data", "TC_01", "Candidate Recruiter");
	
		
		
		logger.testStepLog("Step 2: create account");
		accountPage = alltabsPage.navigateToAccountsPage();
		accountPage.createAccount(accName);
		
		
		logger.testStepLog("Step 3: create contact");
		Contacts contactPage = alltabsPage.navigateToContactsPage();
		contactPage.createCandidate(candidateFirstName, candidateLastName);
		
		logger.testStepLog("Step 4: create Jobs");
		jobPage = alltabsPage.navigateToJobsPage();
//		jobPage.createJob(empId, jobTitle, overallExp, salRange, jobBoard, jobcity);
		
		
		logger.testStepLog("Step 5: create Jobs Appllicants");
//		jobapplicantPage = alltabsPage.navigateToJobApplicantsPage();
//		jobapplicantPage.createJobAllicant(canRecEmailID, jobTitle);
		
		
		
	}
	
	
	
	
	@Test
	public void test2(){
		System.out.println("test 2");
	}
	
	
	@AfterClass
	public void configAfterclass(){
		init.logout();
		init.quitBrowser();
	}

}
