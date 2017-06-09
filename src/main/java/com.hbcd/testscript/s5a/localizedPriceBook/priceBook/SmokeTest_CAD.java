package com.hbcd.testscript.s5a.localizedPriceBook.priceBook;


import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class SmokeTest_CAD extends ScenarioChkout {


    @Override
    public void executeScript() throws Exception {

        nav.ChangeCountry("Canada");
        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckoutInternational();
        icp.AddShippingAddress("8 Gloucester Street", "Toronto", "Ontario", "M4Y 1L5", "automation@saks.com");
        icp.AddCreditCard("visa", "4445222299990007");
        icp.ClickPlaceOrder();
        ValidateConfirmation.hasCADOrderConfirmation();

    }

}
