package com.hbcd.banner.mobile.saks.pages;


import com.hbcd.banner.common.paypal.pBag;
import com.hbcd.banner.mobile.saks.overlays.mGiftOverlay;
import com.hbcd.commonbanner.base.pages.BagPageBase;
import com.hbcd.commonbanner.overlays.*;
import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mBagPage extends BagPageBase {

	private pBag pBagSaks;

	public mBagPage() {
		pBagSaks = new pBag();
	}


	@Override
	public void CheckOut() throws Exception {

		if (Find.Object("bagCheckOutBottomBtn_WS").isPresent()) {
			Report.pass("UnRegisterCheckout Button is Present",BrowserAction.screenshot());
			Thread.sleep(1000);
			Find.Object("bagCheckOutBottomBtn_WS").click();
		} else if (Find.Object("bagCheckOutBtn").isPresent()) {

			StepLogger.validate(Check.ObjectPresent, "bagCheckOutBtn");
			Find.Object("bagCheckOutBtn").click();
		} else if (Find.Object("bagCheckOutBtn_WS").isPresent()) {

			StepLogger.validate(Check.ObjectPresent, "bagCheckOutBtn_WS");
			Find.Object("bagCheckOutBtn_WS").click();
		}

		if (Find.Object("body").isPresent()) {

			if (Find.Object("body").getText().value().toLowerCase()
					.contains("session timeout")) {

				Report.systemFail("Session Time out",
						BrowserAction.screenshot());
			}

		}
		if(Find.Object("shippingBillingError_WS").isPresent())
			Report.systemFail("Unable to enter review submit", BrowserAction.screenshot());
	}

	@Override
	public void UpdateQuantity(String upc, String quantity) throws Exception {

		// if(mBagPage.OccurencesOfSameItemInBag("bagSaksBagItemCheck",upc)>1)
		// {
		// Report.dataFail("Same Item is displayed multimple times in the Bag Page",
		// BrowserAction.screenshot());
		// }
		//
		Storage.save("amountBeforeUpdate", Find.Object("amountEstimated").getText().value().substring(1));
		Find.Object("bagUpdateQty_WS").changeContainsText(upc).click();
		Find.Object("bagUpdateQtyDrpdwn").select(quantity);

		StepLogger.validate(Check.ObjectPresent, "bagUpdateQtyApplyBtn");

		Find.Object("bagUpdateQtyApplyBtn").click();
		
		StepLogger.validate(Check.TextPresent, "bagQtyTxt", quantity);
		if(((Double.parseDouble(Storage.get("amountBeforeUpdate")))*Double.parseDouble(quantity)-Double.parseDouble((Find.Object("amountEstimated").getText().value().substring(1)))<0.01)){
			Report.pass("Correct Amount validation after Quantity Updated", BrowserAction.screenshot());
		}
		else
		{
			Report.fail("Failed Amount validation after Quantity Updated", BrowserAction.screenshot());
		}
	}

	@Override
	public void UpdateSizeColor(String upc, String color) throws Exception {
		Find.Object("bagUpdateQty_WS").changeContainsText(upc).click();
		Find.Object("bagUpdateSizeDrpdwn").select(Integer.parseInt(color));
		
		Storage.save("oldcolor", Find.Object("bagColorItem").getText().value());
		StepLogger.validate(Check.ObjectPresent, "bagUpdateQtyApplyBtn");

		Find.Object("bagUpdateQtyApplyBtn").click();
		if(Storage.get("oldcolor").toString().equalsIgnoreCase(Find.Object("bagColorItem").getText().value()))
		{
			//Report.log("Color Change", "Color Update Failed", "FAIL", BrowserAction.screenshot());
			Report.fail("Color Update Failed", BrowserAction.screenshot());
		}
		else
		{
			Report.pass("Color Update Passed", BrowserAction.screenshot());
		}
		
		//StepLogger.validate(Check.TextPresent, "bagColorItem", color);
		
	}
	@Override
	public GiftOverlay MakeGift(String itemId) throws Exception {

		// if(mBagPage.OccurencesOfSameItemInBag("bagSaksBagItemCheck",itemId)>1)
		// {
		// Report.dataFail("Same Item is displayed multimple times in the Bag Page",
		// BrowserAction.screenshot());
		// }

		Find.Object("bagMakeGiftBtn_WS").changeContainsText(itemId).click();

		// Find.Object("bagMakeGiftBtn").click();
		return new mGiftOverlay();
	}

	public static int OccurencesOfSameItemInBag(String objName, String upc)
			throws Exception {

		String bagItems = Find.Object(objName).getText().value();
		String findStr = upc;
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {

			lastIndex = bagItems.indexOf(findStr, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += findStr.length();
			}
		}
		System.out.println(count);
		return count;

	}

	@Override
	public void Remove(String upc) throws Exception {

		// if(mBagPage.OccurencesOfSameItemInBag("bagSaksBagItemCheck",upc)>1)
		// {
		// Report.dataFail("Same Item is displayed multimple times in the Bag Page",
		// BrowserAction.screenshot());
		// }

		Find.Object("removeItem_WS").changeContainsText(upc).click();

		StepLogger.validate(Check.ObjectPresent, "bagRemoveItem");

		Find.Object("bagRemoveItem").click();
		StepLogger.validate(Check.ObjectPresent, "bagRemoveItemConfirm");
		Find.Object("bagRemoveItemConfirm").click();
		Thread.sleep(3000);
		StepLogger.validate(Check.TextNotPresent, "bagSaksBagItemCheck", upc);

	}

	@Override
	public void EnterZipCode(String zipCode) throws Exception {
		StepLogger.validate(Check.ObjectPresent, "bagZipCodeTxt");
		Find.Object("bagZipCodeTxt").clear();
		Find.Object("bagZipCodeTxt").input(zipCode);

	}

	
	@Override
	public void selectShippingMethod(String shipmethod) throws Exception {
		Find.Object("bagShipMethodZipCode").input("10017");
		switch(shipmethod){
		case "Rush": Find.Object("bagShipMethodDrpDwn").select(2); break;
		case "Next Bus. Day": Find.Object("bagShipMethodDrpDwn").select(3); break;
		case "Saturday": Find.Object("bagShipMethodDrpDwn").select(4); break;
		default: Find.Object("bagShipMethodDrpDwn").select(1); //standard
		}
		StepLogger.validate(Check.TextPresent, "bagShipMethodDrpDwn", shipmethod);
		
	}

	
	@Override
	public void ClickPaypal() throws Exception{
		StepLogger.validate(Check.ObjectPresent, "bagPaypalBtn");
		Find.Object("bagPaypalBtn").click();
	}

	@Override
	public void ClickGuestCheckout() throws Exception {

		if (Find.Object("clickGuestCheckout_AAF").isDisplayed()){
			Report.pass("Click Guest UnRegisterCheckout is Found", BrowserAction.screenshot());
		}else{
			Report.fail("Guest UnRegisterCheckout Not Found", BrowserAction.screenshot());
		}
		Find.Object("clickGuestCheckout_AAF").javascriptClick();
		Thread.sleep(2000);

		Find.Object("firstName_AAF").input("QA");
		Find.Object("lastName_AAF").input("Automation");
		Find.Object("address_AAF").input("8793 144th Street, Jamaica");
		Find.Object("city_AAF").input("Jamaica");
		Find.Object("selectState_AAF").select("New York");
		Find.Object("zipCode_AAF").input("11435");
		Find.Object("emial_AAF").input("fmktdu@gmail.com");
		Find.Object("phoneNumber_AAF").input("3477414105");
		Find.Object("clickNextStep_AAF").click();

	}
@Override
	public void ClickProductImage(String item) throws Exception {

	if(Find.Object("bagPageImage_WS").changeContainsText(item).isPresent()){
		Report.pass("Image Thumbnail is displayed for "+item);
		Find.Object("bagPageImage_WS").changeContainsText(item).click();
	}
	else
		Report.fail("Image Thumbnail is NOT displayed for "+item);

}

	@Override
	public void ClickForgetPasswordBagMobile() throws Exception {

		if (Find.Object("clickForgetPassword_AAF").isPresent()){
		Report.pass("User Clicks the Forgot your password", BrowserAction.screenshot());
			Find.Object("clickForgetPassword_AAF").javascriptClick();
		}else{
			Report.fail("User is unable to clicks on Forget Your Password",BrowserAction.screenshot());
		}

	}
}
