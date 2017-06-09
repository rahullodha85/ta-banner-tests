package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.scripting.core.Find;

/**
 * Created by nithajomy on 12/15/2016.
 */
public class ScenWAT13_02 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("United Kingdom");
        nav.ClickSignInLink();
        yap.Login(dataObject.getEmailID(), dataObject.getLoginPassword());
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        bag.ClickCheckout();
        rsp.ClickEditCreditCard();
        rsp.ClickEnterNewCCRadioButton();
        ValidateRs.isCreditCardNotPresent("masterpass");
    }
}
