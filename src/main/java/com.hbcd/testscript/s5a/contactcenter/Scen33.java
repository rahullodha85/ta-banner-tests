package com.hbcd.testscript.s5a.contactcenter;

import com.hbcd.banner.validations.s5a.ValidateLl;
import com.hbcd.base.ScenarioCC;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen33 extends ScenarioCC {

	@Override
	public void executeScript() throws Exception {
//		nav.SearchFor("0476703126079");
//		pdp.AddToBag(1);
//		pdp.EnterBag();
//		bag.ClickCheckout();
//		lno.LoginLock("contact_center@s5a.com", "1221");
//		ValidateLl.isAccountLocked();
		Navigate.go(Storage.get("Saks_CC_URL"));
		ccp.LoginWith("csr_agent", "csr_agent");
		ccHome.SearchByEmail("contact_center@s5a.com");
		ccHome.UnLockAccount();
	}

}
