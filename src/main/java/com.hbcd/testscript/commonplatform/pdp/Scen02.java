package com.hbcd.testscript.commonplatform.pdp;



import com.hbcd.banner.mobile.saks.validations.ValidateAemPdp;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.common.utility.Data;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.InputData;
import com.hbcd.scripting.enums.impl.ItemType;

public class Scen02 extends ScenarioCommonPlatform {
    //tell a friend
    @Override
    public void executeScript() throws Exception {
        String regItem = itemData.get(ItemType.REGULAR);
        nav.SearchFor(regItem);
        pdp.ClickEmailIcon();
        ValidateAemPdp.hasTellAFriend();
    }
}