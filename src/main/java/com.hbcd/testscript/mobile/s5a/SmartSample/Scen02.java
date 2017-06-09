package com.hbcd.testscript.mobile.s5a.SmartSample;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;

/**
 * Created by 461967 on 8/22/2016.
 */
public class Scen02 extends ScenarioMobileSaks {
    @Override
    public void executeScript() throws Exception {
        Navigate.go(Navigate.currentUrl());
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
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
        ValidateConfirmation.hasOrderNumber();
    }
}
