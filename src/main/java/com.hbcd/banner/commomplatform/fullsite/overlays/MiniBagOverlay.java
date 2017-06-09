package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.MiniBagOverlayBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by yalipova on 12/12/2016.
 */
public class MiniBagOverlay extends MiniBagOverlayBase {
    @Override
    public void closeMiniBag() throws Exception {

        if (Find.Object("minibag_close_YA").isPresent()) {
            Report.pass("close minibag element is found");
            Find.Object("minibag_close_YA").click();
        }

    }

    @Override
    public void clickOnItem() throws Exception {
        if (Find.Object("minibag_items_YA").isPresent()) {
            Report.pass("There are items in mini bag");
            Find.Object("minibag_items_YA").click();
            {
                if (Find.Object("pdp_is Present_YA").isPresent()) {
                    Report.pass("PDP is reached");
                } else {
                    Report.fail("PDP is not reached");
                }
            }
        } else {
            Report.fail("There are no items in mini bag");
        }
    }


    @Override
    public void clickCheckout() throws Exception {

        if (Find.Object("minibag_items_YA").isPresent()) {
            Report.pass("There are items in mini bag");
            Find.Object("minibag_checkout_btn_YA").click();
            {
                if (Find.Object("bag_is _present_YA").isPresent()) {
                    Report.pass("Bag is reached");
                } else {
                    Report.fail("Bag is not reached");
                }
            }
        } else {
            Report.fail("Bag is not reached or no checkout button");
        }


    }

    @Override
    public void clickMiniBag() throws Exception {

        if (Find.Object("miniBag_YA_topNavSign").isPresent()) {
            Find.Object("miniBag_YA_topNavSign").click();
            if (Find.Object("miniBagOpen_YA").isPresent() ||
                    Find.Object("miniBag_Empty_RL").isPresent()) {
                Report.pass("MiniBag Overlay has opened or empty");
            }
        } else {
            Report.fail("Bag is not reached or no checkout button");
        }
    }

    @Override
    public void checkSaveForLater() throws Exception {

        if (Find.Object("minibag_saveFor_later_btn_YA").isPresent()) {
            Report.fail("MiniBag has Save for later button, but is should not");
        }

        if (Find.Object("minibag_checkout_btn_YA").isPresent() || Find.Object("miniBag_Empty_RL").isPresent()) {
            Report.pass(" Mini bag does not have Save for later button");
        } else {
            Report.fail("MiniBag has not expected elements");
        }
    }


     @Override
     public void isMiniBagOverlay() throws Exception {
         if (Find.Object("miniBag_Checkout_RL").isPresent()) {
             Report.pass("Minicart Overlay is open");
         } else if (Find.Object("miniBag_Empty_RL").isPresent()) {
             Report.pass("Minicart Overlay is open but empty");
         } else {
             Report.fail("Minibag overlay is not open");
         }
     }

    @Override
    public void clickSaveForLater() throws Exception {
        if (Find.Object("minibag_saveFor_later_btn_YA").isPresent()) {
            Report.pass("User has Save for later items only");
            Find.Object("minibag_saveFor_later_btn_YA").click();

            if (Find.Object("bag_is _present_YA").isPresent() &&
                    Find.Object("bag_save_for_later_items_YA").isPresent()) {
                Report.pass("Bag with saved items is reached");
            } else {
                Report.fail("Bag is not reached or does not have Save for later items");
            }
        } else {
            Report.fail("Bag is not reached");
        }
    }

    @Override
    public void numberOfItems() throws Exception {
        if (Find.Object("miniBag_header_YA").isPresent()) {

            Report.pass("User has Save for later items only");
            Find.Object("minibag_saveFor_later_btn_YA").click();

            if (Find.Object("bag_is _present_YA").isPresent() &&
                    Find.Object("bag_save_for_later_items_YA").isPresent()) {
                Report.pass("Bag with saved items is reached");
            } else {
                Report.fail("Bag is not reached or does not have Save for later items");
            }
        } else {
            Report.fail("Bag is not reached");
        }
    }

    @Override
    public void errorMessage() throws Exception {
        if (Find.Object("miniBag_ErrorMessage_YA").isPresent()) {
            Report.pass("Error message is present in MiniBag");
        } else

        {
            Report.fail("An Error message does not show up");
        }
    }

}


