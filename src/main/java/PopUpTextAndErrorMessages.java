import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpTextAndErrorMessages extends BaseMethods {

    @FindBy(css = "i[aria-label='Username has to be from 5 to 30 characters in length, only alphanumeric characters allowed.']")
    public static WebElement usernameInfo;

    @FindBy(css = "div[class='alert alert-danger']")
    public static WebElement usernameAlreadyInUse;

    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_txtUserName-error']")
    public static WebElement errorForUsername;
    //ima dva errora-za empty username i kad se koristi bilo sta drugo osim slova, kao i minimum 5 karaktera

    @FindBy(css = "#ContentPlaceHolder1_txtEmail-error")
    public static WebElement errorForEmail;

    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail-error")
    public static WebElement errorForConfirmationEmail;

    @FindBy(id = "ContentPlaceHolder1_txtPassword-error")
    public static WebElement errorForPassword;

    @FindBy(id = "ContentPlaceHolder1_txtPassword2-error")
    public static WebElement errorForConfirmPassword;

    @FindBy(css = "#ContentPlaceHolder1_txtPassword2-error")
    public static WebElement errorForShortPassword;

    @FindBy(id = "ctl00$ContentPlaceHolder1$MyCheckBox-error")
    public static WebElement errorForTermsAndConditions;

    @FindBy(css = ".h4")
    public static WebElement verifyEmailAddress;

    private WebDriver driver;

    public PopUpTextAndErrorMessages(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public static void verifyMessageForVerificationEmail(){
    verifyWebElementTextIs(verifyEmailAddress,"Verify Your Email","Verify Your Email");
}

public void verifyErrorMessageForEmptyUsername(){
    verifyWebElementTextIs(errorForUsername, "Username","Please enter Username.");
}

public void verifyErrorMessageForUnderFiveCharactersForUsername(){
        verifyWebElementTextIs(errorForUsername,"Username","Please enter at least 5 characters.");
}

public void verifyErrorMessageForEnteringSpecialCharactersForUsername(){
        verifyWebElementTextIs(errorForUsername,"Username","Only alphanumeric characters allowed.");
}

public void verifyErrorMessageForEmptyOrWrongEmailAndConfirmationEmail(){
        verifyWebElementTextIs(errorForEmail,"Email Address", "Please enter a valid email address.");
        verifyWebElementTextIs(errorForConfirmationEmail,"Confirm Email Address", "Please re-enter your email address.");
}

public void verifyErrorMessageWhenConfirmationEmailIsDifferent(){
        verifyWebElementTextIs(errorForConfirmationEmail,"Confirm Email Address","Email address does not match.");
}

public void verifyErrorMessageForEmptyPasswordAndConfirmPassword(){
        verifyWebElementTextIs(errorForPassword, "Password", "Please enter Password.");
        verifyWebElementTextIs(errorForConfirmPassword,"Confirm Password","Your password must be at least 8 characters long.");
}

public void verifyErrorMessageWhenPasswordIsUnderEightCharacters(){
    verifyWebElementTextIs(errorForPassword, "Password", "Your password must be at least 8 characters long.");
    verifyWebElementTextIs(errorForConfirmPassword,"Confirm Password","Your password must be at least 8 characters long.");
}

public void verifyErrorMessageWhenConfirmationPasswordIsDifferent(){
        verifyWebElementTextIs(errorForConfirmPassword,"Confirm Password","Password does not match, please check again.");
}
    public void verifyTextInInfoIcon(){
        verifyWebElementTextIs(usernameInfo,"Username info", "Username has to be from 5 to 30 characters in length, only alphanumeric characters allowed.");
    }

    public void verifyErrorForTermsAndConditions(){
        verifyWebElementTextIs(errorForTermsAndConditions,"Terms and Conditions","Please accept our Terms and Conditions.");
    }


}
