import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailinatorPage extends BaseMethods {

    @FindBy(id = "search")
    public static WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='search']/following-sibling::button")
    public static WebElement goButton;

    @FindBy(xpath = "//tr[starts-with(@id,'row')]")
    public static WebElement emailTitle;

    @FindBy(id = "//h1[normalize-space()='Confirm registration']")
    public static WebElement messageBodyIframe;

    private WebDriver driver;

    public MailinatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMailAndConfirmReceivedEmail(String emailAddress) {
        openMailinatorPage();
        sendTextToWebElement(emailAddressField, "Email address field", emailAddress);
        clickWebElement(goButton, "Go button");
        clickWebElement(emailTitle, "Email title");
        verifyWebElementTextIs(messageBodyIframe, "Confirm registration","Confirm registration");
    }
}
