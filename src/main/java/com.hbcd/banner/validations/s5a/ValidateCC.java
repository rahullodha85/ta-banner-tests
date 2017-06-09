package com.hbcd.banner.validations.s5a;

import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateCC {
	public static void hasResult(String expectedResult) throws Exception {
		switchToFrame();
		
			System.out.println(Find.Object("ccResults_WS").getText().value());
			
			if(Find.Object("ccResults_WS").getText().value().contains(expectedResult))
				Report.pass(expectedResult+" is present", BrowserAction.screenshot());
			else
				Report.fail(expectedResult+" is NOT present", BrowserAction.screenshot());
			Switch.toDefaultContent();	
		
	}

	public static void hasCrumb(String crumb) throws Exception {
		switchToFrame();
		StepLogger.validate(Check.TextPresent, "ccCatalogAllCrumbs_WS", crumb);
		Switch.toDefaultContent();
	}

	public static void hasUsername(String username) throws Exception {
		switchToFrame();
		StepLogger.validate(Check.TextPresent, "ccEmailTranResultsTxt_wk",
				username);
		Switch.toDefaultContent();
	}

	private static void switchToFrame() throws Exception {
		if (Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}

	public static void checkStatus(String status) throws Exception {
		switchToFrame();
		StepLogger.validate(Check.TextPresent, "ccOrderStatus_wk", status);
		Switch.toDefaultContent();
	}

	public static void RapidReviewerOrderStatus() throws Exception {

		StepLogger.validate(Check.TextPresent, "rrBody","Transaction resolved: Approve");

		if (Find.Object("rrBody").getText().value()
				.contains("Transaction resolved: Approve")) {

			System.out.println("OrderPage Resolved Successfully.Validation Pass");
		}
	}

	public static void hasOrderInformation() throws Exception {
		switchToFrame();

		StepLogger.validate(Check.ObjectPresent, "ccOrderInformation");
		
	}

	public static void hasProductDetails(String string) throws Exception {
		switchToFrame();
		StepLogger.validate(Check.TextPresent, "ccProductDetails", string);
		Switch.toDefaultContent();
	}

	public static void ValidateStoreFlag() throws Exception {
		switchToFrame();
//		String txt = New.Object("").setProperty(PropertyType.TAG_NAME, "tbody")
//				.setProperty(PropertyIntType.iTH, 1).getAttribute("outerHTML")
//				.value();
//		System.out.println(txt);
		System.out.println(Find.Object("ccStoteFlag_WS").getAttribute("outerHTML").value());
		if (Find.Object("ccStoteFlag_WS").getAttribute("outerHTML").value().contains("Store Fulfilled:</b> Y")) {
			Report.pass("Store Fulfilled is Y", BrowserAction.screenshot());
		} else {
			Report.fail("Store Fulfilled is N", BrowserAction.screenshot());
		}
		Switch.toDefaultContent();
	}

	public static void hasOrderHistory(String orderNumber) throws Exception {
		switchToFrame();

		StepLogger.validate(Check.ObjectPresent, "ccOrderHistoryTable");
		if (Find.Object("ccOrderHistoryTable").getText().value()
				.indexOf(orderNumber) >= 0)
			Report.pass("OrderPage History Table", BrowserAction.screenshot());
		else
			Report.fail("OrderPage History Table", BrowserAction.screenshot());
		Switch.toDefaultContent();
	}

	public static void hasOrderLog(String orderNumber) throws Exception {
		Switch.toNewWindow("OrderPage Log");

		StepLogger.validate(Check.ObjectPresent, "ccOrderLogTable");
		
		StepLogger.validate(Check.TextPresent, "ccOrderLogTable",orderNumber);
		
		if (Find.Object("ccOrderLogTable").getText().value()
				.indexOf(orderNumber) >= 0)
			Report.pass("OrderPage log order number", BrowserAction.screenshot());
		else
			Report.fail("OrderPage log order number", BrowserAction.screenshot());
		Switch.toNewWindow("Contact Center");
	}

	public static void hasEmailHistory(String orderNumber) throws Exception {
		
		Switch.toNewWindow("Email History");

		StepLogger.validate(Check.ObjectPresent, "ccEmailHistory_WS");
		StepLogger.validate(Check.TextPresent, "ccEmailHistory_WS","Email History");
		Switch.toNewWindow("Contact Center");
	}

	public static void ValidateOrderHistory() throws Exception {
		switchToFrame();
		String txt = New
				.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[id='idContentContainer']")
				.setProperty(PropertyType.CONTAINS_TEXT, "OrderPage History")
				.getText().value();
		if (txt.contains("Status")) {
			System.out.println("OrderPage History displayed successfully");
		} else {
			System.out.println("OrderPage History NOT displayed ");
		}
		Switch.toDefaultContent();
	}

	public static void ValidateEmailHistory() throws Exception {
		Switch.toNewWindow("Email History");
		if (New.Object("").setProperty(PropertyType.TAG_NAME, "body").getText()
				.value().contains("Email History")) {
			System.out.println("Email History Validation Pass");
		} else {
			System.out.println("Email History Validation Fail");
		}
		Switch.toDefaultContent();
	}

	public static void hasStoreFlagSet() {
	}

	public static void ValidateCustomerProfile(String customerEmail)
			throws Exception {
		switchToFrame();

		StepLogger.validate(Check.ObjectPresent, "ccCustProfileHeader");
		if (Find.Object("ccCustProfileHeader").getText().value()
				.contains(customerEmail)
				&& Find.Object("ccCustProfileHeader").getText().value()
						.contains("Customer Details")) {
			Report.pass("Validation Pass", BrowserAction.screenshot());
		} else {
			Report.fail("Validation Fail", BrowserAction.screenshot());
		}
		Switch.toDefaultContent();
	}

	public static void ValidateCustomerBillingAddress(String customerAddress1,
			String city, String stateZip, String country, String phone,
			String email, String name) throws Exception {
		switchToFrame();
		if (Find.Object("ccOrderAddress").getText().value()
				.contains(customerAddress1)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(city)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(stateZip)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(country)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(phone)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(email)
				&& Find.Object("ccOrderAddress").getText().value()
						.contains(name)) {

			System.out.println("Billing Address Validation is Passed");
		} else {
			System.out.println("Billing Address Validation is Failed");
		}
		Switch.toDefaultContent();
	}

	/*** Enter any number of comparison texts seperated by comma */

	public static void ValidateTextonOrderSummary(String... comparisonText)
			throws Exception {

		Switch.toFrame("cc_frame_content");

		for (int i = 0; i < comparisonText.length; i++) {
			StepLogger.validate(Check.TextPresent, "ccOrderSummary_WS",
					comparisonText[i]);

			if (Find.Object("ccOrderSummary_WS").getText().value()
					.toLowerCase().contains(comparisonText[i])) {

				System.out.println("Pass");
			} else {

				System.out.println("Fail");
			}
		}

	}

}
