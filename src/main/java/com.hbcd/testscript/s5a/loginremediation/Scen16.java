package com.hbcd.testscript.s5a.loginremediation;

import com.hbcd.banner.validations.s5a.ValidateQL;
import com.hbcd.base.ScenarioSaks;
import com.hbcd.commonbanner.base.pages.SearchFunction;

public class Scen16 extends ScenarioSaks {

	@Override
	public void executeScript() throws Exception {
		yap.GoToMyAcccount();
		yap.Login("saksqa147@saks.com", "test123");
		yap.Signout();
		nav.SearchFor("0476703126079 ");
		//Quick look not opening; since the qa server is down
		ValidateQL.ProductReviews("ReviewLanding.jsp");
	
	}

}
