package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONObject;

public class SaksAlfresco_Parameter {
	static String returnStatus = "Fail";
	static int passcounter = 0;
	static int failcounter = 0;
	static String status = "Fail";
	static String passFailStatus = "Pass";

	public void handle(String data) {

	
		try {


			String rawurl="http://preview-s5a-alfresco-app1.saksdirect.com:8181/alfresco/service/saks/"+data+"?guest=true";


			System.out.println(rawurl);

			if (data.contains("dlpPage")) {
				String jsonResponseText = CallAlfresco_WebService_GetJSONResponse
						.callAlfresco(rawurl);
				JSONObject jsonObject = ConvertJSONResponseToObject
						.toJsonObj(jsonResponseText);
				ValidateJSONforDesignerLandingPage.ValidateDesignerLandingPage(jsonObject);
			} else if (data.contains("sectionPage")) {

				String jsonResponseText = CallAlfresco_WebService_GetJSONResponse
						.callAlfresco1(rawurl);
				JSONObject jsonObject = ConvertJSONResponseToObject
						.toJsonObj(jsonResponseText);
				ValidateJSONforSectionPage.ValidateSectionPage(jsonObject);
						
			} else if (data.contains("paPage")) {
				String jsonResponseText = CallAlfresco_WebService_GetJSONResponse
						.callAlfresco2(rawurl);
				JSONObject jsonObject = ConvertJSONResponseToObject
						.toJsonObj(jsonResponseText);
				ValidateJSONforProductArrayPage.ValidateProductArrayPage(jsonObject);
				
			} else if (data.contains("list")) {
				String jsonResponseText = CallAlfresco_WebService_GetJSONResponse
						.callAlfresco3(rawurl);
				JSONObject jsonObject = ConvertJSONResponseToObject
						.toJsonObj(jsonResponseText);
				ValidateJSONEditorialsPage.ValidateEditorialsPage(jsonObject);
			} else if (data.contains("sbdPage")) {
				String jsonResponseText = CallAlfresco_WebService_GetJSONResponse
						.callAlfresco4(rawurl);

				JSONObject jsonObject = ConvertJSONResponseToObject
						.toJsonObj(jsonResponseText);
				ValidateJSONforShopByDesignerPage.ValidateSBD(jsonObject);
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}


	}

}