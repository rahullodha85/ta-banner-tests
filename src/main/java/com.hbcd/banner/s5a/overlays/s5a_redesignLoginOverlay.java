package com.hbcd.banner.s5a.overlays;

import com.hbcd.commonbanner.pages.BrandsListPage;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class s5a_redesignLoginOverlay extends s5a_LoginOverlay{
	@Override
	public void LoginWith(String useless) throws Exception{

		if (Find.Object("loginOverlayCheckoutAsGuestBtn_wk").isPresent()){
			Report.pass("User Clicks on Login Overlay UnRegisterCheckout Button as Guest", BrowserAction.screenshot());
		}else{
			Report.fail("Login Overlay UnRegisterCheckout Button as Guest is NOT Present",BrowserAction.screenshot());
		}
		Find.Object("loginOverlayCheckoutAsGuestBtn_wk").click();
		Thread.sleep(2000);
	}
}
