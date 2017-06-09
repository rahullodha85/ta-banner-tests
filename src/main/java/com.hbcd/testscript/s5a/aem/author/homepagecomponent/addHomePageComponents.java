package com.hbcd.testscript.s5a.aem.author.homepagecomponent;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.*;

public class addHomePageComponents extends ScenarioAEMAuthor  {
	@Override
	public void executeScript() throws Exception {
        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));

        AuthorUtility.sitesSwitchToCardView();

        AuthorUtility.openComponent("ep_selectHomePage");

        Find.MultipleObjects("ep_header_footer_content_container").select(4).doubleClick();

        Thread.sleep(1000);

        AuthorUtility.selectAddComponentFromSideKick("ep_DisclaimerComponent");

        Find.MultipleObjects("ep_header_footer_content_container").select(3).doubleClick();

        AuthorUtility.selectAddComponentFromSideKick("ep_tabbedHeroCarouselComponent");

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
