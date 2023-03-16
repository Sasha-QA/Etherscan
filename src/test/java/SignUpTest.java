import org.testng.annotations.Test;

import java.util.UUID;

public class SignUpTest extends BaseTest{

    @Test
    public void fillRegistrationForm(){

        //Opening browser with Given URL
        //Creating objects for two classes which we are using
        //Accepting cookies at the bottom of the page
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        MailinatorPage email = new MailinatorPage(driver);
        signUp.acceptCookies();

        //Enter all fields
        signUp.enterUsername(email.username);
        signUp.enterEmailAndConfirmIt(email.mail);
        signUp.enterPasswordAndConfirm("tracelabs");
        signUp.clickOnCheckboxes();

        ////After checkboxes are selected, ewe have enough time to manually solve reCAPTCHA
        //Verify that meesage is showing about verifying your email
        signUp.clickOnCreateAnAccountButton();
        error.verifyMessageForVerificationEmail();

        //how ot find right email and click on it?
        //How to find link in it
        email.openMailAndConfirmReceivedEmail(email.mail);
    }
}
