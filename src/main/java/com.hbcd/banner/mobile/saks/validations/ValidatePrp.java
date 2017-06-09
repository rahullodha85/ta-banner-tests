package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.reporting.objects.Step;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Update;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import org.apache.commons.lang3.Range;

import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePrp {

	public static void ValidateBreadCrumb(String text) throws Exception {
		StepLogger
				.validate(Check.TextPresent, "prpValidateBreadCrumb_wk", text.toUpperCase());

	}

	public static void ValidateSort(String sortBy) {
		StepLogger.validate(Check.TextPresent, "prodArraySortBy", "Sort By: "
                + sortBy);
	}

	public static void ValidateRefine() throws Exception {
		StepLogger.validate(Check.TextPresent, "body", "Filter By: 1 Selected");
	}

	public static void ProdutReviewStars() throws Exception {

		if ((Find.Object("body").getAttribute("innerHTML").value()
				.contains("product-rating"))) {

			Report.pass("Product Review Stars Pass", BrowserAction.screenshot());
		} else
			Report.fail("Product Review Stars fail", BrowserAction.screenshot());
	}

	public static void isBrandPage(String brandName) throws Exception {

		if (Find.Object("prpBreadCrumb_WS").getText().value().toLowerCase()
				.contains(brandName.toLowerCase())) {

			Report.pass("isBrandPage validation Pass",
					BrowserAction.screenshot());
		} else {
			Report.fail("isBrandPage validation Fail",
					BrowserAction.screenshot());
		}
	}

	public static void isLandingPage() throws Exception {
		StepLogger.validate(Check.TextPresent, "prpSection", "Sort");
	}

	public static void isCategorySelected(String string) throws Exception {
		StepLogger.validate(Check.TextPresent, "prpSection", "Sort");

	}

	public static void isPricePresent() throws Exception {
		if ((Find.Object("prpFirstItem").getText().value().indexOf("Was $") >= 0)
				&& (Find.Object("prpFirstItem").getText().value()
						.indexOf("Now $") >= 0))
			Report.pass("Price state is present", BrowserAction.screenshot());
		else
			Report.fail("Price state is not present",
					BrowserAction.screenshot());

	}

	public static void FirstItemHas(String verifyText) throws Exception {

		if (Find.Object("prpFirstItem").getText().value().contains(verifyText))
			Report.pass(verifyText + " is displayed in the First Item",
					BrowserAction.screenshot());
		else
			Report.fail(verifyText + " is NOT displayed in the First Item",
					BrowserAction.screenshot());

	}

	public static void isPreOrderItem(String upc) throws Exception {

		if (Find.Object("prpItem_WS").changeId(upc).getText().value()
				.contains("Pre-Order"))
			Report.pass("PreOrder Item validation Pass",
					BrowserAction.screenshot());
		else
			Report.fail("PreOrder Item validation Fail",
					BrowserAction.screenshot());

	}

	public static void hasColorSwatches() {

		StepLogger.validate(Check.ObjectPresent, "prpColorSwatchesLink_WS");

	}

	public static void hasFilters() throws Exception {
        Find.Object("prpFilterBtn_wk").click();
        StepLogger.validate(Check.ObjectPresent, "prpFilterType_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterDesigner_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterSize_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterColor_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterStyle_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterOccasion_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterMaterial_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterLifestyle_wk");
        StepLogger.validate(Check.ObjectPresent, "prpFilterPrice_wk");
        Find.Object("prpFilterDone_wk").click();
        Thread.sleep(3000L);
	}

    public static void hasSorts() throws Exception{
        Find.Object("prpSortBtn_wk").click();
        StepLogger.validate(Check.ObjectPresent, "prpSortNewest_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortBestSeller_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortTopRated_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortPriceLowToHigh_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortDesigner_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortCategory_wk");
        StepLogger.validate(Check.ObjectPresent, "prpSortSaleFirst_wk");
    }

	public static void CategoryTitle(String category) throws Exception {
		if(Find.Object("o5m_prpPrpTitle_WS").getText().value().toLowerCase().contains(category.toLowerCase()))
			Report.pass(category+" is displayed as title");
		else
			Report.fail(category + " is displayed as title");

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

	public static void isSearchByKeyAppearedOnPrp(String keyword) throws Exception{
		String _productDesc = Find.MultipleObjects("prdDetails_AAF").getText().toString();
		System.out.println(_productDesc);
		String pattern = ("\\W*((?i)Phillip Lim(?-i))\\W*");
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(_productDesc);
		if (m.find()){
			String _matchedKeyWord = m.group(1);
			if(_matchedKeyWord.contains(keyword)){
				Report.pass("User Searched with Keyword "+ keyword + " is Matched and Appeared on Product Array");
			}else{
				Report.fail("User searched with keyword is NOT appeared on Product Array");
			}
		}

	}
}
