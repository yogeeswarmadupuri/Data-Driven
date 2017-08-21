package com.tr.workflowlib;

import com.tr.pageLib.AllTabs;
import com.tr.pageLib.JobApplicants;

/**
 * JobApplicantWorkFlow Libraries.
 * class provide webdriver JobApplicantWorkFlow libraries , which can be used to create jobApplicant .
 *
 * @author Dileep HE
 *
 */
public class JobApplicant {
	JobApplicants jobapplicant;
	
	
	/**
	 * Method to create Jobapplicant
	 * @param alltabsPage
	 * @param accName
	 * @throws InterruptedException 
	 */
	public void createJobapplicant(AllTabs alltabsPage , String accName,String jobId) throws InterruptedException{
		jobapplicant = alltabsPage.navigateToJobApplicantsPage();
		jobapplicant.createJobAplicant(accName,jobId);
	}

}
