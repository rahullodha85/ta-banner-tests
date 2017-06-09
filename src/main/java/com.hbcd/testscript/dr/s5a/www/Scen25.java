package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen25 extends ScenarioSaks{

	@Override
	public void executeScript()  throws Exception {

		nav.SearchFor("0476971482418");
		pdp.AddToBag(3);
		ValidateBag.hasItemInBagOverLay();
		ValidateBag.validateCheckoutButtonAndViewMyLink();
	}
}
