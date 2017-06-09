package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B11967_Welcome_Mat extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*

        Scenario: Display of Welcome Mat (Triggered by IP Detection)
        GIVEN that IP detection is triggering the site to display with an international context
        AND it’s the first time that the site is loading with an international context
        WHEN the site loads
        THEN display the Welcome Mat for the respective country identified via IP detection

        Scenario: Display of Welcome Mat (Manually Updating the Context Chooser)
        GIVEN that I manually update the site context via the Context Chooser
        AND it’s the first time that the site is loading with an international context
        WHEN the site loads
        THEN display the Welcome Mat for the respective country that was manually selected

        Scenario: Display the Welcome Mat Again After 30 Days
        GIVEN the site is automatically or manually updated into an international context
        AND 30 or more days has elapsed since the last display of the Welcome Mat
        WHEN the site loads
        THEN display the Welcome Mat once again

       */
        nav.ChangeCountry("India");
        //Some scenario can't be automated

    }
}


