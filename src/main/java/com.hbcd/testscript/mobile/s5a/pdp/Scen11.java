package com.hbcd.testscript.mobile.s5a.pdp;


import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen11 extends ScenarioCommonPlatform {
	//adding dropship item

	@Override
	public void executeScript() throws Exception {
		String dropshipItem = itemData.get(ItemType.DROPSHIP);

		nav.SearchFor(dropshipItem);
		pdp.AddToBag(2);
		ValidateAemPdp.numberOfItemsAddedOverlayMessage(2);
		pdp.EnterBag();
		ValidateBag.isItemPresentInBag(dropshipItem);
	}
}
