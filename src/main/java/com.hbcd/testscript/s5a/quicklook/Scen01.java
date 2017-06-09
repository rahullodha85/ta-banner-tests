package com.hbcd.testscript.s5a.quicklook;

import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;

public class Scen01 extends ScenarioSaks{

	//Checkout  -  Item is in Stock on the Web and in Store
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickEditFor("0428743782846");
		ValidateQL.isQLViewProductDetailLink();
	}

}