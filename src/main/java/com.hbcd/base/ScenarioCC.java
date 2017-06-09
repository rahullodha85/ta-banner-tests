package com.hbcd.base;

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

public class ScenarioCC extends ScenarioSaks {
	protected CCHomePage ccHome;
	protected Nav ccNav;
	protected Orders ccOrders;
	protected Customers ccCustomers;
	protected Cases ccCases;
	protected Catalog ccCatalog;
	protected RapidReviewer ccRapidReviewer;
	protected ContactCenterPage cc;
	
	public ScenarioCC() {
		
	}
	
	@Override
	public void beforeExecuteScript() throws Exception
	{
		ccHome= new CCHomePage();
		ccNav = new Nav();
		ccOrders = new Orders();
		ccCustomers = new Customers();
		ccCases = new Cases();
		ccCatalog = new Catalog();
		ccRapidReviewer=new RapidReviewer();
		cc = new s5a_ContactCenterPage();
		
		Storage.save("Saks_URL", SiteConfigurationManager.getSiteConfigurationValue("URLSAKS"));
		Storage.save("Saks_CC_URL", SiteConfigurationManager.getSiteConfigurationValue("URL"));
		Storage.save("Saks_RapidReviewer_URL", SiteConfigurationManager.getSiteConfigurationValue("URLRR"));
		Storage.save("Saks_EmailTranslator_URL", SiteConfigurationManager.getSiteConfigurationValue("URLET"));
		
		/*System.out.println(Storage.get("Saks_URL"));
		System.out.println(Storage.get("Saks_CC_URL"));
		System.out.println(Storage.get("Saks_RapidReviewer_URL"));
		System.out.println(Storage.get("Saks_EmailTranslator_URL"));
		*/
		
		super.beforeExecuteScript();
	}
	
	
}
