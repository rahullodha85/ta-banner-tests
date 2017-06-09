package com.hbcd.testscript.commonplatform.pdp;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen27 extends ScenarioCommonPlatform {

    @Override
    public void executeScript() throws Exception {

        nav.ChangeCountry("Canada");
        nav.SearchFor(InputData.get("item1").value());
        ValidatePdp.isIsternationalCurrencyDisplayed();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.isInternationalPriceOnBagPage();
    }
}
