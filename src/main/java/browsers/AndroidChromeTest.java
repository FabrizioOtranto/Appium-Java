package browsers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidChromeTest {
private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        }
        @Test
        public void UserLogin(){
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().timeouts().implicitlyWait(3500, TimeUnit.MILLISECONDS);

            WebElement username = driver.findElementByCssSelector("input#username");
            username.sendKeys("tomsmith");
            WebElement password = driver.findElementByCssSelector("input#password");
            password.sendKeys("SuperSecretPassword!");
            WebElement loginBtn = driver.findElementByCssSelector("button.radius");
            loginBtn.click();

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.urlContains("secure"));
            System.out.println(driver.getCurrentUrl());

        }

        @AfterTest
        public void tearDown(){
        driver.quit();
        }

    }

