package com.hbcd.testscript.s5a.aem.author.productpage;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Storage;
import com.hbcd.testscript.s5a.aem.author.SaksObjBean;

public class Scen02 extends ScenarioAEMAuthor {
	@Override
	public void executeScript() throws Exception {

	
	Find.Object("lgn_Userid").input(Storage.get("username"));
	Thread.sleep(3000);
	Find.Object("lgn_Passwd").input(Storage.get("password"));
	Find.Object("lgn_Submit").click();
	Find.Object("cp_clickSites").click();
	Find.Object("cp_clickGeometrixxDemo_1").click();
	Find.Object("cp_navigateToENUS_1").click();
	Find.Object("ep_changeLayout").click();
	Find.Object("ep_selectProductPage_Select2").click();
	Find.Object("ep_openPage").click();
	Thread.sleep(5000);
	Find.Object("ep_validateProductPage").isDisplayed();
	Thread.sleep(5000);

	}
}
