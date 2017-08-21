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
import com.tr.workflowlib.AccountWorkFlowLib;
import com.tr.workflowlib.ContactWorkflowLib;
import com.tr.workflowlib.InitializationClass;
import com.tr.workflowlib.InterviewWorkFlowLib;
import com.tr.workflowlib.JobApplicant;
import com.tr.workflowlib.JobWorkFlowLib;
import com.tr.workflowlib.PlacementWorkFlowLib;
/**
 * .TR_Eend2EndTest scripts
 *  class implements TR Eend2EndTest scripts, scenario  contains following steps create account ,contact , job, interviews ,jobapplicants  etc
 *
 * @author dileep 
 *
 */
public class EndToEndTest {
	
		/*
		 * Object initialization Steps to create scripts
	     */
		ExcelLIb eLib;
		WebDriver driver;
		AllTabs alltabsPage;
		InitializationClass init;
		ExtLogger logger;
		AccountWorkFlowLib accLib;
		ContactWorkflowLib contactLib;
		JobWorkFlowLib jobLib;
		JobApplicant jobapplicant;
		InterviewWorkFlowLib  interviewLib;
		PlacementWorkFlowLib placementWorkflowLib;
		
		@BeforeClass
		public void configBeforeClass(XmlTest config){
			/*
			 * Login and navigate to all tabs page
			 */
			logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
			init = new InitializationClass();
			eLib = new ExcelLIb();
			accLib = new AccountWorkFlowLib();
			contactLib = new ContactWorkflowLib();
			jobLib = new JobWorkFlowLib();
			jobapplicant=new JobApplicant();
			interviewLib=new InterviewWorkFlowLib();
			placementWorkflowLib=new PlacementWorkFlowLib();
			alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
			
		}
			
		
		 /*
		  *  Test script to create an account
		  */
		 
		@Test(priority=1)
		public void createAccount(XmlTest config) throws InvalidFormatException, IOException, InterruptedException
		{
		    logger.testStepLog("get test data from excel");	
			String accName = eLib.getExcelData("Data", "TC_01", "Account Name");
			System.out.println(accName);
			logger.testStepLog("Step 1: create account");
			accLib.createAccount(alltabsPage, accName);
		}
		
		
		/*
		 *  Test script to create contact 
		 */
		 
		@Test(priority=2)
		public void createContact() throws InvalidFormatException, IOException
		{
			 logger.testStepLog("get test data from excel");	
			 String firstName = eLib.getExcelData("Data", "TC_02", "ContactName");
			 String lastName = eLib.getExcelData("Data", "TC_02", "lastName");
			 
			 logger.testStepLog("Step 2: create contact");
			 contactLib.createContact(alltabsPage, firstName,lastName);
		}
		
		  
		 /*
		  *  Test script to create an Job
		  */
		  
		 
		@Test(priority=4)
		public void createJob() throws InvalidFormatException, IOException
		{
			 logger.testStepLog("get test data from excel");	
		     String jobTitle = eLib.getExcelData("Data", "TC_04", "JobName");
			 logger.testStepLog("Step 4: create Job");
		     jobLib.createJob(alltabsPage, jobTitle);		
		}
		
		
		  
		  /*
		   * Test script to create create job applicant
		   */
		 
		 	
		@Test(priority=5)
    	public void createJobApplicants() throws InvalidFormatException, IOException, InterruptedException
		{
			 logger.testStepLog("get test data from excel");	
			 String accName = eLib.getExcelData("Data", "TC_05", "AccountName");
			 String jobId = eLib.getExcelData("Data", "TC_05", "jobId");
			 
			 logger.testStepLog("Step 5: create Job Applicants");
			 jobapplicant.createJobapplicant(alltabsPage, accName,jobId);		
		}
		
		
	  /*
	   * 	  Test script to create Interview
	   */
	
		@Test(priority=6)
		public void createInterview() throws InvalidFormatException, IOException
		{
			 logger.testStepLog("get test data from excel");	
		     String typeOfInterview=eLib.getExcelData("Data", "TC_06", "TypeOfInterview");
		     logger.testStepLog("Step 6: create interview");
			 interviewLib.createInterview(alltabsPage, typeOfInterview);		
		}
		
		  
		 /*
		  * Test script to convert to placement
		  */
		 
		@Test(priority=7)
		public void createCovertToPlacement() throws InvalidFormatException, IOException
		{	
		     logger.testStepLog("Step 7: convert to placement");
		     placementWorkflowLib.convertToPlacement(alltabsPage);
		}
		

		@AfterClass
		public void configAfterclass()
		{
			init.logout();
			init.quitBrowser();
		}

	}
