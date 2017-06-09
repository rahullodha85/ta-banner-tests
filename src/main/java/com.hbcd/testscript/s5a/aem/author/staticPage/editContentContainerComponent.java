package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editContentContainerComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        Find.Object("ep_contentContainer_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_contentContainer_edit_button").click();

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        Find.Object("ep_contentContainer_sectionTitle").clear();
        Find.Object("ep_contentContainer_sectionTitle").input("Section Title 1");
        //RandomStringUtils random = new RandomStringUtils();
        String sectionID = RandomStringUtils.randomAlphabetic(8);
        Find.Object("ep_contentContainer_sectionID").clear();
        Find.Object("ep_contentContainer_sectionID").input(sectionID);

        ss = BrowserAction.screenshot();
        Report.pass("Edited content container", ss);

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();

    }
}
