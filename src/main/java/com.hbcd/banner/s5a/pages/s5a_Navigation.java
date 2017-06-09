package com.hbcd.banner.s5a.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.Navigation;
import com.hbcd.banner.commomplatform.fullsite.pages.StoreLocatorPage;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;


public class s5a_Navigation extends Navigation {
    @Override
    public StoreLocatorPage ClickStoreLocator() throws Exception {
        super.ClickStoreLocator();
        return new s5a_StoreLocator();
    }

    @Override
    public void SelectCountry(String country) throws Exception{
        Find.Object("navChangeCountryBtn").click();

        Find.Object("changeCountryDrpDwn").select(country);
    }
    @Override
    public void ChangeCountry(String country) throws Exception {
        SelectCountry(country);
        Find.Object("changeCountrySaveBtn").click();
        if(Find.Object("shippingCountry_vm").getAttribute("outerHTML").value().toString().toLowerCase().indexOf("US.gif")<0){
            Report.pass("Country Changed", BrowserAction.screenshot());
        }
        else {
            Report.fail("Country not Changed",BrowserAction.screenshot());
        }
    }
}
