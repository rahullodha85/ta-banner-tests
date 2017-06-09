package com.hbcd.testscript.s5a.aem.author.headercomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 1/27/2016.
 */
public class addHeaderTopToHeader extends ScenarioAEMAuthor {

    @Override
    public void executeScript() throws Exception {

        try {

            BrowserAction.start();
            BrowserAction.deleteAllCookies();
            String ss = BrowserAction.screenshot();

            AuthorUtility.login(Storage.get("username"), Storage.get("password"));
            Find.Object("cp_clickSites").click();
            Find.Object("cp_clickGeometrixxDemo").click();
            Thread.sleep(5000);
            Find.Object("ep_changeLayout").click();
            Thread.sleep(15000);

            Find.Object("ep_select_test_delete_me").click();

            Thread.sleep(20000);

            Find.Object("ep_openPage").click();
            Thread.sleep(5000);
            Switch.toNewWindow("AEM Content Finder");
            Frame[] test = Frame.getFrames();
            Thread.sleep(5000);

            System.out.println("frames : " + test);
            Thread.sleep(3000);

            Switch.toFrame("cq-cf-frame");
            Thread.sleep(5000);


            // Test - Add Header Top

            Find.Object("ep_headerSectionNew").click();
            Find.Object("ep_headerSectionNew").doubleClick();


            Find.Object("ep_headerTopComponent").click();
            Thread.sleep(3000);
            ss = BrowserAction.screenshot();

            Find.Object("ep_sidekickOKNew").click();

            Thread.sleep(3000);
            ss = BrowserAction.screenshot();
            Report.pass("Added Header Top component", ss);

        } catch (Exception e) {
            String ss = BrowserAction.screenshot();
            Report.fail("Fail : "  + e.toString(), ss);
        }


    }
}
