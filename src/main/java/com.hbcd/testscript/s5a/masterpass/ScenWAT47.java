package com.hbcd.testscript.s5a.masterpass;

import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by 901124 on 12/19/16.
 * acceptance criteria:
 S1: I am signed in to my saks.com account and I want to pay with MasterPass
 GIVEN I am signed in to my saks.com account
 AND I have a valid MasterPass account
 WHEN I select MasterPass from the Payment Type pulldown menu
 THEN Then I can continue to MasterPasss
 */
public class ScenWAT47 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(),
                dataObject.getLoginPassword());
        rsp.ClickEditCreditCard();
        rsp.ClickEnterNewCCRadioButton();
        ValidateRs.isCreditCardNotPresent("masterpass");
    }
}