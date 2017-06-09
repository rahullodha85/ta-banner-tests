package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ValidateJSONEditorialsPage {
	String returnStatus = "Fail";
	public static final String NAME = "name";
	public static final String PROJECTS = "projects";
	public static final String PROJECT = "project";

	public static void ValidateEditorialsPage(JSONObject object) {
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
								JSONArray collageAssociation = jsonProject
										.getJSONArray("collageAssociation");
								JSONArray spreadAssociation = jsonProject
										.getJSONArray("spreadAssociation");
								if (collageAssociation != null
										&& collageAssociation.size() == 1) {
									JSONObject collageAssociation1 = collageAssociation
											.getJSONObject(0);
									String pathCollageAssociation = collageAssociation1
											.getString("imagePath");
									String versionCollageAssociation = collageAssociation1
											.getString("version");
									if (pathCollageAssociation
											.equalsIgnoreCase("Content/alfresco/guestDownload/direct/workspace/SpacesStore/74c215e1-c6e8-447e-a85a-8de11ab5f920/120312_THE_EDIT_INDEX_JEWELRY.jpg")) {
										System.out
												.println("pathCollageAssociation validation PASS");
									} else {
										System.out
												.println("Image Path of Collage is null for Editorial Page");
									}

									if (versionCollageAssociation
											.equalsIgnoreCase("0.5")) {
										System.out
												.println("versionCollageAssociation validation PASS");
									} else {
										System.out
												.println("Version of Collage Association is null for Editorial Page");

									}
									if (spreadAssociation != null
											&& spreadAssociation.size() > 1) {
										

									} else {
										System.out
												.println("Spread Association is null for Editorial Page");

									}

								} else {
									System.out
											.println("Collage Association is null for Editorial Page");
								}

							}

						} else {
							System.out
									.println("Project is null for Editorial Page");
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
}
