package com.hbcd.testscript.s5a.PDP;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen16 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        String regularItem = itemData.get(ItemType.REGULAR);
        nav.SearchFor(regularItem);

        ValidateAemPdp.hasMinRichRel();
        ValidateAemPdp.hasRichRelItemInformation();
        ValidateAemPdp.hasRichRelPriceInformation();
        ValidateAemPdp.hasRichRelSpdInformation();
    }
}