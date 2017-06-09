	package com.hbcd.banner.validations.s5a;

	import com.hbcd.scripting.core.BrowserAction;
	import com.hbcd.scripting.core.Find;
	import com.hbcd.scripting.core.Report;
	import com.hbcd.scripting.enums.impl.Check;
	import com.hbcd.scripting.reporting.StepLogger;

	import java.util.regex.Pattern;


	public class ValidateShippingBilling {
		private static boolean newToggle = false;
		public static void setToggleStatus(boolean status){
			newToggle = status;
		}

		public static void hasEmailMsg() {
			StepLogger.validate(Check.ObjectPresent, "shippingBillingEmailTxt_wk");
		}
		public static void hasPhoneMsg() {
			StepLogger.validate(Check.ObjectPresent, "shippingBillingPhoneTxt_wk");
		}
		public void hasEmailErrorMsg() {

			if(newToggle)StepLogger.validate(Check.TextPresent, "shippingBillingEmailError_wk",
					"Please enter a valid email address");
		}


		public void hasPhoneErrorMsg() {

			if(newToggle)StepLogger.validate(Check.TextPresent, "shippingBillingPhoneError_wk",
					"Please enter a valid phone number");
		}


		public void hasEmailLabel() {
			if(newToggle)StepLogger.validate(Check.ObjectPresent, "shippingBillingEmailTxt_wk");
		}
		public void hasPhoneLabel() {
			if(newToggle)StepLogger.validate(Check.ObjectPresent, "shippingBillingPhoneTxt_wk");
		}


		public static void shipAndBillShopRunnerEligibleSignDisplay(String upc) throws Exception {

			if(Find.Object("shiandBillShopRunnerEligible_zk").changeContainsText(upc).getText().value().contains("Eligible"))
				Report.pass("Validation PASS");
			else
				Report.fail("Validation FAIL");
		}

		public static void shipAndBillShopRunnerEligibleSignNotDisplay(String upc) throws Exception {

			if(!Find.Object("shiandBillShopRunnerEligible_zk").changeContainsText(upc).getText().value().contains("Eligible"))
				Report.pass("Validation PASS");
			else
				Report.fail("Validation FAIL");
		}

		public static void shipAndBillShopRunnerEligibleIcon(String text) throws Exception {

			if (Find.Object("shipBillShopRunnerElegibleIcon_AAF").changeContainsText(text).getText().value().contains("Eligible"))
			Report.pass("Validation PASS");
			else{
				Report.fail("Validation FAIL");
			}
		}

		public static void hasShippingMethods(String checkoutType) throws Exception{
				if(checkoutType.equalsIgnoreCase("international")){
						StepLogger.validate(Check.ObjectPresent,"standardshipping_vm");
						StepLogger.validate(Check.ObjectPresent, "expressshipping_vm");
				}

		}
		public static void shipAndBillShopRunnerIneligibleIconNotDisplay() throws Exception{
			StepLogger.validate(Check.ObjectNotPresent, "shipBillShopRunnerElegibleIcon_AAF");
		}

		public static void hasLocalCurrency(String currency) throws Exception {
			StepLogger.validate(Check.TextPresent, "shipping_page_localCurrency_vm",currency);
		}
		public static void hasNoMakeGiftAndGiftWrap() throws Exception{
			StepLogger.validate(Check.TextNotPresent, "shipping_page_makeGift_vm","Make This a Gift");
			StepLogger.validate(Check.TextNotPresent, "shipping_page_localCurrency_vm","Gift Wrap:");
		}
		public static void hasRegionProvinceField(String country) throws Exception{
			if(!country.equalsIgnoreCase("canada"))
			StepLogger.validate(Check.TextPresent, "shipping_page_shipping_address_section_vm","Region / Province");
			else{
			StepLogger.validate(Check.TextPresent, "shipping_page_shipping_address_section_vm", "Province");
				//optional check using javascript
			}
		}
		public static void hasDutiesAndTaxFromBorderFree(Double amount) throws Exception{
			StepLogger.validate(Check.TextPresent, "shipping_page_localCurrency_vm","Duties & Taxes");
			final String regExp="[0-9]+([,.][0-9]{1,2})?";
			Pattern pattern = Pattern.compile(regExp);
			if(pattern.matches(regExp,amount+"")){
					Report.pass("Duties and Taxes Price present",BrowserAction.screenshot());
			}
			else{
				Report.fail("Duties and Taxes Price absent ", BrowserAction.screenshot());
			}

		}
		public static void hasEstimatedShippingLabel() throws  Exception{
			StepLogger.validate(Check.TextNotPresent, "shipping_page_localCurrency_vm","Shipping & Handling");
			StepLogger.validate(Check.TextPresent, "shipping_page_localCurrency_vm","Estimated Shipping");
		}
		public static void isPostalCodeNotRequired() throws Exception{
			StepLogger.validate(Check.TextPresent, "shipping_page_shipping_address_section_vm","Postal Code");
		}
		public static void isPostalCodeRequired() throws Exception{
			StepLogger.validate(Check.TextPresent, "shipping_page_shipping_address_section_vm","Postal Code (Required)");
		}

		public static void hasShippingPriceUpdated(String shippingMethodCurrentPrice) throws Exception{
			String shippingCostUpdated=(String)BrowserAction.javascriptExecuteScript("return Order.getSummary().shippingCost");
			if(!shippingMethodCurrentPrice.equalsIgnoreCase((shippingCostUpdated))){
				Report.pass("Shipping Price Updated", BrowserAction.screenshot());
			}
			else
			{
				Report.fail("Shipping Price Not Updated",BrowserAction.screenshot());
			}

		}

		public static void hasDutiesAndTaxUpdated(String dutiesTaxCurrentPrice) throws Exception{
			if(!dutiesTaxCurrentPrice.equalsIgnoreCase(Find.Object("rsTaxPriceLbl").getText().value())){
				Report.pass("Duties and Tax Price Updated", BrowserAction.screenshot());
			}
			else
			{
				Report.fail("Duties and Tax Not Updated",BrowserAction.screenshot());
			}

		}
		public static void hasNoMultiShippingMessage() throws Exception{
			StepLogger.validate(Check.TextNotPresent, "htmlPage","I Wish to Send This Order to Multiple Addresses");
		}
		public static void isCountryDisabled() throws Exception{
			if(Find.Object("shippingCountry_ShipPage_vm").getAttribute("outerHTML").value().toLowerCase().indexOf("disabled")>=0)
			{
				Report.pass("Shipping Country Disabled",BrowserAction.screenshot());
			}
			else{
				Report.fail("Shipping Country Enabled",BrowserAction.screenshot());
			}
		}
		public static void isStandardPreselected() throws Exception{
			if(Find.Object("standardshipping_vm").getAttribute("innerHTML").value().toString().indexOf("selected")>=0)
				Report.pass("Standard Shipping Preselected",BrowserAction.screenshot());
			else {

				Report.fail("Standard Shipping Not Preselected", BrowserAction.screenshot());
			}	//Report.
		}
		public static void hasErrorMsgEnterZipCode() throws Exception{
			StepLogger.validate(Check.TextPresent,"htmlPage","Please enter a valid ZIP Code");
		}
		public static void hasShippingMethodUpdated(String shippingMethod) throws Exception {
		}
		public static void hasShopRunnerIneligibleIconDisplay(String text) throws Exception {
			if (!Find.Object("shipBillShopRunnerElegibleIcon_AAF").changeContainsText(text).getText().value().contains("Eligible"))
				Report.pass("Validation PASS");
			else {
				Report.fail("Validation FAIL");
			}

		}
		public static void hasCanadaProvinceList() throws Exception{
			if(Find.MultipleObjects("shplistOfProvinces_vm").size()==14){
				Report.pass("All canada provinces present",BrowserAction.screenshot());
			}
			else{
				Report.fail("All canada provinces not present",BrowserAction.screenshot());
			}
		}
		public static void hasNotMatchingZipCodeAndProvince() throws Exception{
			StepLogger.validate(Check.TextPresent, "htmlPage","Province and postal code do not match");
		}
		public static void hasMatchingZipCodeAndProvince() throws Exception{
			StepLogger.validate(Check.TextNotPresent, "htmlPage","Province and postal code do not match");
		}
		public static void hasShippingMethodCount(int countForCountry) throws Exception{
			if(Find.MultipleObjects("shippingMethodsradiobuttons_vm").size()==countForCountry)
				Report.pass("Number of Shipping Methods are correct",BrowserAction.screenshot());
			else
				Report.fail("Number of Shipping Methods not correct",BrowserAction.screenshot());
		}

		public static void hasDutiesandTaxesPaymentOption(String DutiesAndTaxesInfo) throws Exception{
			if(Find.Object("shippingMethoddiv_vm").getText().value().indexOf(DutiesAndTaxesInfo)>=0)
				Report.pass("Duties and Taxes Info Present: "+DutiesAndTaxesInfo,BrowserAction.screenshot());
			else{
				Report.fail("Duties and Taxes Info Not Present: "+DutiesAndTaxesInfo,BrowserAction.screenshot());}
		}
		public static void hasNoZipCodeRequirement(String pageType) throws Exception{
			hasPageLanded();
				if(pageType.equalsIgnoreCase("Shipping")) {

					Object zipCodeRequirment = BrowserAction.javascriptExecuteScript("return Order.isShippingZipRequired()");
				if (!((boolean) zipCodeRequirment)) {
					Report.pass("Zip Code is NotRequired", BrowserAction.screenshot());
				} else {
					Report.fail("Zip Code is Required", BrowserAction.screenshot());
				}
			}
			else if(pageType.equalsIgnoreCase("Billing")){
				Object zipCodeRequirment = BrowserAction.javascriptExecuteScript("return Order.isBillingZipRequired()");
				if (!((boolean) zipCodeRequirment)) {
					Report.pass("Zip Code is NotRequired", BrowserAction.screenshot());
				} else {
					Report.fail("Zip Code is Required", BrowserAction.screenshot());
				}
			}


		}
		public static void hasZipCodeRequirement(String pageType) throws Exception{
			//Add validation for text check also of "Postal code Required"
			hasPageLanded();
			if(pageType.equalsIgnoreCase("Shipping")) {
			Object zipCodeRequirment=BrowserAction.javascriptExecuteScript("return Order.isShippingZipRequired()");
			if((boolean)zipCodeRequirment){
				Report.pass("Zip Code is Required",BrowserAction.screenshot());
			}
			else {
				Report.fail("Zip Code is not Required",BrowserAction.screenshot());
			}}
			else if(pageType.equalsIgnoreCase("Billing")){
				Object zipCodeRequirment = BrowserAction.javascriptExecuteScript("return Order.isBillingZipRequired()");
				if (!((boolean) zipCodeRequirment)) {
					Report.pass("Zip Code is Required", BrowserAction.screenshot());
				} else {
					Report.fail("Zip Code is Not Required", BrowserAction.screenshot());
				}
			}



			//validate text as well that the required message is present with the field


		}
		public static void hasDropDownProvinces(int countOfProvinces) throws Exception{

		}

		public static void isSignitureDeliveryNotPresent() throws Exception{
				if(Find.Object("htmlPage").getText().value().indexOf("Signature Required at Delivery")<=0)
				{
						Report.pass("Signature required is absent",BrowserAction.screenshot());
				}
			else{
					Report.fail("Signature required is present",BrowserAction.screenshot());
				}


		}

		public static void hasPageLanded() throws Exception{
			Thread.sleep(3000);
			Find.Object("proShippingLastNameTxt").input("test");
		}
		public static void hasDutiesAndTaxUnpaid() throws Exception{
			if(Find.Object("shipping_page_localCurrency_vm").getText().value().toUpperCase().indexOf("UNPAID")>=0){
					Report.pass("Duties Prices is unpaid",BrowserAction.screenshot());
			}
			else{
				Report.fail("Duties Prices is not unpaid",BrowserAction.screenshot());
			}
		}
		public static void hasZipCodeRequireText() throws Exception{

		}
		public static void hasCountryDropDown() throws Exception{

		}
		public static void hasNoQAS() throws Exception{

		}
		public static void hasInternationalAddressinShippingDropDown() throws Exception{

		}
		public static void hasInternationalShippingAddress() throws Exception{

		}
		public static void hasEditShippingMethodButtonRemoved() throws Exception{

		}

		public static void isBuyOneGetOneMessagePresent(String promoMessageMiniBag) throws Exception{

			if (Find.Object("ofm_promoMessageMiniBag_AAF").isPresent()){
				Report.pass("Promo Message for BUY 1 G 1 FREE is Present on MiniBag in Shipping&Billing Page");
			}else{
				Report.fail("Promo Message is NOT displayed");
			}
			if(Find.Object("ofm_promoMessageMiniBag_AAF").getText().value().contains(promoMessageMiniBag)){
				Report.pass("MiniBag displayed Promo Message: " + promoMessageMiniBag);
			}else{
				Report.fail("MiniBag is NOT displayed the Promo Message: " + promoMessageMiniBag);
			}
		}

		public static void hasUserlandedOnShippingAndBilling(String page)throws Exception{
			if (Find.Object("shpBillingPage_AAF").isPresent()){
				Report.pass("User Landed on " + page,BrowserAction.screenshot());
			}else{
				Report.fail("User Did NOT Land on Shipping & Billing Address",BrowserAction.screenshot());
			}
		}


}



