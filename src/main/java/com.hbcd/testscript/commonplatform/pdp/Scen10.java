package com.hbcd.testscript.commonplatform.pdp;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen10 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		String regularItem = itemData.get(ItemType.REGULAR);

		nav.SearchFor(regularItem);
		ValidateAemPdp.FBlink();
		ValidateAemPdp.PinItlink();
		ValidateAemPdp.TwitterLink();
		ValidateAemPdp.GooglePlusLink();
		ValidateAemPdp.EmailLink();
	}


}
