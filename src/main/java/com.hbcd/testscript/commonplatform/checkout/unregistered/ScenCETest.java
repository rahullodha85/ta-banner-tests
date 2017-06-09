package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class ScenCETest extends ScenarioCommonPlatform {
	public void executeScript() throws Exception {
		nav.SearchFor("0438386556826");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(
				"ce" + Common.getUniqueNumber() + "@s5a.com");
		shp.AddShippingAddress(false, "13 E 49 street", "New York", "New York", "10017",false);
		shp.ClickCheckoutOptionalAddressConfirmation();
		pap.AddNewCreditCard(3);//mastercard
		pap.ClickCheckout();
		rsp.ClickShipToMultipleAddresses();
		rsp.ChangeItemLevelShippingAddress("0438386556826","14 E 49 street", "New York", "New York","10017",false);
		
		rsp.ClickSignatureRequiredDelivery("0438386556826");
		rsp.ClickEditShippingMethod();
		ValidateRs.IsSignatureAtDeliveryCheckedInOverlay();
		rsp.ClickCloseShippingMethodOverlay();
		ValidateRs.IsSignatureAtDeliveryChecked("0438386556826");
		

		//rsp.ClickEditShippingMethod("0438386556826", null).UpdateShippingMethod("Rush",true);

//		rsp.ClickEditShippingMethod("0438386556826", null).UpdateShippingMethod("Rush",true);

		
		
		//rsp.ClickEditShippingMethod();
		//ValidateRs.IsSignatureAtDeliveryNotCheckedInOverlay();

	//	rsp.ClickEditShippingMethod("0448882328957", null).UpdateShippingMethod("Standard",false);

//		rsp.ClickEditShippingMethod("0448882328957", null).UpdateShippingMethod("Standard",false);

		//ValidateRs.IsSignatureAtDeliveryNotChecked("0448882328957");
		
	
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
		ValidateConfirmation.itemRowHasText("0438386556826", "14 E 49 street");
		ValidateConfirmation.itemRowHasText("0438386556826", "Rush");
	}
}
