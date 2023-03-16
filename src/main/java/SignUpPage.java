import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseMethods {

    @FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtUserName'])[1]")
    public WebElement usernameField;

    @FindBy(css = "#ContentPlaceHolder1_txtEmail")
    public WebElement emailField;

    @FindBy(css = "#ContentPlaceHolder1_txtConfirmEmail")
    public static WebElement confirmEmailField;

    @FindBy(css = "#ContentPlaceHolder1_txtPassword")
    public static WebElement passwordField;

    @FindBy(css = "#ContentPlaceHolder1_txtPassword2")
    public static WebElement confirmPasswordField;

    @FindBy(xpath = "//html[1]/body[1]/main[1]/section[1]/div[1]/form[1]/div[3]/div[6]/input[1]")
    public static WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//html[1]/body[1]/main[1]/section[1]/div[1]/form[1]/div[3]/div[7]/input[1]")
    public static WebElement newsletterCheckbox;

    @FindBy(css = "#ContentPlaceHolder1_btnRegister")
    public static WebElement createAnAccountButton;

    @FindBy(id = "btnCookie")
    public static WebElement acceptCookiesButton;


    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        clickWebElement(acceptCookiesButton, "Got it!");
    }

    public void enterUsername(String username) {
        clickWebElement(usernameField, "Username");
        try {
            usernameField.clear();
            usernameField.sendKeys(username);
        } catch (Exception e) {
            System.out.print("Cannot find it!");
        }
    }

    public void enterEmailAndConfirmIt(String emailAddress) {
        emailField.sendKeys(emailAddress);
        confirmEmailField.sendKeys(emailAddress);
    }

    public void enterPasswordAndConfirm(String password) {
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }


    public void clickOnCheckboxes() {

        //To move to the checkboxes
        moveDownToElement();

        waitForElement(termsAndConditionsCheckbox);
        verifyCheckBoxIsNotSelected(termsAndConditionsCheckbox,"Terms  and Conditions");
        termsAndConditionsCheckbox.click();

        verifyCheckBoxIsSelected(termsAndConditionsCheckbox,"Terms and Conditions");

        verifyCheckBoxIsNotSelected(newsletterCheckbox, "Newsletter");
        waitForElement(newsletterCheckbox);
        newsletterCheckbox.click();

        verifyCheckBoxIsSelected(newsletterCheckbox,"Newsletter");
    }

    public void clickOnCreateAnAccountButton() {

        waitForElement(createAnAccountButton);

        //For having enough time to click on reCAPTCHA before test click Creat An Account button
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createAnAccountButton.sendKeys(Keys.ENTER);
    }

    public void enterDifferentEmailForEmailAndConfirmationEmail(String email, String confirmation) {
        emailField.sendKeys(email);
        confirmEmailField.sendKeys(confirmation);
    }

    public void enterDifferentPasswordForPasswordAndConfirmationPassword(String password, String confirmation) {
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmation);
    }
}
