package com.hbcd.testscript.s5a.aem.author.footercomponent;

import java.awt.Frame;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.core.Switch;

public class addFooter extends ScenarioAEMAuthor  {
	@Override
	public void executeScript() throws Exception {

        BrowserAction.start();
        BrowserAction.deleteAllCookies();
        AuthorUtility.login(Storage.get("username"), Storage.get("password"));
        AuthorUtility.sitesSwitchToCardView();
        AuthorUtility.openComponent("ep_selectPage");

        // double click on Footer Section
        Find.MultipleObjects("ep_header_footer_content_container").select(2).doubleClick();

        // Add Subfooter

        Find.Object("ep_subfooterComponent").click();
        Thread.sleep(3000);

        String ss = BrowserAction.screenshot();
        Report.pass("Screenshot after component added ", ss);

        Find.Object("ep_sidekickOKNew").click();

        ss = BrowserAction.screenshot();
        Report.pass("Added subFooter", ss);

        Thread.sleep(3000);

        // double click on Footer Section
        Find.MultipleObjects("ep_header_footer_content_container").select(2).doubleClick();

        // Add Footer

        Find.Object("ep_footerComponentNew").click();
        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot after component added ", ss);

        Find.Object("ep_sidekickOKNew").click();

        ss = BrowserAction.screenshot();
        Report.pass("Added Footer", ss);
		}
}
