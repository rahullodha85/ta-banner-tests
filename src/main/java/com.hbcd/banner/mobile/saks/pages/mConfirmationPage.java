package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mConfirmationPage implements ConfirmationPage{




	@Override
	public void CancelOrder() throws Exception {
		Find.Object("confCancelOrder_WS").click();
	}

	@Override
	public void CreateAccount() throws Exception {
		
	
	}

	@Override
	public void GoToYourAccount() throws Exception {
	
		
	}

	@Override
	public void EnterPassword(String createPwd, String verifyPwd)
			throws Exception {

	}

	@Override
	public void CheckConfirmation() throws Exception {

	}

	@Override
	public void ClickPrintReceipt() throws Exception {

	}
}
