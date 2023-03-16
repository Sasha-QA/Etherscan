import org.testng.annotations.Test;

public class ErrorMessagesTest extends BaseTest{

    @Test
    public void verifyErrorMessagesForUsername(){

        //Opening browser with Given URL
        //Creating objects for two classes which we are using
        //Accepting cookies at the bottom of the page
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        MailinatorPage email = new MailinatorPage(driver);
        signUp.acceptCookies();


        //Testing error message when the username field is empty
        //We are expecting in terminal one response - "Actual text is the same as expected"
        signUp.enterUsername("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyUsername();

        //Testing error message when the username is too short
        //We are expecting in terminal one response - "Actual text is the same as expected"
        signUp.enterUsername("Sasa");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForUnderFiveCharactersForUsername();

        //Testing error message when the username contains other than numbers and letters
        //We are expecting in terminal one response - "Actual text is the same as expected"
        signUp.enterUsername("Sasha_123");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEnteringSpecialCharactersForUsername();

        //Testing error message if we are using already existing username
        //For this we are going through the complete registration proccess
        signUp.enterUsername(email.username);
        signUp.enterEmailAndConfirmIt(email.mail);
        signUp.enterPasswordAndConfirm("tracelabs");
        signUp.clickOnCheckboxes();

        //After checkboxes are selected, ewe have enough time to manually solve reCAPTCHA
        signUp.clickOnCreateAnAccountButton();

        //Refresh page and enter same credentials
        refreshPage();

        signUp.enterUsername(email.username);
        signUp.enterEmailAndConfirmIt(email.mail);
        signUp.enterPasswordAndConfirm("tracelabs");
        signUp.clickOnCheckboxes();
        signUp.clickOnCreateAnAccountButton();

        //We are expecting in terminal one response - "Actual text is the same as expected"
        error.verifyErrorUsernameIsAlreadyInUse();
        stopWebBrowser();
    }

    @Test
    public void verifyErrorMessagesForEmailAndConfirmEmail(){

        //Opening browser with Given URL
        //Creating objects for two classes which we are using
        //Accepting cookies at the bottom of the page
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        signUp.acceptCookies();

        //Testing error message when we do not fill email and confirm email fields
        //In terminal we are expecting two responses - "Actual text is the same as expected"
        signUp.enterEmailAndConfirmIt("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail();

        //Testing error message when we enter wrong email and confirmation email
        //In terminal we are expecting two responses - "Actual text is the same as expected"
        signUp.enterEmailAndConfirmIt("sasamarkovic");
        error.verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail();

        //Testing error message when confirmation email is not the same as in email field
        //We are expecting in terminal one response - "Actual text is the same as expected"
        signUp.enterDifferentEmailForEmailAndConfirmationEmail("test@mailinator.com", "test@mailinator.co");
        error.verifyErrorMessageWhenConfirmationEmailIsDifferent();
        stopWebBrowser();
    }

    @Test
    public void verifyErrorMessagesForPasswordAndConfirmationPassword(){

        //Opening browser with Given URL
        //Creating objects for two classes which we are using
        //Accepting cookies at the bottom of the page
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        signUp.acceptCookies();

        //Testing error message when we do not fill password and confirm password fields
        //In terminal we are expecting two responses - "Actual text is the same as expected"
        signUp.enterPasswordAndConfirm("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyPasswordAndConfirmPassword();

        //Testing error message when we enter password and confirmation password under 8 characters
        //In terminal we are expecting two responses - "Actual text is the same as expected"
        signUp.enterPasswordAndConfirm("1234567");
        error.verifyErrorMessageWhenPasswordIsUnderEightCharacters();

        //Testing error message when we enter wrong password and confirmation password
        //In terminal we are expecting two responses - "Actual text is the same as expected"
        signUp.enterDifferentPasswordForPasswordAndConfirmationPassword("12345678","12345");
        error.verifyErrorMessageWhenConfirmationPasswordIsDifferent();
        stopWebBrowser();
    }

    @Test
    public void otherMessages(){

        //Opening browser with Given URL
        //Creating objects for two classes which we are using
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);

        //Testing error message when we do not check Terms & Conditions checkbox
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorForTermsAndConditions();
        stopWebBrowser();
    }
}
