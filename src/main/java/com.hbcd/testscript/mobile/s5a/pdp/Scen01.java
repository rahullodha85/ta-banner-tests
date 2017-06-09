package com.hbcd.testscript.mobile.s5a.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen01 extends ScenarioCommonPlatform {
    //pdp page
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(itemData.get(ItemType.REGULAR));
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