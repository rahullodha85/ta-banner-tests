package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen35 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
	//put validation inside change country
	nav.ChangeCountry("Canada");
	// Validate : International Saks home page should display with "Select Country &  Select Currency" dropdown and "Back to U.S. site and Save & continue shipping buttons. 
	nav.SearchFor("0476930905515");
	//check for currency on pdp page
	pdp.AddToBag(2);
	pdp.EnterBag();

	bag.ClickCheckout();
	icp.AddShippingAddress("155 Antibes drive"," North York","Ontario","m2r3g7","saksman@gmail.com");
	icp.AddCreditCard("visa", "4445222299990007");
	
	icp.ClickPlaceOrder();
	//Login to contact center and cancel ord

//	bag.ClickCheckout().LoginWith("saksqa148@saks.com", "test123");
	//rsp.AddShippingAddress("155 Antibes drive"," North York","Ontario","m2r3g7","canada",false);
	//rsp.ClickPlaceOrder();
	//Login to contact center and cancel order

	
	}
}
