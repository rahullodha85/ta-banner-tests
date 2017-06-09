package com.hbcd.testscript.mobile.off5th;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

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
