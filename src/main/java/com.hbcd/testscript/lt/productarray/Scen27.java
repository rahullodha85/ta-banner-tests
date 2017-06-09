package com.hbcd.testscript.lt.productarray;

import com.hbcd.banner.validations.s5a.ValidateProductArray;
import com.hbcd.base.ScenarioChkout;

public class Scen27 extends ScenarioChkout{
	//Saks Nightly: Included
	public void executeScript() throws Exception {
		//check with mehrain
		nav.SearchFor(" ");
		ValidateProductArray.isLeftHandNavOffFifthPresent("Women");
		//validate left hand nav(LHN)
	}
}
