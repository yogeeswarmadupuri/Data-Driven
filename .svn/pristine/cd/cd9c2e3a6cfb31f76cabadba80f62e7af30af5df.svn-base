package com.tr.contact;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Driver;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Contacts;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.trbuisneslib.HandlingPopUps;
import com.tr.workflowlib.InitializationClass;

public class CreateContactTest {
	
	/*
	 * Object initialization Steps to create scripts
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Contacts contactPage;
	HandlingPopUps popup;

	@BeforeClass
	public void configBeforeClass(XmlTest config) {
		/*
		 * Login and navigate to all tabs page
		 */
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		popup=new HandlingPopUps(Driver.driver);
        alltabsPage = init.loginToSalesForce(config,
				config.getParameter("tr_username"),
				config.getParameter("tr_password"),
				config.getParameter("tr_url"), config.getParameter("browser"));
	}

	@Test
	public void createContact() throws InvalidFormatException, IOException, InterruptedException {

        logger.testStepLog("get test data from excel");
		String firstName = eLib.getExcelData("Contact", "TC_01", "ContactFirstName");
		String lastName = eLib.getExcelData("Contact", "TC_01", "ContactLastName");
		String accName = eLib.getExcelData("Contact", "TC_01", "AccountName");
		String title = eLib.getExcelData("Contact", "TC_01", "Title");
		String contactType = eLib.getExcelData("Contact", "TC_01", "ContactType");
		System.out.println(contactType);
		

	     logger.testStepLog("Step 2: create contact"); 
		 contactPage=alltabsPage.navigateToContactsPage();
		 contactPage.createcontWithAcc(accName, firstName, lastName,title,contactType);
		 contactPage.saveRecord();
	}
	
	@Test
	public void createCandidate() throws InvalidFormatException, IOException{
		
		String firstName = eLib.getExcelData("Contact", "TC_02", "ContactFirstName");
		String lastName = eLib.getExcelData("Contact", "TC_02", "ContactLastName");
		String accName = eLib.getExcelData("Contact", "TC_02", "AccountName");
		String title = eLib.getExcelData("Contact", "TC_02", "Title");
		String contactType = eLib.getExcelData("Contact", "TC_02", "ContactType");
		
		 System.out.println(contactType);
		 logger.testStepLog("Step 2: create contact"); 
		 contactPage=alltabsPage.navigateToContactsPage();
		 contactPage.createcontWithAcc(accName, firstName, lastName,title,contactType);	
		 contactPage.saveRecord();
	}
	@AfterClass
	public void configAfterclass() 
	{
		init.logout();
		init.quitBrowser();
	}
}



