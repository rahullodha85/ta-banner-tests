package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class EmailTranslator {
	public void Search(String username) throws Exception{
		
		StepLogger.validate(Check.ObjectPresent, "ccEmailTranSearchTxt_wk");
		Find.Object("ccEmailTranSearchTxt_wk").input(username);
		Find.Object("ccTranBtn_wk").click();
	}
}
