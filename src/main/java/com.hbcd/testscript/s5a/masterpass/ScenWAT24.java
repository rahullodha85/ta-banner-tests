package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioCommonPlatform;

/**
 * Created by 901124 on 12/13/16.
 * As an international guest customer, I can't checkout with MasterPass
 GIVEN The site context is not US
 THEN MasterPass will not be enabled
 AND I will not see the MasterPass button on the bag
 */
public class ScenWAT24 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("Australia");
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.hasNoMasterPassButton();
    }
}