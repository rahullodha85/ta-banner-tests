package com.hbcd.banner.valiations.webservice;

import com.hbcd.banner.webservice.fedex.fedexAddressApiClient;
import com.hbcd.commonbanner.dataobjects.Address;

public class WebserviceValidation {

	public static void isReturningFdxShpngDts(Address address) throws Exception {
		System.out.println(!((new fedexAddressApiClient()).handle(address).isEmpty()) ? "pass"	: "fail");
	}

}
