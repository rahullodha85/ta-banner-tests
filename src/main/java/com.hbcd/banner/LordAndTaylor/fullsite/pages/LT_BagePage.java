package com.hbcd.banner.LordAndTaylor.fullsite.pages;

import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_GiftOverlay;
import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_LoginOverlay;
import com.hbcd.banner.LordAndTaylor.fullsite.overlays.LT_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.BagPage;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LT_BagePage extends BagPage {
    @Override
    public LoginOverlay ClickCheckout() throws Exception {
        super.ClickCheckout();
        return new LT_LoginOverlay();
    }

    public LoginOverlay LoginOverlay() throws Exception{
        super.LoginOverlay();
        return new LT_LoginOverlay();
    }

    @Override
    public QuickLookOverLay ClickEditFor(String upc) throws Exception {
        super.ClickEditFor(upc);
        return new LT_QuickLookOverLay();
    }

    @Override
    public GiftOverlay MakeGift(String itemId) throws Exception {
        super.MakeGift(itemId);
        return new LT_GiftOverlay();
    }
}
