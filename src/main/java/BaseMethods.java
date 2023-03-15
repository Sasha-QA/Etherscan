import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class BaseMethods {
    public WebDriver driver;

    public BaseMethods(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

        public void clickWebElement(WebElement element, String elementName) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found!");
        }
    }

    public static void assertElementVisible(WebElement webElement, String elementName) {
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Web element is not visible!");
        }
    }

    public static void verifyCheckBoxIsSelected(WebElement element, String elementName) {
        if (element.isSelected()) {
            System.out.println("Checkbox " + elementName + " is selected");
        } else {
            System.out.println("Checkbox " + elementName + " is not selected");
        }
    }

    public static void verifyCheckBoxIsNotSelected(WebElement element, String elementName) {
        if (!element.isSelected()) {
            System.out.println("Checkbox " + elementName + " is not selected");
        } else {
            System.out.println("Checkbox " + elementName + " is selected");
        }
    }

    public static void verifyWebElementTextIs(WebElement webElement, String elementName, String expectedText) {
        String actualText = webElement.getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Actual text is the same as expected");
        } else {
            System.out.println("Actual text is not the same as expected");
        }
    }

    public void openMailinatorPage() {
        driver.get("https://www.mailinator.com");
    }

    public void sendTextToWebElement(WebElement element, String elementName, String textToEnter) {

        try {
            element.clear();
            element.sendKeys(textToEnter);
        } catch (NoSuchElementException nsee) {
        }
    }

    public void moveAndClickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
    }

}