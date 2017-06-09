package com.hbcd.testscript.off5th.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen02 extends ScenarioCommonPlatform {
    //tell a friend
    @Override
    public void executeScript() throws Exception {
        nav.SearchFor(InputData.get("regular").value());
        pdp.ClickEmailIcon();
        ValidateAemPdp.hasTellAFriend();
    }
}