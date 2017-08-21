package com.tr.pageLib;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.VerifyMappingValueTest;

/**
 * Home Page Libraries.
 * class provide webdriver Home page libraries , which can be used Add resume etc
 *
 * @author Deepak HR
 *
 */
    public class HomePage {
	public WebElement getAddResumeLink() {
		return addResumeLink;
	}


	public WebDriver driver;
	public Common common;
	public ExtLogger logger = ExtLogger.getLogger(VerifyMappingValueTest.class);
	public static String candidateNameLink;
	public static String skillset;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}
	
	
	public WebElement getUploadFileBtn() {
		return uploadFileBtn;
	}


	@FindBy(xpath="//li[a[text()='Add Resume']]/a")
	private WebElement addResumeLink;
	
	@FindBy(xpath="//iframe[@id='itarget']")
	private WebElement frameName;

	@FindBy(xpath="//input[@name='uploadFile']")
	private WebElement uploadFileBtn;
	
	public WebElement getFrameName() {
		return frameName;
	}


	@FindBy(xpath="//input[@value='Add Resume']")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	@FindBy(xpath="//div[@id='message']")
	private WebElement message;
	
	@FindBy(xpath="//div[@id='message']/a")
	private WebElement candidateName;
	
    public WebElement getCandidateName() {
		return candidateName;
	}


	@FindBy(xpath="//td[text()='Name']/following-sibling::td[1]/div")
    private WebElement verCandidateName;
    
    @FindBy(xpath="//td[text()='Skillset']/following-sibling::td[1]/div")
    private WebElement verCandidateSkillSet;
    
    @FindBy(xpath="//span[text()='Notes & Attachments']/span")
    private WebElement verNorOfNotesandAttachments;
	
    @FindBy(xpath="//td[text()='Chatter Id']/following-sibling::td[1]/div")
    private WebElement getChatterId;
    
    @FindBy(xpath="//td[text()='Account Name']/following-sibling::td[1]/div")
    private WebElement getAccName;
    
    @FindBy(xpath="//div[h2[text()='Messages and Alerts']]/following-sibling::div")
    private WebElement etcAdress;
    
    @FindBy(xpath="//td[text()='Longitude']/following-sibling::td/div")
    private WebElement langitudeValue;
    
    @FindBy(xpath="//td[text()='Latitude']/following-sibling::td/div")
    private WebElement latitudeValue;
    
    /**
     * Method To Create Candidate Through Add Resume
     * @param filePath
     */
    public void createCandidate(String filePath){
    	try{	
    	HashMap<String, String> map =common.getwindowIDs();
		driver.switchTo().window(map.get("childWindow"));
		driver.close();
		driver.switchTo().window(map.get("parentWindow"));
		}
    	catch(Throwable t){
    		System.out.println("no such popups");
    	}
		addResumeLink.click();
		common.switchToFrame(frameName);
		uploadFileBtn.sendKeys(filePath);
	    common.moveToElement(submitBtn);
		common.waitForWebElementPresent(candidateName);
	    candidateNameLink=candidateName.getText();
	    logger.info("Candidate Status =====================>"+message.getText());
	    common.selectpartialLink(candidateNameLink).click();
		HashMap<String, String> map1 =common.getwindowIDs();
		driver.switchTo().window(map1.get("childWindow"));	
	}
    
    /**
     * method to Verify the candidate details once we add the resume
     * 
     */
    public void getCandidateDetailsFromResume(){
    	common.waitForWebElementPresent(verCandidateName);
 	    logger.info("Name of the candidate===="+verCandidateName.getText());
 	    common.waitForWebElementPresent(verCandidateSkillSet);
 	    
 		common.isElementPresentByWebelement(verCandidateSkillSet);
 		logger.info("candidate skillset======"+verCandidateSkillSet.getText()); 
 		skillset=verCandidateSkillSet.getText();
 	    common.isElementPresentByWebelement(getChatterId);
 	   
 	    
 	    logger.info("Chatter ID========"+getChatterId.getText());
 	    common.isElementPresentByWebelement(getAccName);
 	    common.isElementPresentByWebelement(getAccName);
 	    
 	    logger.info("Account Name========"+getAccName.getText());
 	    common.waitForWebElementPresent(verNorOfNotesandAttachments);
 	    common.isElementPresentByWebelement(verNorOfNotesandAttachments);
 	    logger.info("Nor of Notes and attachment========"+verNorOfNotesandAttachments.getText());
 	    
 	    Assert.assertTrue(!(langitudeValue.getText().trim().length()==0)&&!
 	    		(latitudeValue.getText().trim().length()==0), "Langitude value And Lattitude value is displayed");
        logger.info("Langitude value================="+langitudeValue.getText());
        logger.info("Langitude value================="+latitudeValue.getText());
    }
    
    /**
     * method to return the object to Candidates page
     * 
     */
    public Candidates returnToCandidatePage(){
    	return PageFactory.initElements(driver, Candidates.class);
    }
   
    public void addResumeFromHomePage(String filepath){
    	addResumeLink.click();
    	common.switchToFrame(getFrameName());
        getUploadFileBtn().sendKeys(filepath);
        getSubmitBtn().click();
    }

}
