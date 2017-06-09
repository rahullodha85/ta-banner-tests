package com.hbcd.banner.common.paypal;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class pLogin {

	public void LoginWithPaypal(String username, String password) throws Exception {
		Thread.sleep(9000); /*Added to conunter instability for O5M*/
		Switch.toDefaultContent();
		Switch.toFrame(1);
		//StepLogger.validate(Check.ObjectPresent, "bagLoginEmailPaypalTxt");
		if(Find.Object("bagLoginEmailPaypalTxt").isPresent()) {
			Find.Object("bagLoginEmailPaypalTxt").clear();
			Find.Object("bagLoginEmailPaypalTxt").input(username);
			Find.Object("bagLoginPassPaypalTxt").clear();
			Find.Object("bagLoginPassPaypalTxt").input(password);
			StepLogger.validate(Check.ObjectPresent, "bagSignInPaypalBtn");
			Find.Object("bagSignInPaypalBtn").click();
		}
		Switch.toDefaultContent();
		if (Find.Object("bagLoginEmailPaypalTxtOld").isPresent()){

			Find.Object("bagLoginEmailPaypalTxtOld").clear();
			Find.Object("bagLoginEmailPaypalTxtOld").input(username);
			Find.Object("bagLoginPassPaypalTxtOld").clear();
			Find.Object("bagLoginPassPaypalTxtOld").input(password);
			StepLogger.validate(Check.ObjectPresent, "bagSignInPaypalBtnOld");
			Find.Object("bagSignInPaypalBtnOld").click();
		}
		Thread.sleep(2000);
		if(Find.Object("pplLoginBox_WS").isPresent()){

			if(Find.Object("pplLoginBox_WS").getText().value().contains("Please make sure you have entered your email address correctly") ||
			Find.Object("pplLoginBox_WS").getText().value().contains("Please re-enter your PayPal password")){
				Report.dataFail("Email/Password entered incorrectly", BrowserAction.screenshot());
			}
		}

		}
	
	public void ClickPayWithMyPaypalAcc() throws Exception{

		Thread.sleep(2000L);
		if(Find.Object("pplBody_WS").isPresent()){
			StepLogger.validate(Check.ObjectPresent, "pPaywithmyPaypalBtn");
			Find.Object("pPaywithmyPaypalBtn").click();	
		}
		
		
	}
}
