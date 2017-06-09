package com.hbcd.testscript.mobile.s5a;


import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen29 extends ScenarioMobileSaks{

	@Override
	public void executeScript() throws Exception {

		String item1 = dataObject.getSkuListInfo().get(0);
		String item2 = dataObject.getSkuListInfo().get(1);
		String item3 = dataObject.getSkuListInfo().get(2);

		nav.SearchFor(item1);
		ValidatePrp.ValidateBreadCrumb(item1);
		nav.EnterPrp(item1);
		ValidatePrp.ValidateBreadCrumb(item1);
		prp.ClickBreadcrum(item2);
		ValidatePrp.ValidateBreadCrumb(item2);
	}

}
