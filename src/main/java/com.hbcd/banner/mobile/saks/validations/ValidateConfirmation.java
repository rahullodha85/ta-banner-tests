package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Update;
import com.hbcd.scripting.core.fluentInterface.ObjectAction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateConfirmation {
	private static boolean newToggle = false;
	public static void setToggleStatus(boolean status){
		newToggle = status;
	}
	public static void isThankyouPage() throws Exception {

		StepLogger.validate(Check.TextPresent, "confirmOrder", "Order #");

		if ((Find.Object("confirmOrder").getText().value()).contains("Order #")) {
			Report.pass("Thank You Page present", BrowserAction.screenshot());
		} else {
			Report.fail("Thank You Page missing", BrowserAction.screenshot());
		}
	}

	public static void GiftWrap(String giftBox, String sku) throws Exception {

		String txt = Find.Object("confGiftWrapMsg_WS").changeContainsText(sku)
				.getText().value();

		if (txt.toLowerCase().contains(giftBox.toLowerCase())) {
			Report.pass("Gift Wrap Present", BrowserAction.screenshot());
		} else {
			Report.fail("Gift Wrap Absent", BrowserAction.screenshot());
		}

	}

	public static void hasAccountCreationBox() {
		if (newToggle)
			StepLogger.validate(Check.ObjectPresent,
					"confAccountCreationBox_wk");
	}

	
	public static void hasAccountBoxErrorMsg(String msg) {
		if (newToggle)
			StepLogger.validate(Check.TextPresent, "confAccountCreationBox_wk", "Please check the error(s) highlighted below");
	}

	public static void hasPasswordDoesnotMatchError() {

		if (newToggle)
			StepLogger.validate(Check.TextPresent, "papConfPasswordWrap_WS",
					"Password does not match");
	}

	public static void hasInvalidPasswordError() {

		if (newToggle)
			StepLogger
					.validate(
							Check.TextPresent,
							"confAccountCreationBox_wk",
							"Password must be at least six characters and include one number and one letter.");
	}
	
	public static void hasUnabletoCreateError(){
		if (newToggle)
			StepLogger
					.validate(
							Check.TextPresent,
							"confAccountBoxMsg_wk",
							"We're sorry, we're unable to create your account at this time.");
	}
	public static void hasOrderNumber() throws Exception{
		if(Find.Object("confirmOrder").isPresent())
			StepLogger.validate(Check.TextPresent, "confirmOrder", "Order #");
		else Report.systemFail("Confirmation page taking too long", BrowserAction.screenshot());
	}
	public static void PaymentSectionHas(String searchString) throws Exception {

		if(Find.Object("confPaymentMode_WS").getText().value().contains(searchString))
			Report.pass(searchString+" is present in the Payment section ", BrowserAction.screenshot());
		else
			Report.fail(searchString+" is NOT present in the Payment section ", BrowserAction.screenshot());
		
	}
}
