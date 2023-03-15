import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test
    public void fillRegistrationForm(){
        startWebBrowser();
        SignUpPage signUp = new SignUpPage(driver);
        signUp.acceptCookies();
        signUp.enterUsername("Sashasale");
        signUp.enterEmailAndConfirmIt("sasha@mailinator.com");
        signUp.enterPasswordAndConfirm("tracelabs");

        //does not recognizes checkboxes
        //does not recognize this Create an account button

        signUp.clickOnCheckboxes();
        signUp.clickOnCreateAnAccountButton();
        PopUpTextAndErrorMessages.verifyMessageForVerificationEmail();

        MailinatorPage email = new MailinatorPage(driver);

        // Wasn't able to check if there is a email and a link to click on
        email.openMailAndConfirmReceivedEmail("sasha@mailinator.com");
    }
}
