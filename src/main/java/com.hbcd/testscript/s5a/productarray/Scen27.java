package com.hbcd.testscript.s5a.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen27 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		nav.SearchFor(" ");
		ValidateProductArray.isLeftHandNavOffFifthPresent("Women");
		//validate left hand nav(LHN)
	}
}
