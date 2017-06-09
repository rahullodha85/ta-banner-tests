package com.hbcd.testscript.dr.s5a.www;

import com.hbcd.banner.validations.s5a.ValidatePdp;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.logging.log.Log;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Use;
import com.hbcd.utility.entity.ObjectProperties;

public class Scen21 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		nav.SearchFor("0419303587529");
		//ValidatePdp.hasSharingLinks();

		//OLD PDP Main Product Info
//		Find.MultipleObjects("PDP_Main_Product_OLD_ep").selectItemContainText("0419303587529").storeAs("My_PDP_Product");

		//Work with New PDP Main Product Info
		Find.Object("PDP_Main_Product_ep").storeAs("My_PDP_Product");

		//Find Share Container
		Use.CapturedObject("My_PDP_Product").FindObject("PDP_Share_Container_ep").storeAs("My_Share_Info_Container");
		String html = Use.CapturedObject("My_Share_Info_Container").AsIs().getAttribute("innerHTML").value();
		Log.Info(html);


		ObjectProperties email = new ObjectProperties("Email_Share");
		email.setCssSelector("a[class='email-button']");
		Use.CapturedObject("My_Share_Info_Container").FindObject(email).click();

		//Find TAF Container
		Find.Object("TAF_Page_Form_OLD_ep").storeAs("My_TAF_Form");
		html = Use.CapturedObject("My_TAF_Form").AsIs().getAttribute("innerHTML").value();
		Log.Info(html);

		//Validate Form Fields
		ObjectProperties input = new ObjectProperties("inputVal");
		input.setName("TELL_A_FRIEND<>FROM_NAME");
		Use.CapturedObject("My_TAF_Form").FindObject(input).isPresent();
		input.setName("TELL_A_FRIEND<>FROM_EMAIL");
		Use.CapturedObject("My_TAF_Form").FindObject(input).isPresent();

		//Find Product Content
		ObjectProperties table = new ObjectProperties("TableVal");
		table.setCssSelector("table table");
		Use.CapturedObject("My_TAF_Form").FindMultipleObjects(table).selectItemContainText("0419303587529").storeAs("My_Product_Info_Section");
		html = Use.CapturedObject("My_Product_Info_Section").AsIs().getAttribute("innerHTML").value();
		Log.Info(html);

		//Validate Image
		ObjectProperties img = new ObjectProperties("ImageEval");
		img.setTagName("img");
		img.setAttributeKey2("src");
		img.setAttributeValue2("0419303587529");
		Use.CapturedObject("My_Product_Info_Section").FindObject(img).isPresent();


		//Find Product Info Sections and Validate Title/Description/Price
		ObjectProperties infoSec = new ObjectProperties("ProductInfoSection");
		infoSec.setCssSelector("td[class='mainBlackText']");
		String titleText = Use.CapturedObject("My_Product_Info_Section").FindMultipleObjects(infoSec).select(1).getText().value();
		String descriptionText = Use.CapturedObject("My_Product_Info_Section").FindMultipleObjects(infoSec).select(2).getText().value();
		String priceText = Use.CapturedObject("My_Product_Info_Section").FindMultipleObjects(infoSec).select(3).getText().value();
		Log.Info(titleText);
		Log.Info(descriptionText);
		Log.Info(priceText);
		Log.Info("Title Length : " + new Integer(titleText.length()).toString());
		Log.Info("Description Length : " + new Integer(descriptionText.length()).toString());
		Log.Info("Has Dollar Sign : " + new Boolean(priceText.contains("$")).toString());

	}
}
