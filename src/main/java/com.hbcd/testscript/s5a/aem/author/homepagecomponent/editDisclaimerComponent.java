package com.hbcd.testscript.s5a.aem.author.homepagecomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;

/**
 * Created by gbagga on 2/26/2016.
 */
public class editDisclaimerComponent extends ScenarioAEMAuthor {
    @Override
    public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectHomePage");

        Find.Object("ep_editorialDisclaimer_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_editorialDisclaimer_edit_button").click();

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot", ss);

        Find.Object("ep_editorialDisclaimer_title").clear();
        Find.Object("ep_editorialDisclaimer_title").input("Disclaimer Title");

//        ObjectProperties or = new ObjectProperties("test");
//        or.setClassName("x-html-editor-wrap");
//
//        Find.Object(or).storeAs("My_Container");
//        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
//        Log.Info(html);

        Find.Object("ep_html_editor_wrap").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

//        ObjectProperties or1 = new ObjectProperties("test1");
//        or1.setTagName("div");
//        System.out.println("size " + Use.CapturedObject("My_Container").FindMultipleObjects(or1).size());
//        Use.CapturedObject("My_Container").FindMultipleObjects(or1).select(3).storeAs("low_container");

        System.out.println("size " + Use.CapturedObject("My_Container").FindMultipleObjects("ep_div_tag").size());
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_div_tag").select(3).storeAs("low_container");

//        ObjectProperties or2 = new ObjectProperties("test2");
//        or2.setTagName("iframe");
//        //Use.CapturedObject("low_container").FindMultipleObjects(or2).select(1).clear();
//        Use.CapturedObject("low_container").FindMultipleObjects(or2).select(1).input("Disclaimer text");

        Use.CapturedObject("low_container").FindMultipleObjects("ep_iframe_tag").select(1).input("Disclaimer text");


        //Use.CapturedObject("My_Container").FindObject("ep_CTA_edit_button").click();

//        Find.Object("ep_editorialDisclaimer_copy").clear();
//        Find.Object("ep_editorialDisclaimer_copy").input("Disclaimer Copy");

        ss = BrowserAction.screenshot();
        Report.pass("Edited tabbed Hero Carousel", ss);

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();
    }
}
