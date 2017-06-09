package com.hbcd.testscript.commonplatform.checkout.reg;

import com.hbcd.banner.validations.s5a.ValidateYourAcc;
import com.hbcd.base.ScenarioCommonPlatform;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen61 extends ScenarioCommonPlatform {

	@Override
	public void executeScript() throws Exception {

		nav.SearchFor("0476703126079");
		pdp.AddToBag(1);
		nav.SearchFor("0448882328957");
		pdp.AddToBag(1);
		nav.SearchFor("0450508446921");
		pdp.AddToBag(1);
		nav.SearchFor("0433732393872");
		pdp.AddToBag(1);
		nav.SearchFor("0436054165936");
		pdp.AddToBag(1);
		nav.SearchFor("0439052815025");
		pdp.AddToBag(1);
		nav.SearchFor("0456227012096");
		pdp.AddToBag(1);
		nav.SearchFor("0452491067015");
		pdp.AddToBag(1);
		nav.SearchFor("0459930992242");
		pdp.AddToBag(1);
		nav.SearchFor("0437621839496");
		pdp.AddToBag(1);
		nav.SearchFor("0451148786637");
		pdp.AddToBag(1);
		nav.SearchFor("0417563244039");
		pdp.AddToBag(1);
		nav.SearchFor("0417556332323");
		pdp.AddToBag(1);
		nav.SearchFor("0414633116784");
		pdp.AddToBag(1);
		nav.SearchFor("0437895421724");
		pdp.AddToBag(1);
		nav.SearchFor("0437895421724");
		pdp.AddToBag(1);
		nav.SearchFor("0437895421090");
		pdp.AddToBag(1);
		nav.SearchFor("0437816632949");
		pdp.AddToBag(1);
		nav.SearchFor("0477235842567");
		pdp.AddToBag(1);
		nav.SearchFor("0420036548602");
		pdp.AddToBag(1);
		nav.SearchFor("0420006532440");
		pdp.AddToBag(1);
		nav.SearchFor("0431625827442");
		pdp.AddToBag(1);
		nav.SearchFor("0403527080782");
		pdp.AddToBag(1);
		nav.SearchFor("0440927824684");
		pdp.AddToBag(1);
//		nav.SearchFor("0432632066800");
//		pdp.AddToBag(1);
//		nav.SearchFor("0433535487532");
//		pdp.AddToBag(1);
//		nav.SearchFor("0436220522013");
//		pdp.AddToBag(1);
//		nav.SearchFor("0441521326468");
//		pdp.AddToBag(1);
//		nav.SearchFor("0475725518596");
//		pdp.AddToBag(1);
//		nav.SearchFor("0455212637443");
//		pdp.AddToBag(1);
//		nav.SearchFor("0409210492245");
//		pdp.AddToBag(1);
//		nav.SearchFor("0402529469892");
//		pdp.AddToBag(1);
//		nav.SearchFor("0423817632309");
//		pdp.AddToBag(1);
//		nav.SearchFor("0442714346331");
//		pdp.AddToBag(1);
//		nav.SearchFor("0418623881911");
//		pdp.AddToBag(1);
//		nav.SearchFor("0440533269831");
//		pdp.AddToBag(1);
//		nav.SearchFor("0464821824779");
//		pdp.AddToBag(1);
//		nav.SearchFor("0476532420126");
//		pdp.AddToBag(1);
//		nav.SearchFor("0417804676902");
//		pdp.AddToBag(1);
//		nav.SearchFor("0434009382124");
//		pdp.AddToBag(1);
//		nav.SearchFor("0435125233277");
//		pdp.AddToBag(1);
//		nav.SearchFor("0413046629461");
//		pdp.AddToBag(1);
//		nav.SearchFor("0407619329865");
//		pdp.AddToBag(1);
//		nav.SearchFor("0413224278375");
//		pdp.AddToBag(1);
//		nav.SearchFor("0475305557151");
//		pdp.AddToBag(1);
//		nav.SearchFor("0428822853428");
//		pdp.AddToBag(1);
//		nav.SearchFor("0438691291788");
//		pdp.AddToBag(1);
//		nav.SearchFor("0401400545410");
//		pdp.AddToBag(1);
//		nav.SearchFor("0418700988717");
//		pdp.AddToBag(1);
//		nav.SearchFor("0413406363684");
//		pdp.AddToBag(1);
//		nav.SearchFor("0440431838863");
//		pdp.AddToBag(1);
//		nav.SearchFor("0440906428841");
//		pdp.AddToBag(1);
		
		miniBagOverlay.clickCheckout();
		bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
		
		rsp.EditCreditCard("Hello World", "Discover", "6011000990911111");
		rsp.ClickContinueCheckOut();
		rsp.ClickPlaceOrder();
		yap.Login("checkoutscen02@saks.com", "test123");
		yap.ClickPaymentInformation();
//		yap.VerifyCreditCard("6011000990911111");
		ValidateYourAcc.ValidateCC("6011000990911111");
		yap.RemoveCreditCard();
		
		
	}
	

}
