package com.hbcd.banner.validations.s5a;

import javafx.beans.property.SetProperty;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

public class ValidateRs {
	private static boolean newToggle = false;

	public static void setToggleStatus(boolean status) {
		newToggle = status;
	}

	public static void isDropship(String upc) throws Exception {
		// Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
		// "warnings");

		Thread.sleep(4000);
		if (Find.Object("rsDropship_WS")
				.changeAttributeContainsValue("data-cartproductcode", upc)
				.isPresent())
			Report.pass("Is Dropship Pass", BrowserAction.screenshot());
		else
			Report.fail("Is Dropship Fail", BrowserAction.screenshot());
	}

	public static void hasSignatureOnDelivery(String upc) throws Exception {
		// Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
		// "input[name='sigRequired']").isEnabled();

		if (Find.Object("rsSignatureOnDelivery_AAF")
				.changeAttributeContainsValue("data-cartproductcode", upc)
				.isPresent())
			Report.pass("Is Signature on Delivery Pass",
					BrowserAction.screenshot());
		else
			Report.fail("Is Signature on Delivery Fail",
					BrowserAction.screenshot());
	}

	public static void ShippingAddressContains(String shippingText)
			throws Exception {
		StepLogger.validate(Check.TextPresent, "rsShippingAddressLbl",
				shippingText);
	}

	public static void BillingAddressContains(String billingText)
			throws Exception {
		StepLogger.validate(Check.TextPresent, "rsBillingAddressLbl",
				billingText);
	}

	public static void hasShippingMethodChanged(String upc,
			String shippingMethod) throws Exception {
		if (Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
				"description-list").getText().value().indexOf(shippingMethod) >= 0)
			System.out.println("pass");
		else
			System.out.println("fail");
	}

	public static void ValidateShippingDate(String upc) throws Exception {
		String rspShippingCharge = Find.Object("rsShippingUnregChargeLbl")
				.getText().value().split("\\$")[1];
		Storage.save("shippingCharge", rspShippingCharge);

		if (Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
				"div[class='widebag-item-shipment-summary top-divided grid grid-parent']")
				.getText().value().contains("Est. Delivery"))
			System.out.println("pass");
		else
			System.out.println("fail");
	}

	public static void FreeShipping() throws Exception {
		StepLogger
				.validate(Check.TextPresent, "rsFreeShipTxt", "Free Shipping");
	}

	public static void isVegc(String upc) throws Exception {
		// dynamic object check: rspVegcValidation [change contains text]
		boolean hasVegc = Find
				.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
						"div[class='widebag-item-details']").getText().value()
				.contains("Virtual Gift Card");
		if (hasVegc)
			System.out.println(upc + " is VEGC");
		else
			System.out.println(upc + " is NOT VEGC");

	}

	public static void isAssociateDiscountApplied(
			boolean registeredUserOnReviewSubmit) throws Exception {
		String prefix = "";
		if (!registeredUserOnReviewSubmit) {
			prefix = "un";
		}
		double originalItemPrice = Double.parseDouble(Find
				.Object("rs" + prefix + "OriginalItemPriceLbl").getText()
				.value().split("\\$")[1]);
		double discountedPrice = Double.parseDouble(Find
				.Object("rs" + prefix + "AssociateDiscountPriceLbl").getText()
				.value().split("\\$")[1]);
		if ((originalItemPrice * (0.2) - discountedPrice) < 0.20) {
			Report.pass("isAssociateDiscountApplied Validation Pass",
					BrowserAction.screenshot());
		} else {
			Report.fail("isAssociateDiscountApplied Validation Fail",
					BrowserAction.screenshot());
		}
	}

	public static void isPreOrderItemInCart(String upc) throws Exception {

		Thread.sleep(4000);
		if (Find.ObjectWith("jsItemRoot", "data-cartproductcode", upc,
				"widebag-item-inventory-status").getText().value()
				.toLowerCase().indexOf("item may ship sooner than") >= 0) {
			Report.pass("isPreOrderItemInCart validation Pass",
					BrowserAction.screenshot());
			System.out.println("pass");
		} else
			Report.fail("isPreOrderItemInCart validation Fail",
					BrowserAction.screenshot());
		System.out.println("fail");

	}

	public static void isGiftCardApplied() throws Exception {
		double totalBfrTx = Double
				.parseDouble(Find.Object("rsTtlBfrTaxPriceLbl").getText()
						.value().split("\\$")[1]);
		double tx = Double.parseDouble(Find.Object("rsTaxPriceLbl").getText()
				.value().split("\\$")[1]);
		double giftAmt = Double.parseDouble(Find.Object("rsGftDscntLbl")
				.getText().value().split("\\$")[1]);
		double pymtAmt = Double.parseDouble(Find.Object("rsPyAmtLbl").getText()
				.value().split("\\$")[1]);
		if (pymtAmt - (totalBfrTx + tx + giftAmt) < .1) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

	}

	public static void isGift(String upc) throws Exception {
		if(Find.Object("rspMakeGift_RL")
				.changeAttributeContainsValue(PropertyType.ATTRIBUTE_KEY1.getvalue(), upc)
				.getText().value().contains("Gift for")) {
			Report.pass("Is Gift Pass", BrowserAction.screenshot());
		} else {
			Report.fail("Item is not shipped as a Gift");
		}
	}

	public static void isPersonalized(String upc, String personalizedMsg)
			throws Exception {

		// ObjectAction personalizedObj = Find.ObjectWith("jsItemRoot",
		// "data-cartproductcode", upc, "personalization-summary");

		Thread.sleep(6000);
		if (Find.Object("rsPersonalized_WS")
				.changeAttributeContainsValue("data-cartproductcode", upc)
				.isPresent()) {

			Report.pass("Personalized section displayed",
					BrowserAction.screenshot());
		} else
			Report.fail("Personalized section NOT displayed",
					BrowserAction.screenshot());
	}

	public static void isItemPresent(String upc) throws Exception {

		String allitems = Find.Object("rsShipAddressAndItemsSection").getText()
				.value();

		if (allitems.contains(upc)) {
			System.out.println(upc + " found");
		} else {
			System.out.println(upc + " NOT found");
		}

	}

	public static void IsTaxApplied() throws Exception {

		String tax = Find.Object("rsTaxtext").getText().value();
		System.out.println(tax);

		String taxDollar = tax.substring(1);

		Double taxAmount = Double.parseDouble(taxDollar);

		if (taxAmount > 0) {
			Report.pass("Tax amount validation Pass",
					BrowserAction.screenshot());

		} else {

			Report.fail("Tax amount validation Fail",
					BrowserAction.screenshot());
		}

	}

	public static void isEGC(String upc) throws Exception {

		boolean isGC = New
				.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='jsItemRoot widebag-item ']")
				.setProperty(PropertyType.ATTRIBUTE_KEY1,
						"data-cartproductcode")
				.setProperty(PropertyType.ATTRIBUTE_VALUE1, upc).getText()
				.value().contains("Gift Card");

		if (isGC)
			System.out.println(upc + " is EGC");
		else
			System.out.println(upc + " is NOT EGC");

	}

	public static void hasPaypalNotApplied() throws Exception {

		System.out.println((Find.Object("yapErrorMessagePaypal").getText()
				.value().toLowerCase()
				.indexOf("you have already entered paypal") >= 0) ? "pass"
				: "fail");

		StepLogger.validate(Check.TextPresent, "yapErrorMessagePaypal",
				"You have already entered PayPal");
	}

	public static void IsSignatureAtDeliveryCheckedInOverlay() throws Exception {

		if (newToggle)
			if (Find.Object("rsSignReqdOverlayField_WS")
					.getAttribute("outerHTML").value().contains("checked="))
				Report.pass("Signature Reqd at delivery is Checked",
						BrowserAction.screenshot());
			else
				Report.fail("Signature Reqd at delivery is NOT Checked",
						BrowserAction.screenshot());
	}

	public static void IsSignatureAtDeliveryNotCheckedInOverlay()
			throws Exception {

		if (newToggle)
			if (!(Find.Object("rsSignReqdOverlayField_WS")
					.getAttribute("outerHTML").value().contains("checked=")))
				Report.pass("Signature Reqd at delivery is NOT Checked",
						BrowserAction.screenshot());
			else
				Report.fail("Signature Reqd at delivery is Checked",
						BrowserAction.screenshot());
	}

	public static void IsSignatureAtDeliveryChecked(String upc)
			throws Exception {
		if (newToggle)
			if (Find.Object("rspItemSignCheck_WS").changeContainsText(upc)
					.getAttribute("outerHTML").value().contains("checked="))
				Report.pass("Signature Reqd at delivery is Checked",
						BrowserAction.screenshot());
			else
				Report.fail("Signature Reqd at delivery is NOT Checked",
						BrowserAction.screenshot());
	}

	public static void IsSignatureAtDeliveryNotChecked(String upc)
			throws Exception {

		if (newToggle)
			if (!(Find.Object("rspSignatureReqdItemLevel_WS").changeContainsText(upc)
					.getAttribute("outerHTML").value().contains("checked=")))
				Report.pass("Signature Reqd at delivery is NOT Checked",
						BrowserAction.screenshot());
			else
				Report.fail("Signature Reqd at delivery is Checked",
						BrowserAction.screenshot());
	}

	public static void hasNoShippingMethodLink(String upc) throws Exception {
		String test = Find.Object("rsItemRoot_WS").changeContainsText(upc).getText()
				.value();
		if (newToggle)
			if (!Find.Object("rsItemRoot_WS").changeContainsText(upc).getText()
					.value().contains("Shipping Method"))
				Report.pass("No Shipping Method Link displayed",
						BrowserAction.screenshot());
			else
				Report.fail("Shipping Method Link displayed",
						BrowserAction.screenshot());
	}

	public static void hasRestrictedShippingMethod(String upc) throws Exception {

		Thread.sleep(4000);
		if (newToggle)
			if (Find.Object("confItemRow")
					.changeAttributeContainsValue("data-cartproductcode", upc)
					.getText().value().contains("Restricted Shipping Method"))
				Report.pass("Has Restricted Shipping Method",
						BrowserAction.screenshot());
			else
				Report.fail("Has NO Restricted Shipping Method",
						BrowserAction.screenshot());

	}

	public static void hasIconSrReviewandSubmit() throws Exception{
		if (Find.Object("shoprunnerreviewandsubmiticon_AAF").isDisplayed()){
			Report.pass("Object Found");
		}

	}

	public static void hasShoprunnerFreeShippingonReviewandSubmitPage() throws Exception{
		if (Find.Object("shoprunnerTwodayShipping_AAF").isDisplayed()){
			Report.pass("Validation PASS");
		}else{
			Report.fail("Validation FAIL");
		}
	}

	public static void shopRunnerEligibleIcononReviewAndSubmitPage() throws Exception{
		if (Find.Object("shoprunnerElibleIcononReviewAndSubmit_AAF").isDisplayed()){
			Report.pass("Validation PASS");
		}else{
			Report.fail("Validation FAIL");
		}
	}

	public static void noShoprunnerIcononReviewAndSubmitPageIneligible() throws Exception{
		StepLogger.validate(Check.TextNotPresent, "shoprunnerElibleIcononReviewAndSubmit_AAF");
	}

	public static void standardShippingNotLoggedIn() throws Exception{
		if (Find.Object("standardShipping_AAF").isDisplayed()){
			Report.pass("Validation PASS");
		}else{
			Report.fail("Validation FAIL");
		}
	}

	public static void standardShippingLoggedIn() throws Exception{
		if (Find.Object("standardShippingLoggedIn_AAF").isDisplayed()){
			Report.pass("Validation PASS");
		}else{
			Report.fail("Validation FAILED");
		}
	}

	public static void restrictedShippingMethodFirIneligible() throws Exception{
		if (Find.Object("restrictedShippingIneligible_AAF").isDisplayed()){
			Report.pass("Validation PASS");
		}else{
			Report.fail("Validation FAIL");
		}
	}
	public static void isRedirectedToBorderFreeCheckoutPage() throws Exception{

	}
public static void hasGiftCardAppliedText() throws Exception {

	if(Find.Object("confGCSummarysection").getText().value().contains("Applied Gift Cards Total"))
			Report.pass("GiftCard Applied Text displayed");
	else
		Report.fail("GiftCard Applied Text NOT displayed");
}
	public static void hasShippingMethodUpdated(String shippingMethod) throws Exception{

	}
	public static void isCreditCardNotPresent(String cardType) throws Exception{

		if(!Find.Object("changePayment_NJ").getText().value().toLowerCase().contains(cardType.toLowerCase()))
			Report.pass(cardType+" is NOT displayed in Payment Type dropdown as expected");
		else
			Report.fail(cardType+" is displayed in the Payment dropdown");
	}

}
