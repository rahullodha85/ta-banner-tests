package com.hbcd.base;

import com.hbcd.utility.testscriptdata.JSONValidation;
import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Find;
import com.hbcd.utility.testscriptdata.JsonParser;


public class ScenarioAEMPlayService extends ScenarioBase {

	protected JSONValidation data;
	protected String argData;
	
	public void ini(long requestId, String... args) throws Exception {
		if ((args.length > 0) && (args[0] != null) && (args[0].length() > 0))
		{
			argData = args[0].toString();
		} 
	}

	
	public void beforeExecuteScript() throws Exception
	{
		//Intentionally Leave Empty  (since this is the service call, we don't want to call GO HOME default URL of Homepage)		
	}

}
