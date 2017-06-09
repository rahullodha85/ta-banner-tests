package com.hbcd.banner.saks.alfresco;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class CallAlfresco_WebService_GetJSONResponse {
	
 static String output;
 static String output1;
 static String output2;
 static String output3;
 static String output4;
 static String outputResult="";
 static String outputResult1="";
 static String outputResult2="";
 static String outputResult3="";
 static String outputResult4="";

	public static String callAlfresco(String url){
		
		try{
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

				BufferedReader br = new BufferedReader(
                     new InputStreamReader((response.getEntity().getContent())));


				//System.out.println("Output from Web Service ................................. \n");
				//System.out.println(".......................................................... \n");
				while ((output = br.readLine()) != null) {
			//	System.out.println(output);
					
					outputResult=outputResult+output;
				}

				httpClient.getConnectionManager().shutdown();
				br.close();

		} catch (ClientProtocolException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		return outputResult;
}
	

	
	
public static String callAlfresco1(String url){
		
		try{
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

				BufferedReader br = new BufferedReader(
                     new InputStreamReader((response.getEntity().getContent())));


				//System.out.println("Output from Web Service ................................. \n");
				//System.out.println(".......................................................... \n");
				while ((output1 = br.readLine()) != null) {
			//	System.out.println(output);
					
					outputResult1=outputResult1+output1;
				}

				httpClient.getConnectionManager().shutdown();
				br.close();

		} catch (ClientProtocolException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		return outputResult1;
}
	
	
	


public static String callAlfresco2(String url){
	
	try{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		
		if (response.getStatusLine().getStatusCode() != 200) {
			System.out.println(response);
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

			BufferedReader br = new BufferedReader(
                 new InputStreamReader((response.getEntity().getContent())));


			//System.out.println("Output from Web Service ................................. \n");
			//System.out.println(".......................................................... \n");
			while ((output2 = br.readLine()) != null) {
		//	System.out.println(output);
				
				outputResult2=outputResult2+output2;
			}

			httpClient.getConnectionManager().shutdown();
			br.close();

	} catch (ClientProtocolException e) {

		System.out.println(e.getMessage());

	} catch (IOException e) {

		System.out.println(e.getMessage());
	}
	return outputResult2;
}



public static String callAlfresco3(String url){
	
	try{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

			BufferedReader br = new BufferedReader(
                 new InputStreamReader((response.getEntity().getContent())));


			//System.out.println("Output from Web Service ................................. \n");
			//System.out.println(".......................................................... \n");
			while ((output3 = br.readLine()) != null) {
		//	System.out.println(output);
				
				outputResult3=outputResult3+output3;
			}

			httpClient.getConnectionManager().shutdown();
			br.close();

	} catch (ClientProtocolException e) {

		System.out.println(e.getMessage());

	} catch (IOException e) {

		System.out.println(e.getMessage());
	}
	return outputResult3;
}

public static String callAlfresco4(String url){
	
	try{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

			BufferedReader br = new BufferedReader(
                 new InputStreamReader((response.getEntity().getContent())));


			//System.out.println("Output from Web Service ................................. \n");
			//System.out.println(".......................................................... \n");
			while ((output4 = br.readLine()) != null) {
		//	System.out.println(output);
				
				outputResult4=outputResult4+output4;
			}

			httpClient.getConnectionManager().shutdown();
			br.close();

	} catch (ClientProtocolException e) {

		System.out.println(e.getMessage());

	} catch (IOException e) {

		System.out.println(e.getMessage());
	}
	return outputResult4;
}

	
}


