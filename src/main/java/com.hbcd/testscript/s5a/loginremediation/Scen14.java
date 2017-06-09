package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateYap;
import com.hbcd.base.ScenarioSaks;

public class Scen14 extends ScenarioSaks {

    @Override
    public void executeScript() throws Exception {
        yap.GoToMyAcccount();
        yap.Login("saksqa307@saks.com", "saks12345");
        ValidateYap.hasInvalidCredentialsError();

    }


}
