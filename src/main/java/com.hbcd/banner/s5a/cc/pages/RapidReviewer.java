package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;


public class RapidReviewer {

	public void Login(String id, String pwd) throws Exception {
		
		StepLogger.validate(Check.ObjectPresent, "rrLoginId");
		Find.Object("rrLoginId").input(id);
		Find.Object("rrPwd").input(pwd);
		StepLogger.validate(Check.ObjectPresent, "rrSignInBtn");
		Find.Object("rrSignInBtn").click();
	}
	public void SearchOrder(String orderNumber) throws Exception {
		
		StepLogger.validate(Check.ObjectPresent, "rrNavFraudAgentToolsBtn");
		Find.Object("rrNavFraudAgentToolsBtn").click();
		StepLogger.validate(Check.ObjectPresent, "rrQueuedOrdersBtn");
		Find.Object("rrQueuedOrdersBtn").click();
		StepLogger.validate(Check.ObjectPresent, "rrFindTransBtn");
		Find.Object("rrFindTransBtn").click();
		Find.Object("rrSearchData").input("00"+orderNumber);
		StepLogger.validate(Check.ObjectPresent, "rrSearchBtn");
		Thread.sleep(5000);
		if(Find.Object("rrSearchBtn").isEnabled()){
			Find.Object("rrSearchBtn").click();			
		}

	}
	public void ApproveOrder() throws Exception {
				Thread.sleep(5000);
				Find.Object("rrOrderResolveDrpdwn").select(1);
				StepLogger.validate(Check.ObjectPresent, "rrOrderResolveBtn");
				Thread.sleep(5000);
				Find.Object("rrOrderResolveBtn").click();
	}
	

}
