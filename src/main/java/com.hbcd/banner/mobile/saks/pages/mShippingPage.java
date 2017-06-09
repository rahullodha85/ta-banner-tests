package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.commonbanner.base.pages.ShippingPageBase;
import com.hbcd.commonbanner.overlays.*;
import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mShippingPage extends ShippingPageBase {

	@Override
	public QASOverlay ClickCheckoutOptionalAddressConfirmation() throws Exception {
		return null;
	}

	@Override
	public AddressOverlay ClickEditShippingAddress() throws Exception {
		return null;
	}

	@Override
	public void ClickEditBillingAddress() throws Exception {

	}
	@Override
	public void ClickNewBillingAddress() throws Exception{

	}

	@Override
	public void AddBillingAddress(String address, String state, String city,
			String zip, boolean makeDefault) throws Exception {

	}

	@Override
	public void AddShippingAddress(Boolean shipToMultiple, String address,
			String state, String city, String zip, boolean makeDefault)
			throws Exception {
		
		insertCredentials(address, state, city,zip);
		
		
		Find.Object("shpPhone_WS").clear();
		Find.Object("shpPhone_WS").input("9136120800");
		
		
		if(!makeDefault==true){
//			By default this check box is checked
			Find.Object("shipMakethisBilling_WS").click();	
		}
		
		StepLogger.validate(Check.ObjectPresent, "shpNextBtn_WS");
		Find.Object("shpNextBtn_WS").click();
		
		if(Find.Object("shpUseAddressOverlay_WS").isPresent())
			Find.Object("shpUseThisAddress_WS").click();
		}
		
	public static void insertCredentials(String address,
			String state, String city,String zip) throws Exception{
		StepLogger.validate(Check.ObjectPresent, "shpFirstName_WS");
		Find.Object("shpFirstName_WS").clear();
		Find.Object("shpFirstName_WS").input("Abc");
		Find.Object("shpLastName_WS").clear();
		Find.Object("shpLastName_WS").input("Def");
		Find.Object("shpAddress1_WS").clear();
		Find.Object("shpAddress1_WS").input(address);
		Find.Object("shpState_WS").select(state);
		Find.Object("shpCity_WS").clear();
		Find.Object("shpCity_WS").input(city);
		Find.Object("shpZip_WS").clear();
		Find.Object("shpZip_WS").input(zip);
	}

	@Override
	public AddressOverlay EnterShippingAddress(String checkOutFlow)
			throws Exception {
		return null;
	}

	@Override
	public void ClickDomesticShpAddClose() throws Exception {

	}
	@Override
	public void ClickNewShippingAddress() throws Exception{

	}

	@Override
	public void ClickInternationalShipping() throws Exception {

	}

	@Override
	public void ClickCheckoutWithPaypal() throws Exception {

	}

	@Override
	public void SelectAddress(String addressName) throws Exception {

	}

	@Override
	public AddressOverlay ClickAddShippingAddress() throws Exception {
		return null;
	}
	public void AddShippingAddress(Boolean shipToMultiple, String address,
			String state, String city, String zip, boolean makeDefault,
			String email, String phone) throws Exception {
		Storage.save("shippingAddress", address);
		Storage.save("email", email);
		insertCredentials(address, state, city,zip);
		
		

		if (!makeDefault == true) {
			// By default this check box is checked
			Find.Object("shipMakethisBilling_WS").click();
		}
		Find.Object("shippingBillingPhoneTxt_wk").clear();
		Find.Object("shippingBillingPhoneTxt_wk").input(phone);
//		Find.Object("shippingBillingEmailTxt_wk").clear();
//		Find.Object("shippingBillingEmailTxt_wk").input(email);

		StepLogger.validate(Check.ObjectPresent, "shpNextBtn_WS");
		Find.Object("shpNextBtn_WS").click();

		if (Find.Object("shpUseAddressOverlay_WS").isPresent())
			Find.Object("shpUseThisAddress_WS").click();

	}
	@Override
	public void EditShippingZipCode(String zipCode) throws Exception{

	}
	@Override
	public void SelectCountry(String country) throws Exception{

		StepLogger.validate(Check.ObjectPresent,"shpCountry_WS");
		Find.Object("shpCountry_WS").select(country);

	}
}
