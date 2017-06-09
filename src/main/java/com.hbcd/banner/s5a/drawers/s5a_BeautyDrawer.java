package com.hbcd.banner.s5a.drawers;

public class s5a_BeautyDrawer extends s5a_ComDrawer {
	@Override
	public void ClickLinkFromDrawer(String linkText) throws Exception {
		clickFromLinkInsideDrawer("navBeautyDrawer", linkText);
	}
	public void ClickFirstLink() {}
	
}