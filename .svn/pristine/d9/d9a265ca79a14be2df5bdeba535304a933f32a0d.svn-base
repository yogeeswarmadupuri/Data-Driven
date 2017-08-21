package com.tr.pageLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.tr.genericlib.Common;
/**
 * Account Page Libraries.
 * class provide webdriver candidate search page libraries , which can be used create candidate search ..etc
 *
 * @author Deepak HR
 *
 */
public class CandiateSearch {
	
	public WebDriver driver;
	public Common common;
	
	
	
	public CandiateSearch(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		
	}
	@FindBy(xpath="//input[@name='new']")
	private WebElement newButton;
	
	@FindBy(xpath="//div[contains(text(),'Keywor')]/input")
	private WebElement keywordEdt;
	
	@FindBy(xpath="//div[h3[contains(text(),'Search Display')]]/following-sibling::div/descendant::select[contains(@name,'toBox')]")
    private WebElement selectToBox;
	
	@FindBy(xpath="//img[@alt='<-']")
     private WebElement rightArrowBtn;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']/descendant::input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='pbHeader']/descendant::input[2]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='dialog']/descendant::input[@type='text']")
	private WebElement searchNameEdt;
	
	@FindBy(xpath="//div[@id='dialog']/descendant::input[@value='Save']")
	private WebElement diologueSaveBtn;
	
	@FindBy(xpath="//h2[@class='mainTitle']")
	private WebElement verCandiateSearchName;
	
	@FindBy(xpath="//td[@id='topButtonRow'][input[@value='Search Candidates']]/input[@value='Search Candidates']")
	private WebElement searchCandidateBtn;
	
	@FindBy(xpath="//div[contains(text(),'Keywords')]/input")
	private WebElement keywordsEdt;
	
	@FindBy(xpath="//td[a[text()='Sameer Kumar']]/preceding-sibling::td/input")
	private WebElement selectCandidateBtn;
	
	@FindBy(xpath="//div[@class='messageText']")
	private WebElement jobApplicantcreatedMsg;
	
	@FindBy(xpath="//thead[tr[th[div[contains(text(),'Action')]]]]/following-sibling::tbody/tr[1]/descendant::input")
	private WebElement selectFirstCandidateBtn;
	
	
	@FindBys({@FindBy(xpath="//div[span[contains(@id,'ctedRecruiterAndJob')]]/following-sibling::table/descendant::tr")})
	private List<WebElement> totalNorOfCandidadates;
	
	@FindBy(xpath="//input[@value='Create Job Applicant(s)']")
	private WebElement jobapplicantBtn;
	
	@FindBy(xpath="//div[h3[text()='Candidate List']]/following-sibling::div[1]/descendant::iframe")
	private WebElement candidateLisFrame;
	
	@FindBy(xpath="//thead[tr[th[div[text()='Action']]]]/following-sibling::tbody/tr[1]/td/a")
	private WebElement selectFirstCandidate;
	
	public void setSelectFirstCandidate(WebElement selectFirstCandidate) {
		this.selectFirstCandidate = selectFirstCandidate;
	}
	public WebElement getCreatejobAppBtnframe() {
		return candidateLisFrame;
	}
	public WebElement getJobApplicantcreatedMsg() {
		return jobApplicantcreatedMsg;
	}
	public WebElement getSelectFirstCandidate() {
		return selectFirstCandidateBtn;
	}
	public WebElement getSelectCandidate() {
		return selectCandidateBtn;
	}
	public WebElement getJobapplicantBtn() {
		return jobapplicantBtn;
	}
	
	public List<WebElement> getTotalNorOfCandidadates() {
		return totalNorOfCandidadates;
	}
	

	
	/**
	 * This method use to create candidate search
	 * @param searchKeyword
	 * @param jobSearchName
	 */
	public void createSearch(String searchKeyword,String jobSearchName){
		newButton.click();
		keywordEdt.sendKeys(searchKeyword);
		List<WebElement>list=common.selectAllElements(selectToBox);
		for(int i=0;i<list.size()-5;i++){
			list.get(i).click();
			rightArrowBtn.click();
		}
		searchBtn.click();
		common.mouseClickAtHiddenElement(saveBtn);
		searchNameEdt.sendKeys(jobSearchName);
		diologueSaveBtn.click();
		Assert.assertTrue(verCandiateSearchName.isDisplayed(), "Fail to create Candiate Search");
	}
	public void createCandidateSearch(String searchKeyword){
		common.mouseClickAtHiddenElement(searchCandidateBtn);
		List<WebElement>list=common.selectAllElements(selectToBox);
		for(int i=0;i<list.size()-5;i++){
			list.get(i).click();
			rightArrowBtn.click();
		}
		keywordsEdt.sendKeys(searchKeyword);
		searchBtn.click();
     }
	/**
	 * method to get the current page title
	 * @return current page title
	 */
	public String getpagetitle(){
		return	common.getCurrentPageTitle();
		
	}
}


