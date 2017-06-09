package com.hbcd.testscript.off5th.pdp;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen10 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(InputData.get("regular").value());
		ValidateAemPdp.FBlink();
		ValidateAemPdp.PinItlink();
		ValidateAemPdp.TwitterLink();
		ValidateAemPdp.GooglePlusLink();
		ValidateAemPdp.EmailLink();
	}
}
