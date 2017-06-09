package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateNav {
	public static void isvisibleDrpDown() throws Exception
	{ 
		Find.Object("lgnPasswordRstLbl").hover();
		
		if(Find.Object("yapAccountDrpDwn").getText().value().toLowerCase().indexOf("billing address")>=0){
			System.out.println("passed");
		}
		else System.out.println("failed");
	}
	
	public static void hasWelcomeUser(String name) throws Exception
	{
		
		if (Find.Object("navYourAccount_wk").getText().value().contains("Welcome, "+name))
	     {
	    	Report.pass("Welcome is on the page", BrowserAction.screenshot());	
	     }
	     
		else Report.fail("Welcome is NOT on the page", BrowserAction.screenshot());	
	
	}
	public static void hasDefaultCurrency(String currency) throws Exception{
		StepLogger.validate(Check.TextPresent,"contextChooserCurrency_vm",currency);
	}
	public static void hasLinks(String link) throws Exception{
		StepLogger.validate(Check.ObjectPresent,link);
	}
	public static void hasLogo() throws Exception{
		if(Find.Object("o5a_headerLogo_wk").isPresent())
			Report.pass("logo present");
		else Report.fail("logo not present");
	}
	public static void hasSignInLink() throws Exception{
		if(Find.Object("o5a_headerSignIn_wk").isPresent())
			Report.pass("Sign in Link present");
		else Report.fail("Sign In Link not present");
	}
	public static void hasInternationalShippingLink() throws Exception{
		if(Find.Object("o5a_intShippingFlag_wk").isPresent())
			Report.pass("International Shipping Link present");
		else Report.fail("Internation Shipping Link not present");
	}
}
