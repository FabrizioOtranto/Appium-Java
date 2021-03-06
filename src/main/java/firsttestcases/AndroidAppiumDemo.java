package firsttestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidAppiumDemo {


    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @Test
    public void clickTest(){

        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("eq")).click();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "4");
    }

    @AfterTest
    public void tearDown(){
        if(null!= driver){
            driver.quit();
        }
    }

}
