package com.hbcd.banner.s5a.drawers;

public class s5a_JewelryDrawer extends s5a_ComDrawer {
	@Override
	public void ClickLinkFromDrawer(String linkText) throws Exception {
		clickFromLinkInsideDrawer("navJewelryDrawer", linkText);
	}
	public void ClickFirstLink() {}
}
