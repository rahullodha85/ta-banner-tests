package com.hbcd.banner.webservice.fedex;

import com.hbcd.commonbanner.dataobjects.Address;
import com.hbcd.commonbanner.pages.FedExAPI;

public class fedexAddressApiClient implements FedExAPI {

	private String resultFromFedex = "";

	public String handle(Address data) throws Exception  {

		resultFromFedex = null;
		try {
			RateAvailableServicesWebServiceClient object = new RateAvailableServicesWebServiceClient();
			System.out.println("Result from fedex before executing method: "
					+ resultFromFedex);
			resultFromFedex = null;
			resultFromFedex = object.callMain(data);
			System.out.println("Result from fedex After executing method: "+ resultFromFedex);

		} catch (Exception e) {
			throw e;
		}
		return resultFromFedex;
	}
}
