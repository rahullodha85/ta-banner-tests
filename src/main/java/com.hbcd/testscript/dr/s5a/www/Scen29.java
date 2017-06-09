package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen29 extends ScenarioSaks{
	@Override
	public void executeScript() throws Exception {

		String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.PREORDER);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("saksqa148@saks.com");
		shp.AddShippingAddress(false, "12 east 49th st", "New York", "New York", "10017", false);
		pap.AddNewCreditCard(1);
		pap.ClickCheckout();
		rsp.ClickPlaceOrder();
		Storage.save("orderNumber",ValidateConfirmation.getOrderNumber());
		nav.ClickSaksYourAccount();
		yap.CancelOrder(Storage.get("orderNumber"), "10017");
	}
}
