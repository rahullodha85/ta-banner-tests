package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ValidateJSONforShopByDesignerPage {
	String returnStatus = "Fail";
	public static final String NAME = "name";
	public static final String PROJECTS = "projects";
	public static final String PROJECT = "project";

	public static void ValidateSBD(JSONObject object) {
		Utility utility = new Utility();
		try {
			if (object != null) {

				JSONArray pageProjectsArray = object.getJSONArray("projects");

				if (pageProjectsArray != null && pageProjectsArray.size() > 0) {
					for (int i = 0; i < pageProjectsArray.size(); i++) {
						JSONObject project = pageProjectsArray.getJSONObject(i);
						if (project != null) {
							JSONObject jsonProject = project
									.getJSONObject("project");
							if (jsonProject != null) {
								String pageName = jsonProject.getString("name");
								ValidateBanner(jsonProject);

							}
						}
					}
				}
			} else {
				System.out
						.println("Response JSon object from Alfresco is null");

			}
		} catch (Exception e) {
			System.out.println("Exception Occured : " + e.getMessage());
		}

	}

	private static void ValidateBanner(JSONObject jsonProject) {

		JSONArray banners = jsonProject.getJSONArray("banners");
		if (banners != null && banners.size() == 1) {

			JSONObject banner = banners.getJSONObject(0);
			String bannerimage = banner.getString("image");
			// System.out.println("Banner Image path is : "
			// + bannerimage);

			if (bannerimage
					.equalsIgnoreCase("Content/alfresco/guestDownload/direct/workspace/SpacesStore/78eeb796-d859-49e9-8f7a-5e0e1b617a9c/102912_SHOPBYDESIGNER.jpg")) {

				System.out.println("bannerimage validation Pass");
			} else {
				System.out
						.println("Banners Image not found in Shop By Designers Page");

			}
		} else {
			System.out.println("Banners not found in Shop By Designers Page");

		}

	}

}
