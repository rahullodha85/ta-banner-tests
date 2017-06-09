package com.hbcd.testscript.mobile.s5a.mOptimization;

import com.hbcd.banner.mobile.saks.validations.ValidatePayment;
import com.hbcd.banner.mobile.saks.validations.ValidateRs;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

/**
 * Created by aalfaruk on 3/29/2016.
 * Mobile Web - Check Out - Edit Shipping Address
 */
public class ScenB15175_S2 extends ScenarioMobileSaks {

    @Override
    public void executeScript() throws Exception {

        String item1 = dataObject.getSkuListInfo().get(0);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.CheckOut();
        lgn.LoginWith("claudiasosa" + Common.getUniqueNumber() + "@s5a.com");
        shp.AddShippingAddress(true, "P.O. Box 1965", "California", "Rancho Santa Fe", "92067", true);
        ValidatePayment.hasUserLandedOnPaymentPage("Payment");
        pap.AddNewCreditCard(3, "test123", "test123");
        rsp.ClickEditShippingAddressOnMobile();
        ValidateRs.hasApplyButtonAvailable();
        rsp.ChangeShippingAddressOnMobile("230 Vessy Street");
        ValidateRs.hasChangedShippingAddress("230 Vessy Street");
        rsp.ClickPlaceOrder();
    }
}
