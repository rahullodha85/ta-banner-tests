package com.hbcd.testscript.mobile.s5a;

import com.hbcd.banner.mobile.saks.validations.ValidatePap;
import com.hbcd.banner.mobile.saks.validations.ValidateShipping;
import com.hbcd.base.ScenarioMobileSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;
import com.hbcd.utility.helper.Common;

public class Scen13 extends ScenarioMobileSaks{

	@Override
    public void executeScript() throws Exception {
		
		 nav.SearchFor(dataObject.getSkuListInfo().get(0));
			pdp.AddToBag(1);
			pdp.EnterBag();
			bag.CheckOut();
			lgn.LoginWith("claudiasosa"+Common.getUniqueNumber()+"@s5a.com");
			shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true,"","");
			ValidateShipping.hasEmailAddressRequiredText();
			ValidateShipping.hasPhoneRequiredText();
			ValidateShipping.InvalidEmailAddressError();
			ValidateShipping.InvalidPhoneError();
			ValidateShipping.hasErrorHighlightedBelow();
			shp.AddShippingAddress(true, "12 E 49th Street", "New York", "New York", "10017", true);
			pap.AddNewCreditCard(3,"tes","test123");
			ValidatePap.InvalidPasswordError();
			

}
}