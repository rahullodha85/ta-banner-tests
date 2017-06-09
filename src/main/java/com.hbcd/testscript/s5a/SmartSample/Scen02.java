package com.hbcd.testscript.s5a.SmartSample;

import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by 461967 on 8/22/2016.
 */
public class Scen02 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception{
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag();
        pdp.EnterBag();
        bag.ClickSmartSample().IsSmartSampleOverlay();
        sso.SelectSample(1);
        sso.SelectSample(1);
        sso.SelectSample(1);
        sso.ValidateDisabledItemSelection();
        sso.UnselectSample();
        sso.ClickApply();
        bag.ClickCheckout().LoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        rsp.ClickPlaceOrder();
        ValidateConfirmation.isThankYouPage();
    }
}
