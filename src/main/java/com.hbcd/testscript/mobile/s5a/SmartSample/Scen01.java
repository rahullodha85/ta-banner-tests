package com.hbcd.testscript.mobile.s5a.SmartSample;

import com.hbcd.banner.mobile.saks.validations.ValidateConfirmation;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Navigate;


/**
 * Created by 461967 on 8/22/2016.
 */
public class Scen01 extends ScenarioMobileSaks {
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
        bag.ClickCheckout().ClickGuestCheckout();
        shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true,"","1111111111");
        pap.AddNewCreditCard(3);
        pap.ClickCheckout();
        rsp.ClickPlaceOrder();
        ValidateConfirmation.hasOrderNumber();
    }
}
