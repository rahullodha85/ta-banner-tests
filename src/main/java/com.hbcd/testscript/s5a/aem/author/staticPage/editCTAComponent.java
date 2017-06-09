package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editCTAComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        // Edit CTA component
        Find.Object("ep_CTA_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_CTA_edit_button").click();

        String ss = BrowserAction.screenshot();
        Report.pass("Edited content container", ss);

        Thread.sleep(2000);
        Find.Object("ep_CTA_label").input("CTA Label");
        Thread.sleep(2000);
        Find.Object("ep_CTA_url").input("CTA Url");

        ss = BrowserAction.screenshot();
        Report.pass("Edited CTA container", ss);

        //------------------------------ code for different viewable by options------------///
        Find.MultipleObjects("ep_x-form-arrow-trigger").select(2).click();

        Find.Object("ep_cta_userselect").storeAs("container");
        html = Use.CapturedObject("container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        if (Use.CapturedObject("container").FindMultipleObjects("ep_comboListItem").select(1).getText().value().equals("All") == true) {
            ss = BrowserAction.screenshot();
            Report.pass("All option present", ss);
        }

        if (Use.CapturedObject("container").FindMultipleObjects("ep_comboListItem").select(2).getText().value().equals("Non-authenticated") == true){
            ss = BrowserAction.screenshot();
            Report.pass("Non-Authenticated option present", ss);
        }
        if (Use.CapturedObject("container").FindMultipleObjects("ep_comboListItem").select(3).getText().value().equals("Authenticated") == true) {
            ss = BrowserAction.screenshot();
            Report.pass("Non-Authenticated option present", ss);
        }
        Use.CapturedObject("container").FindMultipleObjects("ep_comboListItem").select(1).click();

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        //-------------------------------

//        // select button/link one by one

        Find.MultipleObjects("ep_x-form-arrow-trigger").select(1).click();
        Find.Object("ep_cta_linkType").storeAs("container1");
        html = Use.CapturedObject("container1").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        Use.CapturedObject("container1").FindObject("ep_cta_linkTypeButton").click();

        Find.MultipleObjects("ep_x-form-arrow-trigger").select(1).click();
        Find.Object("ep_cta_linkType").storeAs("container1");
        html = Use.CapturedObject("container1").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        Use.CapturedObject("container1").FindObject("ep_cta_linkTypeLink").click();
        ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        //-----------------------------------

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();

    }
}
