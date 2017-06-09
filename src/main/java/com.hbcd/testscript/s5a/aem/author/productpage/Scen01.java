package com.hbcd.testscript.s5a.aem.author.productpage;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.testscript.s5a.aem.author.SaksObjBean;

public class Scen01 extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {

		SaksObjBean sOB = new SaksObjBean();
		sOB.setEnv(Storage.get("environment"));

		Find.Object("lgn_Userid").input(Storage.get("username"));
		Find.Object("lgn_Passwd").input(Storage.get("password"));
		Find.Object("lgn_Submit").click();

		Find.Object("cp_clickSites").click();

		System.out.println("Environment = " + sOB.getEnv());

		if (sOB.getEnv().equals("local")) {
			Find.Object("cp_clickGeometrixxDemo").click();
		} else {
			Find.Object("cp_clickGeometrixxDemo_1").click();
		}

	    Find.Object("cp_navigateToENUS_1").click();
		Find.Object("cp_createNewPage").click();
		Find.Object("cp_selectCreatePage").click();
		Find.Object("cp_selectProductTemplate").click();

		Find.Object("cp_clickNext").click();

		String val = Storage.get("Test_Page_Name");
		System.out.println("got the value of Test Page Name : " + val);
		val = val + "_product";
		
		Find.Object("cp_enterTitle").input(val);
		Find.Object("cp_clickCreate").click();
		Find.Object("cp_clickDone").click();

	}
}
