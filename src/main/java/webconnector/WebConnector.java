package webconnector;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static io.appium.java_client.remote.AutomationName.APPIUM;

public class WebConnector<v> {

public static WebDriver driver =null;
public SessionId session = null;
public static Properties prop = new Properties();


public WebConnector(){
    try{
            prop.load(new FileInputStream("src/test/config/application.properties"));
    }catch (IOException e){
        e.printStackTrace();

    }
}

public WebDriver getDriver(){
    return this.driver;
}


public  void setDriver(WebDriver driver){
       this.driver=driver;
}


public void setUpDriver() throws MalformedURLException{

    String os = "ios";//System.getProperty("deviceType");

    switch (os){
        case "android" :
                androidSetUp();
                break;
        case "ios"  :
                iosSetUp();
                break;
        default:
            throw new IllegalArgumentException( " No valid  Opertaing system selecetd ..");

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