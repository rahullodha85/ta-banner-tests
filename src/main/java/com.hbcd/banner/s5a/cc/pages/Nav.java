package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Nav {
	public EmailTranslator toEmailTranslator() throws Exception {
		Navigate.go("http://qacc.saksdirect.com/contact/EmailTranslator.jsp");
		return new EmailTranslator();
	}
	public void ClickEditOrderLines() throws Exception {
		switchToContentFrame();
		Find.Object("ccNavEditOrderLines_wk").click();
		Switch.toDefaultContent();
	}
	public void ClickOrders() throws Exception {
		switchToTabFrame();
		
		StepLogger.validate(Check.ObjectPresent, "ccNavOrdersBtn_wk");
		Find.Object("ccNavOrdersBtn_wk").click();
		Switch.toDefaultContent();
	}
	public void ClickCustomers() throws Exception {
		switchToTabFrame();
		
		StepLogger.validate(Check.ObjectPresent, "ccNavCustomersBtn_wk");
		Find.Object("ccNavCustomersBtn_wk").click();
		Switch.toDefaultContent();
	}
	public void ClickCases() throws Exception {
		switchToTabFrame();		
		
		StepLogger.validate(Check.ObjectPresent, "ccNavCasesBtn_wk");
		Find.Object("ccNavCasesBtn_wk").click();
		Switch.toDefaultContent();
	}
	public void ClickCatalog() throws Exception {
		switchToTabFrame();		
		
		StepLogger.validate(Check.ObjectPresent, "ccNavCatalogBtn_wk");
		Find.Object("ccNavCatalogBtn_wk").click();
		Switch.toDefaultContent();
	}
	public CustomerAccountPage ClickMyAccount() throws Exception {
		switchToContentFrame();
		
		StepLogger.validate(Check.ObjectPresent, "ccLeftNavMyAccountBtn_wk");
		Find.Object("ccLeftNavMyAccountBtn_wk").click();
		Switch.toDefaultContent();
		return new CustomerAccountPage();
	}
	public void ClickCreateOrder() throws Exception {
		switchToContentFrame();
		Find.Object("ccLeftNavCreateOrderBtn_wk").click();
		Switch.toDefaultContent();
	}
	public void ClickCreateCase() throws Exception {
		switchToContentFrame();
		StepLogger.validate(Check.ObjectPresent, "ccLeftNavCreateCaseBtn_wk");
		Find.Object("ccLeftNavCreateCaseBtn_wk").click();
		Switch.toDefaultContent();
	}
	
	private void switchToTabFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_tabs");
	}
	private void switchToContentFrame() throws Exception {
		if(Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}
}
