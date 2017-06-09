package com.hbcd.testscript.s5a.aem.author.footercomponent;

import java.awt.Frame;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

public class editFooter extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {

		BrowserAction.start();
        BrowserAction.deleteAllCookies();

        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

//        Find.Object("cp_clickSites").click();
//        Find.Object("cp_clickGeometrixxDemo").click();
//        Find.Object("ep_changeLayout").click();
//
//        Thread.sleep(15000);
//
//        //Find.MultipleObjects("ep_selectPage").select(1).click();
//
//        Find.Object("ep_selectPage").click();
//
//        String ss = BrowserAction.screenshot();
//        Report.pass("Screenshot before opening page", ss);
//
//        Thread.sleep(3000);
//        Find.Object("ep_openPage").click();
//        Thread.sleep(7000);
//        Switch.toNewWindow("AEM Content Finder");
//        Frame[] test = Frame.getFrames();
//        Thread.sleep(3000);
//
//        Switch.toFrame("cq-cf-frame");
//        Thread.sleep(15000);

        // Start Click on edit button
        //Find.Object("ep_footerComponentEdit").click();


        Find.Object("ep_footer_edit_toolbar").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        // End click on edit button

        Use.CapturedObject("My_Container").FindObject("ep_footer_edit_button").click();
        Thread.sleep(5000);


        Find.Object("ep_custServiceText").input("Customer Service 24/7");
        Thread.sleep(2000);
        //Find.Object("ep_custServiceTextPlus").click();
        //Find.Object("ep_menuNavigationPlusButton").click();
//        ObjectProperties or = new ObjectProperties("test");
//        or.setClassName("x-form-element");
//        //Find.Object(or).storeAs("My_Container");
        Find.MultipleObjects("ep_footerWindow").select(2).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();
//        or = new ObjectProperties("test");
//        or.setClassName("cq-multifield-btn");
//        Find.MultipleObjects(or).select(1).click();


//        Find.Object("ep_footerWindow").storeAs("My_Container");
//        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
//        Log.Info(html);
//        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();


        Find.Object("ep_formCustServiceDesktopLabel").input("Desktop Label");

        Thread.sleep(1000);

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot editing intial tab", ss);

        Find.Object("ep_formCustServiceSection1Tab").click();
        Find.Object("ep_formCustServiceSectionHeading").input("Section Heading Tab 1X");
        Thread.sleep(1000);

        Find.MultipleObjects("ep_footerWindow").select(2).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();

        //Find.Object("ep_custServiceSectionPlus").click();
        Thread.sleep(1000);
        Find.Object("ep_formCustServiceDesktopLabel1").input("Desktop Label 1X");

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot editing first tab", ss);

        Find.Object("ep_formCustServiceSection2Tab").click();
        Find.Object("ep_formCustServiceSectionHeading2").input("Section Heading Tab 2X");
        Thread.sleep(1000);

        //Find.Object("ep_custServiceSectionPlus2").click();
        Find.MultipleObjects("ep_footerWindow").select(2).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();

        Thread.sleep(1000);
        Find.Object("ep_formCustServiceDesktopLabel2").input("Desktop Label 2X");

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot editing second tab", ss);

        Find.Object("ep_formCustServiceSection3Tab").click();
        Find.Object("ep_formCustServiceSectionHeading3").input("Section Heading Tab 3X");
        Thread.sleep(1000);

        //Find.Object("ep_custServiceSectionPlus3").click();
        Find.MultipleObjects("ep_footerWindow").select(2).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();

        Thread.sleep(1000);
        Find.Object("ep_formCustServiceDesktopLabel3").input("Desktop Label 3X");

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot editing third tab", ss);

        Find.Object("ep_formCustServiceSection4Tab").click();
        Find.Object("ep_formCustServiceSectionHeading4").input("Section Heading Tab 4X");
        Thread.sleep(1000);

        Find.MultipleObjects("ep_footerWindow").select(2).storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindMultipleObjects("ep_menuNavigationPlusButton").select(1).click();

        //Find.Object("ep_custServiceSectionPlus4").click();
        Thread.sleep(1000);
        Find.Object("ep_formCustServiceDesktopLabel4").input("Desktop Label 4X");

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot editing forth tab", ss);

        Thread.sleep(1000);
        //Find.Object("ep_custServiceSectionOK").click();

        Find.Object("ep_generic_ComponentEditOkCancelFooter").storeAs("My_Container");
        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);
        Use.CapturedObject("My_Container").FindObject("ep_generic_okButton_Class").click();

        Thread.sleep(5000);

        ss = BrowserAction.screenshot();
        Report.pass("Updated Footer component", ss);

        // Add code for header here
	}
}
