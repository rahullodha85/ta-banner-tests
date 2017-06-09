package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.Assert;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidatePrp {


	public static void hasNavRefineButtons(){
		StepLogger.validate(Check.ObjectPresent, "prpRefineSizeValidation_wk");
		//StepLogger.validate(Check.ObjectPresent, "prpRefineColorValidation_wk");
		//StepLogger.validate(Check.ObjectPresent, "prpRefinePriceValidation_wk");
	}
	public static void hasItemInfo()throws Exception{
		//StepLogger.validate(Check.ObjectPresent, "prpFirstItemClick");
		Assert.Report("First Item Info Available").isExist("prpFirstItemClick");
	}
	public static void hasMoreColorItem(){
		StepLogger.validate(Check.ObjectPresent, "prpMoreColorsValidation_wk");
	}
	public static void hasSaksExclusiveTag(){
		StepLogger.validate(Check.ObjectPresent, "prpSaksExclusiveValidation_wk");
	}


	public static void hasPriceWasNow() throws Exception{
		if(Find.Object("prpFirstItemPrice_WS").getText().value().toLowerCase().contains("now"))
			Report.pass("Price Was and Now Displayed", BrowserAction.screenshot());
		else Report.fail("Price Was and Now NOT Displayed", BrowserAction.screenshot());

	}
	public static void hasBreadCrumb(String crumb){
		StepLogger.validate(Check.TextPresent, "productArrayCrumb_vm", crumb);
	}
	
	public static void hasSearchFor(String searchFor){
		StepLogger.validate(Check.ObjectPresent, "prpSection");
		StepLogger.validate(Check.TextPresent, "prpSection",searchFor);
	}
	public static void FirstItemProductDetailHas(String text) throws Exception {
		if(Find.Object("htmlPage").getText().value().toLowerCase().contains(text.toLowerCase()))
			Report.pass("Text displayed successfully-Search Results for "+text);
		else
			Report.fail("Text NOT displayed successfully-Search Results for "+text);


	}
	public static void hasLogoWithText(String t){
		StepLogger.validate(Check.TextPresent, "landingTitleDlpLogo_wk", t);
	}
	public static void hasShopByCategory(){
		StepLogger.validate(Check.ObjectPresent, "shopCategorylink_vm");
	};
	public static void hasSaleCategory(){
		StepLogger.validate(Check.ObjectPresent, "saleCategorylink_vm");
	}
	public static void hasSearchResultsTitle(String searchResult) throws Exception {
		if(Find.Object("productArrayCrumb_vm").getText().value().toLowerCase().contains(searchResult.toLowerCase()))
			Report.pass("Text displayed successfully-Search Results for "+searchResult);
		else
		Report.fail("Text NOT displayed successfully-Search Results for "+searchResult);
	}

	public static void hasStrikeThroughPriceinPA()throws Exception{
		if (Find.Object("productPriceLineThrough_AAF").isPresent()){
			Report.pass("Strike Through Price is Displayed");
		}else{
			Report.fail("Strike Through Price is NOT Displayed");
		}
	}

	public static void hasSaksTag(String s) throws Exception{
		if (Find.Object("tagsaksrefine_vm").getText().value().contains(s)){
			Report.pass("Tag is Displayed");
		}else{
			Report.fail("Tag is NOT Displayed");
		}

		//
	}
}
