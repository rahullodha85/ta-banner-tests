package com.hbcd.base;

import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.pages.ContactCenterPage;
import com.hbcd.banner.s5a.cc.pages.CCHomePage;
import com.hbcd.banner.s5a.cc.pages.Cases;
import com.hbcd.banner.s5a.cc.pages.Catalog;
import com.hbcd.banner.s5a.cc.pages.Customers;
import com.hbcd.banner.s5a.cc.pages.Nav;
import com.hbcd.banner.s5a.cc.pages.Orders;
import com.hbcd.banner.s5a.cc.pages.RapidReviewer;
import com.hbcd.banner.s5a.pages.s5a_ContactCenterPage;
import com.hbcd.scripting.core.SiteConfiguration;
import com.hbcd.scripting.core.Storage;
import com.hbcd.utility.configurationsetting.SiteConfigurationManager;

public class ScenarioAEMAuthor extends ScenarioRetailDomain{
	
	public ScenarioAEMAuthor() {
		
	}
	
	@Override
	public void beforeExecuteScript() throws Exception
	{

		super.beforeExecuteScript();
		Storage.save("username", SiteConfigurationManager.getSiteConfigurationValue("Username"));
		Storage.save("password", SiteConfigurationManager.getSiteConfigurationValue("Password"));
		Storage.save("environment", SiteConfigurationManager.getSiteConfigurationValue("Env"));
		Storage.save("url", SiteConfigurationManager.getSiteConfigurationValue("URL"));
		//	Storage.save("Test_Folder1_Name", SiteConfigurationManager.getSiteConfigurationValue("TESTPAGE_FOLDER1"));
	//	Storage.save("Test_Folder2_Name", SiteConfigurationManager.getSiteConfigurationValue("TESTPAGE_FOLDER2"));
		Storage.save("Test_Page_Name", SiteConfigurationManager.getSiteConfigurationValue("TESTPAGE_NAME"));
		
	}
	
	
}
