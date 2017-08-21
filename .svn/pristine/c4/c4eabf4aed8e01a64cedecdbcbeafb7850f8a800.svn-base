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
import com.tr.pageLib.EtcObectsPage;
import com.tr.pageLib.HomePage;
import com.tr.pageLib.SetupPage;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;

/**
 * .TR_Eend2EndTest scripts
 *  class implements to create candidate through  ETC
 *
 *  @author dileep 
 *
 */

public class CreateEtcCandidateTest {
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
	SetupPage setupPage;
	XmlTest config;
	EtcObectsPage etcObjPage;
	@BeforeClass
	public AllTabs configBeforeClass(XmlTest config){
		/**
		 * 
		 * Login and navigate to all tabs page
		 */
		this.config=config;
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init=new InitializationClass();
		eLib = new ExcelLIb();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		return alltabsPage;
	}

 
  @Test
  public void createEtcCandidate() throws InterruptedException, InvalidFormatException, IOException {
	  
	  logger.testStepLog("Step 1: get test data from excel");	
	  eLib = new ExcelLIb();
	  String url=  eLib.getExcelData("Data", "TC_03", "URL");
	  String userName=  eLib.getExcelData("Data", "TC_03", "UserName");
	  String password=  eLib.getExcelData("Data", "TC_03", "password");
	  String searchableLinkName=  eLib.getExcelData("Data", "TC_03", "SearchableName");
	  String subject=  eLib.getExcelData("Data",  "TC_03", "Subject");
	  CreateEtcCandidateTest c=new CreateEtcCandidateTest();
	  
	  logger.testStepLog("Step 2: Navigate to Setup page");	
	  setupPage=alltabsPage.navigateTosetUpPage();
	  
	  logger.testStepLog("Step 3: get the Email Addresses from the ETC Page");	
	  String emailAddress= setupPage.getEmailAdress(searchableLinkName);
	  
	  logger.testStepLog("Step 3: Navigate to gmail app and send valid resume to Etc adress ");
	  setupPage.createEtcCandidate(url,userName, password, emailAddress, subject);
	  
	  logger.testStepLog("Step 4: Login to Targetrecruit and naviagate to ETC object page ");
	  alltabsPage= c.configBeforeClass(this.config);
	  etcObjPage=alltabsPage.navigateToEtcObectsPage();
	  
	  logger.testStepLog("Step 4: Verify whether that resume is displayed in Etc section ");
      etcObjPage.verEtcDetails();
    
  }
  /**
   * method to logout and quit the browser
   * 
   */
  @AfterClass
	public void configAfterclass()
	{
		init.logout();
		init.quitBrowser();
	}


}
