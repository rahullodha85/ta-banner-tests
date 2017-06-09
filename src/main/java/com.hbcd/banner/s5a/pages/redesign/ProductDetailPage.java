package com.hbcd.banner.s5a.pages.redesign;

import com.hbcd.banner.s5a.pages.s5a_ProductDetailPage;
import com.hbcd.banner.validations.common.ValidateBagPage;
import com.hbcd.commonbanner.pages.PdpPage;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductDetailPage extends s5a_ProductDetailPage
		implements PdpPage {

	public void AddToBag(String sizeOption, String swatchOption, int quantity)
			throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName());
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
				.contains("Virtual Gift Card") ? true : false;
		if (!isVegc) {
			selectSwatch(swatchOption);
			selectDropdownOption(sizeOption);
			selectSizeSwatch(sizeOption);
			updateQty(quantity);
			clickAddToBagButton();
		} else
			addVegc();
		StepLogger.validate(Check.ObjectPresent, "bOverlay");
	}

	public void AddToBag(int quantity) throws Exception {

//		No results found check
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
			selectFirstSwatch();
			selectFirstSizeSwatch();
			selectFirstDropdownItem();
			updateQty(quantity);
			clickAddToBagButton();
		} else
			addVegc();

//		StepLogger.validate(Check.ObjectPresent, "bOverlay");

	}

	@Override
	public void AddToBag(String swatchOption, int quantity) throws Exception {

		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName());
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
				.contains("Virtual Gift Card") ? true : false;
		if (!isVegc) {
			selectSwatch(swatchOption);
			selectFirstDropdownItem();
			selectFirstSwatch();
			updateQty(quantity);
			clickAddToBagButton();
		} else
			addVegc();
		StepLogger.validate(Check.ObjectPresent, "bOverlay");
	}

	@Override
	public void AddToBag(String sizeOption) throws Exception {

		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName());
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		boolean isVegc = Find.Object("pdpVegcValidation").getText().value()
				.contains("Standard Gift Card") ? true : false;
		if(isVegc) {
			Find.Object("giftcardDropDown_RL").click();
			Find.Object("giftcardValueSelect_RL").changeChildContainsText(sizeOption).click();
		}else{
			selectFirstSwatch();
			selectSizeSwatch(sizeOption);
		}
		clickAddToBagButton();
		StepLogger.validate(Check.ObjectPresent, "bOverlay");
	}

	@Override
	public void EnterBag() throws Exception {
		/*
		 * if(!Find.Object("bOverlayViewBagBtn").isPresentDisplayedEnabled())
		 * Find.Object("pdpBagLink").click();
		 * StepLogger.validate(Check.ObjectPresent, "bOverlayViewBagBtn");
		 */
		// if (!Find.Object("bOverlayViewBagBtn1").isDisplayed()) //check first
		// time (may be slow to display)
		Thread.sleep(4000);
		if (Find.Object("bOverlay").getAttribute("style").value()
				.contains("display: none")) {
			Thread.sleep(1000);
			// if (!Find.Object("bOverlayViewBagBtn1").isDisplayed()) //check
			// again
			if (Find.Object("bOverlay").getAttribute("style").value()
					.contains("display: none")) {
				Find.Object("pdpBagLink").click();
				Thread.sleep(1000);
			}
		}
		StepLogger.validate(Check.ObjectPresent, "bOverlayViewBagBtn1");
		Find.Object("bOverlayViewBagBtn1").click();
		StepLogger.validate(Check.ObjectPresent, "bagTitle");

		ValidateBagPage.soldOutStatus("bagItemsTable_WS");

	}

	private void addVegc() throws Exception {
		Find.Object("pdpRedesignVEGCChooseDeno").click();
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"a[class='item sku available first']")
				.setProperty(PropertyIntType.iTH, 1).click();
		Find.Object("pdpRedesignAddToBagBtn").click();

		Find.Object("pdpVgcRecip").input("Leroy Jenkins");
		Find.Object("pdpVgcSender").input("LEEEEEEEEEROY Jenkins");
		Find.Object("pdpVgcNotifyEmail").input("hello@hello.com");
		Find.Object("pdpVgcConfirmEmail").input("hello@hello.com");
		setDate();
		StepLogger.validate(Check.ObjectPresent, "pdpVegcAddToBag");
		Find.Object("pdpVegcAddToBag").click();
//		StepLogger.validate(Check.ObjectPresent, "bOverlay");
	}

	private void setDate() throws Exception {
		Find.Object("pdpVgcDeliverDate").clear();
//		Calendar c = new GregorianCalendar();
//		c.add(Calendar.MONTH, 2);
//
//		int month = c.get(Calendar.MONTH);
//		int day=c.get(Calendar.DAY_OF_MONTH);
//		if(month==2)
//		day=20;
//		String date = checkDigits(month) + "/"
//				+ checkDigits(day) + "/"
//				+ c.get(Calendar.YEAR);

		DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 140);

		String date = dateFormat.format(c.getTime());
		System.out.println(date);
		Find.Object("pdpVgcDeliverDate").input(date);
	}

	private String checkDigits(int input) {
		if (input < 10)
			return "0" + input;
		else if (input > 30) {
			input--;
			return "" + input;
		} else
			return "" + input;
	}

	@Override
	public void PersonalizeAddToBag(int size, String text) throws Exception {
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		selectFirstSwatch();
		selectFirstDropdownItem();
		selectFirstSizeSwatch();
		Find.Object("pdpPersonalizeAddtoBagBtn").click();
		Find.Object("pdpPersonalizeTextBox").input(text);
		if (Find.Object("pdpPersonalizeAddtoBagBtn2").isEnabled()) {
			Find.Object("pdpPersonalizeAddtoBagBtn2").click();
		}
	}

	@Override
	public void PersonalizeAddToBag(int size, int quantity) throws Exception {
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		if (size != -1)
			selectSize(size);
		PersonalizeAddToBag(quantity);
		/*
		 * Find.Object("pdpRedesignQty").clear();
		 * Find.Object("pdpRedesignQty").input(new
		 * Integer(quantity).toString());
		 * Find.Object("pdpPersonalizeAddtoBagBtn").click();
		 */
		Find.Object("pdpPersonalizeTextBox").input("Hello World");
		StepLogger.validate(Check.ObjectPresent, "pdpPersonalizeAddtoBagBtn2");
		Find.Object("pdpPersonalizeAddtoBagBtn2").click();
	}

	@Override
	public void PersonalizeAddToBag(int quantity) throws Exception {
		if (Find.Object("pdpSoldOutMsg_WS").isPresent()) {

			Report.dataFail("Sold Out", BrowserAction.screenshot());
		}
		Find.Object("pdpRedesignQty").clear();
		Find.Object("pdpRedesignQty").input(new Integer(quantity).toString());
		StepLogger.validate(Check.ObjectPresent, "pdpPersonalizeAddtoBagBtn");
		Find.Object("pdpPersonalizeAddtoBagBtn").click();
	}

	private static void clickAddToBagButton() throws Exception {
		Find.Object("qlAddToBagBtn_wk").click().getPerformance("Add to Bag", "PDP");
	}

	private static void selectSize(int optionIndex) throws Exception {
		Find.Object("pdpRedesignPreOrderSize").click();
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR, "a[class='item size ']")
				.setProperty(PropertyIntType.iTH, optionIndex).click();
	}

	private void selectFirstSizeSwatch() throws Exception {
		if (Find.Object("pdpFirstSizeSwatch_wk").isPresent())
			Find.Object("pdpFirstSizeSwatch_wk").click();
		else if(Find.Object("pdpFirstSizeSwatchForPreOrder_RL").isPresent()){
			Find.Object("pdpFirstSizeSwatchForPreOrder_RL").click();
		}
	}

	private static void selectFirstDropdownItem() throws Exception {
		if (Find.Object("pdpRedesignPreOrderSize").isPresent()) {
			Find.Object("pdpRedesignPreOrderSize").click();
			Find.Object("pdpDropdownFirstSelection").click();

		}
	}

	private static void selectFirstSwatch() throws Exception {
		boolean colorSelected = false;
		if (!colorSelected
				&& Find.Object("pdpSwatchFirstSelection").isPresent()) {
			Find.Object("pdpSwatchFirstSelection").click();
			colorSelected = true;
		}
		if (!colorSelected
				&& Find.Object("pdpRedesignColorSection").isPresent()) {
			Find.Object("pdpSwatchFirstAvailableSelection").click();
			colorSelected = true;
		}
	}

	private static void updateQty(int qty) throws Exception {
		Find.Object("pdpRedesignQty").doubleClick();
		Find.Object("pdpRedesignQty").clear();
		Find.Object("pdpRedesignQty").input(new Integer(qty).toString());
	}

	public static void selectSwatch(String swatchOption) throws Exception {
		boolean swatchSelected = false;
		if (!swatchSelected
				&& Find.Object("pdpSwatchFirstSelection").isPresent()) {
			Find.Object("pdpColorSelection")
					.changeChildAttributeContainsValue("title", swatchOption)
					.click();
			swatchSelected = true;
		}
		if (!swatchSelected
				&& Find.Object("pdpSwatchFirstAvailableSelection").isPresent()) {
			Find.Object("pdpColorSelection")
					.changeChildContainsText(swatchOption).click();
			swatchSelected = true;
		}
		if (!swatchSelected
				&& Find.Object("pdpColorSwatch2Check_wk").isPresent()) {
			Find.Object("pdpColorSwatch2_wk")
					.changeChildAttributeContainsValue("title", swatchOption)
					.click();
			swatchSelected = true;
		}
	}

	private static void selectDropdownOption(String option) throws Exception {
		if (Find.Object("pdpRedesignPreOrderSize").isPresent()) {
			Find.Object("pdpRedesignPreOrderSize").click();
			Find.Object("pdpOptionsSelection").changeChildContainsText(option)
					.click();
		}
	}

	public void selectSizeSwatch(String size) throws Exception {
		if (Find.Object("pdpSizeSwatchLink")
				.changeChildAttributeContainsValue("data-value", size)
				.isPresent())
			Find.Object("pdpSizeSwatchLink")
					.changeChildAttributeContainsValue("data-value", size)
					.click();
		else Report.fail("Swatch not found", BrowserAction.screenshot());
	}

	public void AddToBag() throws Exception {
		Find.Object("qlAddToBagBtn_wk").click();
		Thread.sleep(3000);
	}

	@Override
	public void ClickShoprunnerSignoutFromPdp() throws Exception {
		if (Find.Object("shoprunnerSignoutPdp_AAF").isDisplayed()){
			Report.pass("Object found");
			}else{
			Report.fail("Object not present");
		}
		Find.Object("shoprunnerSignoutPdp_AAF").javascriptClick();
		Thread.sleep(2000);
		}

	@Override
	public void ClickShoprunnerLearnMore() throws Exception {

		if (Find.Object("learnMoreShoprunner_AAF").isDisplayed()){
			Report.pass("Object Found");
		}else{
			Report.fail("Object is not present");
		}
		Find.Object("learnMoreShoprunner_AAF").javascriptClick();
		Thread.sleep(3000);
	}

}
