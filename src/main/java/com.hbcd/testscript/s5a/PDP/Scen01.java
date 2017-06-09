package com.hbcd.testscript.s5a.PDP;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
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