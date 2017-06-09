package com.hbcd.banner.Off5th.fullsite.pages;

import com.hbcd.banner.Off5th.fullsite.overlays.o5_QuickLookOverLay;
import com.hbcd.banner.commomplatform.fullsite.pages.ProductArrayPage;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;

/**
 * Created by 461967 on 6/6/2016.
 */
public class o5_ProductArrayPage extends ProductArrayPage {
    @Override
    public QuickLookOverLay ClickQuickView(String upc) throws Exception {
        super.ClickQuickView(upc);
        return new o5_QuickLookOverLay();
    }
}
