package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.Assert;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateLogin {

	public static void hasSignInCheckOutButton(){
		
		StepLogger.validate(Check.ObjectPresent, "loginSignCheckOutBtn_wk");
	}
	
	public static void hasGuestCheckOutButton() {
		StepLogger.validate(Check.ObjectPresent, "loginOverlayCheckoutAsGuestBtn_wk");
		
	}
	
	public static void hasInvalidEmailError()throws Exception {
		Assert.Report("The Error Message has been Highlighted").isExist("loginOverlayInvalidEmail_WS");
		//StepLogger.validate(Check.TextPresent, "loginOverlayInvalidEmail_WS","The email address or password you have entered is not valid. Please check both trying again or click on Forget Password.");
		/*StepLogger.validate(Check.TextPresent, "loginOverlayInvalidEmail_WS","Must have an \"@\"");
		StepLogger.validate(Check.TextPresent, "loginOverlayInvalidEmail_WS","Must have atleast 1 character before the @ sign");
		StepLogger.validate(Check.TextPresent, "loginOverlayInvalidEmail_WS","Must have atleast two characters after the @ sign and before the \".\"");
		StepLogger.validate(Check.TextPresent, "loginOverlayInvalidEmail_WS","Mist have alteast two characters after the \".\"");
		StepLogger.validate(Check.TextPresent, "Sample> x@xx.xx");*/
	}

	public static void hasEmailTextBox() throws Exception{
		if (Find.Object("bagLoginEmailTxt").isPresent()){
			Report.pass("Email Text Box is Present", BrowserAction.screenshot());
		}else{
			Report.fail("Email Text Box is NOT Present",BrowserAction.screenshot());
		}
	}

	public static void hasPasswordTextBox()throws Exception{
		if (Find.Object("bagLoginPassTxt").isPresent()){
			Report.pass("Password Text Box is Present",BrowserAction.screenshot());
		}else{
			Report.fail("Password Text Box is NOT Present",BrowserAction.screenshot());
		}

	}
	public static void hasSignInAndCheckoutBtn(){
		StepLogger.validate(Check.ObjectPresent, "bagSignInBtn");
	}

	public static void hasForgotPasswordLink(){
		StepLogger.validate(Check.ObjectPresent, "lgnForgotPwd_WS");
	}

	public static void hasSignInButtonEnabled() throws Exception {

		if(Find.Object("bagSignInBtn").isEnabled())
			Report.pass("Sign In button is enabled");
		else
			Report.pass("Sign In button is NOT enabled");

	}
}
