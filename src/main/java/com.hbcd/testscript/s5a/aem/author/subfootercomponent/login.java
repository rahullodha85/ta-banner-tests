package com.hbcd.testscript.s5a.aem.author.subfootercomponent;


import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.Report;


public class login extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {
		
	Find.Object("lgn_Userid").input(Storage.get("username"));
	Find.Object("lgn_Passwd").input(Storage.get("password"));
	Find.Object("lgn_Submit").click();

	Find.Object("login_user").click();
	Thread.sleep(2000);
	String ss = BrowserAction.screenshot();
	Report.pass("Login Success - ADMIN", ss);
	BrowserAction.deleteAllCookies();
	
	}
}
