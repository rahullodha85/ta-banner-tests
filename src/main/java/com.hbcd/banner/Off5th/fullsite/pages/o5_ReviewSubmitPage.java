package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.overlays.o5_GiftOverlay;
import com.hbcd.banner.Off5th.fullsite.overlays.o5_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.ReviewSubmitPage;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;

/**
 * Created by 461967 on 6/7/2016.
 */
public class o5_ReviewSubmitPage extends ReviewSubmitPage {
    @Override
    public QuickLookOverLay ClickEditItem(String sku) throws Exception {
        super.ClickEditItem(sku);
        return new o5_QuickLookOverLay();
    }

    @Override
    public GiftOverlay MakeGift(String sku) throws Exception {
        super.MakeGift(sku);
        return new o5_GiftOverlay();
    }
}
