package com.hbcd.testscript.s5a.aem.author.staticPage;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;
import com.hbcd.utility.entity.ObjectProperties;

import java.awt.*;

public class addStaticPageComponents extends ScenarioAEMAuthor  {
	@Override
	public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));

        AuthorUtility.sitesSwitchToCardView();

        AuthorUtility.openComponent("ep_selectPage");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        // Click HBC section and "+" button

        Find.Object("ep_side_kick_hbc_section").storeAs("My_Container");
        String html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
        Log.Info(html);

        //Use.CapturedObject("My_Container").FindObject("ep_side_kick_general_section_plus_button").click();
        Thread.sleep(1000);

        AuthorUtility.selectAddComponentFromSideKick("ep_CTAComponent");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        AuthorUtility.selectAddComponentFromSideKick("ep_contentContainerComponent");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        AuthorUtility.selectAddComponentFromSideKick("ep_imageComponent");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        AuthorUtility.selectAddComponentFromSideKick("ep_richTextEditorComponent");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        Thread.sleep(2000);

//       Title component no longer there
//        // Add general section
//        Find.Object("ep_side_kick_general_section").storeAs("My_Container");
//        html = Use.CapturedObject("My_Container").AsIs().getAttribute("innerHTML").value();
//        Log.Info(html);
//        Use.CapturedObject("My_Container").FindObject("ep_side_kick_general_section_plus_button").click();
//        Thread.sleep(1000);
//
//        AuthorUtility.selectAddComponentFromSideKick("ep_titleComponent");

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot after all components added ", ss);
		}
}
