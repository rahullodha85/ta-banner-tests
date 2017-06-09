package com.hbcd.banner.s5a.pages;

import com.hbcd.banner.commomplatform.fullsite.pages.ProductArrayPage;
import com.hbcd.banner.s5a.overlays.s5a_QuickLookOverlay;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;

public class s5a_ProductArray extends ProductArrayPage {
    @Override
    public QuickLookOverLay ClickQuickView(String upc) throws Exception {
        super.ClickQuickView(upc);
        return new s5a_QuickLookOverlay();
    }
}
