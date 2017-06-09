package com.hbcd.banner.mobile.s5a.pages.redesign;

import com.hbcd.banner.mobile.saks.pages.mShippingPage;
import com.hbcd.commonbanner.pages.ShippingPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.helper.Common;

public class mRedesignShippingPage extends mShippingPage implements
		ShippingPage {

	@Override
	public void AddShippingAddress(Boolean shipToMultiple, String address,
			String state, String city, String zip, boolean makeDefault)
			throws Exception {
		Storage.save("shippingAddress", address);
		insertCredentials(address, state, city, zip);


		if (!makeDefault == true) {
			// By default this check box is checked
			Find.Object("shipMakethisBilling_WS").click();
		}
		Find.Object("shippingBillingPhoneTxt_wk").input("9136120800");
		String email = "abc" + Common.getUniqueNumber() + "@saks.com";
		Find.Object("shippingBillingEmailTxt_wk").input(email);
		Storage.save("email", email);
		StepLogger.validate(Check.ObjectPresent, "shpNextBtn_WS");
		Find.Object("shpNextBtn_WS").javascriptClick();
		//fill this method for not international
		if (isNotInternational()) {
			if (Find.Object("shpUseAddressOverlay_WS").isPresent())
				Find.Object("shpUseThisAddress_WS").javascriptClick();
		}
	}

	/**
	 * Method used only when Email or Phone Number needs to be entered through
	 * script
	 */
	private boolean isNotInternational(){
		return true;
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
		Find.Object("shippingBillingEmailTxt_wk").clear();
		if(email == "" || email == null) {
			Find.Object("shippingBillingEmailTxt_wk").input("checkoutenhancements" + Common.getUniqueNumber() + "@saks.com");
		}

		StepLogger.validate(Check.ObjectPresent, "shpNextBtn_WS");
		Find.Object("shpNextBtn_WS").click();

		if (Find.Object("shpUseAddressOverlay_WS").isPresent())
			Find.Object("shpUseThisAddress_WS").click();

	}
	@Override
	public void AddBillingAddress(String address, String state, String city,
								  String zip, boolean makeDefault) throws Exception {

	}
	@Override
	public void EditBillingZipCode(String zipCode) throws Exception{

	}
}
