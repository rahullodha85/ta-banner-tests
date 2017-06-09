package com.hbcd.banner.common.paypal;

import com.hbcd.commonbanner.pages.PayPalInformationPage;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;

public class pInformationPage implements PayPalInformationPage {

	public void continueFromPaypal() throws Exception {
		
//		StepLogger.validate(Check.ObjectPresent, "paplContinueBtn");
		Thread.sleep(5000);
		Switch.toDefaultContent();
		if(Find.Object("paplContinueBtn").isPresent()) {
			Find.Object("paplContinueBtn").click();
		}else if(Find.Object("paplContinueBtnOld").isPresent()){
			Find.Object("paplContinueBtnOld").click();
		}else{
			Report.fail("Paypal continue button not found", BrowserAction.screenshot());
		}
		Thread.sleep(5000);
	}
	
	public void AddNewInternationalShippingAddress(String country,String name,String address1,String city,String province,String zip) throws Exception {
		
		Find.Object("pChangeAddressBtn").click();
		Find.Object("pAddNewShipAddBtn").click();
		Find.Object("pAddNewShipCountryDrpDwn").select(country);
		Find.Object("pAddNewShipName").input(name);
		Find.Object("pAddNewShipAdd1").input(address1);
		Find.Object("pAddNewShipCity").input(city);
		Find.Object("pAddNewShipProvince").select(province);
		Find.Object("pAddNewShipZip").input(zip);
		Find.Object("pdAddNewShipSaveBtn").click();
	} 

}
