package com.hbcd.testscript.s5a.aem.author.headercomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

public class addHeaderComponents extends ScenarioAEMAuthor {
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
        //Find.MultipleObjects("ep_selectPage").select(1).click();

        AuthorUtility.openComponent("ep_select_test_delete_me");

        // fill in stuff for drag n drop component from sidekick
        Thread.sleep(5000);

        // Edit page window

        // Test - Add Global Promotion Header


        // or.setClassName("cq-editrollover-insert-container");

        Find.MultipleObjects("ep_header_footer_content_container").select(1).doubleClick();

//
//        Find.Object("ep_headerSectionNew").click();
//        Find.Object("ep_headerSectionNew").doubleClick();

        Find.Object("ep_globalPromotionMessageComponent").click();
        Thread.sleep(3000);
        Find.Object("ep_sidekickOKNew").click();

        Thread.sleep(3000);
        String ss = BrowserAction.screenshot();
        Report.pass("Added Global promotion message to header", ss);


//        Test - Add Header Top
//        Find.Object("ep_headerSectionNew").click();
//        Find.Object("ep_headerSectionNew").doubleClick();

        // Gurpreet 10-Apr-2016 No more header top component
//        Find.MultipleObjects("ep_header_footer_content_container").select(1).doubleClick();
//
//        Find.Object("ep_headerTopComponent").click();
//        Thread.sleep(2000);
//        Find.Object("ep_sidekickOKNew").click();
//
//        Thread.sleep(5000);
//        ss = BrowserAction.screenshot();
//        Report.pass("Added Header Top component", ss);

        //  Test - Add Menu Navigation

        //  Find.Object("ep_headerSectionNew").click();
       //  Find.Object("ep_headerSectionNew").doubleClick();

        Find.MultipleObjects("ep_header_footer_content_container").select(1).doubleClick();

        Find.Object("ep_menuNavigationComponent").click();
        Thread.sleep(2000);
        Find.Object("ep_sidekickOKNew").click();

        Thread.sleep(2000);
        ss = BrowserAction.screenshot();
        Report.pass("Added Menu navigation to header", ss);
	}
}
