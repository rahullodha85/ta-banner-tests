package com.hbcd.banner.validations.s5a;

import com.hbcd.scripting.core.*;
import com.hbcd.utility.common.Type.PropertyIntType;
import com.hbcd.utility.common.Type.PropertyType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ValidateStoreLocationEvents {

	public static void StoreLocationEventsPage() throws Exception {
		System.out.println(Find.Object("csValidation").getText().value()
				.contains("Search by City & State") ? "Pass" : "Fail");
	}

	public static void ClosestStoreFirst() throws Exception {

		float dis1 = 0, dis2 = 0;
		String d1 = New
				.Object("fistStoreDistance")
				.setProperty(PropertyType.CSS_SELECTOR,
						"span[class='storeDistance colorCode']")
				.setProperty(PropertyIntType.iTH, 1).getText().value();

		if (d1.contains(" miles"))
			dis1 = Float.parseFloat(d1.replace(" miles", ""));
		else if (d1.contains(" mile"))
			dis1 = Float.parseFloat(d1.replace(" mile", ""));

		String d2 = New
				.Object("fistStoreDistance")
				.setProperty(PropertyType.CSS_SELECTOR,
						"span[class='storeDistance colorCode']")
				.setProperty(PropertyIntType.iTH, 2).getText().value();

		if (d2.contains(" miles"))
			dis2 = Float.parseFloat(d2.replace(" miles", ""));
		else if (d2.contains(" mile"))
			dis1 = Float.parseFloat(d1.replace(" mile", ""));
		if(dis1<dis2){
			Report.pass("Stores disaplyed are sorted by distance from location and closest store shown first",
						BrowserAction.screenshot());
		}else{
			Report.fail("Stores displayed are not sorted by distance from location",
						BrowserAction.screenshot());
		}
//		System.out.println(dis1 <= dis2 ? "Pass" : "Fail");

	}

	private static ArrayList<Integer> startDate(String eventDate) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char character = ' ';

		for (int i = 0; i < eventDate.length(); i++) {
			if (eventDate.charAt(i) == character) {
				list.add(i);
			}
		}
		return list;

	}

	public static void ClosestEventFirst() throws Exception {

		/*hard coding the Event month as a work around for DR2016
		as there is no definite date format in the events*/

		String month1=null;String month2=null;
		month1= Find.Object("slupcomingEventMonth1_WS").getText().value();
		month2=Find.Object("slupcomingEventMonth2_WS").getText().value();

		if(month1.equalsIgnoreCase("December")&&month2.equalsIgnoreCase("January"))
			Report.pass("Earliest event first-Earliest date in December and next event in January");
		else
			Report.fail("Earliest event NOT first-Please verify screenshot");
	}

	public static void StoreAddress(String address) throws Exception {

		Switch.toNewWindow("Store Locations & Events");
		System.out.println(Find.Object("pdpRedesignContainer").getText()
				.value().contains(address) ? "Pass" : "Fail");
	}
}
