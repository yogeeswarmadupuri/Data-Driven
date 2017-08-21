package com.tr.pageLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.TR_Eend2EndTest;

/**
 * Placements Page Libraries.
 * class provide webdriver Placements Page libraries , which can be used to convert to placement etc
 *
 * @author Dileep HE
 *
 */
public class Placements {
	
	public WebDriver driver;
	public Common common;
	public ExtLogger logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
	
	
	public Placements(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}
	@FindBy(xpath="//a[text()='Job Applicants']")
	private WebElement jobApplicantLink;
	
	@FindBy(xpath="//td[text()='Job Applicant']/following-sibling::td[1]/div/a")
    private WebElement clkOnJobAppRecord;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@value='Convert To Placement']")
	private WebElement clkOnConvertToPlacement;
	@FindBy(xpath="//td[label[text()='Start Date']]/following-sibling::td/div/span/input")
	private WebElement clkOnStartDateBox;
	@FindBy(xpath="//td[text()='26']")
	private WebElement selectDate;
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[text()='Placement ID']/following-sibling::td[1]/div")
	private WebElement placementID; 
	
	@FindBy(xpath="//td[text()='Job Applicant']/following-sibling::td[1]/div/a")
	private WebElement jobAppId;
	
	@FindBy(xpath="//td[text()='Job Num']/following-sibling::td[1]/div/a")
	private WebElement jobID;
	
	@FindBy(xpath="//td[text()='Job Title']/following-sibling::td[1]/div")
	private WebElement jobTittle;
	
	@FindBy(xpath="//td[text()='Candidate']/following-sibling::td[1]/div/a")
	private WebElement candidateName;
	/**
	 * method to convert for placement
	 */
	public void convertToPlacement()
	{   
		common.waitForWebElementPresent(clkOnJobAppRecord);
		/*String jobIDXpath = "//tr[th[text()='Job Applicant ID']]/following-sibling::tr/th/a[text()='"+JobApplicants.joidID+"']";
		driver.findElement(By.xpath(jobIDXpath)).click();*/
		clkOnJobAppRecord.click();
		clkOnConvertToPlacement.click();
		clkOnStartDateBox.click();
		selectDate.click();
		saveBtn.click();
		placementDetails();
	 }
   public void placementDetails()
   {
	logger.info("placementID============"+placementID.getText());
	logger.info("JobApplicantID============"+jobAppId.getText());
	logger.info("JobID============"+jobID.getText());
	logger.info("jobTittle============"+jobTittle.getText());
	logger.info("candidateName============"+candidateName.getText());
   }
}
