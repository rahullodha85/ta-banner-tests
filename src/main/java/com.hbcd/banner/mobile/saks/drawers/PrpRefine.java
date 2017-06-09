package com.hbcd.banner.mobile.saks.drawers;

import com.hbcd.banner.mobile.saks.overlays.Designer;
import com.hbcd.commonbanner.drawer.DrawerRefine;
import com.hbcd.commonbanner.overlays.Overlay;
import com.hbcd.scripting.core.Find;


public class PrpRefine implements DrawerRefine {
	public Overlay ClickDesigner() throws Exception{
		Find.Object("prpDdDesignerBtn_wk").click();
		return new Designer();
	}

}
