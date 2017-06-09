package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.*;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

public class ValidateBag {

	public static void ValidateTotalPrice(String... sku) throws Exception {
		float totalUPrice = 0;
		for (int i = 0; i < sku.length; i++) {

			totalUPrice += ValidateSubTotal(sku[i]);

		}

		String totalPrice = New.Object("")
				.setProperty(PropertyType.ID, "jsVal-itemsTotal").getText()
				.value().replace("$", "");
		float total = Float.parseFloat(totalPrice);

		if (total == (totalUPrice)) {
			Report.pass("Total Price Successfully validated",
					BrowserAction.screenshot());
		}

		// Need a method to report the validation
	}

	public static float ValidateSubTotal(String sku) throws Exception {

		String unitPrice = New
				.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='item jsItemRoot']")
				.setProperty(PropertyType.CONTAINS_TEXT, sku)
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.CSS_SELECTOR,
						"div[class='item-unit-price']").getText().value();

		String qty = New
				.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"div[class='item jsItemRoot']")
				.setProperty(PropertyType.CONTAINS_TEXT, sku)
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.CSS_SELECTOR,
						"div[class='item-quantity']").getText().value()
				.replace("Quantity: ", "");

		float uprice = Float.parseFloat((unitPrice.replace("$", "")));
		int uqty = Integer.parseInt(qty);
		return uprice * uqty;
		// Need a method to report the validation
	}

	public static void ValidateShippingDate(String method) throws Exception {

		String txt = New
				.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"select[id='selectShipMethod']")
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.CSS_SELECTOR,
						"option[selected='selected']").getText().value();

		StepLogger.validate(Check.TextNotPresent, "bagShipDateValidation",
				"N/A");

		if ((txt.contains("N/A") == false)) {
			System.out.println("ShippingMethod Date exists");
		}

	}

	public static void ValidateGiftWrapPrice() throws Exception {

		// String
		// txt=New.Object("bagGiftWrapPrice").setProperty(PropertyType.ID,
		// "jsVal-giftWrapTotal").getText().value();

		StepLogger.validate(Check.ObjectPresent, "bagGiftWrapPrice");

		String txt = Find.Object("bagGiftWrapPrice").getText().value()
				.replace("$", "");

		float giftWrap = Float.parseFloat(txt);

		if (giftWrap > 0) {

			Report.pass("Gift Wrap price is more than 0$");
		}

		// Need a method to report the validation
	}

	public static void isItemPresentInBag(String upc) throws Exception {

		if (Find.Object("bagSaksBagItemCheck").getText().value().contains(upc))
			Report.pass("Item present in the bag", BrowserAction.screenshot());
		else
			Report.fail("Item NOT present in the bag",
					BrowserAction.screenshot());

	}

	public static void isDropship(String upc) throws Exception {
		if (Find.Object("bagItemRoot")
				.changeAttributeContainsValue("data-cartproductcode", upc)
				.getText().value().contains("This item cannot be returned")) {
			Report.pass("Item is a dropship", BrowserAction.screenshot());

		}
	}

	public static void hasBrandName(String brandName) throws Exception {

		if (Find.Object("bagSaksBagItemCheck").getText().value()
				.contains(brandName))
			Report.pass("BrandName validation Pass", BrowserAction.screenshot());
		else
			Report.fail("BrandName validation Fail", BrowserAction.screenshot());

	}


	public static void hasSPD(String spd) throws Exception {

		if (Find.Object("bagSaksBagItemCheck").getText().value().contains(spd))
			Report.pass("SPD validation Pass", BrowserAction.screenshot());
		else
			Report.fail("SPD validation Fail", BrowserAction.screenshot());

	}

	public static void hasQuantity(String upc, String qty) throws Exception {

		if (Find.Object("bagSaksBagItemCheck").changeContainsText(upc).getText().value()
				.contains(qty))
			Report.pass("Quantity validation Pass", BrowserAction.screenshot());
		else
			Report.pass("Quantity validation Fail", BrowserAction.screenshot());
	}

	public static void hasPayPalButton() throws Exception{

		if (Find.Object("bagPaypalBtn").isPresent()){
			Report.pass("PayPal is Present",BrowserAction.screenshot());
		}else{
			Report.fail("PayPal is NOT Present",BrowserAction.screenshot());
		}
		Assert.Report("PayPal Option").isExist("bagPaypalBtn");
	}

	public static void hasMakeThisGift(String upc) throws Exception {

		if (Find.Object("bagQtyTxt").changeContainsText(upc).getText().value()
				.contains("Make this a Gift"))
			Report.pass("Make this a Gift present", BrowserAction.screenshot());
		else
			Report.pass("Make this a Gift NOT present",
					BrowserAction.screenshot());
	}

	public static void hasEditSizeColorQtyLink(String upc) throws Exception {
		if (Find.Object("bagQtyTxt").changeContainsText(upc).getText().value()
				.contains("Edit Size, Color & Quantity"))
			Report.pass("Edit Size, Color & Quantity present",
					BrowserAction.screenshot());
		else
			Report.pass("Edit Size, Color & Quantity NOT present",
					BrowserAction.screenshot());
	}

	public static void ItemNOTPresentInBag(String upc) throws Exception {

		if (Find.Object("bagSaksBagItemCheck").getText().value().contains(upc))
			Report.fail("Item present in the bag", BrowserAction.screenshot());
		else
			Report.pass("Item NOT present in the bag",
					BrowserAction.screenshot());

	}

	public static void hasPreOrderMessage(String upc) throws Exception {
		if (Find.Object("rspItemRow_WS")
				.changeContainsText(upc)
				.getText()
				.value()
				.contains(
						"If you order this item now, you will not be charged until it ships to you. If you wish to change your order once it is placed, please refer to the instructions on your confirmation e-mail."))
			Report.pass("PreOrder Message displayed",
					BrowserAction.screenshot());
		else
			Report.fail("PreOrder message NOT displayed",
					BrowserAction.screenshot());

	}

	public static void hasLatestExpectedShipDate(String upc) throws Exception {
		if (Find.Object("rspItemRow_WS").changeContainsText(upc).getText()
				.value().contains("\nLatest\nExpected\nShip Date"))

			Report.pass("LatestExpectedShipDate displayed",
					BrowserAction.screenshot());
		else
			Report.fail("LatestExpectedShipDate NOT displayed",
					BrowserAction.screenshot());
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
	public static void isOnSaksBagPage() throws Exception{

	}
	public static void areItemsShippable() throws Exception{

	}
	public static void hasCurrency(String currency) throws Exception{

	}

	public static void validateSaksBagItems(String items) throws Exception {

		if (Find.Object("validateSaksBagItems_zk").getText().value()
				.contains(items))
			Report.pass("Saks Bag Item validation Pass", BrowserAction.screenshot());
		else
			Report.fail("Saks Bag Item validation Fail", BrowserAction.screenshot());

	}
public static void ShopRunnerIconInSavedItemsSection(String upc) throws Exception {

	if(Find.Object("bagSavedItemsSRIcon_WS").changeContainsText(upc).isPresent())
		Report.pass("SR icon is displayed in Saved Items for "+upc);
	else
		Report.fail("SR icon is NOT displayed in Saved Items for " + upc);
}

	public static void hasAlsoHaveSavedItemMessage() throws Exception {

		if(Find.Object("bagAlsoHaveSavedItem_WS").isPresent()){
			Report.pass("You Also Have Saved Item message displayed successfully");

			if(Find.Object("bagAlsoHaveSavedItem_WS").getText().value().contains("SAVED ITEM"))
				Report.pass("SAVED ITEM link is displayed successfully");
			else
				Report.fail("SAVED ITEM link NOT displayed");
		}
		else
			Report.fail("You Also Have Saved Item message NOT displayed successfully");
	}

	public static void hasNoContinueShoppingLink() throws Exception {

		if(!Find.Object("body").getText().value().contains("Continue Shopping"))
			Report.pass("Continue Shopping button is Not displayed as expected");
		else
			Report.fail("Continue Shopping button is still displayed");
	}
	public static void hasPromoBanner() throws Exception{
		if (Find.Object("HomePagePromo_WS").isPresent()){
			Report.pass("Promo Banner is Present",BrowserAction.screenshot());
		}else{
			Report.fail("Promo Banner is NOT Present",BrowserAction.screenshot());
		}
	}

	public static void hasShoprunnerBanner() throws  Exception{

		if(Find.Object("bagShopRunnerBanner_WS").isPresent()){
			Report.pass("ShopRunner Banner is displayed");

			if(Find.Object("bagShopRunnerLogo_WS").isPresent()){
				Report.pass("ShopRunner Logo is displayed");
			}
			else
			{
				Report.fail("ShopRunner Logo is NOT displayed");
			}
		}
		else
		{
			Report.fail("ShopRunner Banner is NOT displayed");
		}

	}
	public static void hasImageThumbnail(String item) throws Exception {

		if(Find.Object("bagPageImage_WS").changeContainsText(item).isPresent())
			Report.pass("Image Thumbnail displayed for "+item);
		else
			Report.fail("Image Thumbnail NOT displayed for "+item);
	}

	public static void hasBagDisplayedwithNumbersOfItem(String itemCount) throws Exception {
		if (Find.Object("sakaBagNumberItems_AAF").isPresent()) {
			Report.pass("Saks Bag() link is Displayed ");
			if (Find.Object("sakaBagNumberItems_AAF").getText().value().contains(itemCount))
				Report.pass("Bag Count Validations pass with " + itemCount + " in the Bag Page", BrowserAction.screenshot());
			else
				Report.fail("Bag Count Validations Fail", BrowserAction.screenshot());
		}else{
			Report.fail("Saks Bag() link is NOT displayed");
		}
	}

	public static void hasTextWithNoItemsInBag() throws Exception {
		if (Find.Object("noIteminBag_AAF").isPresent()){
			Report.pass("Saks Bag() contains Zero Item is Displayed");
		if(!Find.Object("noIteminBag_AAF").getText().value().contains("There are no items in your Saks Bag."))
			Report.pass("There are no items in your Saks Bag is displayed", BrowserAction.screenshot());
		else
			Report.fail("There are no items in your Saks Bag is NOT displayed");

	}else{
			Report.fail("Saks Bag() contains Zero Item is NOT Displayed");
		}
	}

	public static void isProductBrandNamePresent() throws Exception{
		if (Find.Object("productBrandNameBag_AAF").isPresent())
			Report.pass("Product brand is present");
		else
			Report.fail("Product brand is NOT present");
	}

	public static void isProductNamePresent() throws Exception{
		if (Find.Object("productNameBag_AAF").isPresent())
			Report.pass("Product name is present");
		else
			Report.fail("Product name is NOT present");
	}

	public static void isProductIdPresent() throws Exception{
		if (Find.Object("productIdBag_AAF").isPresent())
			Report.pass("Product ID is present");
		else
			Report.fail("Product ID is NOT present");
	}

	public static void isColorAndSizePresent() throws Exception{
		if (Find.Object("colorSizeBag_AAF").isPresent())
			Report.pass("Color and Size is Present");
		else{
			Report.fail("Color and Size is NOT Present", BrowserAction.screenshot());
		}
	}

	public static void hasEstimatedTotalOnTopOfPage()throws Exception{
		if (Find.Object("bagTopOrderTotal_WS").isPresent()){
			Report.pass("Estimated Total is Displayed on Top of Page",BrowserAction.screenshot());
		}else{
			Report.fail("Estimated Total is NOT Displayed On Top of Page",BrowserAction.screenshot());
		}
	}

	public static void hasEstimatedBottomOnTopOfPage() throws Exception{
		if (Find.Object("bagBottomOrderTotal_WS").isPresent()){
			Report.pass("Estimated Total is Displayed on the Botton On Top of Page",BrowserAction.screenshot());
		}else{
			Report.fail("Estimated Total is NOT Displayed on the Botton On Top of Page",BrowserAction.screenshot());
		}
	}

	public static Double EstimatedTotal() throws Exception {

		if(Find.Object("bagEstimatedTotal_WS").isPresent()){
			Report.pass("Estimated Total field is displayed");
			String total= Find.Object("bagEstimatedTotal_WS").getText().value().replace("$","");
			total=total.replace(",","");
			Double estimatedTotal=Double.parseDouble(total);
			return estimatedTotal;

		}
		else
		{
			Report.fail("Estimated Total field is NOT displayed");
			return null;
		}
	}

	public static void hasEstimatedTotalChangedAfterRemoveItem(Double totalBefore,Double totalAfter) throws Exception {

		if(totalAfter<totalBefore)
			Report.pass("Estimated total reduced after Item has been removed");
		else if( totalAfter==totalBefore)
			Report.fail("Estimated total has not changed after Item has been removed");
		else
			Report.fail("Estimated total has increased after Item has been removed");
	}

	public static void EstimatedTotalDisplaysWithDollarSign() throws Exception {

		if(Find.Object("bagEstimatedTotal_WS").isPresent())
		{
			Report.pass("Estimated Total field is displayed");
			if(Find.Object("bagEstimatedTotal_WS").getText().value().contains("$"))
				Report.pass("Dollar($) sign is displayed with the Estimated total");
			else
				Report.fail("Dollar($) sign is NOT displayed with the Estimated total");
		}
		else
		{
			Report.fail("Estimated Total field is NOT displayed");
		}
	}

	public static void EstimatedTotalHasCommaAtThousandthDigit() throws Exception {
		if(Find.Object("bagEstimatedTotal_WS").isPresent())
		{
			Report.pass("Estimated Total field is displayed");
			if(Find.Object("bagEstimatedTotal_WS").getText().value().contains(","))
				Report.pass("Comma (,) sign is displayed at the Thousandth digit in the Estimated Total");
			else
				Report.fail("Comma(,) is NOT displayed in the Estimated Total");
		}
		else
		{
			Report.fail("Estimated Total field is NOT displayed");
		}
	}

public static void hasPayPalBannerPresent() throws Exception{
	if (Find.Object("bagPayPalBanner_AAF").isPresent()){
		Report.pass("PayPal Banner displayed in Saks Bag()", BrowserAction.screenshot());
	}else{
		Report.fail("PayPal Banner is NOT displayed", BrowserAction.screenshot());
	}
}

public static void hasTopCheckoutButton(){

	StepLogger.validate(Check.ObjectPresent,"bagCheckOutBtn");
}
	public static void hasBottomCheckoutButton(){

		StepLogger.validate(Check.ObjectPresent,"bagCheckOutBottomBtn_WS");
	}

	public static void hasItemStockMessage(String upc, String message) throws Exception {

			if(Find.Object("bagInStockMessage_WS").changeContainsText(upc).changeChildContainsText(message).isPresent())
				Report.pass(message+ " is displayed for item");
			else
				Report.fail(message + " is NOT displayed for item");


		}

	public static void hasNoShopRunnerEligibleMessage(String upc) throws Exception {

		if(Find.Object("bagShopRunnerEligible_WS").changeContainsText(upc).isPresent())
		Report.pass("Shoprunner Elgibile message is displayed for item");
		else
		Report.fail("Shoprunner Elgibile message NOT displayed for item");
	}

	public static void hasApplyPromoCodeMsg() throws Exception{

		if(Find.Object("bagApplyPromoMessage_WS").isPresent()) {
			Report.pass("Apply Promo line is displayed");
			if (Find.Object("bagApplyPromoMessage_WS").getText().value().contains("You will be able to apply promotional codes and gift cards to your order after you proceed to UnRegisterCheckout.")) {
				Report.pass("You will be able to apply promotional codes and gift cards to your order after you proceed to UnRegisterCheckout.- is displayed successfully");
			} else
				Report.fail("Apply Promo message is displayed incorrectly");
		}
		else
			Report.fail("Apply Promo line is NOT displayed");
		}

	public static void itemNotInBag(String upc) throws Exception {

		if(!Find.Object("bagSaksBagItemCheck").getText().value().contains(upc))
			Report.pass(upc + " NOT in Bag");
		else
			Report.fail(upc + " is displayed in Bag");
	}

	public static void hasNOEstimatedShippingTaxesSection(){

		StepLogger.validate(Check.ObjectNotPresent,"bagEstimatedShippingTaxes_WS");
	}

	public static void hasHeaderOnBagPage() throws Exception{
		StepLogger.validate(Check.ObjectPresent, "headerOnBagPage_AAF");
	}

	public static void hasFooteronBagPage() throws Exception{
		StepLogger.validate(Check.ObjectPresent, "footerOnBagPage_AAF");
	}

	public static void hasNoItemsInSaksBag(String itemQuantity) throws Exception{
		StepLogger.validate(Check.ObjectPresent, "zeroItemInSaksBag_AAF");
		if (Find.Object("zeroItemInSaksBag_AAF").getText().value().contains(itemQuantity)){
			Report.pass("Saks Bag() Contains " + itemQuantity + " items");

		}else{
			Report.fail("Saks Bag() contains " + itemQuantity + "items");
		}
	}

	public static void hasAlertMessageOnBag(String alertMessage) throws Exception{
		Thread.sleep(1500);
		if (Find.Object("alertMessagebagPage_AAF").getText().value().contains(alertMessage)){
			Report.pass("User gets the display of Message: " + alertMessage, BrowserAction.screenshot());
		}else{
			Report.fail("Alert Message is NOT displayed", BrowserAction.screenshot());
		}
	}

	public static void hasForgetYourPasswordDisplayed() throws Exception{
		if (Find.Object("forgetYourPasswordDisplayed_AAF").isPresent()){
			Report.pass("User can see Forgot Your Password?");
		}else{
			Report.fail("Forgot Your Password did NOT display");
		}
	}
}





