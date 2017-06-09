package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.lazyCalls.Home;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.enums.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class Scen02 extends ScenarioSaks{

	private void ValidatePAP() throws Exception
	{
		StepLogger.validate(Check.TextPresent, "prp_Find_Refine_ep");
		String total = Find.Object("prp_Get_Total_PA_Items_ep").getText().value();
		total = total.replace(",", "");
		if (Integer.parseInt(total) > 0)
		{
			Report.pass("Total " + total + " Items founds.");
		}
		else
		{
			Report.fail("Unable to find Total Items.");
		}

		Find.Object("prp_PA_Container_ep").storeAs("My_PA_Container");
		Integer count = Use.CapturedObject("My_PA_Container").FindMultipleObjects("prp_PA_Image_ep").size();
		if (count > 0)
		{
			Report.pass("Total " + count + " Image Frame has been generated for this PA.");
		}
		else
		{
			Report.fail("Unable to find any Image Frame on PA.");
		}
//		String text = Use.CapturedObject("My_PA_Container").FindMultipleObjects("prp_PA_ProductDescription").select(1).getText().value();

	}

	@Override
	public void executeScript() throws Exception {
		Home.closeOverlay();

		//1.1
		nav.ClickSaksYourAccount();

		//1.2
		if ( Find.Object("pdpBagLink").isPresent())
		{
			Find.Object("pdpBagLink").click();
			//Validate Popup
			StepLogger.validate(Check.ObjectPresent, "bOverlayViewBagBtn1");
		}

		//All Validate
		//Parent: id="refine-by-nav"  child: span class="ref-cat" validate contain text: Filter By
		//or
		//parent: div class="pa-gination" child: span class="mainBoldBlackText totalRecords" text integer > 0
		//1.3
		nav.ClickNavigationLinks(TopNavLinks.BEAUTY);
		nav.ClickLeftNavLink("Shop All");
		ValidatePAP();


		//2.1
		//nav.HoverNavLinks(TopNavLinks.DESIGNERS).ClickLinkFromDrawer("Gucci");
		nav.ClickNavigationLinks(TopNavLinks.DESIGNERS);
		sec.ClickDesignerLink();
		nav.ClickLeftNavLink("Kids");
		ValidatePAP();
		//Validate Landing Page

		//2.2
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.ClickLeftNavLink("Dresses");
		ValidatePAP();

		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.ClickLeftNavLink("LIFESTYLE BOUTIQUES");
		ValidatePAP();

		//2.3
		nav.ClickNavigationLinks(TopNavLinks.SHOES);
		nav.ClickLeftNavLink("Boots");
		ValidatePAP();

		//2.4
		nav.ClickNavigationLinks(TopNavLinks.HANDBAGS);
		nav.ClickLeftNavLink("Totes");
		ValidatePAP();

		//2.5
		nav.ClickNavigationLinks(TopNavLinks.JEWELRYACCESSORIES);
		nav.ClickLeftNavLink("Bracelets");
		ValidatePAP();

		//2.6
		nav.ClickNavigationLinks(TopNavLinks.BEAUTY);
		nav.ClickLeftNavLink("Shop All");
		ValidatePAP();

		//2.7
		nav.ClickNavigationLinks(TopNavLinks.MEN);
		nav.ClickLeftNavLink("Ties & Formalwear");
		ValidatePAP();

		//2.8
		nav.ClickNavigationLinks(TopNavLinks.KIDS);
		nav.ClickLeftNavLink("Baby Girl (0-24 Months)");
		ValidatePAP();

		//2.9
		nav.ClickNavigationLinks(TopNavLinks.HOME);
		nav.ClickLeftNavLink("Bedding Collections");
		ValidatePAP();

		//2.10
		nav.ClickNavigationLinks(TopNavLinks.SALE);
		nav.ClickLeftNavLink("Just Kids");
		ValidatePAP();
		
	}
}
