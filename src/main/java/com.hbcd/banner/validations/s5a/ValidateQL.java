package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateQL {

	public static void DisplayStar() {
		StepLogger.validate(Check.ObjectPresent, "qlReviewRatingValidation_wk");
	}

	public static void ReadReview() {
	}

	public static void Overlay() throws Exception{
		if (Find.Object("qlOverlayValidation_wk").isPresent()) {
			Report.pass("QuickLook Overlay displayed");
		} else {
			Report.fail("QuickLook Overlay NOT displayed");
		}
	}

	public static void OverlayNotDisplayed() throws Exception {
		if(Find.Object("qlOverlayValidation_wk").isDisplayed())
			Report.fail("Overlay Displayed", BrowserAction.screenshot());
		else Report.pass("Overlay Not Displayed", BrowserAction.screenshot());
	}
	public static void ProductReviews(String url) throws Exception {
		Switch.toNewWindow("Ratings");
		if(Navigate.currentUrl().indexOf(url)>=0){
			System.out.println("pass");
		} else{
			System.out.println("fail");
		}Switch.toNewWindow("Saks.com");
	}

	public static void HighDemandMesage() {
		StepLogger.validate(Check.ObjectPresent, "qlHighDemandErrorMsg_wk");
		StepLogger.validate(Check.TextPresent, "qlHighDemandErrorMsg_wk",
				"DUE TO HIGH DEMAND");
	}
	
	public static void HighDemandMessageNotPresent() {
		StepLogger.validate(Check.ObjectNotPresent, "qlHighDemandErrorMsg_wk");
	}

	public static void isItemInStore() throws Exception {
		StepLogger.validate(Check.ObjectPresent, "bagQuickLookOverLay");
		if(Find.Object("pdpInStoreBtn_ws").isPresent()){
			Report.pass("Item in store validation PASS");
			Find.Object("pdpInStoreBtn_ws").click();
		}else{
			Report.fail("Item in store validation FAIL");
		}
	}

	public static void isQLViewProductDetailLink() throws Exception {
		Find.Object("bagQuickLookOverLay").getAttribute("display: block");
		if(Find.Object("viewProductDetailLink_zk").isPresent()){
			Report.pass("View Product Detail Link validation PASS");
		}else{
			Report.fail("View Product Detail Link validation FAIL");
		}
	}

	public static void isItemNotInStore() throws Exception {
		StepLogger.validate(Check.ObjectNotPresent, "qlInStoreBtn_wk");
	}

	public static void isShoprunnerNotDisplayonQl() throws Exception {
		StepLogger.validate(Check.ObjectNotPresent,"isShopRunnerQLDisplay_AAF");
	}

	public static void shopRunnerIconDisplayedQl() throws Exception {
		StepLogger.validate(Check.TextPresent, "quickLookShoprunnerEligible_AAF");
	}

	public static void HasNoShopRunnerIconDisplayedQl() throws Exception {
		StepLogger.validate(Check.ObjectNotPresent,"quickLookShoprunnerEligible_AAF");
	}

	public static void hasBrandName(String brandName) throws Exception {
		StepLogger.validate(Check.TextPresent,"htmlPage",brandName);
	}

	public static void hasShortDescription(String shortDescription) throws Exception {
		StepLogger.validate(Check.TextPresent,"htmlPage",shortDescription);
	}

	public static void hasQuantityBox() throws Exception {
		StepLogger.validate(Check.ObjectPresent,"pdpRedesignQty");
	}

	public static void hasProductDetailsLink() throws Exception {
		StepLogger.validate(Check.ObjectPresent,"productDetailslink_vm");
	}

	public static void hasBrandLinkNameOnQL() throws Exception{
		if (Find.Object("cmnComponentBrandName_AAF").isPresent()){
			Report.pass("User Click on the Brand Name in the Overlay");
			Find.Object("cmnComponentBrandName_AAF").click();
			closePopUp();
		}else{
			Report.fail("Brand Name on QL Item is NOT Showing");
		}
	}

	private static void closePopUp() throws Exception{
		if(Find.Object("home_iframe").isPresent()) {
			Switch.toFrameObject("home_iframe");
			if (Find.Object("CloseButton").isPresent()) {
				Find.Object("CloseButton").click();
			}
			Switch.toDefaultContent();
		}
	}

}
