package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.ShoprunnerSigninOverLayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.WaitFor;

/**
 * Created by 461967 on 6/6/2016.
 */
public class ShopRunnerSigninOverlay extends ShoprunnerSigninOverLayBase {
    @Override
    public void ShopRunnerLoginWith(String email, String password) throws Exception {
        Find.Object("shopRunnerEmailId_AAF").clear();
        Find.Object("shopRunnerEmailId_AAF").input(email);
        Find.Object("shopRunnerPassword_AAF").clear();
        Find.Object("shopRunnerPassword_AAF").input(password);
        Find.Object("clickShopRunnerLoginButton_AAF").click();
        //Thread.sleep(7000L);
        WaitFor.Object("pdp_shopRunnerOverlayUI").untilDisappear();
    }
}
