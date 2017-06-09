package com.hbcd.banner.s5a.cc.pages;

import com.hbcd.scripting.core.Alert;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Switch;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;


public class Orders {
	public void clickCancelOrder() throws Exception {
		switchToFrame();
		Find.Object("ccOrderCancelOrderBtn_wk").click();
		Alert.Confirm();
		StepLogger.validate(Check.ObjectPresent, "ccSearchResultsTxt_wk");
		StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk",
				"Cancelled");
		Switch.toDefaultContent();
	}

	public void SearchByEmail(String email) throws Exception {
		switchToFrame();
		Find.Object("ccOrdersEmailTxt_wk").input(email);
		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");
		Find.Object("ccSearchBtn_wk").click();
		if (Find.Object("ccSearchResultsTxt_wk").isPresent()) {
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk",
					"Please enter search criteria");
		}

		Switch.toDefaultContent();
	}

	public void SearchByOrderNumberAndZip(String orderNumber, String zip)
			throws Exception {
		switchToFrame();
		Find.Object("ccOrdersOrderNumTxt_wk").input(orderNumber);
		Find.Object("ccOrdersZipTxt_wk").input(zip);
		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");
		Find.Object("ccSearchBtn_wk").click();
		if (Find.Object("ccSearchResultsTxt_wk").isPresent()) {
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk",
					"Please enter search criteria");
		}

		Switch.toDefaultContent();
	}

	public void SearchByFullname(String firstname, String lastname)
			throws Exception {
		switchToFrame();
		Find.Object("ccOrdersFirstnameTxt_wk").input(firstname);
		Find.Object("ccOrdersLastnameTxt_wk").input(lastname);

		StepLogger.validate(Check.ObjectPresent, "ccSearchBtn_wk");

		Find.Object("ccSearchBtn_wk").click();
		if (Find.Object("ccSearchResultsTxt_wk").isPresent()) {
			StepLogger.validate(Check.TextNotPresent, "ccSearchResultsTxt_wk",
					"Please enter search criteria");
		}
		Switch.toDefaultContent();
	}

	private void switchToFrame() throws Exception {
		if (Find.Object("ccFrameId_wk").isPresent())
			Switch.toFrame("cc_frame_content");
	}

	public void AccessPdp(String sku) throws Exception {
		switchToFrame();
		Find.LinkWithText(false, "", sku).click();
		if (Find.Object("ccFrameId_wk").isPresent()) {
			StepLogger.validate(Check.TextPresent, "ccFrameId_wk",
					"General Information");
		}

		Switch.toDefaultContent();
	}

	public void ClickBook() throws Exception {
		switchToFrame();

		StepLogger.validate(Check.ObjectPresent, "ccorderBookBtn");
		Find.Object("ccorderBookBtn").click();
//		StepLogger.validate(Check.TextPresent, "ccFrameId_wk", "OrderPage History");

		Switch.toDefaultContent();

	}

	public void ClickViewOrderLog() throws Exception {
		switchToFrame();

		StepLogger.validate(Check.ObjectPresent, "ccViewLog");
		Find.Object("ccViewLog").click();
		if (Find.Object("ccFrameId_wk").isPresent())
			StepLogger.validate(Check.TextNotPresent, "ccFrameId_wk",
					"OrderPage Number");
		Switch.toDefaultContent();

	}

	public void ClickEmailHistory() throws Exception {
		switchToFrame();
		StepLogger.validate(Check.ObjectPresent, "ccEmailHistory");
		Find.Object("ccEmailHistory").click();
		Switch.toDefaultContent();

	}

	public void ClickViewEmailHistory() throws Exception {
		switchToFrame();
		Find.Object("ccorderEmailHistoryBtn").click();
		Switch.toDefaultContent();
	}

	public void ClickEditPaymentInformation() throws Exception {
		switchToFrame();
		StepLogger.validate(Check.ObjectPresent, "ccOrderEditPaymentBtn");
		Find.Object("ccOrderEditPaymentBtn").click();
		Switch.toDefaultContent();
	}

	public void AddCreditCard(String cardType) throws Exception {
		switchToFrame();
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"select[id='idSelectItems']")
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.TAG_NAME, "option")
				.setChildProperty(PropertyType.CONTAINS_TEXT, cardType).click();

		StepLogger.validate(Check.ObjectPresent, "ccOrderCCAddBtn");
		Find.Object("ccOrderCCAddBtn").click();
		Find.Object("ccOrderUpdatePaymentBtn").click();
		Switch.toDefaultContent();
	}

	public void EditCreditCard(String cardType, String ccNumber)
			throws Exception {
		switchToFrame();
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR,
						"select[id='idSelectItems']")
				.setProperty(PropertyIntType.IS_PARENT, 1)
				.setChildProperty(PropertyType.TAG_NAME, "option")
				.setChildProperty(PropertyType.CONTAINS_TEXT, cardType).click();
		Find.Object("ccOrderCCEditBtn").click();
		Switch.toNewWindow("Edit Credit Card");
		// Find.Object("ccOrderEditCCName").clear();
		// Find.Object("ccOrderEditCCName").input(nameOnCard);
		Find.Object("ccOrderEditCCNumber").clear();
		Find.Object("ccOrderEditCCNumber").input(ccNumber);
		// Find.Object("ccOrderEditCCYear").select(4);
		Find.Object("ccOrderEditCCSaveBtn").click();
		Switch.toDefaultContent();
	}

	public void RemoveCreditCard() throws Exception {
		switchToFrame();
		StepLogger.validate(Check.ObjectPresent, "ccOrderCCRemovechk");
		Find.Object("ccOrderCCRemovechk").click();
		StepLogger.validate(Check.ObjectPresent, "ccOrderUpdatePaymentBtn");
		Find.Object("ccOrderUpdatePaymentBtn").click();
		Switch.toDefaultContent();
	}

	public void CancelLineItemOrder(String upc) throws Exception {
		switchToFrame();
		Find.Object("ccOrderEditLineItemBtn").click();
		String txt = New.Object("").setProperty(PropertyType.ID, "idRow1")
				.setProperty(PropertyType.CONTAINS_TEXT, upc).getText().value()
				.substring(0, 1);
		int rowNumber = Integer.parseInt(txt);
		System.out.println(rowNumber);
		New.Object("")
				.setProperty(PropertyType.CSS_SELECTOR, "select[name='index2']")
				.setProperty(PropertyIntType.iTH, rowNumber).select(1);
		Find.Object("ccOrderUpdateOrderBtn").click();
		Switch.toDefaultContent();

	}
}
