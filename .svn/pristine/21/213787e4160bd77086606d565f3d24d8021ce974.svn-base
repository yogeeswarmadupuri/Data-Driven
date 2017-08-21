package com.tr.workflowlib;

import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Contacts;
/**
 * ContactWorkflowLib Libraries.
 * class provide webdriver ContactWorkflowLib libraries , which can be used to create contact ,candidate .
 *
 * @author Deepak HR
 *
 */
public class ContactWorkflowLib {
	Contacts contactPage;
	
	public void createContact(AllTabs alltabsPage , String firstName,String lastName){
		
		contactPage = alltabsPage.navigateToContactsPage();
		contactPage.createContact(firstName,lastName);
		
	}
	
	public void createCandidate(AllTabs alltabsPage , String candiFirstName ,String LastName, String accName,String contactType){
		
		contactPage = alltabsPage.navigateToContactsPage();
		contactPage.createCandidate(candiFirstName, LastName, accName,contactType);
		
	}

}
