package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.ShopRunnerExpressChekoutOverlayBase;
import com.hbcd.scripting.core.Find;

/**
 * Created by 461967 on 6/6/2016.
 */
public class ShopRunnerExpressChekoutOverlay extends ShopRunnerExpressChekoutOverlayBase {
    @Override
    public void ShopRunnerExpressCheckoutButton()throws Exception{

        Find.Object("shoprunnerExpresscheckoutComplete_AAF").click();

    }
}
