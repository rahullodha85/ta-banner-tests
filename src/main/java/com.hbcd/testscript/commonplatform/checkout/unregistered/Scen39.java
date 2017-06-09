package com.hbcd.testscript.commonplatform.checkout.unregistered;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;
import com.hbcd.scripting.core.Storage;

public class Scen39 extends ScenarioCommonPlatform{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(1);
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().ClickGuestCheckout();
		shp.AddShippingAddress(false, dataObject.getAddress1(), dataObject.getState(), dataObject.getCity(), dataObject.getZipCode(), true);
		pap.AddNewCreditCard(3);//mastercard
		pap.EnterPassword("test123", "test123");
		pap.ClickCheckout();
		
		rsp.MakeGift(dataObject.getSkuListInfo().get(0)).With("Automation", "test1", "no wrap");
		rsp.ClickShipToMultipleAddresses();
		rsp.EnterNewShippingAddress(dataObject.getSkuListInfo().get(0), "abd blvd", "NEW YORK", "New York", "10017", true);
		
		shp.SelectRequireSignatureFor(dataObject.getSkuListInfo().get(0));
		shp.SelectRequireSignatureFor(dataObject.getSkuListInfo().get(1));
		shp.SelectShippingMethodFor(dataObject.getSkuListInfo().get(0), ShipMethod.RUSH);
		shp.ClickContinueAfterMultiShip();

		//re-visit
//		rsp.ClickEditShippingMethod(dataObject.getSkuListInfo().get(1), ShipMethod.STANDARD);
		ValidateRs.IsSignatureAtDeliveryChecked(dataObject.getSkuListInfo().get(1));

		Storage.save("shippingCharge", rsp.GetShippingCharge());
		rsp.ClickPlaceOrder();

		ValidateConfirmation.hasSignatureRequiredAtDelivery(dataObject.getSkuListInfo().get(1));
		ValidateConfirmation.hasNoSignatureRequiredAtDelivery(dataObject.getSkuListInfo().get(0));
		ValidateConfirmation.ShippingAddressContains("abd blvd");
		ValidateConfirmation.isGiftWrapApplied(dataObject.getSkuListInfo().get(0), "Gift Wrap");
		ValidateConfirmation.isShippingChargeApplied();
		ValidateConfirmation.ShippingMethod("Standard",dataObject.getSkuListInfo().get(1));

	}
}
