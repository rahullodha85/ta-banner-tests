package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Customers implements Page{
	public void SearchByUserId(String username) throws Exception {
		switchToFrame();
		Find.Object("ccCustUsernameSearchTxt_wk").input(username);
		
		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");
		Find.Object("ccSearchBtn_wk").click();
//		StepLogger.validate(Check.TextNotPresent, "ccFrameId_wk", "Please enter search criteria and click Search.");
		Switch.toDefaultContent();
	}
	public void SearchByLastname(String lastName) throws Exception {
		switchToFrame();
		Find.Object("ccCustLastnameSearchTxt_wk").input(lastName);
		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");
		Find.Object("ccSearchBtn_wk").click();
		if(Find.Object("ccFrameId_wk").isPresent()){
		StepLogger.validate(Check.TextNotPresent, "ccFrameId_wk", "Please enter search criteria and click Search");
		}
		Switch.toDefaultContent();
	}
	public void SearchByCustomerNumber(String customerNumber) throws Exception {
		switchToFrame();
		Find.Object("ccCustNumberSearchTxt_wk").input(customerNumber);
		
		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");
		Find.Object("ccSearchBtn_wk").click();
		if(Find.Object("ccFrameId_wk").isPresent()){
		
			StepLogger.validate(Check.TextNotPresent, "ccFrameId_wk", "Please enter search criteria and click Search");
		}
		
		Switch.toDefaultContent();
	}
	public void ChangeEmailPw(String password) throws Exception {
		switchToFrame();
		
		StepLogger.validate(Check.ObjectPresent, "ccCustomerClickPasswordChangeBtn_wk");
		Find.Object("ccCustomerClickPasswordChangeBtn_wk").click();
		Switch.toNewWindow("E-mail New Password");
		Find.Object("ccCustomerChangePasswordTxt_wk").input(password);
		Find.Object("ccCustomerConfirmPasswordTxt_wk").input(password);
		
		StepLogger.validate(Check.ObjectPresent, "ccCustomerSendPasswordBtn_wk");
		Find.Object("ccCustomerSendPasswordBtn_wk").click();
//		Switch.toDefaultContent();
		Switch.toNewWindow("Contact Center");
	}
	
	public void SearchByCustomerEmail(String customerEmail) throws Exception {
		switchToFrame();
		Find.Object("ccCustEmailSearchTxt").input(customerEmail);
		Find.Object("ccSearchBtn_wk").click();
		if(Find.Object("ccFrameId_wk").isPresent()){
		StepLogger.validate(Check.TextNotPresent, "ccFrameId_wk", "Please enter search criteria and click Search.");
		}
		Switch.toDefaultContent();
	}
	private void switchToFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}
}
