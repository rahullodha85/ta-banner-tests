package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateCC;
import com.hbcd.base.ScenarioCC;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen22 extends ScenarioCC{

	@Override
	public void executeScript() throws Exception {
		
		ccp.LoginWith("csrtest", "csrtest");
		Navigate.go(Storage.get("Saks_EmailTranslator_URL"));
		ccNav.toEmailTranslator().Search("62iNFrsD7CW4ZXXHE9RaliJaJKe2ZhI4");
		ValidateCC.hasUsername("test123@test.com");
	}

}
