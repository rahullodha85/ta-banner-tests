package com.hbcd.banner.factory;

import com.hbcd.commonbanner.enums.ToggleType;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.configurationsetting.ConfigurationLoader;

public class Factory {
	public static Object getPageUsingToggle(ToggleType toggle) throws Exception {
		return  Class.forName(toggle.getPageClass()).newInstance();
	}
	public static boolean isNew(ToggleType toggle) throws Exception{
		return ConfigurationLoader.getValue(ApplicationSetup.get(Setting.SITE) + "." + toggle.toString())
				.equalsIgnoreCase("new") ? true : false;
	}
}
