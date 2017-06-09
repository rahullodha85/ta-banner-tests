package com.hbcd.testscript.s5a.shopRunner.B11584_MultiAddressShipping;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateReviewSubmit;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen02 extends ScenarioChkout {

    public void executeScript() throws Exception {

        //  One eligible item, One ineligible-restricted Rush item

        String item1 = dataObject.getSkuListInfo().get(0);
        String item2=dataObject.getSkuListInfo().get(1);

        nav.SearchFor(item1);
        ValidatePdp.hasShoprunner();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        pdp.AddToBag(1);
        nav.SearchFor(item2);
        ValidatePdp.hasNoShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(true, "12 E 49 street", "New York", "New York", "10017", true);
        ValidateBag.shopRunnerTopBanner("Your shopping bag contains items that are not eligible for ShopRunner.");
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        rsp.ClickShipToMultipleAddresses();
        rsp.EnterNewShippingAddress(item1, "13 east 49th st", "New York", "New York", "10017", false);
        ValidateReviewSubmit.isShopRunnerEligibleSignDisplay();
        rsp.ClickContinueCheckOut();
        ValidateReviewSubmit.isShopRunnerEligibleSignDisplay();
        ValidateReviewSubmit.isShopRunnerShippingMethodPresent(item2,"Rush Only");


    }
}