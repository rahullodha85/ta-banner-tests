package com.hbcd.testscript.lt.ltm_checkout_userstories.B18966;

import com.hbcd.banner.LordAndTaylor.fullsite.Validations.ValidateReviewAndSubmitPage;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.utility.helper.Common;

/**
 * Created by aalfaruk on 10/18/2016.
 * B-18966
 * L&TM: 3 Countries Billing Address Book (domestic)
 * display only 3 countries
 GIVEN I am a registered LT user
 WHEN I am adding a new address at my billing address book
 THEN I only see United States, Canada and United Kingdom in countries list
 */
public class Scen01 extends ScenarioCommonPlatform{

    @Override
    public void executeScript() throws Exception{
        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        int uniqueNumber= Common.getUniqueNumber();
        rsp.ClickEditBillingAddress();
        ValidateReviewAndSubmitPage.isDisplayForThreeCountriesAvailable("United States");
        ValidateReviewAndSubmitPage.isDisplayForThreeCountriesAvailable("Canada");
        ValidateReviewAndSubmitPage.isDisplayForThreeCountriesAvailable("United Kingdom");
    }
}
