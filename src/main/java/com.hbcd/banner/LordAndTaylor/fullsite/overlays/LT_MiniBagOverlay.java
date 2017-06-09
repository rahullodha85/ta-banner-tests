package com.hbcd.banner.LordAndTaylor.fullsite.overlays;

import com.hbcd.banner.commomplatform.fullsite.overlays.MiniBagOverlay;
import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 12/15/2016.
 */
public class LT_MiniBagOverlay extends MiniBagOverlay {
    @Override
    public void clickCheckout() throws Exception {
        Thread.sleep(9000L);
        if(Find.Object("closeButtonSubwindow_AAF").isPresent()){
            Report.pass("Our Customer Q&A module is temporarily down for maintenance. Thank you for your patience. \n ANNE BACKY created Defect in QC");
            Find.Object("closeButtonSubwindow_AAF").click();
        }
        Thread.sleep(9000L);
        if (!Find.Object("bOverlay").isPresent()) {
            Find.Object("pdpBagLink").click();
            Thread.sleep(1000);
        }
        if (Find.Object("bOverlayViewBagBtn1").isPresent()) {
            Thread.sleep(2000);
            Find.Object("bOverlayViewBagBtn1").click();
            Report.pass("View shopping bag button found and clicked");
        } else {
            Report.fail("View shopping bag button is not present on Minibag Overlay");
        }
        ValidateBagPage.soldOutStatus("bagItemsTable_WS");
    }
}
