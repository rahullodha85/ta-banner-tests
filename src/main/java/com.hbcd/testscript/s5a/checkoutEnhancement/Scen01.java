package com.hbcd.testscript.s5a.checkoutEnhancement;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Scen01 extends ScenarioChkout {


	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		pdp.AddToBag(1);
		
		nav.SearchFor(dataObject.getSkuListInfo().get(1));
		pdp.AddToBag(2);
		
		pdp.EnterBag();
		
		bag.ClickCheckout().LoginWith(dataObject.getEmailID(),dataObject.getLoginPassword());
		if(Find.Object("rspShippingMethodDesc_WS").isPresent())
			System.out.println("Order level shipping method is displayed.");
		if(Find.Object("rspShippingMethodMessage_WS").changeContainsText(dataObject.getSkuListInfo().get(1)).isPresent()){
			
			System.out.println("Item specific shipping method is displayed.");
		}
		//shipping method overlay
		Find.Object("rspAddressLevelShpMtdEditBtn_WS").changeContainsText(dataObject.getSkuListInfo().get(1)).click();
		Find.Object("rspShippingMethodOverlayRadio_wk").changeChildContainsText("Next Bus. Day").click();
		Find.Object("rspShippingMethodOverlayApplyBtn_wk").click();
		Thread.sleep(5000L);
		if(Find.Object("rspShippingMethodDesc_wk").changeContainsText(dataObject.getSkuListInfo().get(1)).getText().value().contains("Next Bus. Day")){
			System.out.println("Shipping Method is Next Business Day.");
		}
		
		Find.Object("rspShippingSignatureCheckBx_WS").changeContainsText(dataObject.getSkuListInfo().get(1)).click();
		
		// Ship to multiple then selecting address from dropdown
		if(Find.Object("bagErorMessageTxt_wk").isPresent() && 
				Find.Object("bagErorMessageTxt_wk").getText().value().contains("There has been an error")){
			System.out.println("THIS SHOULD NOT BE HAPPENING!!!!!!!!!!!");
			System.out.println("Handling Error message at bag: proceeding with checkout");
			bag.ClickCheckout();
		}
		rsp.ClickShipToMultipleAddresses();
		Find.Object("shpShippingDropDownBtn_wk").changeContainsText(dataObject.getSkuListInfo().get(1)).select(1);

		// chagning to Rush
		Find.Object("shpShippingMethodDropDown_wk").changeContainsText(dataObject.getSkuListInfo().get(1)).select("Rush");
		
		// clicking edit shipping for selected item after multi ship and inputting address
		Find.Object("shpShipToMulti_WS").changeContainsText(dataObject.getSkuListInfo().get(1)).click();
		Find.Object("shpOverlayAddressTxt_wk").clear();
		Find.Object("shpOverlayAddressTxt_wk").input("53 W23rd ST");
		Find.Object("shpOverlayApplyBtn_wk").click();
		
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
	}
}
