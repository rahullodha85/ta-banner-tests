package com.hbcd.banner.s5a.pages;

import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

public class s5a_ProductDetails_v {

	public void ClickShippingAccordian() throws Exception{
		Find.Object("ShippingAccordian_vm").click();
		StepLogger.validate(Check.ObjectPresent, "ShippingAccordianPanel_vm");
	}
	public void isAddToBagPresent(){
		StepLogger.validate(Check.TextPresent, "pdpRedesignAddToBagBtn","ADD TO BAG");
	}
	public void isQASectionPresent(){
		StepLogger.validate(Check.TextPresent, "AskQuestionButton_vm","ASK A QUESTION");
	}
	public void isSTLpageLoaded(){
		StepLogger.validate(Check.TextPresent, "stlheader_vm","Complete the Look");
	}
	public void isQuantityMatch(){
		StepLogger.validate(Check.TextPresent, "overlayQuantity_vm","1");
	}
	public void isColorSelected(){
		StepLogger.validate(Check.ObjectPresent, "colorLink_vm");
	}
	public void isSizeSelected(){
		StepLogger.validate(Check.ObjectPresent, "sizeLink_vm");
	}
	public void hasBrandName(String brandName){
		StepLogger.validate(Check.TextPresent, "brandName_vm",brandName);
	}
	public void hasItemNumber(String itemNumber){
		StepLogger.validate(Check.TextPresent, "itemNumber_vm",itemNumber);
	}
	public void isVEGCSection(){
		StepLogger.validate(Check.TextPresent, "giftCardSection_vm","Virtual Gift Card");
	}
	public void isFriendsAndFamilyEligible(){
		StepLogger.validate(Check.TextPresent, "friendsFamily_vm","");
	}
}
