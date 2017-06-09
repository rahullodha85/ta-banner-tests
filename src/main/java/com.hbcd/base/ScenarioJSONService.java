package com.hbcd.base;

import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.exception.ScriptFailException;
import com.hbcd.utility.testscriptdata.JSONValidation;
import com.hbcd.utility.testscriptdata.JsonParser;

public class ScenarioJSONService  extends ScenarioBase {
	
	protected JSONValidation data;
	
	@Override
	public void ini(long requestId, String... args) throws Exception {
		if ((args.length > 0) && (args[0] != null) && (args[0].length() > 0))
		{
			try {
			data = (JSONValidation) JsonParser.parseJson("com.hbcd.utility.testscriptdata.JSONValidation", args[0]);
			}
			catch (Exception e3) {
				// e2.printStackTrace();
				Report.log("Script Failed error", "Error while executing Script",
						"Failed to execute Script", "Script Failure", "Fail",
						"NO screenshots");
				// System.out.println("Script FAILED " +
				// e2.getStackTrace().toString());
			}

		}
	}
	
	@Override
	public void beforeExecuteScript() throws Exception
	{
		//Intentionally Leave Empty  (since this is the service call, we don't want to call GO HOME default URL of Homepage)		
	}
}
