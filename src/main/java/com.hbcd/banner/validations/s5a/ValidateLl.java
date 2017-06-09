package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.Find;

public class ValidateLl {

	public static void isEmailValid() throws Exception {
		if(Find.Object("ErrorMessageLogin").getText().value().toLowerCase().indexOf("enter a valid email")>=0){
			System.out.println("pass");
		}
		else System.out.println("fail");
		
	}
	public static void isAccountLocked() throws Exception {
		if(Find.Object("loAccountLocked").getText().value().toLowerCase().indexOf("locked")>=0){
			System.out.println("pass");
		}
		else System.out.println("fail");
		
	}

}
