package com.hbcd.testscript.mobile.s5a.pdp;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/23/2016.
 */
public class Scen36 extends ScenarioCommonPlatform {
    //Reviews Teaser
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("noReviews").value());
        ValidateAemPdp.hasReviewsTeaser();
    }
}
