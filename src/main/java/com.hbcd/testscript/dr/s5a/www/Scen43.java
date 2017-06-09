package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.banner.s5a.cc.pages.Customers;
import com.hbcd.banner.validations.s5a.ValidateCC;

public class Scen43 extends ScenarioCC{
	public void executeScript() throws Exception{

		Navigate.go("qacc.saksdirect.com");
		cc.LoginWith("csrtest", "csrtest");
		ccNav.ClickCustomers();
		ccCustomers.SearchByCustomerEmail("natalie@test.com");
		ValidateCC.ValidateCustomerProfile("natalie@test.com");
		
	}
}