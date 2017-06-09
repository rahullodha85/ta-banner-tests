package com.hbcd.base;

import com.hbcd.banner.commomplatform.fullsite.overlays.*;
import com.hbcd.banner.commomplatform.fullsite.pages.*;
import com.hbcd.banner.factory.Factory;
import com.hbcd.banner.s5a.overlays.s5a_FindInStore;
import com.hbcd.banner.s5a.overlays.s5a_LoginOverlay;
import com.hbcd.banner.s5a.overlays.s5a_QuickLookOverlay;
import com.hbcd.banner.s5a.overlays.s5a_ShopRunner;
import com.hbcd.banner.s5a.pages.aemPdp.AemProductDetailPage;
import com.hbcd.banner.s5a.pages.*;
import com.hbcd.banner.validations.s5a.*;
import com.hbcd.banner.webservice.fedex.fedexAddressApiClient;
import com.hbcd.commonbanner.base.pages.*;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.enums.ToggleType;
import com.hbcd.commonbanner.pages.ConfirmationPage;
import com.hbcd.scripting.core.ScriptData;

public class ScenarioSaks extends ScenarioCommonPlatform {

	public void beforeExecuteScript() throws Exception {
		super.beforeExecuteScript();
	}
}
