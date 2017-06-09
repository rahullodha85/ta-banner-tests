package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.*;
import com.hbcd.scripting.core.fluentInterface.ObjectAction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;


public class ValidateConfirmation {


	private static boolean newToggle = false;

	public static void setToggleStatus(boolean status) {
		newToggle = status;
	}


	public static void isThankYouPage() throws Exception {
		Thread.sleep(4000);
		if (Find.Object("confOrderNumMsg").isPresent())
			StepLogger.validate(Check.TextPresent, "confOrderNumMsg", "Order #");
		else Report.dataFail("Confirmation not displayed", BrowserAction.screenshot());
	}

	public static void isShippingChargeApplied() throws Exception {
		if(Find.Object("conShippingChargeLbl").getText().value()
				.contains(Storage.get("shippingCharge"))) {
			Report.pass("Shipping charge value is exactly same as expected shipping charge: "
					+ Storage.get("shippingCharge"));
		} else {
			Report.fail("Shipping charge: " + Find.Object("conShippingChargeLbl").getText()
					+ " does not match expected value: " + Storage.get("shippingCharge"));
		}
	}

	public static void validateCreditCard(String name, String cvv)
			throws Exception {
		StepLogger.validate(Check.TextPresent, "confCCInfotxt", name);
//		StepLogger.validate(Check.TextPresent, "confCCInfotxt", cvv);
	}

	public static void validateQuantity(String upc, String qty)
			throws Exception {

		Thread.sleep(4000);
		String value = Find
				.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
						"p[class='widebag-item-quantity']").getText().value();
		int quantityDisplayed = Integer.parseInt(value);
		int quantityInScript = Integer.parseInt(qty);

		if (quantityDisplayed == quantityInScript) {
			Report.pass("Quantity Matched", BrowserAction.screenshot());
		}
	}

	public static void isGiftCardApplied() throws Exception {
		StepLogger.validate(Check.TextPresent, "confGCSummarysection",
				"Applied Gift Cards Total");
	}

	public static boolean isGift(String upc) throws Exception {
		if (Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
				"div[class='giftbox-summary']").isPresent()) {

			Report.pass("Is Gift", BrowserAction.screenshot());
			return true;
		} else {
			Report.fail("Is NOT Gift", BrowserAction.screenshot());
			return false;
		}
	}

	public static boolean isGiftWrapApplied(String upc, String giftWrapText)
			throws Exception {

		if (ValidateConfirmation.isGift(upc)) {

			if (New.Object("rspMakeGift_WS")
					.setProperty(PropertyType.CLASS, "jsItemRoot")
					.setProperty(PropertyType.ATTRIBUTE_KEY1,
							"data-cartproductcode")
					.setProperty(PropertyType.ATTRIBUTE_VALUE1,
							upc)
					.getText().value().toLowerCase().contains(giftWrapText.toLowerCase())) {

				Report.pass("Giftwrap validation Pass", BrowserAction.screenshot());
				System.out.println("Giftwrap text Pass");
				return true;
			} else {
				Report.fail("Giftwrap validation Fail", BrowserAction.screenshot());
				System.out.println("Giftwrap text Fail");
				return false;
			}
		} else {
			System.out.println("Not a gift");
			return false;
		}

	}

	public static void ShippingAddressContains(String text) throws Exception {
		if (newToggle)
			StepLogger.validate(Check.TextPresent,
					"confShippingAddressSection", text);
	}

	public static void BillingAddressContains(String text) throws Exception {
		if (newToggle)
			StepLogger.validate(Check.TextPresent, "confBillingAddressSection",
					text);
	}

	public static String getOrderNumber() throws Exception {

		return Find.Object("confOrderNumMsg").getText().value().split("\n")[0]
				.substring(7);
	}

	public static void ShippingMethod(String shipMethod, String upc)
			throws Exception {

//		Find.Object("confShippingMethod_WS").changeChildAttributeContainsValue("data-cartproductcode", upc);
//		
//		ObjectAction shm = Find.ObjectWith("jsItemRoot",
//				"data-cartproductcode", upc, "dl[class='description-list']");
		Thread.sleep(4000);
		if (Find.Object("confShippingMethod_WS").changeChildAttributeContainsValue("data-cartproductcode", upc).getText().value().contains(shipMethod)) {

			Report.pass("Shipping Method validation Pass", BrowserAction.screenshot());
		} else {
			Report.fail("Shipping Method validation Fail", BrowserAction.screenshot());
		}

	}

	public static void IsTaxApplied() throws Exception {

		String tax = Find.Object("rsTaxtext").getText().value();
		System.out.println(tax);

		String taxDollar = tax.substring(1);

		Double taxAmount = Double.parseDouble(taxDollar);

		System.out.println(taxAmount);
		System.out.println(taxAmount);
		if (taxAmount > 0) {
			Report.pass("Tax amount validation Pass",
					BrowserAction.screenshot());

		} else {

			Report.fail("Tax amount validation Fail",
					BrowserAction.screenshot());
		}

	}

	public static void isItemPresent(String upc) throws Exception {

		String allitems = Find.Object("confShipAddressAndItemsSection")
				.getText().value();

		if (allitems.contains(upc)) {
			System.out.println(upc + " found");
		} else {
			System.out.println(upc + " NOT found");
		}

	}

	public static void isPromoApplied(String promo) throws Exception {

		if (New.Object("").setProperty(PropertyType.CLASS, "top-divided")
				.setProperty(PropertyType.CONTAINS_TEXT, "OrderPage Summary")
				.getText().value().contains(promo)) {

			System.out.println("Promo validation PASS");
		} else {
			System.out.println("Promo validation FAIL");
		}
	}

	public static void hasAccountCreationBox() {
		if (newToggle)
			StepLogger.validate(Check.ObjectPresent,
					"confAccountCreationBox_wk");
	}

	public static void hasAccountLoggedInBox() {
		if (newToggle)
			StepLogger.validate(Check.ObjectPresent,
					"confAccountLoggedInBox_wk");
	}

	public static void hasAccountBoxErrorMsg(String msg) {
		if (newToggle)
			StepLogger.validate(Check.TextPresent, "confAccountBoxMsg_wk", msg);
	}

	public static void hasPasswordDoesnotMatchError() {

		if (newToggle)
			StepLogger.validate(Check.TextPresent, "confAccountBoxMsg_wk",
					"Password does not match");
	}

	public static void hasInvalidPasswordError() {

		if (newToggle)
			StepLogger
					.validate(
							Check.TextPresent,
							"confAccountBoxMsg_wk",
							"Password must be at least six characters and include one number and one letter.");
	}

	public static void hasUnabletoCreateError() {
		if (newToggle)
			StepLogger
					.validate(
							Check.TextPresent,
							"confAccountBoxMsg_wk",
							"We're sorry, we're unable to create your account at this time.");
	}

	public static void itemRowHasText(String upc, String text) throws Exception {

		if (newToggle) {

			if (Find.Object("confItemRow_WS").changeContainsText(upc).getText().value().contains(text))
				Report.pass("Validation Pass", BrowserAction.screenshot());
			else
				Report.fail("Validation Fail", BrowserAction.screenshot());
		}
	}

	public static void hasSignatureRequiredAtDelivery(String upc) throws Exception {
		if (newToggle) {


			if (Find.Object("confItemRow").changeAttributeContainsValue("data-cartproductcode", upc).getText().value().contains("Signature Required at Delivery"))
				Report.pass("Signature Required PASS", BrowserAction.screenshot());
			else
				Report.fail("Signature Required FAIL", BrowserAction.screenshot());

		}
	}

	public static void hasNoSignatureRequiredAtDelivery(String upc) throws Exception {
		if (newToggle) {

			if (!Find.Object("confItemRow").changeAttributeContainsValue("data-cartproductcode", upc).getText().value().contains("Signature Required at Delivery"))
				Report.pass("Signature Not Required validation Pass", BrowserAction.screenshot());
			else
				Report.fail("Signature Not Required validation FAIL", BrowserAction.screenshot());

		}
	}

	public static void hasShopRunnerEligibleSign(String upc) throws Exception {

		if (Find.Object("shiandBillShopRunnerEligible_zk").changeContainsText(upc).getText().value().contains("Eligible"))
			Report.pass("Validation PASS");
		else
			Report.fail("Validation FAIL");
	}

	public static void hasNoShopRunnerEligibleSign() throws Exception {
		StepLogger.validate(Check.TextNotPresent, "rspSRShippingMethod_zk", "Eligible");
	}

	public static void hasCADOrderConfirmation() throws Exception {
		Switch.toFrame("envoyId");
		if (Find.Object("CADOrderConfirmation_zk").isPresent()) {
			Report.pass("Order Submit Validation PASS", BrowserAction.screenshot());
		} else {
			Report.fail("Order Submit Validation PASS");
		}
		Switch.toDefaultContent();
	}

	public static void hasBuyOneGetOnePromoPresent(String promoOnConfmPage) throws Exception{

		StepLogger.validate(Check.ObjectPresent, "ofm_promoMessageRs_AAF");
		if(Find.Object("ofm_promoMessageRs_AAF").getText().value().contains(promoOnConfmPage)){
			Report.pass("Promo Message Displayed on Thank You Page " + promoOnConfmPage,BrowserAction.screenshot());
		}else{
			Report.fail("Promo Message does NOT display on Thank You Page",BrowserAction.screenshot());
		}
	}

	public static void hasBuyTwoGetOneMessageDisplayed(String promo) throws Exception{

		StepLogger.validate(Check.ObjectPresent, "ofm_BuyTwoGetOneOnCp_AAF");
		if(Find.Object("ofm_BuyTwoGetOneOnCp_AAF").getText().value().contains(promo)){
			Report.pass("The Promo with " + promo + "Displayed",BrowserAction.screenshot());
		}else{
			Report.fail("The Promo with BUY TWO GET ONE is NOT displayed",BrowserAction.screenshot());
		}
	}
}