package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCC;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen45 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {

		String item1 = itemData.get(ItemType.REGULAR);
		nav.SearchFor(item1);
		pdp.AddToBag(1);
		pdp.EnterBag();
		ValidateBag.isShipFromStore();
		// check status on right side
		bag.ClickCheckout().LoginWith("saksqa148@saks.com", "test123");
		rsp.ClickPlaceOrder();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		Navigate.go("qacc.saksdirect.com");
		cc.LoginWith("csrtest", "csrtest");

		cc.SearchOrder(Storage.get("orderNumber"));
		ValidateCC.ValidateStoreFlag();

		Navigate.go(Storage.get("Saks_URL"));
		yap.CancelOrder(Storage.get("orderNumber"), "10017");

	}
}
