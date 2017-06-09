package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.s5a.overlays.s5a_FindInStore;
import com.hbcd.banner.validations.s5a.ValidateFindInStore;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateStoreLocationEvents;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.overlays.FindInStore;
import com.hbcd.scripting.core.Storage;

public class Scen44 extends ScenarioSaks {

	// Validating Find in store layer
	@Override
	public void executeScript() throws Exception {
		
		nav.SearchFor(dataObject.getSkuListInfo().get(0));
		ValidatePdp.FindInStoreLink();
		pdp.ClickInStore();
		fis.SearchStores();
		ValidateFindInStore.StoreResults();
		fis.ClickFirstSearchResult();
		Storage.save("addressTitle", fis.FirstStoreAddress());
		ValidateStoreLocationEvents.StoreAddress(Storage.get("addressTitle"));
			
	}
}