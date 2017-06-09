package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen18 extends ScenarioSaks{
/*
"
1. Click on Saks Bag link from the top navigation
2. Click 'Checkout' button
3. Click on 'Edit' link
4. Verify Product Information on the Quick Look overlay

"	"1. Saks Bag overly opens
2. Saks Bag page is displayed
3. Quick Look overlay opens
4. The following product information are dispalyed:
   - Brand
   - Short Description
* The following fields are also displayed
   - Qty
   - Product Review
   - Images and Vidoes
   - Full Product Details link
   - Fit Predictor link conditions as follows:
              - If user has NO transaction history for the category, this link will be displayed ""
""Fit Predictor calculate your size""
              - If user has transaction history for the category, this will be displayed ""
"" Your Best Size: ""
              - If item is not eligible for prediction, no link will be displayed
Shop Runner
- If the product is not a Drop-Ship, CSR, or Virtual Gift Card item, Shop Runner icon will be displayed
"

 */
	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0400088664660");
		pdp.AddToBag();
		pdp.EnterBag();
		bag.ClickEditFor("0400088664660");
		ValidateQL.hasBrandName("hook + ALBERT");
		ValidateQL.hasShortDescription("Black & Gold Stripe Cork Lapel Pin");
		ValidateQL.hasQuantityBox();
		ValidateQL.hasProductDetailsLink();

	}
}
