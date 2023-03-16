import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PopUpTextAndErrorMessages extends BaseMethods {

    @FindBy(css = "div[class='alert alert-danger']")
    public WebElement usernameAlreadyInUse;

    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_txtUserName-error']")
    public WebElement errorForUsername;

    @FindBy(css = "#ContentPlaceHolder1_txtEmail-error")
    public WebElement errorForEmail;

    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail-error")
    public WebElement errorForConfirmationEmail;

    @FindBy(id = "ContentPlaceHolder1_txtPassword-error")
    public WebElement errorForPassword;

    @FindBy(id = "ContentPlaceHolder1_txtPassword2-error")
    public WebElement errorForConfirmPassword;

    @FindBy(id = "ctl00$ContentPlaceHolder1$MyCheckBox-error")
    public WebElement errorForTermsAndConditions;

    @FindBy(xpath = "//h1[normalize-space()='Verify Your Email']")
    public WebElement verifyEmailAddress;

    private WebDriver driver;

    public PopUpTextAndErrorMessages(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyMessageForVerificationEmail() {
        verifyWebElementTextIs(verifyEmailAddress, "Verify Your Email", "Verify Your Email");
    }

    public void verifyErrorMessageForEmptyUsername() {
        verifyWebElementTextIs(errorForUsername, "Username", "Please enter Username.");
    }

    public void verifyErrorMessageForUnderFiveCharactersForUsername() {
        verifyWebElementTextIs(errorForUsername, "Username", "Please enter at least 5 characters.");
    }

    public void verifyErrorMessageForEnteringSpecialCharactersForUsername() {
        verifyWebElementTextIs(errorForUsername, "Username", "Only alphanumeric characters allowed.");
    }

    public void verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail() {
        verifyWebElementTextIs(errorForEmail, "Email Address", "Please enter a valid email address.");
        verifyWebElementTextIs(errorForConfirmationEmail, "Confirm Email Address", "Please re-enter your email address.");
    }

    public void verifyErrorMessageWhenConfirmationEmailIsDifferent() {
        verifyWebElementTextIs(errorForConfirmationEmail, "Confirm Email Address", "Email address does not match.");
    }

    public void verifyErrorMessageForEmptyPasswordAndConfirmPassword() {
        verifyWebElementTextIs(errorForPassword, "Password", "Please enter Password.");
        verifyWebElementTextIs(errorForConfirmPassword, "Confirm Password", "Your password must be at least 8 characters long.");
    }

    public void verifyErrorMessageWhenPasswordIsUnderEightCharacters() {
        verifyWebElementTextIs(errorForPassword, "Password", "Your password must be at least 8 characters long.");
        verifyWebElementTextIs(errorForConfirmPassword, "Confirm Password", "Your password must be at least 8 characters long.");
    }

    public void verifyErrorMessageWhenConfirmationPasswordIsDifferent() {
        verifyWebElementTextIs(errorForConfirmPassword, "Confirm Password", "Password does not match, please check again.");
    }

    public void verifyErrorForTermsAndConditions() {
        verifyWebElementTextIs(errorForTermsAndConditions, "Terms and Conditions", "Please accept our Terms and Conditions.");
    }

    public void verifyErrorUsernameIsAlreadyInUse() {
        waitForElement(usernameAlreadyInUse);
        verifyWebElementTextIs(usernameAlreadyInUse, "Username error", "Sorry! The username you entered is already in use.");
    }


}
