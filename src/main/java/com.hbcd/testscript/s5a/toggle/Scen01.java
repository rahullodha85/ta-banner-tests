package com.hbcd.testscript.s5a.toggle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hbcd.scripting.base.ScenarioBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.SiteConfiguration;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Storage;

public class Scen01 extends ScenarioBase {

	private String htmlcontentString;
	private String htmlEnvironment;
	private int rowCounter =1;
	private boolean isPass = true;
	private void initializeHTMLBody(String dynamicDate, String scenarioName){
		 Date d = new Date();
		 String cssString = "<style type='text/css'>"+
				 " body {font: normal 10px auto Tahoma, Geneva, sans-serif;"+
				 "	color: #000;"+
				 "	background: #E6EAE9;"+
				 "}"+
				 "a {color: #c75f3e;}"+
				 ""+
				 "table.resultTable {padding: 0;margin: 0; width:950px}"+
				 "caption {padding: 0 0 5px 0;font: italic 12px 'Trebuchet MS', Verdana, Arial, Helvetica, sans-serif;text-align: right;}"+				 
				 "table.resultTable th {"+
				 "	padding: 7px 6px;"+
				 "	font-size : 80%;"+
				 "	font-family:Tahoma, Geneva, sans-serif;"+
				 "	color:#FFF;"+
				 "	background:#000;"+
				 "	border: 1px solid #999999;"+
				 "}"+
				 " table.resultTable td {font: 12px Tahoma, Geneva, sans-serif;"+
				 "	border-right: 1px solid #333;"+
				 "	border-bottom: 1px solid #333;"+
				 "	background: #fff;"+
				 "	padding: 6px 6px 6px 12px;"+
				 "	color: #000;}"+
				 "table.resultTable td.alt {"+
				 "	background: #CCC;"+
				 "	color: #000;}"+
				 "table.resultTable td.fail {"+
				 "font-weight:bold;"+
				 "background: #FDD;"+
				 "color: #F00;}"+
				 "</style>";
		String date=d.toString().replaceAll(" ", "-");
		 htmlcontentString =cssString+ "<html>"+"<head>" + "<title> Execution Result</title>" +
				"</head>"  +"<body >" +"<center>" +"<font face='Edwardian Script ITC' size='+4'><b>Automation Results</b> </font> <br/>"  +
				" <font face='Times New Roman' size='+1'><b>"+ scenarioName +"</b> </font>" +
				"<br>" +
				"<div style='text-align: center;'>" +
				"<div style='text-align: center; margin: 1em auto; width: 50%;'>" +
				"<img src= '../saks-fifth-avenue-logo.jpg' width='66' height='66'  style='display: block; margin-left: auto; margin-right: auto;' alt='Saks Fifth Avenue'</img>" +
				"</div>"+"</div>"+
				htmlEnvironment +
				" <table class='resultTable' cellspacing='0'>"+
				"<tr>"+
				"<th>Toggle Name</th>"+
				" <th>Preview</th>"+
				"<th>QA</th>"+
				" <th>Prod</th>"+
				"</tr>";

	}
	
	private void reportHTML(String argToggleName, String argQA, String argPreview, String argProd,String status ) throws IOException{
		rowCounter++;
		String tdStr="";
		if(rowCounter%2==0){
			tdStr="<td>";
		}else{
			tdStr=" <td class='alt'>";
		}
		
		if(status.equalsIgnoreCase("fail")){
			tdStr=" <td class='fail'>";
		htmlcontentString =htmlcontentString+ "<tr> <fontcolor='#FF0000'>"+
				tdStr+argToggleName+"</td>"+
				tdStr+argPreview+"</td>"+
				tdStr+argQA+"</td>"+
				tdStr+argProd+"</td>"+
				"</font></tr>";
		}else
			htmlcontentString =htmlcontentString+ "<tr>"+
					tdStr+argToggleName+"</td>"+
					tdStr+"&nbsp;"+argPreview+"</td>"+
					tdStr+"&nbsp;"+argQA+"</td>"+
					tdStr+"&nbsp;"+argProd+"</td>"+
					"</tr>";		
	}
	
	private void completeHTMLBody(){
		htmlcontentString +="</table>"+"</center></body>"+"</html>";
	}
	
	
	public static String writeInHTMLFile(String htmlContent) throws IOException
	{
		String retResPath = "";	
		String resFileName = "";
		String indexHtmlPath;
		FileInputStream fs;
		Date date = new Date();
		
		//indexHtmlPath="J:\\Automation_Framework\\Selenium Projects\\Saks_Paypal\\HTML_Report\\"+System.currentTimeMillis()+".html";
		resFileName = "ToggleReport_" + System.currentTimeMillis()+".html";
		retResPath = resFileName;
		
		//indexHtmlPath=System.getProperty("user.dir")+retResPath;
		indexHtmlPath=retResPath;
		new File(indexHtmlPath).createNewFile();

		FileWriter fstream = new FileWriter(indexHtmlPath);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(htmlContent);
		out.flush();
			
		return resFileName;		
				
	}
	private String generateHTMLReport() throws IOException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		initializeHTMLBody( dateFormat.format(date), "Toggle Validation");
		
		//Fail Only
		for (String key : masterList.keySet())
		{
			if (!masterList.get(key).isTheSame())
			{
				reportHTML(masterList.get(key).getName(), masterList.get(key).getQaData(), masterList.get(key).getStgData(), masterList.get(key).getProdData(), (masterList.get(key).isTheSame() ? "pass" : "fail"));
				if (!masterList.get(key).isTheSame())
				{
					isPass = false;
				}
			}
		}
		
		//Pass Only
		for (String key : masterList.keySet())
		{
			if (masterList.get(key).isTheSame())
			{
				reportHTML(masterList.get(key).getName(), masterList.get(key).getQaData(), masterList.get(key).getStgData(), masterList.get(key).getProdData(), (masterList.get(key).isTheSame() ? "pass" : "fail"));
				if (!masterList.get(key).isTheSame())
				{
					isPass = false;
				}
			}
		}
		completeHTMLBody();
		
		//writeInHTMLFile(htmlcontentString);
		return htmlcontentString;
	}
	
	private class Toggle
	{
		String name = "";
		String qaData = "";
		String stgData = "";
		String prodData = "";
		
		
		public Toggle (String n)
		{
			name = n;
		}

		public String getName() {
			return name;
		}

		public String getQaData() {
			return qaData;
		}

		public String getStgData() {
			return stgData;
		}

		public String getProdData() {
			return prodData;
		}

		public void set(String type, String value)
		{
			if (type.equalsIgnoreCase("q"))
			{
				qaData = value;
			}
			else if (type.equalsIgnoreCase("s"))
			{
				stgData = value;
			}
			else if (type.equalsIgnoreCase("p"))
			{
				prodData = value;
			}
		}
		
		public boolean isTheSame()
		{
			//return (qaData.equalsIgnoreCase(prodData));
			return (qaData.equalsIgnoreCase(stgData) && qaData.equalsIgnoreCase(prodData));
		}
		
		public void print ()
		{
			System.out.println(name + "|" + qaData + "|" + stgData + "|" + prodData + "|" + (isTheSame() ? "YES" : "NO"));
		}
	}
	HashMap<String, Toggle> masterList= new HashMap<String, Toggle>();
//	HashMap<String, String> qaList = new HashMap<String, String>();
//	HashMap<String, String> stageList = new HashMap<String, String>();
//	HashMap<String, String> prodList = new HashMap<String, String>();
	
	private void getToggle(String site, String type) throws Exception
	{
		//
		Navigate.go(site);
		Find.Object("qaLogin").inputPresetData();
		Thread.sleep(500);
		Find.Object("qaPassword").inputPresetData();
		Thread.sleep(500);
		Find.Object("qaLoginButton").click();
		Thread.sleep(500);
			
			
		//Toggle Page
		List<String> allAttrib = Find.MultipleObjects("MultipleToggle").getAttributes("data-feature", "data-state");

		for (String s : allAttrib)
		{
			List<String> tmp = Arrays.asList(s.split("\\|"));
			String key = tmp.get(0);
			String value = "";
			
			//Reverse Value
			if (tmp.get(1).equalsIgnoreCase("On"))
			{
				value = "OFF";
			}
			else if (tmp.get(1).equalsIgnoreCase("Off"))
			{
				value = "ON";
			}
			
			if (!masterList.containsKey(key))
			{
				masterList.put(key, new Toggle(key));
			}
			masterList.get(key).set(type, value);
		}
	}
	
	@Override
    public void executeScript() throws Exception {
		
//		getToggle(SiteConfigurationManager.getSiteConfigurationValue("URL"), "q");
//		getToggle(SiteConfigurationManager.getSiteConfigurationValue("URL2"), "s");
//		getToggle(SiteConfigurationManager.getSiteConfigurationValue("URL3"), "p");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dynamicDate = dateFormat.format(date);
		htmlEnvironment = "<table class='resultTable' cellspacing='0'><caption>Execution Time: " + dynamicDate + " </caption>"+
				"<tr>"+
				"<th>Environment</th>"+
				" <th>URL</th>"+
				"</tr>"+
				"<tr><td>Preview Environment</td><td>" + SiteConfiguration.getData(".URL2") + "</td></tr>" +
				"<tr><td>QA Environment</td><td>" + SiteConfiguration.getData(".URL") + "</td></tr>" +
				"<tr><td>Production Environment</td><td>" + SiteConfiguration.getData(".URL3") + "</td></tr>" +
				"</table>";
		getToggle(SiteConfiguration.getData(".URL"), "q");
		getToggle(SiteConfiguration.getData(".URL2"), "s");
		getToggle(SiteConfiguration.getData(".URL3"), "p");
		
		Storage.save("CURRENT_CASE_HTML_REPORT", generateHTMLReport());
		
		if (isPass)
		{
			Report.pass("TOGGLES in QA, PREVIEW, & PROD are the SAME", "");
		}
		else
		{
			Report.fail("There are differences of TOGGLES in QA, PREVIEW, & PROD", "");
		}
//		for (String key : masterList.keySet())
//		{
//			masterList.get(key).print();
//		}
		
//		Factory fac=new Factory();
//		fac.pdpToggle();
//		nav.SearchFor("0499928820294");
//		
//		pdp.AddToBag(1);
		
	}
}
