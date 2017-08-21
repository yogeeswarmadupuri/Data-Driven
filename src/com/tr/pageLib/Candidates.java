package com.tr.pageLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.VerifyMappingValueTest;

/**
 * Candidate Page Libraries.
 * class provide webdriver contact Page libraries , which can be used to create Candidate,Candidate contact  etc
 *
 * @author Deepak HR
 *
 */
public class Candidates {	
		public WebDriver driver;
		public Common common;
		public ExtLogger logger = ExtLogger.getLogger(VerifyMappingValueTest.class);
		/*public static String currentWindow;*/
		
		public Candidates(WebDriver driver){
		this.driver = driver;
	    this.common = new Common(driver);
			
		}
		
		
		
		@FindBy(xpath="//td[text()='Contact Record Type']/following-sibling::td/div")
		private WebElement candidateRecordType;
		
        @FindBy(xpath="//td[text()='Title']/following-sibling::td/div[text()='Analyst']")
	     private WebElement candidateTitle;
        
        @FindBy(xpath="//td[text()='Email']/following-sibling::td/div/a")
        private WebElement candidateEmailID;
        
        @FindBy(xpath="//td[text()='Mailing Address']/following-sibling::td[1]/div")
        private WebElement candidateMailingAddress;
        
        @FindBy(xpath="//td[span[text()='Work Details']]/following-sibling::td[1]/div")
        private WebElement candidateWorkDetails;
        
        @FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@value='Add Resume']")
        private WebElement addTopResumeBtn;
        
        @FindBy(xpath="//p[contains(text(),'Select Resume')]/input")
        private WebElement browseBtn;
        
        @FindBy(xpath="//input[@value='Add Resume']")
        private WebElement addResumeBtn;
        
        @FindBy(xpath="//input[@value='Close']")
        private WebElement closeBtn;
        
        @FindBy(xpath="//div[@class='messageText']")
        private WebElement msgText;
        
        @FindBy(xpath="//span[text()='Notes & Attachments']")
        private WebElement notesAndAttacLink;
        public void verCandidateDetails(){
        	String candidateRecordValue=candidateRecordType.getText();
        	//String candidateTitleValue=candidateTitle.getText();
        	String candidateEmailIDValue=candidateEmailID.getText();
        	String candidateMailingAddressValue=candidateMailingAddress.getText();
        	String candidateWorkDetailsValue=candidateWorkDetails.getText();
        	
        	logger.info("candidateRecord====================="+candidateRecordValue);
        	//logger.info("candidateTitle======================"+candidateTitleValue);
        	logger.info("candidateEmailID===================="+candidateEmailIDValue);
        	logger.info("candidateMailingAddress============="+candidateMailingAddressValue);
        	logger.info("candidateWorkDetailsValue==========="+candidateWorkDetailsValue);
        }
        /**
         * method to select a candidate from the Candidate lis
         * @param contactName
         */
        public void selectCandidateNameInList(String contactName){
    		WebElement contactLink=common.selectLink(contactName);
    		contactLink.click();
    		common.waitForPageToLoad();
    	} 
        
        /**
         * method to add resume for a candidate
         * @param filePath
         */ 
		public void addResumeFromCandidate(String filePath){
			addTopResumeBtn.click();
			String childwindowID = common.expectedWindow("salesforce.com - Developer Edition");
			driver.switchTo().window(childwindowID);
			browseBtn.sendKeys(filePath);
			common.waitForWebElementPresent(addResumeBtn);
			addResumeBtn.click();
			common.waitForWebElementPresent(msgText);
			Assert.assertTrue(msgText.isDisplayed(), "Resume is not uploaded");
			closeBtn.click();
			driver.switchTo().window(common.currentWindow);
		}
		/**
		 * method to verify whether resume is added to candidate or not
		 * @param fileName
		 */
		public void verifyAttachedResume(String fileName){
		
			for(int i=0;i<5;i++)
			{
			common.waitForPageToLoad();
			common.refreshPage();
			}
			notesAndAttacLink.click();
			WebElement element=common.selectpartialLink(fileName);
			Assert.assertTrue(element.isDisplayed(), "Resume Not available in Notes and attachment section");
		    common.isElementPresentByXPath("//td[text()='"+fileName+"']");
		    WebElement status= common.getWebElement("//td[text()='"+fileName+"']/following-sibling::td[2]");
		    logger.info("Etc object Status========="+status.getText());
		}


        

}
