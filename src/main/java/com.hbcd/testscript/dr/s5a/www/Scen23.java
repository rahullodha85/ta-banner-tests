package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.enums.BotNavLinks;
import com.hbcd.scripting.core.Storage;

import java.util.Date;

public class Scen23 extends ScenarioSaks{
	@Override
	public void executeScript() throws Exception {
		nav.ClickBottomNavLink(BotNavLinks.GIFTCARDS);
		//click vegc
		prp.clickVegc();
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickCheckout().LoginWith("drScen23@saks.com", "test123");
		rsp.ClickPlaceOrder();
		String timeStamp = Long.toString(new Date().getTime());
		String varOrderNumber = "Order_Number_" + timeStamp;
		Storage.save(varOrderNumber, ValidateConfirmation.getOrderNumber());
		yap.GoToMyAcccount().CancelOrder(Storage.get(varOrderNumber), "10017");
	}
}
