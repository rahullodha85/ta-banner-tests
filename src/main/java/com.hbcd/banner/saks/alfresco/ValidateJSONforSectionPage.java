package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ValidateJSONforSectionPage {
	String returnStatus = "Fail";
	public static final String NAME = "name";
	public static final String PROJECTS = "projects";
	public static final String PROJECT = "project";
	

	public static void ValidateSectionPage(JSONObject object) {
		Utility utility = new Utility();
		try {
			if (object != null) {

				JSONArray pageProjectsArray = utility.returnarrayofValues(
						object, PROJECTS);
				if (pageProjectsArray != null && pageProjectsArray.size() > 0) {
					for (int i = 0; i < pageProjectsArray.size(); i++) {
						JSONObject project = pageProjectsArray.getJSONObject(i);
						if (project != null) {
							
							
							
							JSONObject jsonProject = project
									.getJSONObject(PROJECT);
							if (jsonProject != null) {
								String pageName = jsonProject.getString(NAME);
								// System.out.println("Name of page is :"+pageName);
								ValidateVideo(jsonProject);
								ValidateSliders(jsonProject);
								ValidateCompanions(jsonProject);
								ValidateFeatures(jsonProject);

							} else {
								System.out
										.println("Sliders not found in Section Page");
								
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

	private static void ValidateVideo(JSONObject jsonProject) {

//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		
		JSONArray videos = jsonProject.getJSONArray("videos");

		if (videos != null && videos.size() == 1) {

			JSONObject video1 = videos.getJSONObject(0);
			JSONObject video2 = video1.getJSONObject("video");
			String pathofvideo = video2.getString("video");
			String thumbnailofvideo = video2.getString("thumbnail");
			String versionNumber = video2.getString("version");
			if (pathofvideo
					.trim()
					.equalsIgnoreCase(
							"Content/alfresco/guestDownload/direct/workspace/SpacesStore/6aebc821-aa29-4aa8-8697-97705ea89835/holiday_video_2012.mp4")) {
				System.out.println("Path of Video PASS");
				if (thumbnailofvideo
						.trim()
						.equalsIgnoreCase(
								"Content/alfresco/guestDownload/direct/workspace/SpacesStore/9049f0e5-47d4-4f52-93c5-012300d77cbb/112211_HOLIDAYWINDOW_THUMBNAIL.jpg")) {
					
					System.out.println("Thumbnail of Video PASS");

					if (versionNumber.trim().equalsIgnoreCase("0.22")) {
						System.out.println("VersionNUmber of Video PASS");

					} else {
						System.out
								.println("Video version number not found for video 1 in Section Page");
					}
				} else {
					System.out
							.println("Video thumbnail not found for video 1 in Section Page");

				}
			} else {
				System.out
						.println("Video path not found for video 1 in Section Page");
				
			}
		} else {
			System.out.println("Videos  not found in Section Page");

			
		}

	}

	private static void ValidateSliders(JSONObject jsonProject) {

//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		JSONArray sliders = jsonProject.getJSONArray("sliders");

		JSONObject slider1 = null;
		if (sliders.size() > 0) {
			slider1 = sliders.getJSONObject(0);
		}
		if (sliders != null && sliders.size() == 1) {

			String versionofslider = slider1.getString("version");
			String pathofslider = slider1.getString("sliderPath");

			if (versionofslider.trim().equalsIgnoreCase("1.1")) {

				if (pathofslider
						.trim()
						.equalsIgnoreCase(
								"Content/alfresco/guestDownload/direct/workspace/SpacesStore/b5684995-47d4-4c21-84b0-267c027b21ca/TEST_SLIDER.jpg")) {
					
					System.out.println("PathofSlider PASS");

				} else {
					System.out.println("Companions not found in Section Page");

				}
			} else {
				System.out
						.println("Path for Sliders not found in Section Page");

			}
		} else {
			System.out
					.println("Version number for Sliders not found in Section Page");

		}
	}

	private static void ValidateCompanions(JSONObject jsonProject) {

//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		JSONArray companions = jsonProject.getJSONArray("companions");

		JSONObject companion1 = null;
		if (companions.size() > 0) {
			companion1 = companions.getJSONObject(0);
		}

		if (companions != null && companions.size() == 1) {

			String pathofcompanion = companion1.getString("path");
			String versionofcompanion = companion1.getString("version");
			if (pathofcompanion
					.trim()
					.equalsIgnoreCase(
							"Content/alfresco/guestDownload/direct/workspace/SpacesStore/cd2db6b3-c9db-43ce-bcd8-3e92b3e3954f/Test_LeftNav2012.gif")) {
				
				System.out.println("pathofcompanion PASS");
				if (versionofcompanion.trim().equalsIgnoreCase("1.2")) {
					
					System.out.println("versionofcompanion PASS");

				} else {
					System.out
							.println("Companions version number not found in Section Page");

				}
			} else {
				System.out.println("Companions path not found in Section Page");

			}
		} else {
			System.out.println("Companions not found in the Section Page");
		}
	}

	private static void ValidateFeatures(JSONObject jsonProject) {
//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		JSONArray features = jsonProject.getJSONArray("features");

		JSONObject feature1 = null;
		if (features.size() > 0) {
			feature1 = features.getJSONObject(0);
		}

		if (features != null && features.size() == 1) {

			String imagePath = feature1.getString("imagePath");
			String version = feature1.getString("version");

			if (imagePath
					.trim()
					.equalsIgnoreCase(
							"Content/alfresco/guestDownload/direct/workspace/SpacesStore/8219aa3f-e8ec-4a5b-96c6-bfb1a6095b88/Test-Feature-Section.jpg")) {
				
				System.out.println("imagePath PASS");

				if (version.trim().equalsIgnoreCase("0.4")) {
					
					System.out.println("Version of features PASS");

					JSONArray videoLoopAssociation = feature1
							.getJSONArray("videoLoopAssociation");
					JSONObject assortment1 = feature1
							.getJSONObject("assortment");

					JSONObject videoLoopAssociation1 = videoLoopAssociation
							.getJSONObject(0);

					if (videoLoopAssociation != null
							&& videoLoopAssociation.size() == 1) {

						String pathforvideoLoopAssociation = videoLoopAssociation1
								.getString("path");
						String externalIDforAssortment = assortment1
								.getString("externalId");

						if (pathforvideoLoopAssociation
								.trim()
								.equalsIgnoreCase(
										"Content/alfresco/guestDownload/direct/workspace/SpacesStore/f110635a-b929-47df-b076-10a950a7ebc1/BackstageSpring2012-Alice-and-Olivia-Video.mp4")) {
							System.out.println("pathforvideoLoopAssociation PASS");

							if (externalIDforAssortment.trim()
									.equalsIgnoreCase("2534374306588076")) {
								
								System.out.println("externalIDforAssortment PASS");

							} else {
								System.out
										.println("External Id for Assortment for features not found in Section Page");
							}
						} else {
							System.out
									.println("Path for Video Loop Association for features not found in Section Page");
						}

					} else {
						System.out
								.println("Video Loop Association for features not found in Section Page");
					}

				} else {
					System.out
							.println("Version number for features not found in Section Page");

				}
			} else {
				System.out
						.println("Image path for features not found in Section Page");

			}

		} else {
			System.out.println("Features not found in Section Page");

		}
	}
}
