package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateHome {

	public static void Logo() {

		StepLogger.validate(Check.ObjectPresent, "mhomePageBtn");
	}

	public static void hasCountryChanged(String country) throws Exception{
		if(Find.Object("mnavChangeCountryBtn").getAttribute("outerHTML").value().indexOf(country)>0)
			Report.pass("Country has changed");
			else
		Report.fail("Country has not changed");
	}
	public static void NeedHelp() {

		StepLogger.validate(Check.ObjectPresent, "needHelp_WS");
	}

	public static void SearchBox() {

		StepLogger.validate(Check.ObjectPresent, "SearchItemFieldTxtBx");
	}

	public static void SearchButton() {

		StepLogger.validate(Check.ObjectPresent, "SearchBtn");
	}
	
	public static void Stores() {

		StepLogger.validate(Check.ObjectPresent, "storesBtn_WS");
	}

	public static void SaksBag() {

		StepLogger.validate(Check.ObjectPresent, "homePgSaksBagCounter");
	}

	public static void PromoCode(String promo) {
		
		StepLogger.validate(Check.ObjectPresent,"homePromo_WS");
		StepLogger.validate(Check.TextPresent,"homePromo_WS",promo);
		
	}
	public static void hasWelcomeMat(String CountryName) {


		StepLogger.validate(Check.TextPresent,"WelcomeMatCountry_vm",CountryName);

	}

	public static void hasBottomNavLt() throws Exception{
		String footerText=Find.Object("footer_vm").getText().value();
		if(footerText.indexOf("Gift Cards")>=0&&
				footerText.indexOf("FAQ")>=0&&
				footerText.indexOf("Pricing Policy")>=0&&
				footerText.indexOf("Contact Us")>=0&&
				footerText.indexOf("Forms of Payment")>=0&&
				footerText.indexOf("Store Locations & Events")>=0&&
				footerText.indexOf("Shop Smart Do Good")>=0&&
				footerText.indexOf("About Us")>=0&&
				footerText.indexOf("Careers")>=0&&
				footerText.indexOf("Personal Shopping")>=0&&
				footerText.indexOf("Shipping & Taxes")>=0&&
				footerText.indexOf("Returns & Exchanges")>=0&&
				footerText.indexOf("International Shipping")>=0&&
				footerText.indexOf("Order Status & Tracking")>=0&&
				footerText.indexOf("Credit Services")>=0&&
				footerText.indexOf("Pay Bills Online")>=0&&
				footerText.indexOf("Apply for the Lord & Taylor Card")>=0){
			Report.pass("Bottom Nav all links present");

		}else{
			Report.fail("Bottom Nav links all not present");
		}
	}
}
