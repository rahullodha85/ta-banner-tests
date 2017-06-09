package com.hbcd.testscript.mobile.off5th;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

public class Scen01 extends ScenarioCommonPlatform {
    //pdp page
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("regular").value());
        ValidateAemPdp.hasBrandName();
        ValidateAemPdp.hasShortDescription();
        ValidateAemPdp.hasItemNumber();
        ValidateAemPdp.hasCurrencyCode();
//        ValidateAemPdp.hasSinglePrice();
        ValidateAemPdp.hasAddToBag();
        ValidateAemPdp.hasSharingIcons();
        ValidateAemPdp.shippingReturnsAccordion();
    }
}