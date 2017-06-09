package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.banner.mobile.saks.validations.ValidatePrp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen55 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		// Need PRE-ORDER item
		String preOrderItem1= itemData.get(ItemType.PREORDER);

		nav.SearchFor(preOrderItem1 + " ");
		ValidatePrp.isPreOrderItem(preOrderItem1);
		nav.SearchFor(preOrderItem1);
		ValidatePdp.ColorSizeDrpDwnHasPreOrder();
		pdp.AddToBag("1",1);
		pdp.EnterBag();
		ValidateBag.hasPreOrderMessage(preOrderItem1);
		ValidateBag.hasLatestExpectedShipDate(preOrderItem1);
		
		
}
}