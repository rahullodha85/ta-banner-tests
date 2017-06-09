package com.hbcd.banner.mobile.saks.enums;

public enum SectionLinks {
	DRESSES("Dresses"),
	DAY("Day"),
	SHOPALL("Shop All");
	
	private String linkText;
	private SectionLinks(String linkText){
		this.linkText = linkText;
	}
	public String toString(){
		return linkText;
	}
}
