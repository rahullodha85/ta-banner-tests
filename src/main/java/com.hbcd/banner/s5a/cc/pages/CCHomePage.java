package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class CCHomePage implements Page{

	public void SearchByLastName(String lastName) throws Exception {
	
		switchToFrame();
		
//		New.Object("").setProperty(PropertyType., value)
		Find.Object("ccHomeLastName_WS").input(lastName);
		StepLogger.validate(Check.ObjectPresent, "ccCustSearchBtn_WS");
		Find.Object("ccCustSearchBtn_WS").click();
		if(Find.Object("ccSearchResultsTxt_wk").isPresent()){
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk", "Please enter search criteria");	
		}
		Switch.toDefaultContent();
	}
	private void switchToFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}
	
	public void SearchByFirstName(String firstName) throws Exception {
		switchToFrame();
		Find.Object("ccHomeFirstName_WS").input(firstName);
		StepLogger.validate(Check.ObjectPresent, "ccCustSearchBtn_WS");
		Find.Object("ccCustSearchBtn_WS").click();
		if(Find.Object("ccSearchResultsTxt_wk").isPresent()){
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk", "Please enter search criteria");	
		}
		Switch.toDefaultContent();
	}
	
	public void SearchByEmail(String email) throws Exception {
		switchToFrame();
		Find.Object("ccHomeEmail_WS").input(email);
		StepLogger.validate(Check.ObjectPresent, "ccCustSearchBtn_WS");
		Find.Object("ccCustSearchBtn_WS").click();
		if(Find.Object("ccSearchResultsTxt_wk").isPresent()){
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk", "Please enter search criteria");	
		}
		Switch.toDefaultContent();
	}
	
	public void SearchByOrderNumber(String orderNumber) throws Exception {
		
		Switch.toFrame("cc_frame_content");
		Find.Object("ccHomeOrderNum_WS").input(orderNumber);
		StepLogger.validate(Check.ObjectPresent, "ccOrderSearchBtn_WS");
		Find.Object("ccOrderSearchBtn_WS").click();
		if(Find.Object("ccSearchResultsTxt_wk").isPresent()){
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk", "Please enter search criteria");	
		}
		Switch.toDefaultContent();
	}
	public void UnLockAccount() throws Exception {

		switchToFrame();
		Find.Object("ccStatusActive_WS").click();
		StepLogger.validate(Check.ObjectPresent, "ccSave");
		Find.Object("ccSave").click();
		Switch.toDefaultContent();
	}
}
