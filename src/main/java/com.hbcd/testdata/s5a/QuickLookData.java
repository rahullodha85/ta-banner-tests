package com.hbcd.testdata.s5a;

public enum QuickLookData {QLITMSC01("0428743782846"),
	QLITMSC02("0428773748828"),QLITMSC03(" 0400090917152"),QLITMSC04(" 0428736830206");

	private String skuid;

	private QuickLookData(String skuid) {
		this.skuid = skuid;
	}
	public String toString(){
		return this.skuid;
	}
};
