package com.hbcd.testscript.dr.s5a.mobile;

import com.hbcd.banner.mobile.saks.validations.ValidatePdp;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
public class Scen05 extends ScenarioMobileSaks {
	/*
	"Add 1 regular item, 1 SFS item that has a restricted shipping method Standard, 1 dropship item that has  shipping method  Next Bus. Day and proceed to checkout to Review&Submit page.

"	"On load on R&S page:

Radio buttons will be as follows:

 - Next Business Day radio button renders and is pre-selected
 - Saturday

Shipping method restriction messaging is positioned below radio buttons in the
 Shipping Address section
 "" ! Some items(s) cannot ship via Next Bus. Day shipping ""

 ""! All eligible items have been upgrded to ship via Next Bus. Day shipping.""
"
	 */
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0412264496516");
		
		ValidatePdp.hasBrandName("Clinique");
		ValidatePdp.hasSPD("Facial Soap with Dish, Mild/5.2 oz.");
		ValidatePdp.hasPrice("14.00");
		ValidatePdp.hasItemNumber("0412264496516");
		ValidatePdp.hasQuantityDropdown();
		
	}
}