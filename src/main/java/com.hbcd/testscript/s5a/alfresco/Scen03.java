package com.hbcd.testscript.s5a.alfresco;

import com.hbcd.banner.saks.alfresco.SaksAlfresco_Parameter;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.base.ScenarioAlfresco;

public class Scen03 extends ScenarioAlfresco {

	@Override
	public void executeScript() throws Exception {
	
		SaksAlfresco_Parameter sp = new SaksAlfresco_Parameter();
		sp.handle("page/testpa/paPage");
		
	}

}
