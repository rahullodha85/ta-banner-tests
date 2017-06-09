package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.commonbanner.base.pages.ReviewSubmitPageBase;
import com.hbcd.commonbanner.overlays.*;
import com.hbcd.commonbanner.pages.*;
import com.hbcd.banner.mobile.saks.overlays.mGiftOverlay;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

public class mReviewSubmitPage extends ReviewSubmitPageBase {

	@Override
	public void ClickPlaceOrder() throws Exception {

		Thread.sleep(9000);//Waseem: Added this to counter instability in O5M environment

		if(Find.Object("o5m_rsCVV_WS").isPresent())
		{
			Report.pass("Credit card CVV field is displayed");
			Find.Object("o5m_rsCVV_WS").input("126");
		}
		if (Find.Object("additionalCVVError_AAF").isPresent()){
			Find.Object("additionalCVVError_AAF").input("123");
		}
		if (Find.Object("saksBagAdditionalItemError_WS").isPresent()
				&& Find.Object("saksBagAdditionalItemError_WS").getText()
						.value()
						.contains("International shipping is available")) {

			Report.dataFail(
					"Please enter a domestic shipping address. International shipping is available on Saks.com by using the Change Country link",
					BrowserAction.screenshot());
		}
		if(Find.Object("clickContinueAsErrorHandle_AAF").isPresent()){
			Find.Object("clickContinueAsErrorHandle_AAF").click();
		}
		Thread.sleep(2000);
		StepLogger.validate(Check.ObjectPresent, "rsPlaceOrderBtn");
		Find.Object("rsPlaceOrderBtn").click();
		if(Find.Object("checkoutResponseError_wk").isPresent()){
			String errorMessage = Find.Object("checkoutResponseError_wk").getText().value();
			if(errorMessage.contains("There has been an error")){
				Report.systemFail("Place order not working: " + errorMessage, BrowserAction.screenshot());
			}
		}
	}

	public void ApplyGiftCard(String CardNumber, String pinNumber)
			throws Exception {

		StepLogger.validate(Check.ObjectPresent, "rsEditGiftCard");
		Find.Object("rsEditGiftCard").click();
		StepLogger.validate(Check.ObjectPresent, "rsAddGiftCard");
		Find.Object("rsAddGiftCard").click();
		Find.Object("rsEnterGiftCard").input(CardNumber);
		Find.Object("rsEnterGiftCardPin").input(pinNumber);

		StepLogger.validate(Check.ObjectPresent, "rsAddGiftCard");
		Find.Object("rsAddGiftCard").click();
		//StepLogger.validate(Check.ObjectPresent, "rsGiftCardApply");
		//Find.Object("rsGiftCardApply").click();
		if(Find.Object("rspGiftCardLayer_WS").isPresent()){
			if(Find.Object("rspGiftCardLayer_WS").getText().value().contains("The gift card you entered has no available balance")){
				Report.dataFail("The gift card you entered has no available balance", BrowserAction.screenshot());
			}	
		}
		
	}

	public void AddShippingAddress(String address, String city, String state,
			String zipcode) {
	}

	public void EditShippingAddress(String address) {
	}

	public void EditBillingAddress(String address) {
	}

	public void ChangeShippingMethod(String shippingMethod) throws Exception {
		
		if(shippingMethod.toLowerCase().contains("standard"))
		Find.Object("rspShippingMethodName_WS").changeContainsText("Standard").click();
		else if(shippingMethod.toLowerCase().contains("rush"))
		Find.Object("rspShippingMethodName_WS").changeContainsText("Rush").click();
		else if(shippingMethod.toLowerCase().contains("next bus"))
			Find.Object("rspShippingMethodName_WS").changeContainsText("Next Bus").click();
		else if(shippingMethod.toLowerCase().contains("saturday"))
			Find.Object("rspShippingMethodName_WS").changeContainsText("Saturday").click();
	}

	public void ToggleSignature(String sku) {
	}

	public GiftOverlay MakeGift(String sku) throws Exception {

//		if(mBagPage.OccurencesOfSameItemInBag("rspItems_WS",sku)>1){
//			
//			Report.dataFail("Same Item is displayed multimple times in the Review Submit Page", BrowserAction.screenshot());
//		}
		StepLogger.validate(Check.ObjectPresent, "rsPlaceOrderBtn");
		
		Find.Object("rsMakeGiftBtn_WS").changeContainsText(sku).click();

		return new mGiftOverlay();
	}

	@Override
	public void ClickShipToMultipleAddresses() {

	}

	@Override
	public void ClickContinueCheckOut() {

	}

	@Override
	public void Remove(String upc) {

	}

	@Override
	public void EditCreditCard(String name) {

	}

	@Override
	public void ClickShippingAndBillingTab() {

	}

	@Override
	public void RemoveGift(String sku) {

	}

	public void EditCreditCard(String name, String paymentType, String ccNumber) {

	}

	@Override
	public void AddShippingAddress(String address, String city, String state,
			String zipcode, boolean makeDefaultAddress) throws Exception {
		Find.Object("rspEditShippingAddress_WS").click();
		Find.Object("rspCreateNewShipAddress_WS").click();
		Find.Object("shpFirstName_WS").input("hello");
		Find.Object("shpLastName_WS").input("world");
		Find.Object("shpAddress1_WS").input(address);
		Find.Object("shpState_WS").select(state);
		Find.Object("shpCity_WS").input(city);
		Find.Object("shpZip_WS").input(zipcode);
		Find.Object("shpPhone_WS").input("9999999999");
		Find.Object("rsUpdateShipping").click();

	}

	@Override
	public void EnterNewShippingAddress(String upc, String address,
			String city, String state, String zipcode,
			boolean makeDefaultAddress) throws Exception {
		
	}

	@Override
	public void ClickEditCreditCard() throws Exception {
		Find.Object("rsEditCreditCard").click();
		StepLogger.validate(Check.ObjectPresent, "rspCreditCardLayer");

	}

	@Override
	public ShippingMethodOverlay ClickEditShippingMethod() {
		return null;
	}

	@Override
	public ShippingMethodOverlay ClickChangeShippingMethod() {
		return null;
	}

	@Override
	public void RemoveGiftCard() {

	}

	@Override
	public void UpdateQuantity(String upc, String qty) {

	}

	@Override
	public BillingMethodOverlay ClickEditBilling() {
		return null;
	}

	@Override
	public void SelectCreditCard(String cardName) throws Exception {

		Thread.sleep(9000); //Waseem: Added to counter instability in QASlot34 env O5Migration
		StepLogger.validate(Check.ObjectPresent, "rsEditCreditCard");

		Find.Object("rsEditCreditCard").click();
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='option form-field-wrap radio-checkbox']")
				.setProperty(PropertyType.CONTAINS_TEXT, cardName)
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.CLASS, "title").click();

		StepLogger.validate(Check.ObjectPresent, "rsUpdateCreditCard");

		Find.Object("rsUpdateCreditCard").click();
//		StepLogger
//				.validate(Check.TextPresent, "rspCreditCardSection", cardName);

	}

	@Override
	public void ClickPaypal() {

	}

	@Override
	public void ChangeShippingAddress(String address) throws Exception {

		StepLogger.validate(Check.ObjectPresent, "rsEditShippingAddress");

		Find.Object("rsEditShippingAddress").click();

		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='option address-option']")
				.setProperty(PropertyType.CONTAINS_TEXT, address)
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.NAME, "existingShipping")
				.click();

		StepLogger.validate(Check.ObjectPresent, "rsUpdateShipping");
		Find.Object("rsUpdateShipping").click();

	}

	@Override
	public void ChangeBillingAddress(String address) throws Exception {

		StepLogger.validate(Check.ObjectPresent, "rsEditBillingAddress");
		Find.Object("rsEditBillingAddress").click();

		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='option address-option']")
				.setProperty(PropertyType.CONTAINS_TEXT, address)
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.NAME, "existingBilling").click();

		StepLogger.validate(Check.ObjectPresent, "rsUpdateBilling");
		Find.Object("rsUpdateBilling").click();

	}

	@Override
	public QuickLookOverLay ClickEditItem(String sku) {
		return null;
	}

	@Override
	public void ChangePaymentType(int index) {

	}

	@Override
	public void AddShippingAddress(String address, String city, String state,
			String zipcode, String country, boolean makeDefaultAddress)
			throws Exception {

	}

	@Override
	public void AddBillingAddress(String address, String city, String state,
			String zipcode, String cntry, boolean makeDefaultAddress)
			throws Exception {

	}

	@Override
	public String GetShippingCharge() throws Exception {
		return null;
	}
	public void ClickShippingMethodToolTip(String itemNumber) throws Exception{
		Find.Object("rspShippingMethodToolTip").changeContainsText(itemNumber).click();
	}

	@Override
	public void ClickNextOnMobile() throws Exception{
		Thread.sleep(5000);
		if (Find.Object("nextStepBagPage_AAF").isDisplayed()) {
			Thread.sleep(4000);
			Find.Object("nextStepBagPage_AAF").javascriptClick();
		}
		Thread.sleep(7000);
	}

	@Override
	public void ClickEditOnMobile() throws Exception {
		if(Find.Object("editRs_AAF").isPresent()){
			Report.pass("User Clicks on Edit Button on Review and Submit Page");
			Find.Object("editRs_AAF").click();
			Find.Object("newAddress_AAF").click();
		}else{
			Report.fail("Edit Button is NOT Available");
		}

	}

	@Override
	public void ClickEditShippingAddressOnMobile() throws Exception {
		if (Find.Object("editShippingAddressOnMobile_AAF").isPresent()){
			Report.pass("Edit Shipping Address is Present",BrowserAction.screenshot());
		}else{
			Report.fail("Edit Shipping Address is NOT Present",BrowserAction.screenshot());
		}
		Find.Object("editShippingAddressOnMobile_AAF").click();
		if (Find.Object("clickEditShiiping_AAF").isPresent()){
			Report.pass("Edit Shipping Address is Clicked", BrowserAction.screenshot());
		}else{
			Report.fail("Edit Shipping Address is NOT Worked",BrowserAction.screenshot());
		}
		Find.Object("clickEditShiiping_AAF").click();
	}

	@Override
	public void ClickEditBillingAddressOnMobile() throws Exception {
		StepLogger.validate(Check.ObjectPresent, "editBillingAddressOnMobile_AAF");
		Find.Object("editBillingAddressOnMobile_AAF").click();
		StepLogger.validate(Check.ObjectPresent, "editOnBillingOverlay_AAF");
		Find.Object("editOnBillingOverlay_AAF").click();
	}

	@Override
	public void ClickEditPaymentOnMobile() throws Exception {
		StepLogger.validate(Check.ObjectPresent, "clickEditOnPayment_AAF");
		Find.Object("clickEditOnPayment_AAF").click();
		//StepLogger.validate(Check.ObjectPresent, "clickEditOnMobilePayment_AAF");
		Find.Object("clickEditOnMobilePayment_AAF").click();
	}

	@Override
	public void EnterShippingAddress(String firstName, String lastName, String address, String city, String zipCode, String state, String phoneNumber) throws Exception {

		Find.Object("firstNameOnChange_AAF").input(firstName);
		Find.Object("lastNameChange_AAF").input(lastName);
		Find.Object("addressChange_AAF").input(address);
		Find.Object("cityChange_AAF").input(city);
		Find.Object("zipcodeChange_AAF").input(zipCode);
		Find.Object("state_AAF").select(state);
		Find.Object("phoneNumberChange_AAF").input(phoneNumber);
		Find.Object("clickApply_AAF").click();
	}

	@Override
	public void ChangeShippingAddressOnMobile(String address) throws Exception {

		if (Find.Object("addressChange_AAF").isPresent()){
			Report.pass("Address line Present");
		}else{
			Report.fail("Address Line is NOT Present");
		}
		Find.Object("addressChange_AAF").clear();
		Find.Object("addressChange_AAF").input(address);

		Find.Object("clickApply_AAF").click();

	}
}
