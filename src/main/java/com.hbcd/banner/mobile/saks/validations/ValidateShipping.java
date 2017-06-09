package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;



public class ValidateShipping {
	private static boolean newToggle = false;
	public static void setToggleStatus(boolean status){
		newToggle = status;
	}
	public static void InvalidEmailAddressError() {

		if(newToggle)StepLogger.validate(Check.TextPresent,"shippingBillingEmailError_wk","Please enter a valid email address");
	}

	public static void InvalidPhoneError() {
		if(newToggle)StepLogger.validate(Check.TextPresent,"shippingBillingPhoneError_wk","Please enter a valid phone number");
	}

	public static void isShippingPage() {

		StepLogger.validate(Check.ObjectPresent, "shippingBillingEmailTxt_wk");
	}

	public static void hasEmailAddressRequiredText() {

		if(newToggle)StepLogger.validate(Check.TextPresent, "shippingEmailTxt_wk",
				"(Required)");
	}
	
	public static void hasPhoneRequiredText() {

		if(newToggle)StepLogger.validate(Check.TextPresent, "shippingBillingPhoneError_wk",
				"(Required)");
	}


	public static void hasEmailAddressTextBox() {

		if(newToggle)StepLogger.validate(Check.TextPresent, "shippingBillingEmailTxt_wk",
				"(Required)");
	}

	public static void hasPhoneTextBox() {

		if(newToggle)StepLogger.validate(Check.ObjectPresent, "shippingBillingEmailTxt_wk");
	}
	public static void hasRegionProvinceText(String country){
		if(country.equalsIgnoreCase("canada")){
		if(newToggle)StepLogger.validate(Check.TextPresent, "mShippingAddressTxt_vm",
				"Province");}
	}

	public static void hasStandardShippingSelected(){

	}

	public static void hasShippingMethods(){

	}
	public static void hasShippingMethods(int ShippingMethods) throws Exception{
		if(Find.MultipleObjects("ShippingMethods").size()==ShippingMethods)
		{
			Report.pass("Shipping methods complete: "+ShippingMethods, BrowserAction.screenshot());
		}
		else
		{
			Report.fail("Shipping methods not complete: "+ShippingMethods,BrowserAction.screenshot());
		}
	}
	public static void isCountryDisabled(){

	}
	public static void hasPostelCodeRequired(){

	}
	public static void hasPostelCodeNotRequired(){

	}

	public static void hasEnterPostalCodeMessage(){

	}
	public static void hasMatchingZipCodeAndProvince(){

	}
	public static void hasNotMatchingZipCodeAndProvince(){

	}
	public static void hasRegionProvinceField(String shippingMethod){

	}
	public static void hasCanadaProvinceList(){

	}
	public static void hasOptionDutyFreeAndTaxes() throws Exception{
		if(Find.Object("shpDutyFreeOption_vm").getText().value().contains("duty free")){
				Report.pass("");
		}
		else {
			Report.fail("");
		}
	}
	public static void hasErrorHighlightedBelow() {

		if(newToggle)StepLogger.validate(Check.TextPresent, "shippingBillingError_WS",
				"Please check the error(s) highlighted below.");
	}
	public static void hasNoInternationalStateProvinceRegion(){

	}
	public static void hasBorderfreeCountries(int listOfCountries){

	}
	public static void hasPostalCodeProvinceMismatch() {

	}
	public static void hasPostalCodeProvinceMatch(){

	}
	public static void hasBillingCanadaProvinceList(){

	}
	public static void hasBillingRegionProvinceText(String zipCode){

	}
	public static void hasBillPostalCodeProvinceMismatch(){

	}
	public static void hasBillingPostalCodeProvinceMatch(){

	}
	/**Enter the step number as parameter*/
	public static void hasStepInactive(int stepNumber) throws Exception {

		switch (stepNumber) {
			case 1:  {
				if(!Find.Object("shpStep1_WS").isEnabled())
					Report.pass("Step 1 is Inactive");
				else
					Report.fail("Step 1 is NOT Inactive");
					}
			case 2: {
				if(!Find.Object("shpStep2_WS").isEnabled())
					Report.pass("Step 2 is Inactive");
				else
					Report.fail("Step 2 is NOT Inactive");
					}
			case 3: {
				if(!Find.Object("shpStep3_WS").isEnabled())
					Report.pass("Step 3 is Inactive");
				else
					Report.fail("Step 3 is NOT Inactive");
			}

			case 4: {
				if(!Find.Object("shpStep4_WS").isEnabled())
					Report.pass("Step 4 is Inactive");
				else
					Report.fail("Step 4 is NOT Inactive");
			}

			default: {
			Report.dataFail("The stepNumber provided in the script is invalid",BrowserAction.screenshot());
			break;
					}
		}
	}
	public static void hasStep(int stepNumber) throws Exception {

		switch (stepNumber) {
			case 1:  {
				if(Find.Object("shpStep1_WS").isPresent())
					Report.pass("Step 1 is Present");
				else
					Report.fail("Step 1 is NOT Present");
			}
			case 2: {
				if(Find.Object("shpStep2_WS").isPresent())
					Report.pass("Step 2 is Present");
				else
					Report.fail("Step 2 is NOT Present");
			}
			case 3: {
				if(Find.Object("shpStep3_WS").isPresent())
					Report.pass("Step 3 is Present");
				else
					Report.fail("Step 3 is NOT Present");
			}
			case 4: {
				if(!Find.Object("shpStep4_WS").isEnabled())
					Report.pass("Step 4 is Inactive");
				else
					Report.fail("Step 4 is NOT Inactive");
			}


			default: {
				Report.dataFail("The stepNumber provided in the script is invalid",BrowserAction.screenshot());
				break;
			}
		}
	}
	public static void hasStepNumber(int stepNumber) throws Exception{
		if(Find.Object("shpStep1_WS").isPresent())
			Report.pass("Step 1 is Present");
		else
			Report.fail("Step 1 is NOT Present");
	}
	public static void hasCityField(){
		StepLogger.validate(Check.ObjectPresent,"shpCity_WS");
	}
	public static void hasStateField(){
		StepLogger.validate(Check.ObjectPresent,"shpState_WS");
	}
	public static void hasInternationalStateProvinceRegion(){
		StepLogger.validate(Check.ObjectPresent,"shpIntlStateProvinceRegion_WS");
	}

	public static void hasProgressBar() {

		StepLogger.validate(Check.ObjectPresent,"progressbar_AAF");
	}

	public static void hasCheckoutHeadingText() {
		StepLogger.validate(Check.ObjectPresent,"shpCheckoutHeading_WS");
	}

	public static void hasFirstNameField() {
		StepLogger.validate(Check.ObjectPresent,"shpFirstName_WS");
	}

	public static void hasLastNameField() {
		StepLogger.validate(Check.ObjectPresent,"shpLastName_WS");
	}

	public static void hasAddress2Field() {
		StepLogger.validate(Check.ObjectPresent,"shpAddress2_WS");
	}

	public static void hasContactInformationText() {
		StepLogger.validate(Check.ObjectPresent,"shpContactInfo_WS");
	}

	public static void hasStepTwoActive()throws Exception {
		if (Find.Object("shpStep2_WS").isEnabled()) {
			Report.pass("Step 2 is Inactive",BrowserAction.screenshot());
		} else {
			Report.fail("Step 2 is Active");
		}

	}

	public static void hasStepThreeActive()throws Exception{
		if(Find.Object("shpStep3_WS").isPresent())
			Report.pass("Step 3 is Present",BrowserAction.screenshot());
		else
			Report.fail("Step 3 is NOT Present",BrowserAction.screenshot());
	}
}
