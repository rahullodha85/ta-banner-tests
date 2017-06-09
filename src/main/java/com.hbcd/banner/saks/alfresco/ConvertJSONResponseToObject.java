package com.hbcd.banner.saks.alfresco;


import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

public class ConvertJSONResponseToObject {
	
	public static JSONObject toJsonObj(String jsonString)
	{
		JSONObject jsonObj = null;
		
		if (StringUtils.isNotBlank(jsonString))
		{
			try
			{
				jsonObj = JSONObject.fromObject(jsonString);
			}
			catch(Exception ex)
			{
				System.out.println("Exception converting response to JSONObject " + ex.getMessage());
			}
		}
		
		return jsonObj; 
	}

}
