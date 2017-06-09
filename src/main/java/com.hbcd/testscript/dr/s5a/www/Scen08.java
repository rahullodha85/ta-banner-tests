package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.enums.TopNavLinks;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.entity.ObjectProperties;

public class Scen08 extends ScenarioSaks{

	@Override
	public void executeScript() throws Exception {
		nav.ClickNavigationLinks(TopNavLinks.WOMENSAPPAREL);
		nav.ClickLeftNavLink("Sweaters");
//		Find.LinkWithText(false, "", "Sweaters").isPresent();
//		Find.MultipleObjects("Left_Link_Container").selectItemContainText("SaksFirst Membership").storeAs("SaksFirstMembershipContainer");
//		ObjectProperties link = new ObjectProperties("abc");
//		link.setLinkText("Benefit");
//		Use.CapturedObject("SaksFirstMembershipContainer").FindObject(link);
//		have to validate display blocks

		String html = Find.Object("prp_PA_Container_ep").hasChildObjects("prp_PA_Image_ep").select(1).getAttribute("innerHTML").value();
		//Save Image Container in PA Page
		//Save First Product Image
//		int imageTotal = Use.CapturedObject("My_PA_Container").FindMultipleObjects("prp_PA_Image_ep").size();
//		Use.CapturedObject("My_PA_Container").FindMultipleObjects("prp_PA_Image_ep").select(1).storeAs("My_First_PA_Product_Image_Container");
//
//		String html = Use.CapturedObject("My_First_PA_Product_Image_Container").AsIs().getAttribute("innerHTML").value();
		Log.Info(html);
		ObjectProperties img = new ObjectProperties("img");
		img.setTagName("img");
		int totalImages = Find.Object("prp_PA_Container_ep").hasChildObjects("prp_PA_Image_ep").select(1).hasChildObjects(img).size();
//		int totalImages = Use.CapturedObject("My_First_PA_Product_Image_Container").FindMultipleObjects(img).size();
		if (totalImages >= 1)
		{
			Report.pass("At least one (" + totalImages + ") image founds in First Product in PA.");
		}
		else
		{
			Report.fail("Unable to find image in First Product in PA.");
		}

	}
}
