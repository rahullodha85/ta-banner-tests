package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ValidateJSONforDesignerLandingPage {
	String returnStatus = "Fail";
	public static final String NAME = "name";
	public static final String PROJECTS = "projects";
	public static final String PROJECT = "project";
	

	public static void ValidateDesignerLandingPage(JSONObject object) {
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
								
								ValidateVideos(jsonProject);
								ValidateFeatures(jsonProject);
								ValidateLogos(jsonProject);
								ValidateLinks(jsonProject);
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

	private static void ValidateLinks(JSONObject jsonProject) {

//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		JSONArray links = jsonProject.getJSONArray("links");
		if (links != null && links.size() == 1) {
			JSONObject link = links.getJSONObject(0);
			String urloflink = link.getString("url");
			String linklabel = link.getString("linkLabel");
			if (urloflink
					.trim()
					.equalsIgnoreCase(
							"javascript:popupwin('/main/contentpopup.jsp?FOLDER<>folder_id=2534374306439964',550,500)")) {
				System.out.println("urloflink Path match PASS");
				if (linklabel.trim().equalsIgnoreCase("Special Offer")) {

				} else {
					System.out
							.println("Link label not found for Designer Landing Page");

				}
			} else {
				System.out
						.println("Link url not found for Designer Landing Page");

			}
		} else {
			System.out
					.println("Atleast one link is present for Designer Landing Page");

		}
	}

	private static void ValidateLogos(JSONObject jsonProject) {
//		JSONObject jsonProject = project.getJSONObject(PROJECT);

		JSONArray logos = jsonProject.getJSONArray("logos");
		if (logos != null && logos.size() == 1) {
			JSONObject logo = logos.getJSONObject(0);

			String pathoflogo = logo.getString("path");
			if (pathoflogo
					.trim()
					.equalsIgnoreCase(
							"Content/alfresco/guestDownload/direct/workspace/SpacesStore/1fb00937-55e5-4998-a9b0-d2d46a50f3f8/BURBERRY-logo.gif")) {
				
				System.out.println("pathoflogo match PASS");

			} else {
				System.out
						.println("path of logo not found for Designer Landing Page");

			}
		} else {
			System.out
					.println("At Least one logo found for Designer Landing Page");

		}

	}

	private static void ValidateFeatures(JSONObject jsonProject) {

//		JSONObject jsonProject = project.getJSONObject(PROJECT);
		JSONArray features = jsonProject.getJSONArray("features");
		if (features != null && features.size() == 1) {
			JSONObject feature = features.getJSONObject(0);
			String imagePathoffeature = feature.getString("imagePath");
			String versionoffeature = feature.getString("version");

			if (imagePathoffeature
					.trim()
					.equalsIgnoreCase(
							"Content/alfresco/guestDownload/direct/workspace/SpacesStore/ce7b72eb-3416-4e7a-a441-2ecbdf38471d/Test-Feature-DLP.jpg")) {
				System.out.println("imagePathoffeature match PASS");

				if (versionoffeature.trim().equalsIgnoreCase("0.3")) {
					
					System.out.println("versionoffeature match PASS");
					JSONObject assortmentobject = feature
							.getJSONObject("assortment");

					JSONArray videoLoopAssociationarray = feature
							.getJSONArray("videoLoopAssociation");

					if (videoLoopAssociationarray != null
							&& videoLoopAssociationarray.size() == 1) {
						
						
						JSONObject videoloop1 = videoLoopAssociationarray
								.getJSONObject(0);
						String videoundervideoloop = videoloop1
								.getString("path");
						if (videoundervideoloop
								.trim()
								.equalsIgnoreCase(
										"Content/alfresco/guestDownload/direct/workspace/SpacesStore/f110635a-b929-47df-b076-10a950a7ebc1/BackstageSpring2012-Alice-and-Olivia-Video.mp4")) {
							
							System.out.println("videoundervideoloop match PASS");

							String externalId = assortmentobject
									.getString("externalId");
							if (externalId.trim().equalsIgnoreCase(
									"2534374306588076")) {
								
								System.out.println("externalId match PASS");

							} else {
								System.out
										.println("External ID for assortment not found for Designer Landing Page");

							}

						} else {
							System.out
									.println("Path for video loop association not found in feature for Designer Landing Page");

						}
					} else {
						System.out
								.println("Atleast one video loop association not found in feature for Designer Landing Page");

					}
				} else {
					System.out
							.println("Version number of feature not found for Designer Landing Page");

				}
			} else {
				System.out
						.println("Image path of feature not found for Designer Landing Page");

			}
		} else {
			System.out
					.println("Atleast one feature not found for Designer Landing Page");

		}
	}

	private static void ValidateVideos(JSONObject jsonProject) {

		try {
//			JSONObject jsonProject = project.getJSONObject(PROJECT);

			JSONArray videos = jsonProject.getJSONArray("videos");

			if (videos != null && videos.size() == 1) {

				JSONObject companion = videos.getJSONObject(0);
				JSONObject path = companion.getJSONObject("video");

				String videopath = path.getString("video");

				String thumbnail = path.getString("thumbnail");
				String vesion = path.getString("version");

				if (videopath
						.equalsIgnoreCase("Content/alfresco/guestDownload/direct/workspace/SpacesStore/6cbebb43-5893-465e-a75a-af603014de37/100812_AlliceOliviaFall12.mp4")) {
					
					
					System.out.println("Video Path match PASS");

					if (thumbnail
							.trim()
							.equalsIgnoreCase(
									"Content/alfresco/guestDownload/direct/workspace/SpacesStore/7c3887a4-2aae-4901-ac39-ba2d19c668dc/100812_ALICE_AND_OLIVIA.jpg")) {

						System.out.println("VideoThumbNail Path match PASS");
						if (vesion.equalsIgnoreCase("0.6")) {

							System.out.println("VideoVersion Path match PASS");

						} else {
							System.out
									.println("Version of Video not found for Designer Landing Page");
							
						}
					} else {
						System.out
								.println("Thumbnail for Video not found for Designer Landing Page");
						
					}
				} else {
					System.out
							.println("Path of video not found for Designer Landing Page");
					
				}
			} else {
				System.out
						.println("Exactly 10 Videos not found for Designer Landing Page");
				
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
	}
}
