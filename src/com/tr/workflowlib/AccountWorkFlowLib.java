package com.tr.workflowlib;

import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
/**
 * AccountWorkFlowLib Libraries.
 * class provide webdriver AccountWorkFlowLib libraries , which can be used to create account .
 *
 * @author Deepak HR
 *
 */
public class AccountWorkFlowLib {
	
	Accounts accountPage;
	
	public void createAccount(AllTabs alltabsPage , String accName){
		accountPage = alltabsPage.navigateToAccountsPage();
		accountPage.createAccount(accName);
	}

}
