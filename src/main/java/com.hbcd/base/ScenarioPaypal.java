package com.hbcd.base;

import com.hbcd.banner.common.paypal.pInformationPage;
import com.hbcd.banner.common.paypal.pLogin;
import com.hbcd.banner.common.paypal.pReview;
import com.hbcd.scripting.core.HomePage;
import com.hbcd.utility.testscriptdata.CheckoutDataRow;
import com.hbcd.utility.testscriptdata.JsonParser;

public class ScenarioPaypal extends ScenarioSaks{
		protected pLogin plog;
		protected pInformationPage pinf;
		protected pReview prev;
		
		public ScenarioPaypal(){
		
		
		}

	@Override
	public void ini(long requestId, String... args) throws Exception {
		super.ini(requestId, args);
	}
		
		@Override
		public void beforeExecuteScript() throws Exception
		{
			plog= new pLogin();
			pinf=new pInformationPage();
			prev=new pReview();
			super.beforeExecuteScript(); 
		}
}
