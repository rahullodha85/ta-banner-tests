package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.GiftOverlayBase;
import com.hbcd.scripting.core.Find;

/**
 * Created by 461967 on 6/6/2016.
 */
public class GiftOverlay extends GiftOverlayBase {
    @Override
    public void With(String name, String message) throws Exception {

        selectNameMessage(name, message);
        Find.Object("giftOverlaySubmitBtn").click();
    }

    @Override
    public void With(String name, String message, String wrap) throws Exception {
        Thread.sleep(4000);
        selectNameMessage(name, message);
        switch(wrap.toLowerCase()){
            case "logo":Find.Object("goLogoWrapBtn").click();
                break;
            case "white wrap":
                break;
            case "no wrap":
                break;
            case "gift box":
                break;
        }

        Find.Object("giftOverlaySubmitBtn").click();
        Thread.sleep(6000);
    }

    private void selectNameMessage(String name,String message) throws Exception {
        if(Find.Object("giftReceiptwindow").getText().value().contains("Add to an Existing Gift Box")){
            Find.Object("giftCreateNewradio").click();
        }
        Find.Object("giftOverlayName").input(name);
        Find.Object("giftOverlayMsg1").input(message);

    }
}
