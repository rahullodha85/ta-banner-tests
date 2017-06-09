package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.banner.commomplatform.mobile.pages.mNavigation;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.commonbanner.pages.*;
import com.hbcd.commonbanner.drawer.*;
import com.hbcd.commonbanner.enums.TopNavLinks;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mNavigationPage extends mNavigation {

	@Override
	public void SearchFor(String value) throws Exception {
		if(Find.Object("ofm_navSearchBox_wk").isPresent()){
			Find.Object("ofm_navSearchBox_wk").click();
			Find.Object("nav_searchText_wk").clear();
			Find.Object("nav_searchText_wk").input(value);
			//Find.Object("SearchItemFieldTxtBx").enter();
			Report.pass("Search For " + value, BrowserAction.screenshot());
			Find.Object("nav_searchText_wk").submit().getPerformance("SUBMIT on Search Button", "SearchFunction");
		}else SearchFunction.SearchFor(value);
	}

	@Override
	public StoreLocatorPage ClickStoreLocator() throws Exception {
		StepLogger.validate(Check.ObjectPresent, "mstoreBtn");
		Find.Object("mstoreBtn").click();
		return null;
	}
	@Override
	public void SelectCountry(String country) throws Exception{
		if(Find.Object("nav_hamburger").isPresent()) {
			Find.Object("nav_hamburger").click();
			Find.Object("nav_hamburgerShipto").click();
		}else Find.Object("navChangeCountryBtn").click();

		Find.Object("changeCountryDrpDwn").select(country);
	}
	@Override
	public void ChangeCountry(String country) throws Exception {
		SelectCountry(country);
		Find.Object("changeCountrySaveBtn").click();
		if(Find.Object("nav_hamburger").isPresent())
			Find.Object("nav_hamburger").click();

		if(Find.Object("navChangeCountryBtn").isPresent()){
			if(Find.Object("navChangeCountryBtn").getAttribute("outerHTML").value().toString().toLowerCase().indexOf("US.gif")<0){
				Report.pass("Country Changed", BrowserAction.screenshot());
			}
			else {
				Report.fail("Country not Changed",BrowserAction.screenshot());
			}
		}else {
			if (Find.Object("nav_hamburgerShipImage").getAttribute("outerHTML").value().toString().toLowerCase().indexOf("US.gif") == 0)
				Report.pass("Country Changed", BrowserAction.screenshot());
			else Report.fail("Country not Changed", BrowserAction.screenshot());
			if (Find.Object("nav_hamburgerClose").isPresent())
				Find.Object("nav_hamburgerClose").click();
		}
	}

	@Override
	public Drawer ClickHome() throws Exception {
		StepLogger.validate(Check.ObjectPresent, "HomePgBtn");
		Find.Object("HomePgBtn").click();
		return null;
	}

	@Override
	public void ClickMainHomePage() throws Exception {
		Find.Object("mhomePageBtn").click();
	}

	@Override
	public void EnterPrp(Object... args) throws Exception {
		Thread.sleep(1000L);
		for(int i=0;i<args.length;i++){
			if(Find.LinkWithText(false, "", (String)args[i]).isPresent()){
//				StepLogger.validate(Check.ObjectPresent,(String)args[i]);
				Find.LinkWithText(false, "", (String)args[i]).click();
			}else Report.fail(args[0] + " link not found");
		}
	}
	@Override
	public void ClickNavigationLinks(TopNavLinks linkName) throws Exception {
		clickNavLink(linkName.toString());
//		clickLinkByClassAndText("menu-item", linkName.toString());
		StepLogger.validate(Check.ObjectPresent, linkName.getObjectToValidate());
		
	}
	
	private void clickNavLink(String linkText) throws Exception{
		/*New.Object("").setProperty(PropertyType.CSS_SELECTOR, "div[class='nav']")
			.setProperty(PropertyIntType.IS_PARENT, 1)
			.setChildProperty(PropertyType.CLASS, "menu-item-link")
			.setChildProperty(PropertyType.CONTAINS_TEXT, linkText)
			.click();*/
		Find.Object("navSection").changeChildContainsText(linkText).click();
	}
}
