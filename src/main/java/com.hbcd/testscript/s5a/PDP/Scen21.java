package com.hbcd.testscript.s5a.PDP;

import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;

/**
 * Created by aalfaruk on 5/21/2016.
 */
public class Scen21 extends ScenarioCommonPlatform {
    //waitlistable
    @Override
    public void executeScript() throws Exception {

        nav.SearchFor(InputData.get("waitlistable").value());
        ValidateAemPdp.isSoldOut();
        ValidatePdp.isWaitListPresentOnPDP();
        ValidatePdp.hasWaitListMessage();
        pdp.JoinWaitListEmail("fmktdu@gmail.com", "3478734608");

    }


    }
