package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Utility {
public JSONArray returnarrayofValues(JSONObject object,String values){
	JSONArray arrayOfElements = null;
	try{
	 arrayOfElements = object.getJSONArray(values);
}catch(Exception e){
	System.out.println("Exception Occured while pulling array of items"+e.getMessage());
}
	return arrayOfElements;
}


public JSONObject returnValues(JSONObject object,String individualValue){
	JSONObject value = null;
	try{
 value= object.getJSONObject(individualValue);
	}catch(Exception e){
		System.out.println("Exception Occured while pulling individual items"+e.getMessage());
	}
	return value;
}
}