package com.hbcd.testscript.s5a.shopRunner.B11584_MultiAddressShipping;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateReviewSubmit;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.ShipMethod;

public class Scen05 extends ScenarioChkout {

    public void executeScript() throws Exception {

        //  Two eligible items, both items being sent via upgraded shipping

        String item1 = dataObject.getSkuListInfo().get(0);
        String item2=dataObject.getSkuListInfo().get(1);

        nav.SearchFor(item1);
        ValidatePdp.hasShoprunner();
        pdp.ClickShopRunnerSignin();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        pdp.AddToBag(1);
        nav.SearchFor(item2);
        ValidatePdp.hasShoprunner();
        pdp.AddToBag(1);
        pdp.EnterBag();
        ValidateBag.bagExpressShopRunnerBtn();
        bag.ClickCheckout().LoginWith("saksqa148@saks.com");
        ValidateShippingBilling.shipAndBillShopRunnerEligibleIcon("Eligible");
        shp.AddShippingAddress(true, "12 E 49 street", "New York", "New York", "10017", true);
        pap.AddNewCreditCard(3);//mastercard
        pap.ClickCheckout();
        rsp.ClickShipToMultipleAddresses();
        rsp.EnterNewShippingAddress(item2, "13 east 49th st", "New York", "New York", "10017", false);
        ValidateReviewSubmit.isShopRunnerEligibleSignDisplay();
        shp.SelectShippingMethodFor(item2, ShipMethod.NEXTBUS);
        Thread.sleep(4000);
        shp.SelectShippingMethodFor(item1, ShipMethod.NEXTBUS);
        Thread.sleep(4000);
        rsp.ClickContinueCheckOut();
        ValidateReviewSubmit.isShopRunnerShippingMethodPresent(item2, "Next Bus. Day");
        Thread.sleep(4000);
        ValidateReviewSubmit.isShopRunnerShippingMethodPresent(item1, "Next Bus. Day");

    }
}
