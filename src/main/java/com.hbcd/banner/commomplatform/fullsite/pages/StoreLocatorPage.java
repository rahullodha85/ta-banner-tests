package com.hbcd.banner.commomplatform.fullsite.pages;

import com.hbcd.commonbanner.base.pages.StoreLocatorPageBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

/**
 * Created by 461967 on 6/1/2016.
 */
public class StoreLocatorPage extends StoreLocatorPageBase {
    @Override
    public void SearchBy(String city, String state) throws Exception {
        Find.Object("slpSearchByTxt_ws").clear();
        Find.Object("slpSearchByTxt_ws").input(city);
        Find.Object("slpStateBox_ws").click();
        New.Object("").setProperty(Type.PropertyType.CSS_SELECTOR, "div[id='storesState_container']")
                .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                .setChildProperty(Type.PropertyType.TAG_NAME, "li")
                .setChildProperty(Type.PropertyType.CONTAINS_TEXT, state).click();


        Find.Object("slpSearchBtn_ws").click();

        if(Find.Object("slpFirstAddressTxt_ws").isPresent()){

            Report.pass("Address present", BrowserAction.screenshot());
        }
        StepLogger.validate(Check.ObjectPresent, "slpFirstAddressTxt_ws");

    }

    @Override
    public void SearchBy(String zip) throws Exception {
        Find.Object("slpSearchByZipTxt_ws").clear();
        Find.Object("slpSearchByZipTxt_ws").input(zip);
        Find.Object("slpSearchBtn_ws").click();
        if(Find.Object("slpFirstAddressTxt_ws").isPresent()){

            Report.pass("Address present", BrowserAction.screenshot());
        }
        StepLogger.validate(Check.ObjectPresent, "slpFirstAddressTxt_ws");

    }

    @Override
    public void StoreEvents() throws Exception {

        if(Find.Object("slpViewStoreEvents_ws").isPresent()){

            New.Object("").setProperty(Type.PropertyType.CSS_SELECTOR, "tr[class='searchResultRow']")
                    .setProperty(Type.PropertyIntType.iTH, 1)
                    .setProperty(Type.PropertyIntType.IS_PARENT, 1)
                    .setChildProperty(Type.PropertyType.TAG_NAME, "a")
                    .setChildProperty(Type.PropertyType.CONTAINS_TEXT, "View Store Events")
                    .click();
        }


    }
}
