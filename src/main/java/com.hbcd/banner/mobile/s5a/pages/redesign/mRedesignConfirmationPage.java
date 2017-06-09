package com.hbcd.banner.mobile.s5a.pages.redesign;

import com.hbcd.banner.mobile.saks.pages.mConfirmationPage;
import com.hbcd.commonbanner.pages.ConfirmationPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mRedesignConfirmationPage extends mConfirmationPage implements ConfirmationPage{
	
	@Override
	public void CreateAccount() throws Exception {
		
		Find.Object("confPasswordTxt_wk").clear();
		Find.Object("confPasswordTxt_wk").input("test123");
		Find.Object("confVerifyPasswordTxt_wk").clear();
		Find.Object("confVerifyPasswordTxt_wk").input("test123");
		StepLogger.validate(Check.ObjectPresent, "confCreateAccountBtn_wk");
		Find.Object("confCreateAccountBtn_wk").click();
	}
	
	public void GoToYourAccount() throws Exception{
		StepLogger.validate(Check.ObjectPresent, "confGoToYourAccountBtn_WS");
		Find.Object("confGoToYourAccountBtn_WS").click();
	}
	
	public void EnterPassword(String createPwd, String verifyPwd) throws Exception {
		StepLogger.validate(Check.ObjectPresent, "confPasswordTxt_wk");
		Find.Object("confPasswordTxt_wk").clear();
		Find.Object("confPasswordTxt_wk").input(createPwd);
		Find.Object("confVerifyPasswordTxt_wk").clear();
		Find.Object("confVerifyPasswordTxt_wk").input(verifyPwd);
		StepLogger.validate(Check.ObjectPresent, "confVerifyPasswordTxt_wk");
		Find.Object("confCreateAccountBtn_wk").click();
	}

}
