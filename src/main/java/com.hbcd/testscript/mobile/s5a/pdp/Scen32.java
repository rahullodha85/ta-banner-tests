package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen32 extends ScenarioCommonPlatform {
    //chanel: no shipping, no sharing, reviews, questions, richrel
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("chanel").value());
        ValidateAemPdp.hasChanelBanner();
        ValidateAemPdp.noShippingAccordion();
        ValidateAemPdp.noSharingIcons();
        ValidateAemPdp.hasReviews();
        ValidateAemPdp.hasQuestions();
        ValidateAemPdp.hasRichRelItemInformation();
        ValidateAemPdp.hasRichRelSpdInformation();
        ValidateAemPdp.hasRichRelPriceInformation();
    }
}
