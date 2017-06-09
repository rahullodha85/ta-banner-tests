package com.hbcd.testscript.s5a.checkout.checkoutArchive;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen36 extends ScenarioChkout {
	public void executeScript() throws Exception{
		nav.SearchFor("0438386556826");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ApplyPromo("Holiday7");
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York", "Manhattan", "11223", false);
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout();
		rsp.ApplyGiftCard("6015990000350662", "8853");
		rsp.ClickPlaceOrder();
		yap.CancelOrder(ValidateConfirmation.getOrderNumber(), "11223");
	}
}
