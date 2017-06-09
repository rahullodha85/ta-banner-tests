package com.hbcd.testscript.commonplatform.borderfree;

import com.hbcd.banner.mobile.saks.validations.ValidateHome;
import com.hbcd.banner.validations.s5a.ValidateNav;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateRs;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.CurrencyType;

/**
 * Created by vevinmoza on 11/16/15.
 */
public class Scen_B11541_Manually_Update_the_Context_Chooser extends ScenarioChkout {
    public void executeScript() throws Exception {

       /*
     Scenario: Manually Changing the Selected Country
    GIVEN I click on the Context Chooser
    AND select a country from the shipping selections
    WHEN the localized site loads
    THEN update the localized site elements for the respective country
    AND prepopulate the currency field for the Context Chooser with the default currency for the selected country

    Scenario: Manually Changing the Selected Currency
    GIVEN I click on the Context Chooser
    AND select a currency from the provided options
    WHEN the localized site loads
    THEN update the localized site elements for the respective currency

    Scenario: Clicking the Back to U.S. Site Link
    GIVEN I am on the Context Chooser
    WHEN I click the Back to U.S. site link
    THEN display the default (U.S.) site elements
     */
        nav.SelectCountry("India");
        ValidateNav.hasDefaultCurrency("Indian Rupee");
        nav.ClickBackToUSSite();
        //********************************
        nav.ChangeCountry("India");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasCurrency(CurrencyType.NIL);
        //***************************
        nav.SelectCountry("India");
        nav.ClickBackToUSSite();
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        ValidatePdp.hasCurrency(CurrencyType.DEFAULT);

    }
}


