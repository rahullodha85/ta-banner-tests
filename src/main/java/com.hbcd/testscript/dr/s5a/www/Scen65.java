package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioChkout;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.enums.NavLinks;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.fluentInterface.ObjectPropertySetting;
import com.hbcd.scripting.enums.impl.ItemType;
import com.hbcd.utility.entity.ObjectProperties;

/**
 * Created by ephung on 1/6/2016.
 */
public class Scen65  extends ScenarioChkout {
    public void executeScript() throws Exception {
        String searchTerm = "Prada";  //Gucci, Burberry, Fendi
        nav.SearchFor(searchTerm);
        ObjectProperties spread = new ObjectProperties("spreads_Images_Validation");
        spread.setCssSelector("div[class='spreads-wrapper']");

        ObjectProperties module = new ObjectProperties("Module_Validation");
        //module.setCssSelector("div[class='saks-module'");
        module.setTagName("div");
        module.setAttributeKey1("data-module-name");
        module.setAttributeValue1(searchTerm);

        Find.Object(spread).isPresent();
        Find.Object(module).isPresent();
        //Validate Exist object with div class="spreads-wrapper"
        //Validate Exist div class="saks-module" with data-module-name="Burberry"
    }
}
