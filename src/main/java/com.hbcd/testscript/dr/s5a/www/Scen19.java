package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen19 extends ScenarioSaks{

	/*
	"1. From top navigation, enter Product Code for an item that has reviews/Q&A and press <ENTER>
2. Verify Product Information on the Product Detail page
3. Click on read reviews link in the teaser
4. Click on the Q&A links in the teaser
5. Click on ""Write a Review"" link in the teaser
6. Login into Shop Runner using a Test Account.

"	"1. Product Detail page opens
2. The following product information are dispalyed:
   - Brand
   - Short Description
   - Product Description
* The following fields are also displayed
   - Qty and Add to Bag button are visible
   - Product Review
   - Images and Vidoes
   - Product Recommend
   - Recently Viewed Items
   - Q&A Teaser and widget
   - Reviews  Teaser and widget
   - Fit Predictor link conditions as follows:
              - If user has NO transaction history for the category, this link will be displayed ""
""Fit Predictor calculate your size""
              - If user has transaction history for the category, this will be displayed ""
"" Your Best Size: ""
              - If item is not eligible for prediction, no link will be displayed
Shop Runner
- If item is eligible, Shop Runner banner copy and links will display

3. User should be brought down to the Reviews widget and can read all reviews
4. User should be brought down to the Q&A widget and can view all Q&A
5. Write a Review form overlay should display
6. User should successfully be able to login on any eligible item PDP
"
	 */

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0400088664660");
		ValidatePdp.hasBrandName("hook + ALBERT");
		ValidatePdp.hasShortDescription("Black & Gold Stripe Cork Lapel Pin");
		ValidatePdp.hasProductDescription("Unique cork lapel pin with bright gold stripes");
		ValidatePdp.hasQuantityBox();
		ValidatePdp.hasAddToBagButton();
		pdp.ClickReviews();
		ValidatePdp.hasReviewsSection();
		ValidatePdp.hasRecentlyViewedSection();

		pdp.ClickSeeAllQnA();
		ValidatePdp.hasQnASection();



	}
}
