package com.hbcd.banner.mobile.s5a.pages.redesign;

import com.hbcd.banner.mobile.saks.pages.mBagPage;
import com.hbcd.banner.mobile.saks.pages.mLogin;
import com.hbcd.banner.s5a.pages.s5a_SmartSampleOverlay;
import com.hbcd.commonbanner.overlays.LoginOverlay;
import com.hbcd.commonbanner.overlays.SmartSampleOverlay;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import javax.sql.rowset.BaseRowSet;

/**
 * Created by 901124 on 3/1/2016.
 */
public class mRedesignBagPage extends mBagPage {

    @Override
    public void Remove(String upc) throws Exception {

    if (Find.Object("bagRemoveButton_WS").isPresent()){
        Report.pass("User Clicks On (X) for Removing Items from Bag Page", BrowserAction.screenshot());
        }else{
        Report.fail("(X) is Not Clicked",BrowserAction.screenshot());
        }
        Find.Object("bagRemoveButton_WS").changeContainsText(upc).click();

        if (Find.Object("bagRemoveButtonOverlay_WS").isPresent()){
            Report.pass("Removed Overlay is Present",BrowserAction.screenshot());
        }else{
            Report.fail("Removed Overlay is NOT Present",BrowserAction.screenshot());
        }
        //StepLogger.validate(Check.ObjectPresent, "bagRemoveButtonOverlay_WS");
        if (Find.Object("bagRemoveButtonOverlayRemove_WS").isPresent()){
            Report.pass("User Clicks on REMOVE button",BrowserAction.screenshot());
        }else{
            Report.dataFail("REMOVE Button is NOT Available",BrowserAction.screenshot());
        }
        //StepLogger.validate(Check.ObjectPresent,"bagRemoveButtonOverlayRemove_WS");
        Find.Object("bagRemoveButtonOverlayRemove_WS").click();
    }

    @Override
    public void RemoveCancel(String upc) throws Exception {

        Find.Object("bagRemoveButton_WS").changeContainsText(upc).click();

        StepLogger.validate(Check.ObjectPresent, "bagRemoveButtonOverlay_WS");
        StepLogger.validate(Check.ObjectPresent,"bagRemoveButtonOverlayCancel_WS");
        Find.Object("bagRemoveButtonOverlayCancel_WS").click();
    }
    @Override
    public void SelectBagItemQuantity(String upc,int quantity) throws Exception {
        if (Find.Object("productQuantityBag_AAF").isPresent()){
            Report.pass("Item quantity in Bag page Displayed");
            Find.Object("productQuantityBag_AAF").changeContainsText(upc).select(quantity);
        }else{
            Report.fail("Item quantity in Bag Page is NOT displayed");
        }

    }

    @Override
    public SmartSampleOverlay ClickSmartSample() throws Exception {
        if(Find.Object("bagSmartSample_RL").isPresent()) {
            Report.pass("Smart Sample banner found and clicked");
            Find.Object("bagSmartSample_RL").click();
        } else {
            Report.dataFail("Smart sample banner not present," +
                    " please verify if this item is eligible for smart sample promo");
        }
        return new s5a_SmartSampleOverlay();
    }

    @Override
    public LoginOverlay ClickCheckout() throws Exception {
        if (Find.Object("bagCheckoutBtn").isPresent()){
            Report.pass("LoginOverlay is Appeared",BrowserAction.screenshot());
        }else{
            Report.fail("LoginOverLay is NOT Appeared",BrowserAction.screenshot());
        }
        Find.Object("bagCheckoutBtn").click();
        return new mLogin();
    }

}
