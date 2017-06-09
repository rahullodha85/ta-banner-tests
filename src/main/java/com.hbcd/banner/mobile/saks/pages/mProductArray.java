package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.banner.mobile.saks.drawers.PrpRefine;
import com.hbcd.commonbanner.base.pages.ProductArrayPageBase;
import com.hbcd.commonbanner.enums.SortOptions;
import com.hbcd.commonbanner.overlays.QuickLookOverLay;
import com.hbcd.scripting.core.*;
import com.hbcd.scripting.core.fluentInterface.ObjectAction;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type;

public class mProductArray extends ProductArrayPageBase {

	@Override
	public PrpRefine ClickRefineDrpDwn() throws Exception {
		Find.Object("prpClickRefineBtn_wk").click();
		return new PrpRefine();
	}

	@Override
	public void AddClearanceItem() {
	}

	@Override
	public QuickLookOverLay ClickQuickView(String upc) {
		return null;
	}

	@Override
	public void SelectSortBy(String sortMethod) {
	}

	@Override
	public void RefineByType(String type) {

	}

	public static void clickRefine() throws Exception {

		StepLogger.validate(Check.ObjectPresent, "prpRefine_WS");

		Find.Object("prpRefine_WS").click();
		//
		// New.Object("Refine").setProperty(PropertyType.TAG_NAME, "a")
		// .setProperty(PropertyType.CONTAINS_TEXT, "Refine").click();

	}

	@Override
	public void RefineByStyle(String style) {
	}

	@Override
	public void RefineByDesigner(String designer) throws Exception {
		clickRefine();

		StepLogger.validate(Check.ObjectPresent, "prpRefineDesigner_WS");
		Find.Object("prpRefineDesigner_WS").click();

		// New.Object("designer").setProperty(PropertyType.TAG_NAME, "a")
		// .setProperty(PropertyType.CONTAINS_TEXT, "designer").click();

		Find.Object("prpDesignerSel_WS").changeContainsText(designer).click();
		StepLogger.validate(Check.ObjectPresent, "prpRefineDesignerApplyBtn");
		Find.Object("prpRefineDesignerApplyBtn").click();

		
	}

	@Override
	public void RefineBySize(String size) {
	}

	@Override
	public void RefineByColor(String color)throws Exception{
		StepLogger.validate(Check.ObjectPresent, "prpFilterBy_WS");
		Find.Object("prpFilterBy_WS").click();
		if (Find.Object("prpRefineColor_AAF").isPresent()){
			Report.pass("User Selects Color "+ color);
			Find.Object("prpRefineColor_AAF").click();
			Find.Object("refineColorSelect_AAF").doubleClick();
			Find.Object("refineApplyBtn_wk").changeId("color-multiselect").click();
		}else{
			Report.fail("Color is NOT selected");
		}
	}

	@Override
	public void RefineByPrice(String price) throws Exception{
		if(Find.Object("prpRefineByPrice_wk").isPresent()) {
			Report.pass(String.format("user Clicks on Filter By to filters based on Attributes of Price Range"));
			Find.Object("prpRefineByPrice_wk").doubleClick();
		}else{
			Report.fail("Filter By Option is NOT Present");
		}
		Find.Object("clickPrice_AAF").doubleClick();
		Find.Object("prpRefinePriceCheckbox_wk").changeContainsText(price).doubleClick();
		Report.pass("User Clicks on the price range between " + price, BrowserAction.screenshot());
		Find.Object("refineApplyBtn_wk").click();
	}

	@Override
	public void RefineByLifeStyle(String lifeStyle) throws Exception{
		StepLogger.validate(Check.ObjectPresent, "prpFilterBy_WS");
		Find.Object("prpFilterBy_WS").click();
		if (Find.Object("prpLifeStyle_AAF").isPresent()){
			Report.pass("User Clicks on LifeStyle" + lifeStyle);
			Find.Object("prpLifeStyle_AAF").click();
			Find.Object("prpContemporary_AAF").click();
			Find.Object("prpRefineDesignerApplyBtn_WS").click();
		}else{
			Report.fail("LifeStyle is NOT Appeared" + lifeStyle);
		}
	}

	@Override
	public void ClickPagination() {
	}

	@Override
	public void ClickNavigation(int page) {
	}

	@Override
	public void RemoveFilter(String filterName) {
	}

	@Override
	public void RemoveAllFilters() {
	}

	@Override
	public void Refines() {

	}

	@Override
	public void ClickBreadcrum(String breadcrumName) throws Exception {

		Thread.sleep(3000);
		if(Find.Object("prpBreadCrumbLink_WS")
				.changeContainsText(breadcrumName).isPresent())
			Report.pass(breadcrumName+" is present", BrowserAction.screenshot());
		else
			Report.fail(breadcrumName+" is NOT present", BrowserAction.screenshot());
		
		Find.Object("prpBreadCrumbLink_WS")
				.changeContainsText(breadcrumName).click();

		// New.Object("").setProperty(PropertyType.TAG_NAME, "a")
		// .setProperty(PropertyType.CONTAINS_TEXT, breadcrumName).click();

	}

	@Override
	public void Sorts(String sortBy) throws Exception {

		StepLogger.validate(Check.ObjectPresent, "prpSortByCategory_WS");
		
		Find.Object("prpSortByCategory_WS").click();
		
		Find.Object("prpSortByCategory_WS").changeContainsText(sortBy).click();

		
	}

	@Override
	public void hoverFirstItem() {

	}

	@Override
	public void SortBy(SortOptions option) throws Exception{
		if (Find.Object("prodArraySortBy").isPresent()) {
			Report.pass("User is sorting by " + option);
			Find.Object("prodArraySortBy").click();
			Find.Object("prpSortByCategory_WS").changeContainsText(option.toString()).click();
		}else{
			Report.fail("Sort Option is NOT available");
		}
	}

	@Override
	public void ClickFirstItem() throws Exception {
		String [] prpFirstItemInfo= Find.Object("prpFirstItem").getText().value().split("\n");
		
		Storage.save("prpFirstItemBrandName", prpFirstItemInfo[0]);
		Find.Object("prpFirstItem").click();
		
	}

	@Override
	public void ClickFirstQuickLook() throws Exception {

	}

	@Override
	public void CloseQuickLook() throws Exception {

	}
	public void ClickShopAll() throws Exception{
		
		Find.Object("ShopAll_WS").click();
		
	}
	
	public void ClickPromoSlider() throws Exception{
	
		Find.Object("HomePagePromo_WS").javascriptClick();
}
	
	public void ClickLogo() throws Exception{
		
		Find.Object("mhomePageBtn").click();
		
	}
	
	@Override
	public void FilterByDesigner(String option) throws Exception {

		StepLogger.validate(Check.ObjectPresent, "prpFilterBy_WS");
		Find.Object("prpFilterBy_WS").click();
		
		StepLogger.validate(Check.ObjectPresent, "prpDesigner_WS");
		Find.Object("prpDesigner_WS").click();
		
		if(Find.Object("prpDesignerName_WS").changeContainsText(option).isPresent())
			Report.pass(option+" is Present", BrowserAction.screenshot());
		else
			Report.pass(option+" is NOT Present", BrowserAction.screenshot());
		
		Find.Object("prpDesignerName_WS").changeContainsText(option).click();
		Find.Object("prpRefineDesignerApplyBtn_WS").click();
		
		
		
	}
}
