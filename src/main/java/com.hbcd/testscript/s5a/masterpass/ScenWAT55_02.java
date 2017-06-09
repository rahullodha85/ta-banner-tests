package com.hbcd.testscript.s5a.masterpass;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.base.ScenarioSaks;

/**
 * Created by richardjap on 12/23/2016.
 */
/**
 We need to disable MasterPass when the site context is set to anything other than USA.
 acceptance criteria:
 Scenario 2: As a registered international customer, I can't pay with MasterPass
 GIVEN The site context is not US
 AND I am signed in to my saks.com account
 WHEN I edit my payment method in checkout
 THEN I will not see the MasterPass option in the list of available payment methods
 */

public class ScenWAT55_02 extends ScenarioSaks {
    @Override
    public void executeScript() throws Exception {
        nav.ChangeCountry("Canada");
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
