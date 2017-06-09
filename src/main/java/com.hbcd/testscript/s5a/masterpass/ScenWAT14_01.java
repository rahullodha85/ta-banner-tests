package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidateSignInPage;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by nithajomy on 12/7/2016.
 * When I am signed in to my saks.com account, I will not see the 'Checkout with MasterPass' button on the bag page
 */
public class ScenWAT14_01 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        {
            nav.ClickSignInLink();
            ValidateSignInPage.IsSignInPage();
            yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
            String item1 = dataObject.getSkuListInfo().get(0);
            nav.SearchFor(item1);
            pdp.AddToBag(1);
            pdp.EnterBag();
            ValidateBag.hasNoMasterPassButton();
        }
    }
}
