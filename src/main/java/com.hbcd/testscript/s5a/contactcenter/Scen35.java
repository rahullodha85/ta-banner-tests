package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen35 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {
		
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csrtest", "csrtest");
		ccNav.ClickCreateCase();
		
	}

}
