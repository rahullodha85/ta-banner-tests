package com.hbcd.banner.validations.common;

import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

public class ValidateBagPage {

	/***
	 * Validates if the Sold Out Status is displayed on any item in the Bag
	 * 
	 * @throws Exception
	 */
	public static void soldOutStatus(String objectName) throws Exception {

		if (Find.Object(objectName).isPresent()) {
			if (Find.Object(objectName).getText().value().toLowerCase()
					.contains("sold out")) {

				Report.dataFail("Sold Out", BrowserAction.screenshot());

			}

		}

	}
}
