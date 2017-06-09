package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.overlays.o5_GiftOverlay;
import com.hbcd.banner.Off5th.fullsite.overlays.o5_LoginOverlay;
import com.hbcd.banner.Off5th.fullsite.overlays.o5_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.BagPage;
import com.hbcd.commonbanner.overlays.GiftOverlay;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;

/**
 * Created by 461967 on 6/6/2016.
 */
public class o5_BagPage extends BagPage {
    @Override
    public LoginOverlay ClickCheckout() throws Exception {
        super.ClickCheckout();
        return new o5_LoginOverlay();
    }

    public LoginOverlay LoginOverlay() throws Exception{
        super.LoginOverlay();
        return new o5_LoginOverlay();
    }

    @Override
    public QuickLookOverLay ClickEditFor(String upc) throws Exception {
        super.ClickEditFor(upc);
        return new o5_QuickLookOverLay();
    }

    @Override
    public GiftOverlay MakeGift(String itemId) throws Exception {
        super.MakeGift(itemId);
        return new o5_GiftOverlay();
    }
}
