package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;

public class Scen01 extends ScenarioMobileSaks {

	@Override
	public void executeScript() throws Exception {

		/*String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);

		nav.SearchFor(item1);
		pdp.AddToBag(2);

		nav.SearchFor(item2);
		pdp.AddToBag(2);

		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.UpgradeShippingMessage();
		ValidateRs.ShippingMethod(item2,"Standard");
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();*/

		Find.Object("ofm_navSearchBox_wk").click();
		nav.SearchFor("0492545191655");
		pdp.AddToBag();
		//ValidatePdp.TotalItemsInBag("1");
		pdp.EnterBag();
		bag.CheckOut();
		lgn.LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
		rsp.ClickPlaceOrder();
		ValidateConfirmation.hasOrderNumber();
		

	}

}