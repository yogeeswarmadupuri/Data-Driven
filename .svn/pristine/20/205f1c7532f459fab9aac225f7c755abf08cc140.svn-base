package com.tr.pageLib;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.trbuisneslib.HandlingPopUps;


/**
 * JobApplicants Page Libraries.
 * class provide webdriver JobApplicants Page libraries , which can be used to create JobApplicants  etc
 *
 * @author Deepak HR
 *
 */
public class JobApplicants {
	
	
	
	public WebDriver driver;
	public Common common;
	public static String joidID;
    public HandlingPopUps hp;
	
	
	public JobApplicants(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
		this.hp=new HandlingPopUps(driver);
	}

	
	String selRecipents="//select[contains(@name,'Recipients')]";
	String selectFolder="//th[label[contains(text(),'Folder')]]/following-sibling::td/select";
	String selectTemplate="//th[label[contains(text(),'Template')]]/following-sibling::td/select";
	String selContactFromMultiSelectBox="//select[contains(@name,'userOptions')]";
	String expwindow="Search ~ salesforce.com - Developer Edition";
	
	@FindBy(xpath="//input[@name='new']")
	private WebElement newButton;
	
	@FindBy(xpath="//td[span[label[contains(text(),'Candidate Recruiter Email')]]]/following-sibling::td[1]/input")
	private WebElement candidateRecruiterEdt;
	
	@FindBy(xpath="//td[@class='labelCol requiredInput'][label[contains(text(),'Job')]]/following-sibling::td[1]/div/input[1]")
	private WebElement jobEdt;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[label[text()='Job']]/following-sibling::td/div/span/a/img")
	private WebElement jobLookUpBtn;
	
	@FindBy(xpath="//td[label[text()='Candidate']]/following-sibling::td/div/span/a/img")
	private WebElement candiateLookUpBtn;
	
	@FindBy(xpath="//frame[@name='resultsFrame']")
	private WebElement ResultFrame;
	
	@FindBy(xpath="//tr[th[a[text()='Job Num']]]/following-sibling::tr[2]/th/a")
	private WebElement selectJobId;
	
	@FindBy(xpath="//tr[th[text()='Name']]/following-sibling::tr[1]/th/a")
	private WebElement selectCandiateName;
	
	@FindBy(xpath="//tr[th[text()='Job Applicant ID']]/following-sibling::tr[1]/td[1]/a")
	private WebElement selectFirstCandidateName;
	
	@FindBy(xpath="//span[text()='Job Applicants']")
	private WebElement jobApplRelatedListRecord;
	
	@FindBy(xpath="//tr[th[text()='Job Applicant ID']]/following-sibling::tr[1]/th/a")
	private WebElement selFirstJobappRec;
	
	@FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@value='Submit Candidate']")
	private WebElement submitCandidateBtn;
	
	@FindBy(xpath="//div[1][div[a[img[@alt='->']]]]/div/a/img[@alt='->']")
	private WebElement firstRtArrowBtn;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']/descendant::input[@value='Send']")
    private WebElement sendBtn;
	
	@FindBy(xpath="//td[text()='Stage']/following-sibling::td[1]/div")
	private WebElement jobapplicantStage;
	
	@FindBy(xpath="//td[text()='Type']/following-sibling::td[1]/div")
    private WebElement jobApplicantType;
	
	@FindBy(xpath="//frame[@id='searchFrame']")
	private WebElement searchFrame;
	
	@FindBy(xpath="//input[@name='lksrch']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@name='go']")
	private WebElement goBtn;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	private WebElement pageDescription;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='clone']")
	private WebElement cloneBtn;
	
	@FindBy(xpath="//div[@id='errorDiv_ep']")
	private WebElement actValidErrorMsg;
	
	/**
	 * 
	 *  Method to select First Job applicant From the List
	 */
	
	public WebElement getSelFirstJobappRec()
	{
		return selFirstJobappRec;
	}
	
	public void selectJobapplicantRecord(String jobApplicantID)
	{
		common.selectLink(jobApplicantID).click();
		common.waitForPageToLoad();
	}
	/**
	 * 
	 * This method is use to create job applicant
	 */
	public String createJobAplicant(String jobId,String candidateName) throws InterruptedException{
		newButton.click();
		common.waitForPageToLoad();
		hp.lookUpPopupHandling(jobLookUpBtn, expwindow, searchFrame, searchEdt, jobId, goBtn, ResultFrame, jobId);
		hp.lookUpPopupHandling(candiateLookUpBtn, expwindow, searchFrame, searchEdt,
				candidateName, goBtn, ResultFrame, candidateName);
		saveBtn.click();
		common.waitForWebElementPresent(pageDescription);
		return pageDescription.getText().trim();
	}
	
	/**
	 * This method to select a candidate from lookup button and 
	 * to create a job applicant for a selected job
	 * @param candidateName
	 */
	public void selectCandidate(String candidateName)
	{
		hp.lookUpPopupHandling(candiateLookUpBtn, expwindow, searchFrame, searchEdt,
				candidateName, goBtn, ResultFrame, candidateName);
		
		saveBtn.click();
		common.waitForWebElementPresent(pageDescription);
		Assert.assertTrue(pageDescription.isDisplayed(), "jobapplicant creation failed");
	}
	/**
	 * This method is use to create interview through job applicant page
	 * @param typeOfInterview
	 */
	public void createInterviewthroughJobapplicantPage(String typeOfInterview){
		Interviews interviewPage = PageFactory.initElements(driver, Interviews.class);
		interviewPage.createInterview(typeOfInterview);
	}
	/**
	 * This method is use to create interview From the ScheduleInterview Button
	 * @param typeOfInterview
	 */
	public void scheduleInterviewthroughJobapplicantPage(String typeOfInterview){
		Interviews interviewPage = PageFactory.initElements(driver, Interviews.class);
        interviewPage.scheduleInterview(typeOfInterview);
	
		
	}
	/**
	 * 
	 * This method is use to convert to placement through job applicant page
	 */
	public void convertToPlacement(){
		Placements placementPage=PageFactory.initElements(driver, Placements.class);
		placementPage.convertToPlacement();
	}
	public void verifyjobapplicantRecord(String jobTitle){
		String xpath="//td[text()='"+jobTitle+"']";
		selectFirstCandidateName.click();
		jobApplRelatedListRecord.click();
		common.isElementPresentByXPath(xpath);	
	}
	/**
	 * Method to submit a candidate to the specific Job
	 * @param folderName
	 */
	public void submitCandidate(String folderName,String recipent){
		submitCandidateBtn.click();
		common.waitForWbXpath(selRecipents);
		common.select(selRecipents, recipent);
		common.select(selContactFromMultiSelectBox, 0);
		firstRtArrowBtn.click();
		common.select(selectFolder, folderName);
		common.select(selectTemplate, 1);
		common.waitForPageToLoad();
		sendBtn.click();	
	}
	
	/**
	 * Method to Verify the job applicant stages against expected result
	 * @param expJobappStage
	 * @return
	 */
	public void verJobAppStages(String expJobappStage,String expJobApplicantType){
		String actJobApplicantType=jobApplicantType.getText();
		String actJobappStage=jobapplicantStage.getText();
		System.out.println(actJobappStage+""+ expJobappStage);
		System.out.println(actJobApplicantType+""+ expJobApplicantType);
		Assert.assertEquals(actJobappStage, expJobappStage, "jobapplicants stages are mismatching ");
		Assert.assertEquals(actJobApplicantType, expJobApplicantType, "jobapplicants Types are mismatching");
	}
	
	/**
	 * Method to clone job applicant
	 * @param expErrorMessage
	 */
	public void cloneJobApplicant(String expErrorMessage)
	{
	cloneBtn.click();
	saveBtn.click();
	String actErrorMessage=	actValidErrorMsg.getText();
	Assert.assertTrue(actErrorMessage.contains(expErrorMessage), "valid error message not displayed");
	}
	
	/**
	 * method to clone job applicant for d/f job
	 * @param expErrorMessage
	 * @param jobId
	 */
	public void cloneJobAppForDiffJob(String expErrorMessage,String jobId)
	{
		cloneJobApplicant(expErrorMessage);
		hp.lookUpPopupHandling(jobLookUpBtn, expwindow, searchFrame, searchEdt, jobId, goBtn, ResultFrame, jobId);
		saveBtn.click();
		Assert.assertTrue(pageDescription.isDisplayed(), "fail to clone for diff job");
	}
}
