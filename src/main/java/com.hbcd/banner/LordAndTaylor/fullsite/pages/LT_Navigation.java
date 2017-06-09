package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.pages.o5_StoreLocatorPage;
import com.hbcd.banner.commomplatform.fullsite.pages.Navigation;
import com.hbcd.banner.commomplatform.fullsite.pages.StoreLocatorPage;
import com.hbcd.scripting.core.Find;

/**
 * Created by 461967 on 6/1/2016.
 */
public class LT_Navigation extends Navigation {
    @Override
    public StoreLocatorPage ClickStoreLocator() throws Exception {
        super.ClickStoreLocator();
        return new o5_StoreLocatorPage();
    }
    @Override
    public void SelectDesigner(String designer) throws Exception {
        Find.Object("brand_vev").click();
        Find.Object("designer_checkbox_vev").click();
        Find.Object("clickApplyForFilter_AAF").click();

       // if(Find.Object("navSelectedTab_wk").isPresent());
        //StepLogger.validate(Check.TextPresent, "prpFirstItem", designer, BrowserAction.screenshot());
        //else StepLogger.validate(Check.TextPresent, "LeftNavSelectBoxValidation_wk", designer, BrowserAction.screenshot());
    }
    @Override
    public void ClickStores() throws Exception {
        Find.Object("StoreLocations").click();
    }
}
