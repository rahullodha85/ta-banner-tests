package com.hbcd.banner.LordAndTaylor.fullsite.overlays;

import com.hbcd.banner.commomplatform.fullsite.overlays.GiftOverlay;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 6/6/2016.
 */
public class LT_GiftOverlay extends GiftOverlay {

    @Override
    public void With(String message) throws Exception {

        if(Find.Object("giftOverlayMsg1").isPresent()){
           Report.pass("User Enters Gift Messages");
           Find.Object("giftOverlayMsg1").input(message);
           Find.Object("ltClickSbtBtn_AAF").click();
        }else{
            Report.fail("Gift Wrap Message is NOT displayed");
        }


    }
}
