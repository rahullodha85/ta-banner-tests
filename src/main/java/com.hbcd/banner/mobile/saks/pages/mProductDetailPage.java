package com.hbcd.banner.mobile.saks.pages;


import com.hbcd.commonbanner.base.pages.PDPPageBase;
import com.hbcd.commonbanner.overlays.*;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mProductDetailPage extends PDPPageBase {

	@Override
	public void AddToBag(int option) throws Exception {

		if(Find.Object("pdpColorSizeDropdown_wk").isPresent()) {
			Report.pass("Color size drop down displayed");
			Find.Object("pdpColorSizeDropdown_wk").select(option);
		}
		if (Find.Object("CheckOutBtn").isPresent()){
			Report.pass("User Clicks on Add To Bag",BrowserAction.screenshot());
			Find.Object("CheckOutBtn").click();
		}else{
			Report.fail("Add To Button is NOT Clicked",BrowserAction.screenshot());
		}

	}

	@Override
	public void SelectSize(String option) throws Exception {
		Find.Object("pdpColorSizeDrpDwn_vm").select(Integer.parseInt(option));
		
	}
	
	@Override
	public void AddToBag(String option, int quantity) throws Exception{
		
		if(!(option.equals("")))
		Find.Object("pdpColorSizeDropdown_wk").select(Integer.parseInt(option));
		
		Find.Object("pdpqty_WS").select(quantity);
		
		StepLogger.validate(Check.ObjectPresent, "CheckOutBtn");
		Find.Object("CheckOutBtn").click();
	}
	

	@Override
	public void EnterBag() throws Exception {

		if (Find.Object("homePgSaksBagCounter").isPresent()){
			Report.pass("User Clicks Enter Bag",BrowserAction.screenshot());
		}else{
			Report.fail("Enter Bag is NOT working",BrowserAction.screenshot());
		}
		//StepLogger.validate(Check.ObjectPresent, "homePgSaksBagCounter");

		Find.Object("mCheckoutSaksEnterBag_vm").click();
		System.out.println("Saks BagCounter Button Clicked");
		if (Find.Object("body").isPresent()) {

			if (Find.Object("body").getText().value().toLowerCase()
					.contains("session timeout")) {

				Report.systemFail("Session Time out", BrowserAction.screenshot());
			}
		}

	}

	@Override
	public void AddToWaitList(String email) throws Exception{

		if (Find.Object("yapPaymentMethodForm").isPresent()) {

			if (Find.Object("yapPaymentMethodForm").getText().value()
					.contains("No results were found for"))
				Report.dataFail("No results were found for",
						BrowserAction.screenshot());
		}
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName());

		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}

		boolean isVegc = false;
		if(Find.Object("pdpVegcValidation").isPresent())
			isVegc = Find.Object("pdpVegcValidation").getText().value()
					.contains("Virtual Gift Card");
		if (!isVegc) {
			Thread.sleep(2000);
			selectFirstUnavailableColorSwatch();
			selectFirstUnavailableSizeSwatch();
			StepLogger.validate(Check.ObjectPresent, "pdpWaitListEmailTextBox_zk");
			Find.Object("pdpWaitListEmailTextBox_zk").input(email);
			clickAddToWaitListButton();
		} else{
			Report.fail("Item selected has no unavailable colore or size, so cannot be added to waitlist", BrowserAction.screenshot());
		}
	}

	private static void selectFirstUnavailableColorSwatch() throws Exception{
		boolean colorSelected = false;
		if (!colorSelected && Find.Object("pdpUnavailableColorSwatchLink_zk").isPresent()) {
			Find.Object("pdpUnavailableColorSwatchLink_zk").click();
			colorSelected = true;
		}else {
			Report.dataFail("Selected item has no unavailable colore or size, so cannot be added to waitlist", BrowserAction.screenshot());
		}

	}

	private void selectFirstUnavailableSizeSwatch() throws Exception {
		Boolean sizeSilected = false;
		if (!sizeSilected && Find.Object("pdpUnavailableSizeSwatchLink_zk").isPresent()){
			Find.Object("pdpUnavailableSizeSwatchLink_zk").click();
			sizeSilected = true;
		}else {
			Report.dataFail("Selected item has no unavailable colore or size, so cannot be added to waitlist", BrowserAction.screenshot());
		}

	}

	private void clickAddToWaitListButton() throws Exception{
		Find.Object("pdpAddToWaitListButton_zk").click();
	}


}
