package com.hbcd.banner.validations.s5a.mobile;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class ValidateNav {
	public static void hasSearchPredict(String input) throws Exception{
		Find.Object("SearchItemFieldTxtBx").clear();
		Find.Object("SearchItemFieldTxtBx").input(input);
		Thread.sleep(3000L);
		if(Find.Object("searchPredictBox_wk").getAttribute("innerHTML").value().contains("ul hidden=")){
			Report.fail("Predictive Search Not Shown: "+ input.length() + " characters", BrowserAction.screenshot());
		}else Report.pass("Predictive Search Shown: "+ input.length() + " characters", BrowserAction.screenshot());
	}
	public static void doesNotHaveSearchPredict(String input) throws Exception{
		Find.Object("SearchItemFieldTxtBx").clear();
		Find.Object("SearchItemFieldTxtBx").input(input);
		Thread.sleep(3000L);
		if(Find.Object("searchPredictBox_wk").getAttribute("innerHTML").value().contains("hidden")){
			Report.pass("Predictive Search Not shown: "+ input.length() + " characters", BrowserAction.screenshot());
		}else Report.fail("Predictive Search Shown: "+ input.length() + " characters", BrowserAction.screenshot());
	}
	public static void clearSearchWithX(String input) throws Exception{
		Find.Object("SearchItemFieldTxtBx").clear();
		Find.Object("SearchItemFieldTxtBx").input(input);
		Thread.sleep(1000L);
		Find.Object("searchCancelBtn_wk").click();
		if(Find.Object("SearchItemFieldTxtBx").getText().value().isEmpty()){
			Report.pass("Search Box cleared", BrowserAction.screenshot());
		}else Report.fail("Search Box not cleared", BrowserAction.screenshot());
	}
}
