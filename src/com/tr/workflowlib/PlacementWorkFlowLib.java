package com.tr.workflowlib;

import com.tr.pageLib.AllTabs;
import com.tr.pageLib.JobApplicants;

/**
 * PlacementWorkFlowLib Libraries.
 * class provide webdriver PlacementWorkFlowLib libraries , which can be used to convert Placement .
 *
 * @author Dileep HE
 *
 */
public class PlacementWorkFlowLib {
	JobApplicants jobApplicantPage;
	
	
	/**
	 * Method to Convert for placement
	 * @param alltabsPage
	 */
	public void convertToPlacement(AllTabs alltabsPage){
		jobApplicantPage=alltabsPage.navigateToJobApplicantsPage();
		jobApplicantPage.convertToPlacement();
		
	}
}
