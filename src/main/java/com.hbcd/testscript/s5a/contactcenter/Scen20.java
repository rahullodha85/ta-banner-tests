package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.s5a.cc.pages.RapidReviewer;
import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen20 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
		
//		Saks Steps Begin
		Navigate.go(Storage.get("Saks_URL"));
		nav.SearchFor("0476715292991");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//master
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.isThankYouPage();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
//	Saks Steps End
		
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csrtest", "csrtest");
		ccHome.SearchByOrderNumber(Storage.get("orderNumber"));
		ValidateCC.hasResult(Storage.get("orderNumber"));
		ValidateCC.checkStatus("Hold - Risk");
		
		Navigate.go(Storage.get("Saks_RapidReviewer_URL"));
		
		ccRapidReviewer.Login("sandy", "password");
		ccRapidReviewer.SearchOrder(Storage.get("orderNumber"));
		ccRapidReviewer.ApproveOrder();
		ccRapidReviewer.SearchOrder(Storage.get("orderNumber"));
		

	}

}
