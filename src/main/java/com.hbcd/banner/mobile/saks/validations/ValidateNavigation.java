package com.hbcd.banner.mobile.saks.validations;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class ValidateNavigation {

	public static void ValidateBagCounter(String noOfItems) throws Exception {

		if (Find.Object("body").getText().value().contains("BAG")) {

			Report.pass("Bag link is displayed");

			if(Find.Object("homePgSaksBagCounter").getText().value().contains(noOfItems)){

				Report.pass("Bag link contains "+noOfItems+" items");
			}
			else
				Report.fail("Bag link DOESNT contains "+noOfItems+" items");
		}
		else
			Report.fail("Bag link is NOT displayed");
	}

	public static void ValidateStores() throws Exception {
		
		
		Find.Object("storeZiptxtbox").input("10017");
		Find.Object("storeFindStoresBtn").click();
		
		StepLogger.validate(Check.TextPresent, "body", "Stores near 10017");
		if(Find.Object("body").getText().value().contains("Stores near 10017")){
			
			System.out.println("Validate Stores Pass");
		}
			
	}
	public static void ValidateSinglePromo() throws Exception {
		
		StepLogger.validate(Check.ObjectPresent, "HomePagePromo_WS");
		
	}
}
