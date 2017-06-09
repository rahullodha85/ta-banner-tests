package com.hbcd.banner.saks.alfresco;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ValidateJSONforProductArrayPage {
	String returnStatus = "Fail";
	public static final String NAME = "name";
	public static final String PROJECTS = "projects";
	public static final String PROJECT = "project";
	
	public static void ValidateProductArrayPage(JSONObject object){
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
									.getJSONObject("project");
							if (jsonProject != null) {
								JSONArray videos = jsonProject
										.getJSONArray("videos");
								JSONArray banners = jsonProject
										.getJSONArray("banners");
								JSONArray bgimage = jsonProject
										.getJSONArray("bgImage");
								JSONArray companions = jsonProject
										.getJSONArray("companions");
								JSONObject banner1 = banners.getJSONObject(0);
								JSONObject bgImage1 = bgimage.getJSONObject(0);
								JSONObject companion1 = companions
										.getJSONObject(0);

								if (videos != null && videos.size() == 1) {

									JSONObject video1 = videos.getJSONObject(0);
									JSONObject video2 = video1
											.getJSONObject("video");
									String videopath = video2
											.getString("video");
									String thumbnail1 = video2
											.getString("thumbnail");
									String version = video2
											.getString("version");
									if (videopath
											.trim()
											.equalsIgnoreCase(
													"Content/alfresco/guestDownload/direct/workspace/SpacesStore/6cbebb43-5893-465e-a75a-af603014de37/100812_AlliceOliviaFall12.mp4")) {
										System.out.println("videopath validation PASS");
										if (thumbnail1
												.trim()
												.equalsIgnoreCase(
														"Content/alfresco/guestDownload/direct/workspace/SpacesStore/7c3887a4-2aae-4901-ac39-ba2d19c668dc/100812_ALICE_AND_OLIVIA.jpg")) {
											System.out.println("thumbnail1 validation PASS");
											if (version.trim()
													.equalsIgnoreCase("0.4")) {
												
												System.out.println("version validation PASS");

												String bannerVersion = banner1
														.getString("version");
												String bannerImage = banner1
														.getString("image");

												if (bannerVersion
														.trim()
														.equalsIgnoreCase("1.0")) {

													if (bannerImage
															.trim()
															.equalsIgnoreCase(
																	"Content/alfresco/guestDownload/direct/workspace/SpacesStore/b6e8dcd3-e2a1-4c62-8232-f114a267f471/Test-banner.jpg")) {
														
														System.out.println("bannerImage validation PASS");

														String bgImageVersion = bgImage1
																.getString("version");
														String bgImageImage = bgImage1
																.getString("image");

														if (bgImageVersion
																.trim()
																.equalsIgnoreCase(
																		"1.1")) {
															
															System.out.println("bgImageVersion validation PASS");

															if (bgImageImage
																	.trim()
																	.equalsIgnoreCase(
																			"Content/alfresco/guestDownload/direct/workspace/SpacesStore/b555fcf7-6aa2-419f-a8aa-778399c7f30d/Test-BACKGROUND.jpg")) {

																System.out.println("bgImage validation PASS");
																String companionVersion = companion1
																		.getString("version");
																String companionPath = companion1
																		.getString("path");

																if (companionVersion
																		.trim()
																		.equalsIgnoreCase(
																				"1.2")) {
																	System.out.println("companionVersion validation PASS");

																	if (companionPath
																			.trim()
																			.equalsIgnoreCase(
																					"Content/alfresco/guestDownload/direct/workspace/SpacesStore/cd2db6b3-c9db-43ce-bcd8-3e92b3e3954f/Test_LeftNav2012.gif")) {
																		System.out.println("companionPath validation PASS");
																		
																	} else {
																		System.out
																				.println("Companion path not found in Product Array Page");
																		
																	}

																} else {
																	System.out
																			.println("Companion version number not found in Product Array Page");
																	
																}

															} else {
																System.out
																		.println("Bg Image path not found in Product Array Page");
																
															}

														} else {
															System.out
																	.println("Bg Image version number not found in Product Array Page");
															
														}

													}

												} else {
													System.out
															.println("banner image path not found in Product Array Page");
													
												}

											} else {
												System.out
														.println("banner version number not found in Product Array Page");
												
											}

										}
									} else {
										System.out
												.println("version number for video not found in Product Array Page");
										
									}
								} else {
									System.out
											.println("Thumbnail for video not found in Product Array Page");
									
								}
							} else {
								System.out
										.println("VideoPath for video not found in Product Array Page");
								
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
}
