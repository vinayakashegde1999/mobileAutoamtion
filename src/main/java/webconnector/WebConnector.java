package webconnector;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class WebConnector<v> {

    //private SessionId session = null;
    private final Properties prop = new Properties();
    private static WebDriver driver = null;


    public WebConnector() {
        try {
            prop.load(new FileInputStream("src/test/config/application.properties"));  //Path for Properties files to load the driver properties
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public WebDriver getDriver() {
        return driver;             //Path for Properties files to load the driver properties
    }


    public void setDriver(WebDriver driver) {

        this.driver = driver;           //Set driver for required OS
    }


    public void setUpDriver() throws MalformedURLException {

        String os = System.getProperty("deviceType");

        switch (os) {
            case "android":
                androidSetUp();
                break;
            case "ios":
                iosSetUp();
                break;
            default:
                throw new IllegalArgumentException(" invalid  operating system selected ..");

        }


    }

    private void iosSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.getProperty("iosPlatformName"));
        caps.setCapability("platformVersion", prop.getProperty("iosPlatformVersion"));
        caps.setCapability("deviceName", prop.getProperty("iosDeviceName"));
        caps.setCapability("app", prop.getProperty("iosApp"));

        driver = new IOSDriver(new URL(prop.getProperty("APPIUM")), caps);

    }

    private void androidSetUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.getProperty("androidPlatformName"));
        caps.setCapability("platformVersion", prop.getProperty("androidPlatformVersion"));
        caps.setCapability("deviceName", prop.getProperty("androidDeviceName"));
        caps.setCapability("automationName", prop.getProperty("androidAutomationName"));
        caps.setCapability("app", prop.getProperty("androidApp"));
        driver = new AndroidDriver(new URL(prop.getProperty("APPIUM")), caps);
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}