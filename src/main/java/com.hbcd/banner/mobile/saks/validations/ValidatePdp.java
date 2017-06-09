package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidatePdp {

	public static void hasBrandName(String brandName) throws Exception {

		if (Find.Object("pdpProdDescription_WS").isPresent()) {

			Report.pass("Brand Name is displayed", BrowserAction.screenshot());
			StepLogger.validate(Check.TextPresent, "pdpProdDescription_WS",
					brandName);
		} else {
			Report.fail("Brand Name is NOT displayed",
					BrowserAction.screenshot());
		}

	}

	public static void hasSPD(String shortProdDescription) throws Exception {

		if (Find.Object("pdpSPD_WS").isPresent()) {

			Report.pass("Brand Name is displayed", BrowserAction.screenshot());
			StepLogger.validate(Check.TextPresent, "pdpSPD_WS",
					shortProdDescription);
		} else {
			Report.fail("Brand Name is NOT displayed",
					BrowserAction.screenshot());
		}
	}

	public static void hasPrice(String price) throws Exception {

		if (Find.Object("pdpPrice_WS").getText().value().replace("$", "").replace(" ", "")
				.contains(price)) {
			Report.pass("Has Price validation Pass", BrowserAction.screenshot());
		} else {
			Report.fail("Has Price validation Fail", BrowserAction.screenshot());
		}
		System.out.println(Find.Object("pdpPrice_WS").getText().value());
	}

	public static void hasPriceWasNow(String text) throws Exception {

		if (Find.Object("pdpPrice_WS").getText().value().contains(text)) {
			Report.pass("Has Price validation Pass", BrowserAction.screenshot());
		} else {
			Report.fail("Has Price validation Fail", BrowserAction.screenshot());
		}
		System.out.println(Find.Object("pdpPrice_WS").getText().value());
	}

	public static void hasItemNumber(String upc) throws Exception {

		System.out.println(Find.Object("pdpProductCode_WS").getText().value());
		
		if (Find.Object("pdpProductCode_WS").getText().value().contains(upc)) {
			Report.pass("Has Item Number validation Pass",
					BrowserAction.screenshot());
		} else {
			Report.fail("Has Item Number validation Fail",
					BrowserAction.screenshot());
		}

	}

	public static void hasQuantityDropdown() throws Exception {

		StepLogger.validate(Check.ObjectPresent, "AddToBagBtn");

	}

	// public static void hasShortDescription(String shortDescription) throws
	// Exception{
	// if(Find.Object("pdpShortDescription_vm").getText().value().contains(shortDescription)){
	// Report.pass("Short Description Present", BrowserAction.screenshot());
	// }
	// else{
	// Report.fail("Short Description Absent", BrowserAction.screenshot());
	// }
	//
	// }

	public static void hasColorSizeDropDown() {
		// pdpColorSizeDrpDwn_vm

	}

	public static void hasColorSwatches() {

		StepLogger.validate(Check.ObjectPresent, "pdpSwatchesSection_WS");

	}
	public static void bagCount(String bagCount) throws Exception {

		if (Find.Object("homePgSaksBagCounter").getText().value()
				.contains(bagCount))
			Report.pass("Bag Counter validation PASS",
					BrowserAction.screenshot());
		else
			Report.fail("Bag Counter validation FAIL",
					BrowserAction.screenshot());

	}

	public static void isFinalSaleText() {
		
		StepLogger.validate(Check.TextPresent, "pdpFinalSaleTxt_WS","Final Sale: This item cannot be returned");
		
	}


	public static void hasRecommendationSection() throws Exception {
		if(Find.Object("pdpRecSection_wk").isPresent()){
			Report.pass("Recommendation Seciton displayed", BrowserAction.screenshot());
		}else 
			Report.fail("Recommendation Section not displayed", BrowserAction.screenshot());
	}
	public static void hasRecommendationDots() throws Exception{
		if(Find.Object("pdpRecDots_wk").isPresent()){
			Report.pass("Recommendation Dots displayed", BrowserAction.screenshot());
		}else 
			Report.fail("Recommendation Dots not displayed", BrowserAction.screenshot());
	}
	public static void recommendsDotsClickable() throws Exception{
		Thread.sleep(2000L);
		Find.Object("pdpRecRightDot_wk").click();
		if(Find.Object("pdpRecActive1_wk").getAttribute("data-slick-index").value().contains("3"))
			Report.pass("4th Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("4th Recommendation displayed", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecActive2_wk").getAttribute("data-slick-index").value().contains("4"))
			Report.pass("5th Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("5th Recommendation displayed", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecActive3_wk").getAttribute("data-slick-index").value().contains("5"))
			Report.pass("6th Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("6th Recommendation displayed", BrowserAction.screenshot());

		Thread.sleep(1000L);
		Find.Object("pdpRecLeftDot_wk").click();
		if(Find.Object("pdpRecActive1_wk").getAttribute("data-slick-index").value().contains("0"))
			Report.pass("1st Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("4th Recommendation displayed", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecActive2_wk").getAttribute("data-slick-index").value().contains("1"))
			Report.pass("2nd Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("5th Recommendation displayed", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecActive3_wk").getAttribute("data-slick-index").value().contains("2"))
			Report.pass("3rd Recommendation displayed", BrowserAction.screenshot());
		else Report.fail("6th Recommendation displayed", BrowserAction.screenshot());
	}
	public static void recommendationsNotInclude(String upc) throws Exception{
		if(Find.Object("pdpRecSection_wk").getAttribute("innerHTML").value().contains(upc)){
			Report.fail("Item "+ upc + " should not display", BrowserAction.screenshot());
		}else Report.pass("Item " + upc + " not displayed", BrowserAction.screenshot());
	}
	
	public static void hasRichRelDetails() throws Exception{
		if(Find.Object("pdpRecRRHeader_wk").isPresent())
			Report.pass("RR Header shown", BrowserAction.screenshot());
		else Report.fail("RR Header not shown", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecRRDesc_wk").isPresent())
			Report.pass("RR Description shown", BrowserAction.screenshot());
		else Report.fail("RR Description not shown", BrowserAction.screenshot());
		
		if(Find.Object("pdpRecRRNowPrice_wk").isPresent())
			Report.pass("RR Now Price shown", BrowserAction.screenshot());
		else Report.fail("RR Now Price not shown", BrowserAction.screenshot());
	}

	public static void ColorSizeDrpDwnHasPreOrder() throws Exception {
		
		if(Find.Object("pdpColorSizeDropdown_wk").getText().value().contains("PRE-ORDER"))
			Report.pass("Color Size Dropdown has PreOrder Item", BrowserAction.screenshot());
		else
			Report.pass("Color Size Dropdown DOES NOT have PreOrder Item", BrowserAction.screenshot());
		
	}

	public static void hasSalePriceWasNow() {
		
		StepLogger.validate(Check.ObjectPresent,"pdpProductOffer_WS");
	}
	public static void hasAddToBagButton()throws Exception{
		Thread.sleep(2000);
		if (Find.Object("AEMaddtoBagButton_wk").isPresent()){
			Report.pass("Add To Bag Button is Present",BrowserAction.screenshot());
		}else{
			Report.fail("Add to Bag Button is NOT Present",BrowserAction.screenshot());
		}
	}
	public static void hasItemAddedToBagOverlay()throws Exception{
		if (Find.Object("pdpItemAddedToBag_WS").isPresent()){
			Report.pass("Item(s) Added to Saks-Bag",BrowserAction.screenshot());
		}else{
			Report.fail("Item is NOT Present in the Saks-Bag Page",BrowserAction.screenshot());
		}
	}

	public static void hasUserLandedOnPdpPage(String upc) throws  Exception{
		if (Find.Object("pdpPageLanded_AAF").isPresent()){
		if (Find.Object("pdpPageLanded_AAF").getText().value().contains(upc)){
				Report.pass("User Landed on PDP Page " + upc, BrowserAction.screenshot());
			}
		}else{
			Report.fail("User is NOT landed on PDP Page",BrowserAction.screenshot());
		}
	}

	public static void hasBrandNameOnPdpPage(String brandName) throws Exception{
		if (Find.Object("brandNameOnPdp_AAF").isPresent()){
		if (Find.Object("brandNameOnPdp_AAF").getText().value().contains(brandName)){
			Report.pass("Brand Name: " + brandName,BrowserAction.screenshot());
			}
		}else{
			Report.fail("Brant is NOT shown", BrowserAction.screenshot());
		}
	}

	public static void colorSelectedOnPDP(String color) throws Exception{

		StepLogger.validate(Check.ObjectPresent, "colorSelectedOnPDP_AAF");
		if (Find.Object("colorSelectedOnPDP_AAF").getText().value().contains(color)){
			Report.pass("Color: " + color);
		}else{
			Report.fail("Color is NOT Selected");
		}
	}
public static void hasOldPriceStrikedOut(){

	StepLogger.validate(Check.ObjectPresent,"pdpStrikethroughOldPrice_WS");
}

	public static void hasProductQuantitySection(){

		StepLogger.validate(Check.ObjectPresent,"pdpProductQtySection_WS");
	}
}
