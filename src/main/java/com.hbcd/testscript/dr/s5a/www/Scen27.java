package com.hbcd.testscript.dr.s5a.www;


import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;

public class Scen27 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0476971482418");
		pdp.AddToBag(1);
		nav.SearchFor("0476971482418");
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.UpdateQuantity("0476971482418", "3");
		bag.UpdateQuantity("0476971482418", "1");
		bag.selectShippingMethod("Rush");
		bag.ClickCheckout().LoginWith("drorigin1@s5a.com", "test123");
		rsp.ClickShipToMultipleAddresses();
		//edit shipping address
		shp.ClickMultiContinue();
		rsp.ClickPlaceOrder();
		Storage.save("orderNumber", ValidateConfirmation.getOrderNumber());
		nav.ClickSaksYourAccount();
		yap.CancelOrder(Storage.get("orderNumber"), "10017");
	}
}
