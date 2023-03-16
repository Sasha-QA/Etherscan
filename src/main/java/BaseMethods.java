import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;


public class BaseMethods {
    public WebDriver driver;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWebElement(WebElement element, String elementName) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found!");
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
        driver.manage().window().maximize();
    }

    public void sendTextToWebElement(WebElement element, String elementName, String textToEnter) {
        try {
            element.click();
            element.clear();
            element.sendKeys(textToEnter);
        } catch (NoSuchElementException nsee) {
        }
    }

    public void moveDownToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(800, 776)");
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterInfo(WebElement element, String username) {
        clickWebElement(element, "Username");
        try {
            element.clear();
            element.sendKeys(username);
        } catch (Exception e) {
            System.out.print("Cannot find it!");
        }
    }
}
