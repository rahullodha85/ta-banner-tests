package com.hbcd.banner.commomplatform.mobile.pages;

import com.hbcd.commonbanner.base.pages.CreateAccountPageBase;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Use;

import java.util.List;

/**
 * Created by 461967 on 3/14/2016.
 */
public class mCreateAccountPage extends CreateAccountPageBase {
    @Override
    public void AreYouCanadianSelection(String value) throws Exception {
        if (Find.MultipleObjects("cap_RadioBtns").selectItemContainText(value).isPresent()) {
            Report.pass("Are you a canadian customer option selected by user: " + value);
            Find.MultipleObjects("cap_RadioBtns").selectItemContainText(value).storeAs("my_Label_Container");
            Use.CapturedObject("my_Label_Container").FindObject("cap_RadioBtnSelection").click();
        } else {
            Report.fail("Are you a canadian customer selection is not present on Create Account Page");
        }
    }

    @Override
    public void ClickCancel() throws Exception {
        if (Find.Object("cap_Cancel").isPresent()) {
            Report.pass("Cancel button found and clicked");
            Find.Object("cap_Cancel").click();
        } else {
            Report.fail("Cancel button is not present on Create Account Page");
        }
    }

    @Override
    public void CreateAccount(String firstName, String lastName, String email, String pwd, String confPwd) throws Exception {
        if (Find.Object("cap_FirstName").isPresent()) {
            Find.Object("cap_FirstName").input(firstName);
            Thread.sleep(1000);
        }
        if (Find.Object("cap_LastName").isPresent()) {
            Find.Object("cap_LastName").input(lastName);
            Thread.sleep(1000);
        }
        if (Find.Object("cap_Email").isPresent()) {
            Find.Object("cap_Email").input(email);
            Thread.sleep(1000);
        }
        if (Find.Object("cap_Password").isPresent()) {
            Find.Object("cap_Password").input(pwd);
            Thread.sleep(1000);
        }
        if (Find.Object("cap_ConfPassword").isPresent()) {
            Find.Object("cap_ConfPassword").input(confPwd);
            Thread.sleep(1000);
        }
        if (Find.Object("cap_CreateAcc").isPresent()) {
            Find.Object("cap_CreateAcc").click();
            Thread.sleep(1000);
        }
    }

    @Override
    public void ClickCreateAccount() throws Exception {
        if (Find.Object("cap_CreateAcc").isPresent()) {
            Find.Object("cap_CreateAcc").click();
            Thread.sleep(1000);
        }
    }

    @Override
    public  void IsCreateAccountPage() throws Exception {
        if (Find.Object("cap_Title").isPresent()) {
            Report.pass("User is on Create Account Page");
        } else {
            Report.fail("User is not on Create Account Page");
        }
    }

    @Override
    public  void IsFirstNamePresent() throws Exception {
        if (Find.Object("cap_FirstName").isPresent()) {
            Report.pass("First Name text box is present on Create Account Page");
        } else {
            Report.fail("First Name text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsLastNamePresent() throws Exception {
        if (Find.Object("cap_LastName").isPresent()) {
            Report.pass("Last Name text box is present on Create Account Page");
        } else {
            Report.fail("Last Name text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsEmailPresent() throws Exception {
        if (Find.Object("cap_Email").isPresent()) {
            Report.pass("Email text box is present on Create Account Page");
        } else {
            Report.fail("Email text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsPasswordPresent() throws Exception {
        if (Find.Object("cap_Password").isPresent()) {
            Report.pass("Password text box is present on Create Account Page");
        } else {
            Report.fail("Password text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsConfPasswordPresent() throws Exception {
        if (Find.Object("cap_ConfPassword").isPresent()) {
            Report.pass("Confirm Password text box is present on Create Account Page");
        } else {
            Report.fail("Confirm Password text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsPhonePresent() throws Exception {
        if (Find.Object("cap_Phone").isPresent()) {
            Report.pass("Phone text box is present on Create Account Page");
        } else {
            Report.fail("Phone text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsZipPresent() throws Exception {
        if (Find.Object("cap_Zip").isPresent()) {
            Report.pass("Zip-Code text box is present on Create Account Page");
        } else {
            Report.fail("Zip-Code text box is present on Create Account Page");
        }
    }

    @Override
    public  void IsCanadianCustomerAgreementPresent() throws Exception {
        if (Find.Object("cap_CanadinCustomerAgreement").isPresent()) {
            Report.pass("Agreement for Saks and Off5th Canada is  present");
        } else {
            Report.fail("Agreement for Saks and Off5th Canada is not present");
        }
    }

    @Override
    public  void IsPrivacyPolicyPresent() throws Exception {
        if (Find.Object("cap_PrivacyPolicy").isPresent()) {
            Report.pass("Privacy policy is present");
        } else {
            Report.fail("Privacy policy is not present");
        }
    }

    @Override
    public  void IsCheckBoxPresent(String text) throws Exception {
        if (Find.Object("cap_CheckBoxes").changeContainsText(text).isPresent()) {
            Report.pass(text + " checkbox is present and checked");
        } else {
            Report.fail(text + " checkbox is not present");
        }
    }

    @Override
    public  void IsTermsCondPresent() throws Exception {
        if (Find.Object("cap_TermsCond").isPresent()) {
            Report.pass("Terms & Conditions link is present");
        } else {
            Report.fail("Terms & Conditions link is present");
        }
    }

    @Override
    public  void IsFirstNameErrorTextPresent(String text) throws Exception {
        if (Find.Object("cap_FirstNameError").isPresent()) {
            if (Find.Object("cap_FirstNameError").getText().value().contains(text)) {
                Report.pass("FirstName textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("FirstName textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("FirstName textbox is a required field" +
                    " error message is not present on Create Account Page");
        }
    }

    @Override
    public  void IsConfPwdErrorTextPresent(String text) throws Exception {
        if (Find.Object("cap_ConfPasswordError").isPresent()) {
            if (Find.Object("cap_ConfPasswordError").getText().value().contains(text)) {
                Report.pass("FirstName textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("FirstName textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("FirstName textbox is a required field" +
                    " error message is not present on Create Account Page");
        }
    }

    @Override
    public  void IsPwdErrorTextPresent(String text) throws Exception {
        if (Find.Object("cap_PasswordError").isPresent()) {
            if (Find.Object("cap_PasswordError").getText().value().contains(text)) {
                Report.pass("FirstName textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("FirstName textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("FirstName textbox is a required field" +
                    " error message is not present on Create Account Page");
        }
    }

    @Override
    public  void IsLastNameErrorTextPresent(String text) throws Exception {
        if (Find.Object("cap_LastNameError").isPresent()) {
            if (Find.Object("cap_LastNameError").getText().value().contains(text)) {
                Report.pass("FirstName textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("FirstName textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("FirstName textbox is a required field" +
                    " error message is not present on Create Account Page");
        }
    }

    @Override
    public  void IsEmailErrorTextPresent(String text) throws Exception {
        if (Find.Object("cap_EmailError").isPresent()) {
            if (Find.Object("cap_EmailError").getText().value().contains(text)) {
                Report.pass("FirstName textbox is required field error message" +
                        " displayed with expected text " + text);
            } else {
                Report.fail("FirstName textbox is required field error message" +
                        " does not match expected text " + text);
            }
        } else {
            Report.fail("FirstName textbox is a required field" +
                    " error message is not present on Create Account Page");
        }
    }

    @Override
    public  void PrivacyPolicyHasLink(String text) throws Exception {
        List<String> links = Find.MultipleObjects("cap_PrivacyPolicyLinks").getAttributes("href");
        for(String link : links){
            if(link.contains(text)){
                Report.pass("Link: " + text + " is present in privacy policy");
                return;
            }
        }
        Report.fail("Link: " + text + " is not present in privacy policy");
    }

    @Override
    public void IsMoreNumMsgPresent(String text) throws Exception {
        if(Find.Object("cap_MoreNumMsg").isPresent()){
            if(Find.Object("cap_MoreNumMsg").getText().value().contains(text)){
                Report.pass("\"Already a More Member?\" message present " +
                        "and verified on Create Account Page");
            }else {
                Report.fail("Create Account Page More Member message text: " +
                        Find.Object("cap_MoreNumMsg").getText().value() +
                        "does not match expected value: " + text);
            }
        }else {
            Report.fail("\"Already a More Member?\" message not present " +
                    "on Create Account Page");
        }
    }
}
