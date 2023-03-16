import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//table[@class='table-striped jambo_table']/tbody/tr")
    public WebElement emailTitle;

    @FindBy(xpath = "//h1[contains(text(),'Confirm registration')]")
    public WebElement messageBodyIframe;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to Etherscan!')]")
    public WebElement welcome;

    @FindBy (xpath = "//a[contains(text(),'etherscan.io/confirmemail')]")
    public WebElement emailLink;

    private WebDriver driver;

    public MailinatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMailAndConfirmReceivedEmail(String emailAddress) throws InterruptedException {
        //In mailinator, find email from Etherscan
        openMailinatorPage();
        sendTextToWebElement(emailAddressField, "Email address field", emailAddress);
        clickWebElement(goButton, "Go button");
        Thread.sleep(2000);
        clickWebElement(emailTitle, "Email title");
        Thread.sleep(2000);

        //Handle iframe and click on email and link in it
        //Also verifies the existence of confirmation email
        driver.switchTo().frame(driver.findElement(By.id("html_msg_body")));
        verifyWebElementTextIs(messageBodyIframe, "Confirm registration","Confirm registration");
        emailLink.click();
        driver.switchTo().defaultContent();
        //waitForElementToBeSeen(welcomeMessage);
        Thread.sleep(2000);
        verifyWebElementTextIs(welcome,"Welcome to Etherscan!","Welcome to Etherscan!");
    }
}
