package com.hbcd.banner.s5a.pages;


import com.hbcd.banner.commomplatform.fullsite.pages.BagPage;
import com.hbcd.banner.common.paypal.pBag;
import com.hbcd.banner.s5a.overlays.s5a_GiftOverlay;
import com.hbcd.banner.s5a.overlays.s5a_LoginOverlay;
import com.hbcd.banner.s5a.overlays.s5a_QuickLookOverlay;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.commonbanner.overlays.SmartSampleOverlay;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class s5a_BagPage extends BagPage {
	private pBag pBagSaks;
	public s5a_BagPage(){
		pBagSaks=new pBag();
	}
	@Override
	public void ClickPaypal() throws Exception {
		pBagSaks.ClickPaypal();
		Thread.sleep(5000);
		//StepLogger.validate(Check.TextPresent, "paypalPage_wk","Log in to your account to complete the purchase");
	}

	@Override
	public SmartSampleOverlay ClickSmartSample() throws Exception {
		if(Find.Object("bagSmartSample_RL").isPresent()) {
			Report.pass("Smart Sample banner found and clicked");
			Find.Object("bagSmartSample_RL").click();
		} else {
			Report.dataFail("Smart sample banner not present," +
					" please verify if this item is eligible for smart sample promo");
		}
		return new s5a_SmartSampleOverlay();
	}

	@Override
	public LoginOverlay ClickCheckout() throws Exception {
		super.ClickCheckout();
		return new s5a_LoginOverlay();
	}

	public LoginOverlay LoginOverlay() throws Exception{
		super.LoginOverlay();
		return new s5a_LoginOverlay();
	}

	@Override
	public QuickLookOverLay ClickEditFor(String upc) throws Exception {
		super.ClickEditFor(upc);
		return new s5a_QuickLookOverlay();
	}

	@Override
	public GiftOverlay MakeGift(String itemId) throws Exception {
		super.MakeGift(itemId);
		return new s5a_GiftOverlay();
	}
}
