package com.hbcd.testscript.off5th.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen16 extends ScenarioCommonPlatform {
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("regular").value());

        ValidateAemPdp.hasMinRichRel();
        ValidateAemPdp.hasRichRelItemInformation();
        ValidateAemPdp.hasRichRelPriceInformation();
        ValidateAemPdp.hasRichRelSpdInformation();
    }
}