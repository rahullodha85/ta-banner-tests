package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.banner.s5a.cc.pages.Customers;
import com.hbcd.banner.validations.s5a.ValidateCC;

public class Scen42 extends ScenarioCC{
	public void executeScript() throws Exception{

		Navigate.go("qacc.saksdirect.com");
		cc.LoginWith("csrtest", "csrtest");
		ccNav.ClickOrders();
		ccOrders.SearchByOrderNumberAndZip("72327397","");
		ValidateCC.ValidateCustomerBillingAddress("1 Main St", "San Jose", "California - 95131", "United States", "408-273-1957", "testnn11@test.com", "Petrova, Maria");	
		
	}
}