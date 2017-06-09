package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateFindInStore {

	public static void StoreResults() throws Exception{

		StepLogger.validate(Check.ObjectPresent, "pdpFinResults_WS");
		
	}
	
		
}
