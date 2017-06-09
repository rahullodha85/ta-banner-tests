package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateRs {

	public static void ValidateShippingAddressContains(String address)
			throws Exception {

		StepLogger
				.validate(Check.TextPresent, "rspShippingAddSection", address);

		if (Find.Object("rspShippingAddSection").getText().value()
				.contains(address)) {

			System.out.println("Shipping Address validation Pass");
		}
	}

	public static void ValidateBillingAddressContains(String address)
			throws Exception {

		StepLogger.validate(Check.TextPresent, "rspBillingAddSection", address);

		if (Find.Object("rspBillingAddSection").getText().value()
				.contains(address)) {

			System.out.println("Billing Address validation Pass");
		}
	}

	public static void UpgradeShippingMessage() throws Exception {

		if (Find.Object("rspAddressLevelShippingMethod_WS").getText().value()
				.contains("All eligible items have been upgraded to ship via"))
			Report.pass("UpgrageShippingMessage is displayed",
					BrowserAction.screenshot());
		else
			Report.fail("UpgrageShippingMessage is NOT displayed",
					BrowserAction.screenshot());

	}

	public static void ShippingMethod(String itemNumber, String shpMethod)
			throws Exception {

		if (Find.Object("rspItemRow_WS").changeContainsText(itemNumber)
				.getText().value().contains(shpMethod))
			Report.pass("ShippingMethod validation Pass",
					BrowserAction.screenshot());
		else
			Report.fail("ShippingMethod validation Fail",
					BrowserAction.screenshot());
	}

	public static void ToolTipShippingRestrictionMsg(String itemNumber)
			throws Exception {

		Thread.sleep(6000);
		if (Find.Object("rspItemRow_WS")
				.changeContainsText(itemNumber)
				.getText()
				.value()
				.contains(
						"Because of certain shipping restrictions, this item can only ship via this method"))
			Report.pass("Tool Tip Shipping Restriction message PASS",
					BrowserAction.screenshot());
		else
			Report.fail("Tool Tip Shipping Restriction message FAIL",
					BrowserAction.screenshot());

	}

	public static void ShippingRestrictionMessage() throws Exception {
		if (Find.Object("rspAddressLevelShippingMethod_WS").getText().value()
				.contains("Some item(s) cannot ship via "))
			Report.pass("ShippingRestrictionMessage is displayed",
					BrowserAction.screenshot());
		else
			Report.pass("ShippingRestrictionMessage is NOT displayed",
					BrowserAction.screenshot());

	}

	public static void ShippingMethodSpeedAndCost(String shpMethod)
			throws Exception {

		if (shpMethod.toLowerCase().contains("next bus")) {
			if (Find.Object("rspAddressLevelShippingMethod_WS").getText()
					.value().contains("Next Bus. Day (1 business day) - $"))
				Report.pass("Shipping speed is Next Bus. Day (1 business day)",
						BrowserAction.screenshot());
			else
				Report.fail(
						"Shipping speed is NOT Next Bus. Day (1 business day)",
						BrowserAction.screenshot());
		}

		else if (shpMethod.toLowerCase().contains("saturday")) {
			if (Find.Object("rspAddressLevelShippingMethod_WS").getText()
					.value().contains("Saturday (Saturday) - $"))
				Report.pass("Shipping speed is Saturday",
						BrowserAction.screenshot());
			else
				Report.fail("Shipping speed is NOT Saturday",
						BrowserAction.screenshot());
		}
	}

	public static void DropshipShippingRestrictionMsg() throws Exception {

		if (Find.Object("rspDropshipShpRestrictMsg_WS")
				.getText()
				.value()
				.contains(
						"The following items in your order cannot be shipped to a P.O. Box., a U.S. Territory or Military Address. Please remove the item in your "))
			Report.pass(
					"Dropship Shipping Restriction Message validation Pass",
					BrowserAction.screenshot());
		else
			Report.fail(
					"Dropship Shipping Restriction Message validation Fail",
					BrowserAction.screenshot());

	}

	public static void ShippingCharges(String shpMethodSelected) throws Exception {

		if(shpMethodSelected.toLowerCase().contains("standard")){
		
			if(Find.Object("rspTotalShippingCost_WS").getText().value().contains("$7.99"))
					Report.pass("Standard Shipping costs displayed correctly", BrowserAction.screenshot());
			else
				Report.fail("Standard Shipping costs displayed incorrectly", BrowserAction.screenshot());
		}
		
		else if(shpMethodSelected.toLowerCase().contains("rush")){
			
			if(Find.Object("rspTotalShippingCost_WS").getText().value().contains("$14.99"))
					Report.pass("Standard Shipping costs displayed correctly", BrowserAction.screenshot());
			else
				Report.fail("Standard Shipping costs displayed incorrectly", BrowserAction.screenshot());
		}
		
		else if(shpMethodSelected.toLowerCase().contains("next bus")){
			
			if(Find.Object("rspTotalShippingCost_WS").getText().value().contains("$24.99"))
					Report.pass("Standard Shipping costs displayed correctly", BrowserAction.screenshot());
			else
				Report.fail("Standard Shipping costs displayed incorrectly", BrowserAction.screenshot());
		}
		else if(shpMethodSelected.toLowerCase().contains("saturday")){
			
			if(Find.Object("rspTotalShippingCost_WS").getText().value().contains("$34.99"))
					Report.pass("Standard Shipping costs displayed correctly", BrowserAction.screenshot());
			else
				Report.fail("Standard Shipping costs displayed incorrectly", BrowserAction.screenshot());
		}
	}

	public static void EstimatedDeliveryDate() {
		StepLogger.validate(Check.ObjectPresent,"rspEstDeliveryDate_WS");
		
	}
	public static void hasShippingMethodUpdated(String shippingMethod)
	{

	}

	public static void hasChangedShippingAddress(String address) throws Exception{
		if (Find.Object("changedShippingAddress_AAF").isPresent()){
		  	Report.pass("The Address That User Changed is: " + address);
		}else{
			Report.fail("Changed Address is UNAVAILABLE");
		}
	}

	public static void hasApplyButtonAvailable() throws Exception{
		if (Find.Object("applyButtonOnRs_AAF").isPresent()){
			Report.pass("Apply Button is Present");
		}else{
			Report.fail("Apply Button is NOT Present");
		}
	}

	public static void hasGiftCardNumberDisplayed()throws Exception{

		if (Find.Object("mobileGiftCard_AAF").isPresent()){
			Report.pass("Gift Card is Displayed on Review & Submit Page",BrowserAction.screenshot());
		}else{
			Report.fail("Gift Crad is NOT displayed on Review & Submit Page",BrowserAction.screenshot());
		}
	}

	public static void hasUserLandedOnRS (String rs) throws Exception{
		StepLogger.validate(Check.ObjectPresent, "mobileRsPage_AAF");
		if(Find.Object("mobileRsPage_AAF").getText().value().contains(rs)){
			Report.pass("User Landed on " + rs,BrowserAction.screenshot());
		}else{
			Report.fail("Review & Submit Page is NOT Displayed",BrowserAction.screenshot());
		}


	}
}
