package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 901124 on 12/7/16.
 *
 * UserStory Description:
 * We need to disable MasterPass when the site context is set to anything other than USA.
 acceptance criteria:
 S1: As an international guest customer, I can't checkout with MasterPass
 GIVEN The site context is not US
 THEN MasterPass will not be enabled
 AND I will not see the MasterPass button on the bag
 */

public class ScenWAT13_01 extends ScenarioSaks {
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