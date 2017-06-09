package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Scen34 extends ScenarioCommonPlatform {
	public void executeScript() throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		gcp.VirtualGiftCardAddToBag("sender", "receipent", "test@test.com",
				"test@test.com", "test message", new SimpleDateFormat("MM/dd/yyyy")
						.format(cal.getTime()));
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
//		ValidateRs.isVegc("0499928820294");//dynamic object check
		rsp.ClickPlaceOrder();
//		ValidateRs.isVegc("0499928820294");//dynamic object check
		ValidateConfirmation.isThankYouPage();
	}
}
