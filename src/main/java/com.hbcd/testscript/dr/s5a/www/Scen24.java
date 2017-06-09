package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen24 extends ScenarioSaks{

	//  Add to Bag from Quick Look and bag items validation

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0427989892035 ");
		prp.ClickFirstQuickLook();
		qlo.AddToBag(1);
		pdp.EnterBag();
		ValidateBag.hasBrandName("Kiehl's Since 1851");
		ValidateBag.validateSaksBagItems("Cucumber Toner");
		ValidateBag.validateSaksBagItems("8.4 OZ.");
		ValidateBag.validateSaksBagItems("Edit");
		ValidateBag.hasQuantity("0427989892035","1");

	}
}
