package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class ValidatePymt {

	public static void isQuantityUpdatedTo(String skuid,String qty) throws Exception {
		
		if(Find.ObjectWith("jsItemRoot", "data-cartproductcode", skuid, "description-list").getText().value().indexOf(qty)>=0)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}

	public static void hasBuyOneGetOnePromoOnPaymentPage(String promoMessagePymt) throws Exception{
		if (Find.Object("ofm_promoMessageMiniBag_AAF").isPresent()){
			Report.pass("MiniBag displayed Promo Message: " + promoMessagePymt, BrowserAction.screenshot());
			Find.Object("ofm_promoMessageMiniBag_AAF").getText().value().contains(promoMessagePymt);
		}else{
			Report.fail("MiniBag is NOT displayed the Promo Message: " + promoMessagePymt,BrowserAction.screenshot());
		}
	}

}
