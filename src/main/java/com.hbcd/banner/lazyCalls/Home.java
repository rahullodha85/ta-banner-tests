package com.hbcd.banner.lazyCalls;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;

public class Home {
	public static void closeOverlay() throws Exception{
		if(Find.Object("homeOverlayScape_wk").isPresent())
			Find.Object("homeOverlayScape_wk").click();
	}
}
