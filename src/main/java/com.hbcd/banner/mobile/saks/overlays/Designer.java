package com.hbcd.banner.mobile.saks.overlays;

import com.hbcd.commonbanner.overlays.*;
import com.hbcd.scripting.core.Find;

public class Designer implements Overlay{
	public void SelectDesigner(String ...designers) throws Exception{
		for(String designer : designers){
			Find.Object("prpoDesignerSelectionBtn_wk").changeChildContainsText(designer);
			Find.Object("prpoDesignerSelectionBtn_wk").click();
		}
	}
}
