package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_GiftOverlay;
import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.ReviewSubmitPage;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/7/2016.
 */
public class LT_ReviewSubmitPage extends ReviewSubmitPage {
    @Override
    public QuickLookOverLay ClickEditItem(String sku) throws Exception {
        super.ClickEditItem(sku);
        return new LT_QuickLookOverLay();
    }

    @Override
    public GiftOverlay MakeGift(String sku) throws Exception {
        super.MakeGift(sku);
        return new LT_GiftOverlay();
    }

    @Override
    public void ClickEditBillingAddress() throws Exception {
        Find.Object("rsEditBillingBtn").click();
        Find.Object("rsEnterNewBillAddressRdBtn").click();
    }

    @Override
    public void ClickPlaceOrder() throws Exception {
        if (Find.Object("rspCcReview").isPresent()) {
            Find.Object("rspCcReview").input("888");
        }
        if (Find.Object("pyCheckout").isPresent())
            Find.Object("pyCheckout").click();
        //This is unspecified exception handler NOT needed for any CommonPlatform Checkout Scripts
        /*if (Find.Object("bagItemsTable_WS").isPresent()){
            ValidateBagPage.soldOutStatus("bagItemsTable_WS");
        }*/
        if(Find.Object("rsPlaceOrderBtn").isPresent()){
            Report.pass("User Clicks on Place Order Button");
        }else{
            Report.fail("Place Order Button is NOT present");
        }
        Find.Object("rsPlaceOrderBtn").click();

        if(Find.Object("pay_SPG_Errormessage_zk").isPresent()){
            Report.systemFail("Failing because of SPG error", BrowserAction.screenshot());
            }
        }

    }

