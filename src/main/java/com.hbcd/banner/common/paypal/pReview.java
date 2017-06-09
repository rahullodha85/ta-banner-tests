package com.hbcd.banner.common.paypal;

import com.hbcd.scripting.core.New;
import com.hbcd.scripting.core.Switch;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

public class pReview {

	public void ClickSubmitOrder() throws Exception {

		Switch.toFrame("envoyId");
		
		New.Object("").setProperty(PropertyType.CSS_SELECTOR, "section[id='order-submit']")
						.setProperty(PropertyIntType.IS_PARENT, 1)
						.setChildProperty(PropertyType.TAG_NAME, "button")
						.setChildProperty(PropertyType.CONTAINS_TEXT, "Submit OrderPage")
						.click();
		Switch.toDefaultContent();
	}
}
