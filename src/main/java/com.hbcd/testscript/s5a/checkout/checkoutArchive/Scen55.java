package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen55  extends ScenarioChkout{
	public void executeScript() throws Exception{
		nav.SearchFor("0476703125737");
		pdp.AddToBag(1);
		nav.SearchFor("0424160097005");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saks1@gmail.com", "google@1234");
		//pap.AddNewCreditCard(3);
		rsp.MakeGift("0424160097005").With("Automation", "test");
		rsp.ToggleSignature("0424160097005");
		rsp.ChangeShippingMethod("Rush");
		//add more items from RSP 0438369560316
		rsp.ClickPlaceOrder();
//		ValidateRs.hasSignatureOnDelivery("0476703125737");
//		ValidateRs.hasShippingMethodChanged("0476703125737", "Rush");
		//validate expected shipDate
		//validate item 0438369560316 added
	}
}
