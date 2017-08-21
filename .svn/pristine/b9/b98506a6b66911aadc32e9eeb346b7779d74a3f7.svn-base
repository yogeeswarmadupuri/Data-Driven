package com.tr.contact;

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
import com.tr.pageLib.Contacts;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class provide TR_Eend2EndTest scripts, which can be used to delete candidate .
 *
 * @author Dileep HE
 *
 */
public class DeleteContactTest {

	/*
	 * object Initialization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Contacts contactPage;
	InitializationClass init;
	ExtLogger logger;
	
	/*
	 * Login to TR application
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		// create object intilization

		
		logger = ExtLogger.getLogger(DeleteContactTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
	
	@Test
	public void test(XmlTest config) throws InvalidFormatException, IOException{
		
		logger.testStepLog("Step 1: get test data from excel");
		eLib = new ExcelLIb();
		String contactName = eLib.getExcelData("Data", "TC_08", "Contact Name");
		logger.testStepLog("Step 2: Delete Candiate");
		contactPage = alltabsPage.navigateToContactsPage();
		contactPage.deleteContact(contactName);
   }
	/*
	 * Logout From the Application
	 */
	@AfterClass
	public void configAfterclass(){
		init.logout();
		init.quitBrowser();
	}

	}
