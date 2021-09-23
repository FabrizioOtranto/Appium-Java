package DataProvider.Tests;

import DataProvider.PageObjects.LoginPage;
import DataProvider.utils.JsonReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Login {
    LoginPage login;
        private AppiumDriver driver;

        @DataProvider(name = "Tasks data")
        public Object[][] passData() throws IOException, ParseException {

            return  JsonReader.getJSONData(
                    System.getProperty("user.dir") + "/data/TaskData.json",
                    "Tasks Data", 2);
        }

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

    @Test(dataProvider = "Tasks data")
    public void UserLogin(String Username, String Password) throws MalformedURLException{
        driver.get("https://rendering-fabry.web.app/examples/login");
        driver.manage().timeouts().implicitlyWait(3500, TimeUnit.MILLISECONDS);

        login = new LoginPage(driver);
        login.sendUsername(Username);
        login.sendPassword(Password);
        login.clickLogin();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
