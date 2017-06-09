package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class CustomerAccountPage {
	public static void with(String username) throws Exception {
		Switch.toNewWindow("Saks.com");
			
		Find.Object("ccCustomerAccountLoginUsernameTxt_wk").input(username);
		StepLogger.validate(Check.ObjectPresent, "ccCustomerAccountLoginBtn_wk");
		Find.Object("ccCustomerAccountLoginBtn_wk").click();
	
		if(Find.Object("BagInternationalCheckoutBtn").isPresent())
		StepLogger.validate(Check.TextNotPresent, "BagInternationalCheckoutBtn", "account information");
	}
	
public static void click() throws Exception {
		
		
		Find.Object("vTest").click();
		StepLogger.validate(Check.ObjectPresent, "ccCustomerAccountLoginBtn_wk");
		Find.Object("ccCustomerAccountLoginBtn_wk").click();
	}
}
