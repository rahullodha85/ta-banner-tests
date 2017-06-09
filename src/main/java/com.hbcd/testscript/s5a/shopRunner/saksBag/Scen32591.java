package com.hbcd.testscript.s5a.shopRunner.saksBag;


import com.hbcd.banner.validations.s5a.ValidateBag;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.banner.validations.s5a.ValidateShippingBilling;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen32591 extends ScenarioChkout {

    public void executeScript() throws Exception {

        nav.SearchFor(dataObject.getSkuListInfo().get(0));
        pdp.AddToBag(3);
        pdp.EnterBag();
        ValidateBag.bagShopRunnerEligibleSignNotDisplay();
        Thread.sleep(3000);
        bag.ClickBagShopRunnerSignIn();
        shr.ShopRunnerLoginWith(dataObject.getEmailID(), dataObject.getLoginPassword());
        Thread.sleep(8000);
        ValidateBag.bagExpressShopRunnerBtn();
        Thread.sleep(5000);
        ValidateBag.bagShopRunnerSignOut();

    }

}
