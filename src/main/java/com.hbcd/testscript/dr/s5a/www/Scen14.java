package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.scripting.enums.impl.ItemType;
import org.apache.jackrabbit.core.ItemData;

public class Scen14 extends ScenarioSaks{

    /**
     * 1.Click the search icon from the Top Navigation
     Review stars and ratings and teaser link on PDP
     Q&A teasers on PDP
     Q&A and Reviews on PDP in Tabs
     Authenticated customers to write reviews on PDP
     Reviews and Q&A Emails (Root Seach)
     */

	@Override
	public void executeScript() throws Exception {
        nav.SearchFor(itemData.get(ItemType.REGULAR));
		ValidatePdp.hasAskAQuestionLink();
		ValidatePdp.hasQnASection();
        ValidatePdp.hasReadReviewsTeaserLink();
        ValidatePdp.hasWriteReviewsTeaserLink();
        ValidatePdp.displaysFormForReviewLink();
	}
}
