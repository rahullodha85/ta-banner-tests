package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;

public class TestScenario_Waseem extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
		
		Navigate.go("http://qacc.saksdirect.com/contact/login.jsp");
		ccp.LoginWith("csrtest", "csrtest");
		ccHome.SearchByOrderNumber("72323883");
//		ccOrders.ClickEditPaymentInformation();
//		ccOrders.EditCreditCard("Master", "5444009999222205");
		ccOrders.CancelLineItemOrder("0424168279717");
		ccOrders.AddCreditCard("Master");
		
		
		
		
	}

}
