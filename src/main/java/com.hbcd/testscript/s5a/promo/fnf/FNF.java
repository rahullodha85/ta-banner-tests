package com.hbcd.testscript.s5a.promo.fnf;

import com.hbcd.banner.validations.s5a.ValidatePromo;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.dataobjects.OrderSummary;

public class FNF extends ScenarioChkout {


	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		OrderSummary beforePromo = new OrderSummary();
		bag.ApplyPromo(dataObject.getPromo());
		ValidatePromo.hasPercentOff(dataObject.getPercentage(), true, beforePromo);
	}
}
