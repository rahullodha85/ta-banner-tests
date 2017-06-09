package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Cases {
	public void SearchByCaseNumber(String caseNumber) throws Exception {
		switchToFrame();
		Find.Object("ccCaseSearchTxt_wk").input(caseNumber);
		Find.Object("ccSearchBtn_wk").click();
		StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk", "Please enter search criteria");
		Switch.toDefaultContent();
		
	}

	private void switchToFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}
}
