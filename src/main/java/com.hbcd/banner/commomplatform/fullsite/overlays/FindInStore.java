package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.FindInStoreOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.enums.impl.Check;
import com.hbcd.scripting.reporting.StepLogger;

/**
 * Created by 461967 on 6/6/2016.
 */
public class FindInStore extends FindInStoreOverlayBase {
    @Override
    public void SearchStores() throws Exception {

//		Switch.toFrame("findInStore");
        Find.Object("inStoreOLZip_ws").input("10017");
        Find.Object("inStoreOLDistance_ws").select("100 Miles");
        if(Find.Object("inStoreOL").getText().value().contains("Choose Color and"))
            Find.Object("inStoreOLSelColorSize_ws").select(1);

        StepLogger.validate(Check.ObjectPresent, "inStoreOLSubmitBtn_ws");
        Find.Object("inStoreOLSubmitBtn_ws").click();

    }

    @Override
    public void ClickFirstSearchResult() throws Exception {

        StepLogger.validate(Check.ObjectPresent, "inStoreResultsFirstAddress_ws");
        Find.Object("inStoreResultsFirstAddress_ws").click();


    }

    @Override
    public String FirstStoreAddress() throws Exception {
        return Find.Object("inStoreResultsFirstAddress_ws").getText().value();
    }
}
