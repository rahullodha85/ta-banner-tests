package com.hbcd.testscript.s5a.aem.author.headercomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 1/27/2016.
 */
public class addGlobalPromotionMessageToHeader extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {

        BrowserAction.start();
        BrowserAction.deleteAllCookies();

        // login
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));


        //Go to edit page
        Find.Object("cp_clickSites").click();
        Thread.sleep(2000);

        Find.Object("cp_clickGeometrixxDemo").click();

        Thread.sleep(2000);
        Find.Object("ep_changeLayout").click();

        Thread.sleep(15000);
        //Find.MultipleObjects("ep_selectPage").select(1).click();

        AuthorUtility.openComponent("ep_select_test_delete_me");

        // fill in stuff for drag n drop component from sidekick
        Thread.sleep(5000);

        // Edit page window

        // Test - Add Global Promotion Header

/*        ObjectProperties or = new ObjectProperties("test");
        or.setID("ext-comp-1082");
        Find.Object(or).click();
        Find.Object(or).doubleClick();*/

        Find.Object("ep_headerSectionNew").click();

        Find.Object("ep_headerSectionNew").doubleClick();

        Find.Object("ep_globalPromotionMessageComponent").click();
        Thread.sleep(3000);
        Find.Object("ep_sidekickOKNew").click();

        Thread.sleep(3000);
        String ss = BrowserAction.screenshot();
        Report.pass("Added Global promotion message to header", ss);


    }
}
