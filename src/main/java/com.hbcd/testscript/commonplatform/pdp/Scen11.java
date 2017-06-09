package com.hbcd.testscript.commonplatform.pdp;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen11 extends ScenarioCommonPlatform {
	//dropship item

	@Override
	public void executeScript() throws Exception {
		String dropshipItem = itemData.get(ItemType.DROPSHIP);

		nav.SearchFor(dropshipItem);
//		Pre-condition:Select an item that is configured with no color and no size - dropship item/ candles Regular item #:
		pdp.AddToBag(2);
		ValidateAemPdp.numberOfItemsAddedOverlayMessage(2);
//		pdp.EnterBag();
//		ValidateBag.isItemPresentInBag(dropshipItem);

	}


}
