package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tr.genericlib.Common;
/**
 * all tabs Libraries.
 * class provide All Tabs page libraries , which can be used to navigate to specific page like accounts,contacts ..etc
 *
 * @author Deepak HR
 *
 */
public class AllTabs {
	
	public WebDriver driver;
	public Common common;
	
	
	
	public AllTabs(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		
	}
	
	@FindBy(linkText="Accounts")
	private WebElement accountsLnk;
	
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Jobs")
	private WebElement jobsLnk;

	
	@FindBy(linkText="Jobs Search")
	private WebElement jobsSearchsLnk;
	
	
	@FindBy(linkText="Placements")
	private WebElement placementsLnk;
	
	@FindBy(linkText="Interviews")
	private WebElement interviewsLnk;
	
	@FindBy(linkText="Job Applicants")
	private WebElement jobApplicantsLnk;
	
	@FindBy(linkText="Job Boards Search")
	private WebElement jobBoardsSearchLnk;
	
	@FindBy(linkText="Employees")
	private WebElement EmployeesLnk;
	
	@FindBy(xpath="//img[@class='allTabsArrow']")
	private WebElement showMoresymbol;
	
	@FindBy(linkText="Candidates Search")
	private WebElement candiateSearchLink;
	
	@FindBy(xpath="//td[a[text()='Home']]/a")
	private WebElement homePageLink;

	@FindBy(linkText="Setup")
	private WebElement setupPageLink;
	
	@FindBy(xpath="//li[a[text()='ETCObjects']]/a")
	private WebElement etcObjectsPageLink;
	
	/**
	 * To navigate to Accounts page
	 * @return account page
	 */
	public Accounts navigateToAccountsPage(){
		
		accountsLnk.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, Accounts.class);
		
	}
	/**
	 * To navigate to contacts  page
	 * @return contacts page
	 */
    public Contacts navigateToContactsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    contactsLnk.click();
	    common.waitForPageToLoad();
		
		return PageFactory.initElements(driver, Contacts.class);
		
	}/**
	 * To navigate to Candidates  page
	 * @return Candidates page
	 */
    public Candidates navigateToCandidatesPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    contactsLnk.click();
	    common.waitForPageToLoad();
		return PageFactory.initElements(driver, Candidates.class);
	  }
    /**
	 * To navigate to Jobs page
	 * @return jobs page
	 */
    public Jobs navigateToJobsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    jobsLnk.click();
	    common.waitForPageToLoad();
		return PageFactory.initElements(driver, Jobs.class);
	}
    
    /**
	 * To navigate to CandiateSearch page
	 * @return CandiateSearch page
	 */
    public CandiateSearch navigateToJobsSearchPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    jobsSearchsLnk.click();
	    common.waitForPageToLoad();
		return PageFactory.initElements(driver, CandiateSearch.class);
		
	}
    /**
	 * To navigate to Placements page
	 * @return Placements page
	 */
    public Placements navigateToPlacementsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    placementsLnk.click();
	    common.waitForPageToLoad();
		return PageFactory.initElements(driver, Placements.class);
		
	}
    /**
   	 * To navigate to Interviews page
   	 * @return Interviews page
   	 */
	
    public Interviews navigateToInterviewsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
	    interviewsLnk.click();
	    common.waitForPageToLoad();
		return PageFactory.initElements(driver, Interviews.class);
		
	}
    /**
   	 * To navigate to JobApplicants page
   	 * @return JobApplicants page
   	 */
	
    public JobApplicants navigateToJobApplicantsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
    	jobApplicantsLnk.click();
    	common.waitForPageToLoad();	
    	return PageFactory.initElements(driver, JobApplicants.class);
    		
    }
    /**
   	 * To navigate to JobBoardsSearch page
   	 * @return JobBoardsSearch page
   	 */
    public JobBoardsSearch navigateToJobBoardsSearchPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
    	jobBoardsSearchLnk.click();
    	common.waitForPageToLoad();	
    		return PageFactory.initElements(driver, JobBoardsSearch.class);
    		
    }
    
    /**
   	 * To navigate to Employees page
   	 * @return Employees page
   	 */
    public Employees navigateToEmployeesPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
    	EmployeesLnk.click();
    	common.waitForPageToLoad();
    		return PageFactory.initElements(driver, Employees.class);
    		
    }
    /**
   	 * To navigate to CandiateSearch page
   	 * @return CandiateSearch page
   	 */
    public CandiateSearch navigateToCandiateSearchPage(){
    	common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
		candiateSearchLink.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, CandiateSearch.class);
    }
    /**
   	 * To navigate to Home page
   	 * @return HomePage
   	 */
    public HomePage navigateToHomePage(){
    	common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
		homePageLink.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, HomePage.class);
    }
    /**
   	 * To navigate to SetUp page
   	 * @return SetupPage
   	 */
    public SetupPage navigateTosetUpPage(){
    	common.waitForWebElementPresent(showMoresymbol);
    	showMoresymbol.click();
    	setupPageLink.click();
    	common.waitForPageToLoad();
		return PageFactory.initElements(driver, SetupPage.class);
    }
    /**
   	 * To navigate to EtcObects page
   	 * @return EtcObectsPage
   	 */
    public EtcObectsPage navigateToEtcObectsPage(){
    	common.waitForWebElementPresent(showMoresymbol);
    	showMoresymbol.click();
    	common.mouseClickAtHiddenElement(etcObjectsPageLink);
    	common.waitForPageToLoad();
		return PageFactory.initElements(driver, EtcObectsPage.class);
    }
}
