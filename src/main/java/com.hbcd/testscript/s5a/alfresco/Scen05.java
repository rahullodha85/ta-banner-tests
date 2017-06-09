package com.hbcd.testscript.s5a.alfresco;

import com.hbcd.banner.saks.alfresco.SaksAlfresco_Parameter;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.base.ScenarioAlfresco;

public class Scen05 extends ScenarioAlfresco{

	@Override
	public void executeScript() throws Exception {

		SaksAlfresco_Parameter sp = new SaksAlfresco_Parameter();
		sp.handle("page/1408474395261685/sbdPage");
		
	}

}
