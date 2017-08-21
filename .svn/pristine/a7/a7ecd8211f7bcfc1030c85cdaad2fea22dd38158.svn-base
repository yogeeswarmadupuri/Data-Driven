package com.tr.workflowlib;

import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Jobs;

/**
 * JobWorkFlow Libraries.
 * class provide webdriver JobWorkFlow libraries , which can be used to create job .
 *
 * @author Dileep HE
 *
 */
public class JobWorkFlowLib {
	
	Jobs jobPage;
	
	/**
	 * Method to create job
	 * @param alltabsPage
	 * @param jobName
	 */
	public void createJob(AllTabs alltabsPage ,String jobName ){
		jobPage = alltabsPage.navigateToJobsPage();
		jobPage.createJob(jobName);
		
	}

}
