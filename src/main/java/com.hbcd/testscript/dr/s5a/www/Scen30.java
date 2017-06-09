package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.mobile.saks.validations.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;
import org.apache.commons.lang.Validate;

public class Scen30 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		String item1 = itemData.get(ItemType.REGULAR);
		String item2 = itemData.get(ItemType.REGULAR);
		String item3 = itemData.get(ItemType.REGULAR);

		nav.SearchFor(item1);
		pdp.AddToBag(1);
		nav.SearchFor(item2);
		pdp.AddToBag(1);
		nav.SearchFor(item3);
		pdp.AddToBag(1);
		pdp.EnterBag();
		bag.ClickSaveForLater(item1);
		ValidateBag.hasAlsoHaveSavedItemMessage();
		ValidateBag.ShopRunnerIconInSavedItemsSection(item1);
		bag.MoveToBag(item1);
		ValidateBag.isItemPresentInBag(item1);

	}
}
