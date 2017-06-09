package com.hbcd.banner.s5a.pages;

import com.hbcd.commonbanner.pages.*;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Switch;

public class s5a_InternationalCheckout implements InternationalCheckout{

	@Override
	public void AddShippingAddress(String address, String city, String state,
			String zipcode,String email) throws Exception {
		Thread.sleep(3000);
		Switch.toFrame("envoyId");
		Thread.sleep(3000);
		new s5a_ReviewSubmitPage().commonCredentials("IntShip", address, state, city, zipcode);
		Find.Object("IntShipEmailId").input(email);
		Switch.toDefaultContent();
	}

	@Override
	public void AddCreditCard(String... creditCard ) throws Exception{
		Thread.sleep(4000);
		Switch.toFrame("envoyId");
		Find.Object("rsIntvisaCard").click();
//		Switch.toDefaultContent();
		Thread.sleep(4000);
		Switch.toFrame("cc-frame");
		Find.Object("IntBillCardNumber").input(creditCard[1]);
		Find.Object("IntBillCardExpiryYear").select("2025");
		Find.Object("IntBillCardSecurityCode").input("121");
		Switch.toDefaultContent();
	}

	@Override
	public void ClickPlaceOrder() throws Exception{
		Switch.toFrame("envoyId");
		Find.Object("IntPlaceOrder").click();
		Thread.sleep(6000);
		Switch.toDefaultContent();
		
	}

	
}
