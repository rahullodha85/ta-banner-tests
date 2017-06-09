package com.hbcd.banner.mobile.s5a.pages.redesign;

import com.hbcd.banner.mobile.saks.pages.mProductDetailPage;
import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by williskong on 10/26/2015.
 */
public class ProductDetailPage extends mProductDetailPage {

    @Override
    public void AddToBag() throws Exception{
        selectFirstColor();
        selectFirstSize();
        clickAddToBag();
    }
    @Override
    public void AddToBag(int option) throws Exception {
        AddToBag();
    }

    @Override
    public void EnterQuantity(int q) throws Exception {
        Find.Object("AEMsizeTxt_wk").clear();
        Find.Object("AEMsizeTxt_wk").input("" + q);
    }

    private void selectSize(String option) throws Exception {
        if(hasSizeSection())
            Find.Object("AEMsizeSwatch_wk").changeChildPartialLinkText(option).click();
    }
    private void selectFirstSize() throws Exception {
        if(hasSizeSection())
            Find.Object("AEMsizeSwatch_wk").changeChildithElement(1).click();
        else Log.Info("No Available sizes");
    }
    private void selectFirstColor()throws Exception{
        if(hasColorSection()) {
            Find.Object("AEMcolorSwatch_wk").click();
            if (hasSizeSection())         // checks if selected color has available sizes
                colorHasSizes();
        }
        else Log.Info("No Available Colors");
    }
    private void clickAddToBag() throws Exception{
        if(Find.Object("AEMsoldOutMsg_wk").isPresent())
            Report.fail("Sold Out Message Displayed");
        else Find.Object("AEMaddtoBagButton_wk").click();
        Report.pass("User Clicks on AddToBag Button",BrowserAction.screenshot());
        Thread.sleep(4000);
        if (Find.Object("ContunieShippingAEMPDP_AAF").isPresent()){
            Report.pass("User Clicks on Continue Shopping in BagOverLay Page",BrowserAction.screenshot());
            Find.Object("ContunieShippingAEMPDP_AAF").click();
        }
    }
    /** checks for an available size after selecting color */
    private void colorHasSizes() throws Exception{
        if(Find.Object("AEMsizeSwatch_wk").changeChildithElement(1).isPresent())
            Report.pass("Sizes available");
        else Report.fail("Sizes not available for selected Color");
    }
    private boolean hasSizeSection() throws Exception{
        return Find.Object("AEMsizeCheck_wk").isPresent();
    }
    private boolean hasColorSection() throws Exception{
        return Find.Object("AEMcolorSwatch_wk").isPresent();
    }

    private void clickCheckoutOverLay()throws Exception{
        Find.Object("checkoutMobileOverlay_AAF").isPresent();
        Report.pass("User Clicks on UnRegisterCheckout from PDP OverLay",BrowserAction.screenshot());
        Find.Object("checkoutMobileOverlay_AAF").click();
    }

    @Override
    public void ContinueShipping() throws Exception {
        Thread.sleep(3000);
        StepLogger.validate(Check.ObjectPresent, "ContunieShippingAEMPDP_AAF");
        Thread.sleep(1000);
        Find.Object("ContunieShippingAEMPDP_AAF").click();
    }

    @Override
    public void EnterBag() throws Exception {
        if (Find.Object("homePgSaksBagCounter").isPresent()){
            Report.pass("User Clicks Enter Bag",BrowserAction.screenshot());
        }else{
            Report.fail("Enter Bag is NOT working",BrowserAction.screenshot());
        }
        Find.Object("mCheckoutSaksEnterBag_vm").javascriptClick();
        Report.pass("Saks BagCounter Button Clicked",BrowserAction.screenshot());
        if (Find.Object("body").isPresent()) {
            if (Find.Object("body").getText().value().toLowerCase()
                    .contains("session timeout")) {
                Report.systemFail("Session Time out", BrowserAction.screenshot());
            }
        }
    }

}
