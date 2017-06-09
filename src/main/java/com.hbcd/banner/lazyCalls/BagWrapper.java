package com.hbcd.banner.lazyCalls;

import com.hbcd.commonbanner.lazyCalls.helpers.PageFactory;

public class BagWrapper {
	public static void addItem(int option) throws ReflectiveOperationException{
		
		PageFactory.getPage("s5a_BagPage");
	}
}	
