import org.testng.annotations.Test;

public class ErrorMessagesTest extends BaseTest{

    @Test
    public void verifyErrorMessagesForUsername(){
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        signUp.acceptCookies();

        signUp.enterUsername("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyUsername();

        signUp.enterUsername("Sasa");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForUnderFiveCharactersForUsername();

        signUp.enterUsername("Sasha_123");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEnteringSpecialCharactersForUsername();
    }

    @Test
    public void verifyErrorMessagesForEmailAndConfirmEmail(){
        startWebBrowser();

        //Create objects for these two clases

        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);

        signUp.acceptCookies();
        signUp.enterEmailAndConfirmIt("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail();

        //Enter invalid email and confirmation email
        signUp.enterEmailAndConfirmIt("sasamarkovic");
        error.verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail();


        signUp.enterDifferentEmailForEmailAndConfirmationEmail("test@mailinator.com", "test@mailinator.co");
        error.verifyErrorMessageWhenConfirmationEmailIsDifferent();
    }

    @Test
    public void verifyErrorMessagesForPasswordAndConfirmationPassword(){
        startWebBrowser();

        //Create objects for these two clases

        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);

        signUp.acceptCookies();
        signUp.enterPasswordAndConfirm("");
        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorMessageForEmptyPasswordAndConfirmPassword();

        signUp.enterPasswordAndConfirm("1234567");
        error.verifyErrorMessageWhenPasswordIsUnderEightCharacters();

        signUp.enterDifferentPasswordForPasswordAndConfirmationPassword("12345678","12345");
        error.verifyErrorMessageWhenConfirmationPasswordIsDifferent();
    }

    @Test
    public void otherMessages(){
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        PopUpTextAndErrorMessages error = new PopUpTextAndErrorMessages(driver);
        error.verifyTextInInfoIcon();

        signUp.clickOnCreateAnAccountButton();
        error.verifyErrorForTermsAndConditions();
    }
}
