import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MailinatorPage extends BaseMethods {

    public static String random = RandomStringUtils.randomAlphabetic(10);
    public static String username = random;
    public static String mail = random + "@mailinator.com";

    @FindBy(id = "search")
    public WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='search']/following-sibling::button")
    public WebElement goButton;

    @FindBy(xpath = "(//td[@class='ng-binding'][normalize-space()='Team Etherscan'])[1]")
    public WebElement emailTitle;

    @FindBy(id = "//h1[normalize-space()='Confirm registration']")
    public WebElement messageBodyIframe;

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
        //clickWebElement(emailTitle, "Email title");
        emailTitle.sendKeys(Keys.ENTER);
        verifyWebElementTextIs(messageBodyIframe, "Confirm registration","Confirm registration");
    }
}
