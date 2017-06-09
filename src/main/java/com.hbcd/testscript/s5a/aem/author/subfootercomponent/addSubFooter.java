package com.hbcd.testscript.s5a.aem.author.subfootercomponent;

import java.awt.Frame;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.core.Switch;

public class addSubFooter extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {
		BrowserAction.start();
		BrowserAction.deleteAllCookies();
		Find.Object("lgn_Userid").input(Storage.get("username"));
        Thread.sleep(3000);
        Find.Object("lgn_Passwd").input(Storage.get("password"));
        Find.Object("lgn_Submit").click();

        String ss = BrowserAction.screenshot();
        Report.pass("Login sucessful", ss);

        Find.Object("cp_clickSites").click();
        Find.Object("cp_clickGeometrixxDemo").click();
        Find.Object("ep_changeLayout").click();
        Thread.sleep(15000);
        //Find.MultipleObjects("ep_selectPage").select(1).click();


        Find.Object("ep_selectPage").click();
        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot before opening page", ss);

        Find.Object("ep_openPage").click();
        Thread.sleep(5000);
        Switch.toNewWindow("AEM Content Finder");
        Frame[] test = Frame.getFrames();
        Thread.sleep(5000);

        System.out.println("frames : " + test.length);
        Thread.sleep(3000);

        Switch.toFrame("cq-cf-frame");
        Thread.sleep(5000);

// TEMP			Find.Object("ep_subfooterSectionNew").doubleClick();

        //Find.Object("ep_headerComponentNew").click();
        //ep_headerSectionNew
        //Thread.sleep(3000);

        Find.Object("ep_subfooterSectionNew").click();
        Thread.sleep(3000);

        Find.Object("ep_subfooterSectionNew").doubleClick();
        Thread.sleep(3000);

        Find.Object("ep_subfooterComponent").click();
        Thread.sleep(3000);

        ss = BrowserAction.screenshot();
        Report.pass("Screenshot after component added ", ss);

        Find.Object("ep_sidekickOKNew").click();

        ss = BrowserAction.screenshot();
        Report.pass("Added subFooter", ss);

        Thread.sleep(3000);
        ss = BrowserAction.screenshot();
        Report.pass("Added subFooter", ss);
	}

}
