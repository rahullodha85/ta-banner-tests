package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.saks.alfresco.Utility;
import com.hbcd.banner.validations.s5a.ValidatePap;
import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.ItemType;
import com.hbcd.utility.helper.Common;

import java.util.Random;

/**
 * Created by 901124 on 1/7/2016.
 */
public class Scen62 extends ScenarioChkout {

    @Override
    public void executeScript() throws Exception {
        String item1 = itemData.get(ItemType.REGULAR);
        nav.SearchFor(item1);
        pdp.AddToBag(1);
        pdp.EnterBag();
        bag.ClickCheckout().LoginWith("abcd@yahoo.com");
        Storage.save("email","dremail" + Common.getUniqueNumber() + "@saks.com");
        shp.AddShippingAddress(false, "12 east 49th st", "New York", "New York", "10017", false, "dremail" + Common.getUniqueNumber() + "@saks.com", "8989098959");
        ValidatePap.hasEmailAddress(Storage.get("email"));

    }
}