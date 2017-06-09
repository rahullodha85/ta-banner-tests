package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;
import org.apache.commons.lang3.Range;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateProductArray {

	public static void isQuickLookPresent() throws Exception {
		if (Find.Object("prpQLBtn_WS").isPresent()){
			Report.pass("Quick Look Link validation PASS");
		}else {
			Report.fail("Quick Look Link validation FAIL");
		}
	}
	
	public static void isItemSoldOut() throws Exception {
		
		String text=Find.Object("bagQuickLookOverLay").getText().value();

		if(text.toLowerCase().contains("sorry")){
			
			System.out.println("Sold out Message is displayed");
		}
	}

	public static void isPageTitle(String title) throws Exception {
		if(Find.Object("ProductArrayTitle_RL").getText().value().toLowerCase().contains(title.toLowerCase())){
			Report.pass("User is on " + title + " page",
						BrowserAction.screenshot());
		}else {
			Report.fail("User is not on " + title + " page",
					BrowserAction.screenshot());
		}
	}
	public static void hasBannerLandingPage(String bannerName) throws Exception {

		if(Find.Object("prpbrandLandingPage_WS").isPresent()){

			Report.pass("BannerLandingPage is displayed");
			if(Find.Object("prpbrandLandingPage_WS").getAttribute("outerHTML").value().toLowerCase().contains(bannerName.toLowerCase()))
			Report.pass(bannerName+" landing page is displayed successfully");
			else
			Report.fail(bannerName+" landing page is NOT displayed ");
		}
		else
			Report.fail("BannerLandingPage is NOT displayed");
	}
	public static void hasBannerItemCategory(String itemCategory)throws Exception {

		if(Find.Object("prpbrandItemCategoryBanner_WS").isPresent()){

			Report.pass("Item Category Banner is displayed");
			if(Find.Object("prpbrandItemCategoryBanner_WS").getAttribute("outerHTML").value().toLowerCase().contains(itemCategory.toLowerCase()))
				Report.pass(itemCategory+" is displayed successfully");
			else
				Report.fail(itemCategory+" is NOT displayed successfully");

		}



	}
public  static void refinedBy(String text) throws Exception {

	if(Find.Object("prpRefinedText_WS").getText().value().contains(text))
		Report.pass("Successfully refined by "+text);
	else
		Report.fail("Not refined by "+text);
}
	public static void isTrendEventsPresent(String text) throws Exception{
		if(Find.Object("paLeftNavLastGroupTitle_RL").getText().value().toLowerCase().contains(text.toLowerCase())){
			Report.pass("TRENDS & EVENTS is present",
					BrowserAction.screenshot());
		}else {
			Report.fail("TRENDS & EVENTS not found",
						BrowserAction.screenshot());
		}
	}

	public static void ItemsInPriceRange(String range) throws Exception{
		double high=0, low=0, dPrice;
		String price;
		if(range.contains("Under")){
			high = Double.parseDouble(range.replace("Under","").replace("$","").trim());
		}else if(range.contains("Over")){
			low = Double.parseDouble(range.replace("Over","").replace("$","").trim());
		}else if(range.contains("-")){
			range = range.replace("$","");
			low = Double.parseDouble(range.split("-")[0].trim());
			high = Double.parseDouble(range.split("-")[1].trim());
		}else{
			Report.fail("Unknown Price format passed in as argument",
						BrowserAction.screenshot());
		}
		if(Find.Object("prpFirstItemSalePrice_RL").isPresent()){
			price = Find.Object("prpFirstItemSalePrice_RL").getText().value();
		}else {
			price = Find.Object("prpFirstItemPrice_RL").getText().value();
		}
		dPrice = Double.parseDouble(price.substring(price.indexOf('$')+1));
		if(dPrice>high || dPrice<low){
			Report.fail("Item price not in price range selected",
					BrowserAction.screenshot());
		}else{
			Report.pass("Item price in price range selected",
					BrowserAction.screenshot());
		}
	}

	public static void leftNavText(String text) throws Exception{
		if (Find.Object("leftNavText_AAF").getText().value().contains(text))
			Report.pass("LeftNav text is displayed", BrowserAction.screenshot());
		else
			Report.fail("Left Nav text is not Displayed", BrowserAction.screenshot());
	}

	public static void isPreviousAndPresentPrice()throws Exception{
		Thread.sleep(5000);
		if (Find.Object("regularprice_AAF").isDisplayed())
			Report.pass("Regular price is Selected", BrowserAction.screenshot());
		else
			Report.fail("Regular price is Not Displayed");
		Thread.sleep(2000);
		if (Find.Object("salePrice_AAF").isDisplayed())
			Report.pass("Sale price is Selected", BrowserAction.screenshot());
		else
			Report.fail("Sale Price is Not Selected", BrowserAction.screenshot());
	}

	public static void isLeftHandNavOffFifthPresent(String text) throws Exception{
		if (Find.Object("ofm_paLeftHandNav_AAF").getText().value().contains(text))
			Report.pass("Left Hand Nav is Validated", BrowserAction.screenshot());
		else
			Report.fail("Validation Failed", BrowserAction.screenshot());

		}
	public static void isPageTitleByKeyWordSearched(String title) throws Exception{
		if (Find.Object("ofm_prpTitlebyKwSearch_AAF").getText().value().contains(title.toUpperCase())) {
			Report.pass("User is Landed on Page with Search Results: " + title, BrowserAction.screenshot());
		}else{
			Report.fail("Validation Failed ", BrowserAction.screenshot());
		}
	}
	//This Validation is created to validate whether user can see the Search results Text
	public static void isPageTitleBySearchResult(String text) throws Exception{
		Thread.sleep(1000);
		Find.Object("productArrayCrumb_wk").isDisplayed();
		if (Find.Object("productArrayCrumb_wk").getText().value().contains(text))
			Report.pass("User can see the Search Results " + text, BrowserAction.screenshot());
		else{
			Report.fail("Object Not Present", BrowserAction.screenshot());
		}
	}

	public static void isPageTitleByDesigner(String text) throws Exception{
		Thread.sleep(1000);
		//Find.Object("ofm_prpTitleDesignerPage_AAF").isDisplayed();
		if (Find.Object("htmlPage").getText().value().toUpperCase().contains(text.toUpperCase()))
			Report.pass("By Selecting Shop By Designer, User Landed on " + text, BrowserAction.screenshot());
		else{
			Report.fail("Object Not Present", BrowserAction.screenshot());
		}
	}

	public static void hasBreadcrumbTitleAppeared(String text) throws Exception{
		if (Find.Object("breadCrumbText_AAF").getText().value().contains(text))
			Report.pass("User Landed on " + text, BrowserAction.screenshot());
		else
			Report.fail("Validation BreadCrumb Failed", BrowserAction.screenshot());

		}

	public static void hasleftNavLinkGroupContainer(String text) throws Exception {
		if(Find.Object("leftNavGroupContainer_AAF").isPresent()){
			Report.pass("perpetual left-nav-group-container Appeared");
		}else{
			Report.fail("perpetual left-nav-group-container is NOT Appeared");
		}
		Find.Object("leftNavGroupContainer_AAF").getText().value().contains(text);
		Find.Object("leftNavGroupContainer_AAF").click();
	}

	public static void productArrayFilterBy(String text) throws Exception{
		if (Find.Object("filterBy_AAF").getText().value().contains(text))
			Report.pass("Filter By " + text);
		else
			Report.fail("Filter By is NOT Displayed");
		Find.Object("filterBy_AAF").click();
		Thread.sleep(3000);
		if (Find.Object("selectBrandDesigner_AAF").isPresent()){
			Report.pass("Select a Designer");
		}else {
			Report.fail("NOT Selected");
		}
		Find.Object("selectBrandDesigner_AAF").click();
		if(Find.Object("clickApplyForFilter_AAF").isPresent()){
			Report.pass("Click Apply");
		}else{
			Report.fail("Click Apply is NOT Working");
		}
		Find.Object("clickApplyForFilter_AAF").click();

	}

	public static void filterBySizeProductArray()throws Exception{
		if (Find.Object("filterSize_AAF").isPresent()){
			Report.pass("User Validated Product Array by Size Selection");
		}else{
			Report.fail("Size Slection is NOT Displayed");
		}
		Find.Object("filterSize_AAF").click();
		if (Find.Object("selectFirstSize").isPresent()){
			Report.pass("Select First Size");
		}else{
			Report.fail("Select First Size is NOT Working");
		}
		Find.Object("selectFirstSize").click();
	}

	public static void filterByColor()throws Exception{

		if (Find.Object("refineByLifeStyle_AAF").isPresent()){
			Report.pass("Filter By LifeStyle");
			Find.Object("refineByLifeStyle_AAF").click();
		}else{
			Report.fail("Filter By Lifestyle is NOT Present");
		}

		Find.Object("clickApplyForFilter_AAF").click();
	}

	public static void hasProductInfoOnPa()throws Exception{
		if (Find.Object("productText_AAF").isPresent()){
			Report.pass("Product Info/Description is Available in Product Array");
		}else{
			Report.fail("Product Info NOT Available");
		}
	}

	public static void hasLeftNavDesignContainer(String designer)throws Exception{
		if (Find.Object("leftNavDesigner_AAF").isPresent()){
			Report.pass("Left Nav Designer Container Link Present with User Clicks on " + designer);
			Find.Object("leftNavDesigner_AAF").click();
		}else{
			Report.fail("Validations Failed");
		}
	}

	public static void hasLeftNavLinks() throws Exception{
		closeEmailPopUps();
		if (Find.Object("leftNavLinks_AAF").isPresent()){
			Report.pass("User Can able to see and Clicks on the Left Nav");
			Find.Object("leftNavLinks_AAF").click();
		}else{
			Report.fail("Left Nav Links are NOT working");
		}
	}

	private static void closeEmailPopUps() throws Exception{
		if(Find.Object("home_iframe").isPresent()) {
			Switch.toFrameObject("home_iframe");
			if (Find.Object("CloseButton").isPresent()) {
				Find.Object("CloseButton").click();
			}
			Switch.toDefaultContent();
		}
	}

	public static void hasShopByCategoryPresent() throws Exception{
		if (Find.Object("shopByCategory_AAF").isPresent()){
			Report.pass("User can able to see the Shop By Categories on the LHN");
		}else{
			Report.fail("Shop By Category is NOT displayed");
		}
	}

	public static void hasClearAllPresent() throws Exception{
		if (Find.Object("clearAllFilters_AAF").isPresent()){
			Report.pass("User can Able to See Clear All for all the filters");
			Find.Object("clearAllFilters_AAF").click();
		}else{
			Report.fail("Clear All Filters is NOT available");
		}
	}

	public static void isPageTitleByBrandName() throws Exception{
		if(Find.Object("productArrayTitleByBrand_AAF").isPresent()){
		   Report.pass("User is on a Page with Brand Title");
		}else{
			Report.fail("Brand title is NOT appeared");
		}
	}

	public static void hasLeftHandNavigation(String text) throws Exception{
		if (Find.Object("o5aleftHandNav_AAF").getText().value().contains(text)){
			Report.pass("LeftNav text is displayed and User Clicks on Left Nav Text");
			Find.Object("o5aleftHandNav_AAF").click();
		}
		else{
			Report.fail("Left Nav is NOT displayed");
		}

	}

	public static void isFirstItemPriceRange(int value1, int value2) throws Exception{
		String _price = Find.MultipleObjects("listPrice_AAF").getText().get(1);
		String pattern = "(\\d+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(_price);
		if (m.find()){
			String _parsedPrice = m.group(1);
			int foo = Integer.parseInt(_parsedPrice);
			Range<Integer> _priceRange = Range.between(value1,value2);
			if (_priceRange.contains(foo)){
				Report.pass(String.format("The selected price for First Item falls with the price range of " + "\t" + value1 + " And " + "\t" + value2));
			}else{
				Report.fail("The selected item does not falls under the price range of " + value1+value2);
			}
		}
	}
}
