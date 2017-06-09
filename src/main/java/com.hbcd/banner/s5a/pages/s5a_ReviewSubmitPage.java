package com.hbcd.banner.s5a.pages;


import com.hbcd.banner.commomplatform.fullsite.pages.ReviewSubmitPage;
import com.hbcd.banner.s5a.overlays.s5a_GiftOverlay;
import com.hbcd.banner.s5a.overlays.s5a_QuickLookOverlay;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.Find;

public class s5a_ReviewSubmitPage extends ReviewSubmitPage {
    @Override
    public QuickLookOverLay ClickEditItem(String sku) throws Exception {
        super.ClickEditItem(sku);
        return new s5a_QuickLookOverlay();
    }

    @Override
    public GiftOverlay MakeGift(String sku) throws Exception {
        super.MakeGift(sku);
        return new s5a_GiftOverlay();
    }

    @Override
    public void ClickEnterNewCCRadioButton() throws Exception {
        Find.Object("newPaymentType_NJ").click();
    }
    @Override
    public void ClickEditCreditCard() throws Exception {
        Find.Object("rsPaymentTypeEditBtn").click();
    }
}