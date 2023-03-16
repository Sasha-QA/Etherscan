import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String URL = "https://etherscan.io/register";
    public static WebDriver driver;

    public WebDriver startWebBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(URL);
        Cookie cookie = new Cookie("_GRECAPTCHA", "09AJBLKW0PDbC7s9T2ezma9Y7CukMMK09K2-IZIVpOKbRsepE968MQIxouRG623IL_VV8dQk3DQrQBDmNne3HY6mU");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.manage().window().fullscreen();

        return driver;
    }

    public static void stopWebBrowser() {
        driver.close();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }


}
