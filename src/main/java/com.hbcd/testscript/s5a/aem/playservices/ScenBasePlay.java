package com.hbcd.testscript.s5a.aem.playservices;

/*
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
*/

import com.hbcd.base.ScenarioAEMPlayService;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Service;
import com.hbcd.scripting.exception.ScriptFailException;
import com.hbcd.utility.testscriptdata.ServiceRequestResult;

public class ScenBasePlay extends ScenarioAEMPlayService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ServiceRequestResult r = null;

	@Override
	public void executeScript() throws Exception {
		
		
	//	ServiceRequestResult r = null;
		try {
			r = Service.JSONValidate(data);
			
		}
		catch (ScriptFailException e2) {
			// e2.printStackTrace();
			 Report.log("Script Failed error",
			 "Error while executing Script","Failed to execute Script",
			 "Script Failure", "Fail","NO screenshots");
			// System.out.println("Script FAILED " +
			// e2.getStackTrace().toString());
		}

		catch (Exception e3) {
			// e2.printStackTrace();
			Report.log("Script Failed error", "Error while executing Script",
					"Failed to execute Script", "Script Failure", "Fail",
					"NO screenshots");
			// System.out.println("Script FAILED " +
			// e2.getStackTrace().toString());
		}
		
		
		String status = null;
		
		if (r.isErrorFound())
		{
			status = "fail_error";
			try {
			Report.fail(r.getErrorResponse(),"" /* no screenshot */);
			}
			catch (ScriptFailException e3) {
				// e2.printStackTrace();
				Report.log("Script Failed error", "Error while executing Script",
						"Failed to execute Script", "Script Failure", "Fail",
						"NO screenshots");
				// System.out.println("Script FAILED " +
				// e2.getStackTrace().toString());
			}
		}
		else
		{
			status = r.getStatus() != null? "pass" : "fail";
			Report.pass(r.getStatus(), "" /* no screenshot */);
		//	System.out.println("Messages : " + r.getMessage2() + " - " + r.getResponse());
		}
	}
}
