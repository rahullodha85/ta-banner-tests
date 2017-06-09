package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen09 extends ScenarioMobileSaks{
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0427915085753");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.MakeGift("0427915085753").With("hello world", "bye", "white wrap"); //add validation into method for gift overlay 
	}
}
