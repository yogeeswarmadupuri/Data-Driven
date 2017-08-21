package com.tr.pageLib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.genericlib.Driver;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.sampleTest;
import com.tr.trbuisneslib.HandlingPopUps;

/**
 * Jobs Page Libraries.
 * class provide webdriver Jobs Page libraries , which can be used to create Jobs etc
 *
 * @author Deepak HR
 *
 */
public class Jobs {
	public WebDriver driver;
	int count;
	boolean flag;
	public Common common;
	public CandiateSearch candidateSearch ;
	public HandlingPopUps hp;
	public String expWindtitle="Search ~ salesforce.com - Developer Edition";
	public String expWintitle2="Search for a user ~ salesforce.com - Developer Edition";
	public Jobs(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		hp=new HandlingPopUps(driver);
		
	}
	String frameXpathForJapp="//iframe[@id='06690000005MB0I']";
	
	@FindBy(xpath="(//td[label[contains(text(),'Da_Employer ID')]]/following-sibling::td/input)[1]")
	private WebElement daEmplyeID;
	
	@FindBy(xpath="//input[@name='new']")
	private WebElement newButton;
	
	@FindBy(xpath="//td[label[contains(text(),'Broadcasted On')]]/following-sibling::td//a")
	private WebElement dateLnk;
	
	@FindBy(xpath="//td[label[contains(text(),'Overall Experience')]]/following-sibling::td//select")
	private WebElement overExperienceLst;
	
	@FindBy(xpath="//td[label[contains(text(),'Job Title')]]/following-sibling::td[1]//input[@type='text']")
	private WebElement jobTitle;
	
	@FindBy(xpath="(//td[label[contains(text(),'Job Board')]]/following-sibling::td//select)[1]")
	private WebElement jobBoard;
	
	@FindBy(xpath="(//td[label[contains(text(),'Salary Range(year)')]]/following-sibling::td//select)[1]")
	private WebElement salaryRange;
	
	@FindBy(xpath="(//td[label[contains(text(),'Job Board City')]]/following-sibling::td//select)[1]")
	private WebElement jobBoardCity;
	
	@FindBy(xpath="//td[span[label[text()='Publish']]]/following-sibling::td/input")
	private WebElement publishCkeckBox;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[label[text()='Hiring Manager']]/following-sibling::td/span/a/img")
	private WebElement hiringManagerLookupBtn;
	
	@FindBy(xpath="//td[label[text()='Recruiter']]/following-sibling::td/span/a/img")
	private WebElement recruiterLookupBtn;
	
	@FindBy(xpath="//td[label[text()='Account']]/following-sibling::td/span/a/img")
	private WebElement accLookupBtn;
	
	@FindBy(xpath="//frame[@name='resultsFrame']")
	private WebElement resultFrame;
	
	@FindBy(xpath="//frame[@id='searchFrame']")
	private WebElement searchFrame;
	
	@FindBy(xpath="//tr[th[text()='Name']]/following-sibling::tr[1]/th/a")
	private WebElement selHiringManager;
	
	@FindBy(xpath="//tr[th[text()='Full Name']]/following-sibling::tr[1]/th/a")
	private WebElement selRecruiter;
	
	@FindBy(xpath="//tr[th[text()='Account Name']]/following-sibling::tr[1]/th/a")
	private WebElement selAccount;
	
	@FindBy(xpath="//td[label[text()='Expected Start Date']]/following-sibling::td/span/input")
	private WebElement clkOnDateBox;
	
	@FindBy(xpath="//a[text()='Today']")
	private WebElement selectDate;
	
	@FindBy(xpath="//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")
	private WebElement frameTextBox;
	
	@FindBy(id="00N9000000CiGcIEAV_rta_body")
	private WebElement jobDescriptionRichedt;
	
	@FindBy(xpath="//td[label[text()='City']]/following-sibling::td[1]/input")
    private WebElement citynameEdt;
	
	@FindBy(xpath="//td[label[text()='State']]/following-sibling::td[1]/input")
	private WebElement statenameEdt;
	
	@FindBy(xpath="//td[label[text()='Postal Code']]/following-sibling::td[1]/input")
	private WebElement pastalcodeEdt;
	
	@FindBy(xpath="//td[label[text()='Country']]/following-sibling::td[1]/input")
	private WebElement countryEdt;
	
	@FindBy(xpath="//h1[text()='Job']/following-sibling::h2")
	private WebElement verCreatedJob;
	
	@FindBy(xpath="//span[text()='Job Applicants']")
	private WebElement jobapplicantLink;
	
	@FindBy(xpath="//input[@value='New Job Applicant']")
	private WebElement newjobApplicantBtn;
	
	@FindBy(xpath="//input[@id='lksrch']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@id='lksrch']/following-sibling::input[@name='go']")
	private WebElement goBtn;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	private WebElement jobpageTitle;
	
	@FindBy(xpath="//td[text()='Candidate Search']/following-sibling::td/div/a")
	private WebElement candidateSearchLink;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='clone']")
	private WebElement cloneBtn;
	
	@FindBy(xpath="//td[label[text()='Desired Skills']]/following-sibling::td/textarea")
	private WebElement desiredskillsEdt;
	
	@FindBy(xpath="//td[label[text()='Job Description']]/following-sibling::td/textarea")
	private WebElement jobdescription;
	
	@FindBy(xpath="//div[h3[text()='Candidate List']]/following-sibling::div[1]/descendant::iframe")
	private WebElement candidateListFrame;
	
	@FindBys({@FindBy(xpath="//div[table[tbody[tr[td[h3[text()='Job Applicants']]]]]]/following-sibling::div/table/tbody/tr")})
	private List<WebElement>jobapplicantsList;
	
	@FindBys({@FindBy(xpath="//thead[tr[th[div[contains(text(),'Action')]]]]/following-sibling::tbody/tr")})
	private  List<WebElement> totalCandidateList;
	
	@FindBy(xpath="//input[@value='Copy to Job']")
	private WebElement copyToJobBtn;
	
	@FindBys({@FindBy(xpath="//div[table[tbody[tr[td[h3[text()='Questions']]]]]]/following-sibling::div/descendant::tr")})
	private List<WebElement> totalQuestionsList;
	
	@FindBy(xpath="//span[text()='Please, select Job']/span/a/img")
	private WebElement plsSelectJobLookupBtn;
	
	@FindBy(xpath="//label[text()='All Fields']/preceding-sibling::input[@value='SEARCH_ALL']")
	private WebElement allfieldsCheckbtn;
	
	@FindBy(xpath="//div[@class='pbHeader']/descendant::input[@value='Copy']")
	private WebElement copyBtn;
	
	@FindBy(xpath="//td[@class='messageCell']")
    private WebElement successfullcopiedMsg;
	
	@FindBy(xpath="//div[table[tbody[tr[td[h3[text()='Job Applicants']]]]]]/following-sibling::div/table/tbody/tr[2]/descendant::input")
	private WebElement selectFirstJobApplicantRecord;
	
	@FindBy(xpath="//tr[td[@class='messageCell']]/following-sibling::tr/descendant::ul")
	private WebElement alreadyExistErrorMsg;
	
	@FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@value='Clone With Job Applicants']")
	private WebElement cloneWithJobApplicantsBtn;
	
	@FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@value='Clone with Questions']")
	private WebElement cloneWithQuestionsBtn;
	
	@FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@value='Search Candidates']")
	private WebElement searchCandidatesBtn;	
	
	@FindBy(xpath="//td[text()='Street Address']/following-sibling::td[1]/div")
	private WebElement streetadress;
	
	@FindBy(xpath="//td[text()='City']/following-sibling::td[1]/div")
	private WebElement cityAddress;
	
	@FindBy(xpath="//td[text()='Postal Code']/following-sibling::td[1]/div")
	private WebElement pastalCodeaddress;
	
	@FindBy(xpath="//td[text()='Country']/following-sibling::td[1]/div")
	private WebElement countryAddress;
	
	@FindBy(xpath="//td[text()='State']/following-sibling::td[1]/div")
	private WebElement stateAddress;
	
	@FindBy(xpath="//div[table[tbody[tr[td[h3[text()='Job Applicants']]]]]]"
			+ "/following-sibling::div/descendant::input[contains(@onclick,'SelectAllOrNoneByCheckbox')]")
	private WebElement selectAllJobApplicantCheckBoxes;
	
	
	@FindBy(xpath="//div[table[tbody[tr[td[h3[text()='Job Applicants']]]]]]"
			+ "/following-sibling::div/descendant::th[text()='No records to display']")	
	private WebElement noRecordsToDisplayMsg;
	
	@FindBy(xpath="//input[@value='Mass Delete']")
    private WebElement massDeleteBtn;
	
	public List<WebElement> getJobapplicantList() {
		return jobapplicantsList;
	}
	public List<WebElement> getTotalCandidateList() {
		return totalCandidateList;
	}
	public WebElement getCandidateListFrame() {
		return candidateListFrame;
	}

	/**
	 * To create a Job
	 * @param jobTitle
	 */
	
	public void createJob(String jobTitle ){
		newButton.click();
		this.jobTitle.sendKeys(jobTitle);
		saveBtn.click();
	}
	/**
	 * To create Job from Contacts
	 */
	public void createJobFromContact(String jobTitle ){
		this.jobTitle.sendKeys(jobTitle);
		saveBtn.click();
	}
	/**
	 * To create a job With multiple field values 
	 * @param jobTitle
	 * @param skillset
	 * @throws InterruptedException
	 */
	public void createJob(String jobTitle,String skillset) throws InterruptedException{
		newButton.click();
		this.jobTitle.sendKeys(jobTitle);
        publishCkeckBox.click();
        recruiterLookupBtn.click();
        String childwindowID2 =common.expectedWindow(expWindtitle);
		driver.switchTo().window(childwindowID2);
		common.waitForWebElementPresent(resultFrame);
		common.switchToFrame(resultFrame);
	    selRecruiter.click();
	    driver.switchTo().window(common.currentWindow);
	    accLookupBtn.click();
	    String childwindowID3 = common.expectedWindow("Search ~ salesforce.com - Developer Edition");
		driver.switchTo().window(childwindowID3);
		common.waitForWebElementPresent(resultFrame);
		common.switchToFrame(resultFrame);
		selAccount.click();
		driver.switchTo().window(common.currentWindow);
		common.waitForWebElementPresent(frameTextBox);
	    driver.switchTo().frame(frameTextBox);
		jobDescriptionRichedt.sendKeys(skillset);
		driver.switchTo().defaultContent();
		clkOnDateBox.click();
		selectDate.click();
		saveBtn.click();
		common.waitForWebElementPresent(verCreatedJob);
		Assert.assertTrue(verCreatedJob.isDisplayed(), "job is not craeated");
	}
	/**
	 * Method to create a job with below params
	 * @param jobTitle
	 * @param recruiterName
	 * @param hrName
	 * @param accName
	 * @param skillset
	 */
	
	public void createJobWithAllData(String jobTitle,String recruiterName,String hrName,String accName,String skillset){
		newButton.click();
		this.jobTitle.sendKeys(jobTitle);
        publishCkeckBox.click();
        hp.lookUpPopupHandling(recruiterLookupBtn, expWintitle2, searchFrame, searchEdt, recruiterName, goBtn, resultFrame, recruiterName);
        hp.lookUpPopupHandling(hiringManagerLookupBtn, expWindtitle, searchFrame, searchEdt, hrName, goBtn, resultFrame, hrName);
        hp.lookUpPopupHandling(accLookupBtn, expWindtitle, searchFrame, searchEdt, accName, goBtn, resultFrame, accName); 
        common.waitForWebElementPresent(frameTextBox);
	    driver.switchTo().frame(frameTextBox);
		jobDescriptionRichedt.sendKeys(skillset);
		driver.switchTo().defaultContent();
        clkOnDateBox.click();
		selectDate.click();
		saveBtn.click();
		common.waitForWebElementPresent(jobpageTitle);
		Assert.assertTrue(jobpageTitle.isDisplayed(), "job creation failed");
	}
	 /**
	  * Candidate Search Link Webelement
	  * @return WebElement
	  */
	  public WebElement getCandidateSearchLink() {
		return candidateSearchLink;
	    }
	/**
	   * Method to create  jobapplicants for a candidate From  Job page
	   * @throws InterruptedException
	   */
	public void createJobappFromJob() throws InterruptedException{
		candidateSearch =PageFactory.initElements(driver, CandiateSearch.class);
		while(count<10){
			try{
			candidateSearch.getCreatejobAppBtnframe().isDisplayed();
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",candidateSearch.getCreatejobAppBtnframe());
			driver.switchTo().frame(candidateSearch.getCreatejobAppBtnframe());
			driver.findElement(By.xpath("//thead[tr[th[div[contains(text(),'Action')]]]]/following-sibling::tbody/tr[1]/descendant::input")).click();
			candidateSearch.getJobapplicantBtn().click();
			break;
			}
			catch(Throwable T){
				driver.navigate().refresh();
			    Thread.sleep(30000);
			}
		}
		common.waitForWebElementPresent(candidateSearch.getJobApplicantcreatedMsg());
		String textmsg=candidateSearch.getJobApplicantcreatedMsg().getText();
		Assert.assertTrue(textmsg.contains("Creation has been successful"), "Jobapplicant not created");
		driver.switchTo().defaultContent();
	    }
	
	 public CandiateSearch createJobAndSearchCand(String jobTitle){
		createJob(jobTitle);
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, CandiateSearch.class);
	  }
	 /**
	 * This method to create jobapplicant from jobPage
	 * return jobapplicantsPage
	 */
	
	public JobApplicants creatJobApplicantFromJob(){
		common.waitForWebElementPresent(jobapplicantLink);
		jobapplicantLink.click();
		newjobApplicantBtn.click();
		return PageFactory.initElements(driver, JobApplicants.class);
	}
	/**
	 * mathod to select a existing job record using below param
	 * @param jobID
	 */
	public void selectJob(String jobID){
		common.selectLink(jobID).click();
		common.waitForPageToLoad();
	}
	/**
	 * method to clone a job By editing with below params
	 * @param jobID
	 * @param jobTittle
	 * @param keywords
	 */
	public void cloneJob(String jobID,String jobTittle,String keywords){
		selectJob(jobID);
		String initialRecordNor=jobpageTitle.getText();
		common.waitForWebElementPresent(cloneBtn);
		cloneBtn.click();
		jobTitle.clear();
		jobTitle.sendKeys(jobTittle);
		desiredskillsEdt.clear();
		desiredskillsEdt.sendKeys(keywords);
		driver.switchTo().frame(frameTextBox);
		jobDescriptionRichedt.clear();
		jobDescriptionRichedt.sendKeys(keywords);
	    driver.switchTo().defaultContent();
	    saveBtn.click();
	    common.waitForWebElementPresent(jobpageTitle);
	    String finalRecordNor=jobpageTitle.getText();
		Assert.assertNotEquals(initialRecordNor, finalRecordNor, "Fail to clone job");
	}
	
	/**
	 * method for copyTojob for a selected job applicant from the jobdetailsPages
	 * @param jobId2
	 * @throws InterruptedException
	 */
	public void copyToJob(String jobId2) throws InterruptedException
	{  
		while(count<5)
		{
		try
		{
			common.waitForWebElementPresent(selectFirstJobApplicantRecord);
			selectFirstJobApplicantRecord.click();
			copyToJobBtn.click();
			hp.lookUpPopupHandling(plsSelectJobLookupBtn, expWindtitle, searchFrame, searchEdt, jobId2, goBtn, resultFrame, jobId2);
	        copyBtn.click();
	        common.waitForWebElementPresent(successfullcopiedMsg);
	        Assert.assertTrue(successfullcopiedMsg.isDisplayed(), "Fail to copytoJob");
	        flag=true;
	        break;
		}
		catch(Exception E)
		{
			count++;
			common.refreshPage();
			Thread.sleep(7000);
		}
	    }
	}
	
	/**
	 * 
	 * method to clone a job with job applicants
	 * @throws InterruptedException
	 */
	public void cloneWithJobApplicant() throws InterruptedException{
		String initialRecordNor=jobpageTitle.getText();
		List<WebElement>list=getJobapplicantList();
		int initialNorOFJobapp=list.size()-1;
		int intialNorofcandidates=getTotalCandidateList().size();
		cloneWithJobApplicantsBtn.click();
		common.waitForWebElementPresent(jobpageTitle);
		String finalrecordNor=jobpageTitle.getText();
	    for (int i=0;i<2;i++){
	    	common.refreshPage();
	    	Thread.sleep(8000);
	    	common.scrolldowntoBottom();
	    }
		int finalNorOFJobapp=list.size()-1;
		int finalNorofcandidates=  getTotalCandidateList().size();
		Assert.assertNotEquals(initialRecordNor, finalrecordNor, "Fail to clone the job applicants");
		Assert.assertEquals(intialNorofcandidates, finalNorofcandidates, "Nor of candiadates list displaying d/f after clone with job applicants");
		Assert.assertEquals(initialNorOFJobapp, finalNorOFJobapp, "Nor of Job applicants displaying  d/f after clone with job applicants");
	}
	
	/**
	 * 
	 * method to clone a job with questions
	 * @throws InterruptedException
	 */
	public void CloneWithQuestions() throws InterruptedException
	{
		 String initialRecordNor=jobpageTitle.getText();
		 common.scrolldowntoBottom();
		 int initialTotalQuestions=totalQuestionsList.size()-1;
		 int initialNorOfJobapplicants=jobapplicantsList.size()-1;
		 common.refreshPage();
		 common.waitForWebElementPresent(cloneWithQuestionsBtn);
		 common.mouseClickAtHiddenElement(cloneWithQuestionsBtn);
		 common.waitForWebElementPresent(jobpageTitle);
		 String clonedRecordNor=jobpageTitle.getText();
		 common.scrolldowntoBottom();
		 int finalNorOfQuestions=totalQuestionsList.size()-1;
		 int finalNorOfJobapplicants=jobapplicantsList.size()-1;
		 System.out.println(initialTotalQuestions+"=="+finalNorOfQuestions);
		 Assert.assertNotEquals(initialRecordNor, clonedRecordNor, "fail to clone the questions");
		 Assert.assertNotEquals(initialNorOfJobapplicants, finalNorOfJobapplicants, "Job applicants also cloning while cloning the questions");
		 Assert.assertEquals(initialTotalQuestions, finalNorOfQuestions, "Nor of Questions displaying  d/f after clone with Questions");

	}
	/**
	 * 
	 * method to verify whether jobLocation details are displaying or not
	 */
	
	public void jobLocationDetailVerification(){
		Assert.assertTrue(streetadress.getText().trim().length()!=0, "Street adress valueis empty");
		Assert.assertTrue(stateAddress.getText().trim().length()!=0, "State value is empty");
		Assert.assertTrue(cityAddress.getText().trim().length()!=0, "city value is empty");
		Assert.assertTrue(pastalCodeaddress.getText().trim().length()!=0, "postal code value is empty");
		Assert.assertTrue(countryAddress.getText().trim().length()!=0, "country name  is empty");
	}
	/**
	 * method to click the searchCandidates Button
	 * @return
	 */
	public CandiateSearch clickOnSearchCandidatesBtn(){
		searchCandidatesBtn.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, CandiateSearch.class);
	}
	/**
	 * method to Delete multiple job applicants
	 * 
	 */
	public void massDelete(){
		common.waitForWebElementPresent(jobapplicantLink);
		jobapplicantLink.click();
		selectAllJobApplicantCheckBoxes.click();
		massDeleteBtn.click();
		common.acceptAlert();
		common.waitForPageToLoad();
		if(selectAllJobApplicantCheckBoxes.isDisplayed()){
			massDeleteBtn.click();
			common.acceptAlert();
			Assert.assertTrue(noRecordsToDisplayMsg.isDisplayed(), "records are still found");
		}
		else
		{
			Assert.assertTrue(noRecordsToDisplayMsg.isDisplayed(), "records are still found");
		}
		
	}
   }
