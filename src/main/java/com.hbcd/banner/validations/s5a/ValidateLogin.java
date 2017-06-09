package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.Find;

public class ValidateLogin {

	public static void isPasswordReset() throws Exception {
		if (Find.Object("lgnPasswordRstLbl")
				.getText()
				.value()
				.toLowerCase()
				.indexOf(
						"includes a time-sensitive link to reset your password") >= 0) {
			System.out.println("true");
		} else
			System.out.println("false");
	}

	public static void isInvalidEmail() throws Exception {
		if (Find.Object("lgnPasswordRstLbl")
				.getText()
				.value()
				.toLowerCase()
				.indexOf(
						" unable to reset the password for this account online") >= 0) {
			System.out.println("true");
		} else
			System.out.println("false");
	}

	public static void isValidEmail() throws Exception {
		isPasswordReset();
	}

	public static void hasNonExistingAccountError() throws Exception {
		System.out
				.println(Find.Object("bagoEmailErrorTxt_wk").getText().value()
						.contains("Please enter a valid email address.") ? "pass"
						: "fail");
	}

	public static void hasEmptyPasswordError() throws Exception {
		System.out
				.println(Find
						.Object("bagoPasswordErrorTxt_wk")
						.getText()
						.value()
						.contains(
								"Please enter your account password. Note: Passwords are case sensitive") ? "pass"
						: "fail");
	}

	public static void hasNoCredentialsError() throws Exception {
		hasNonExistingAccountError();
		hasEmptyPasswordError();
	}

	public static void hasInvalidPasswordError() throws Exception {
		System.out
				.println(Find
						.Object("bagoPasswordErrorTxt_wk")
						.getText()
						.value()
						.contains(
								"The e-mail address and/or password entered do not match a registered saks.com account.") ? "pass"
						: "fail");
	}

	public static void hasInvalidEmailError() throws Exception {
		System.out
				.println(Find
						.Object("bagoEmailErrorTxt_wk")
						.getText()
						.value()
						.contains(
								"The e-mail address and/or password entered do not match a registered saks.com account.") ? "pass"
						: "fail");
	}

	public static void hasForgotPassword() throws Exception {
		System.out
				.println(Find.Object("bagoForgotPasswordBtn_wk").isPresent() ? "pass"
						: "fail");
	}

	public static void hasTopErrorMsg() throws Exception {
		System.out.println(Find.Object("bagoTopError").isPresent() ? "pass"
				: "fail");
	}

	public static void hasUnregEmailError() throws Exception {
		System.out.println(Find.Object("bagoUnregError").isPresent() ? "pass"
				: "fail");
	}

	public static void hasLockedAccountError() throws Exception {
		System.out.println(Find.Object("bagoEmailErrorTxt_wk").getText()
				.value().contains("locked out") ? "pass" : "fail");
	}

}
