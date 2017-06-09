package com.hbcd.banner.mobile.saks.pages;

import com.hbcd.banner.mobile.saks.enums.SectionLinks;
import com.hbcd.commonbanner.base.pages.SectionPageBase;
import com.hbcd.scripting.core.Find;

public class mSectionPage extends SectionPageBase{

	@Override
	public void ClickDresses() throws Exception{
		clickByText(SectionLinks.DRESSES.toString());
	}
	@Override
	public void ClickDay() throws Exception{
		clickByText(SectionLinks.DAY.toString());
	}
	@Override
	public void ClickShopAll() throws Exception {
		clickByText(SectionLinks.SHOPALL.toString());
		
	}
	private void clickByText(String linkText) throws Exception{
		Find.Object("secClickByTextTemplate_wk")
			.changeChildContainsText(linkText)
			.click();
	}
}
