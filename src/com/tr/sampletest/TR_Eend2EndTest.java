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
public class TR_Eend2EndTest {
	
	/*
	 * Object initialization To create an account
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
		
	
	@Test
	public void createwAccount(XmlTest config) throws InvalidFormatException, IOException, InterruptedException{
		
	    logger.testStepLog("Step 1: get test data from excel");	
		String accName = eLib.getExcelData("Data", "TC_03", "Account Name");
	    String contactName = eLib.getExcelData("Data", "TC_03", "Contact Name");
	    String contactType = eLib.getExcelData("Data", "TC_03", "ContactType");
	    
		String candidateName = eLib.getExcelData("Data", "TC_03", "CandidateName");
     	String jobTitle = eLib.getExcelData("Data", "TC_03", "JobTitle");
        String typeOfInterview=eLib.getExcelData("Data", "TC_03", "IntType");
        String lastName=eLib.getExcelData("Data", "TC_03", "CandiateLastName");
        String jobID=eLib.getExcelData("Data", "TC_03", "jobIDs");
        
		logger.testStepLog("Step 2: create account");
		accLib.createAccount(alltabsPage, accName);
			
	    logger.testStepLog("Step 3: create contact");
		contactLib.createContact(alltabsPage, contactName,contactName);
		
		logger.testStepLog("Step 4: create candidate");
		contactLib.createCandidate(alltabsPage, candidateName ,lastName,accName,contactType);
		
		logger.testStepLog("Step 5: create Job");
		jobLib.createJob(alltabsPage, jobTitle);
			
		logger.testStepLog("Step 6: create Job Applicants");
		jobapplicant.createJobapplicant(alltabsPage, accName,jobID);
		
	    logger.testStepLog("Step 7: create interview");
		interviewLib.createInterview(alltabsPage, typeOfInterview);
        
        logger.testStepLog("Step 8: convert to placement");
        placementWorkflowLib.convertToPlacement(alltabsPage);
	
		
	}
	
	
	@AfterClass
	public void configAfterclass(){
		init.logout();
		init.quitBrowser();
	}

	

}
