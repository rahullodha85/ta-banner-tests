package com.hbcd.testscript.s5a.quicklook;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.testdata.s5a.QuickLookData;
import org.apache.commons.lang.Validate;


public class Scen10 extends ScenarioSaks {

	//Checkout - Edit Item Rendering
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickEditFor("0428793785004");
		ValidateBag.isQuickLookOverlay();
	}

}
