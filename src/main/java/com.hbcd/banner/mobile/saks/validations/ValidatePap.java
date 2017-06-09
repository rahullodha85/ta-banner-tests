package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidatePap {

	public static void MismatchPasswordError(){
		
		StepLogger.validate(Check.TextPresent, "papConfPasswordWrap_WS","Password does not match");
	}
	
public static void InvalidPasswordError(){
		
		StepLogger.validate(Check.TextPresent, "papPasswordWrap_WS","Password must be at least six characters and include one number and one letter");
	}
public static void isPaymentPage(){
	StepLogger.validate(Check.ObjectPresent,"papCCNumber_WS");
}

}
