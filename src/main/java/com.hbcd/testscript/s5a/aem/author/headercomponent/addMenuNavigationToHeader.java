package com.hbcd.testscript.s5a.aem.author.headercomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 1/27/2016.
 */
public class addMenuNavigationToHeader extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();

        // login
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));


        //go to edit page
        Find.Object("cp_clickSites").click();
        Thread.sleep(2000);

        Find.Object("cp_clickGeometrixxDemo").click();

        Thread.sleep(2000);
        Find.Object("ep_changeLayout").click();

        Thread.sleep(15000);


        AuthorUtility.openComponent("ep_select_test_delete_me");

        Thread.sleep(5000);

        Find.Object("ep_headerSectionNew").click();

        Find.Object("ep_headerSectionNew").doubleClick();

        Find.Object("ep_menuNavigationComponent").click();
        Thread.sleep(3000);
        Find.Object("ep_sidekickOKNew").click();

        Thread.sleep(3000);
        String ss = BrowserAction.screenshot();
        Report.pass("Added Menu navigation to header", ss);

    }
}
