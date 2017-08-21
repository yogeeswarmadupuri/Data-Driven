package com.tr.workflowlib;
import org.openqa.selenium.WebDriver;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Interviews;
import com.tr.pageLib.JobApplicants;

/**
 * InterviewWorkFlowLib Libraries.
 * class provide webdriver InterviewWorkFlowLib libraries , which can be used to create interviews .
 *
 * @author Dileep HE
 *
 */
    public class InterviewWorkFlowLib {
	JobApplicants jobApplicantPage;
	Interviews interviewsPage;
	WebDriver driver;
	
	/**
	 * Method to create interview
	 * @param alltabsPage
	 * @param typeOfInterview
	 */
	public void createInterview(AllTabs alltabsPage ,String typeOfInterview){
		jobApplicantPage = alltabsPage.navigateToJobApplicantsPage();
		jobApplicantPage.createInterviewthroughJobapplicantPage(typeOfInterview);
		
	}
}
	