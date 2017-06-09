package com.hbcd.testscript.s5a.localizedPriceBook.COMX;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;


public class B12406_AddAssociateAndStoreId extends ScenarioChkout {

    public void executeScript() throws Exception {

//        nav.SelectCountry("Canada");
//        ValidateNav.hasDefaultCurrency("Canadian Dollar");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();


    }

}
