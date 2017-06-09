package com.hbcd.banner.mobile.saks.overlays;

import com.hbcd.commonbanner.overlays.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class mGiftOverlay implements GiftOverlay{

	@Override
	public void With(String name, String message) {
	}

	@Override
	public void With(String name, String message, String wrap) throws Exception {
		
		StepLogger.validate(Check.ObjectPresent, "goReceipientName");
		
		Find.Object("goReceipientName").input(name);
		Find.Object("goReceipientMessage").input(message);

		switch(wrap.toLowerCase()){
		case "logo":Find.Object("goLogoWrapBtn").click();
			break;
		case "white wrap":
			break;
		case "no wrap":
			break;
		case "gift box":
			break;
		}
		StepLogger.validate(Check.ObjectPresent, "goSubmitBtn");
		Find.Object("goSubmitBtn").click();
		
	}

	@Override
	public void With(String message) throws Exception {

	}

}
