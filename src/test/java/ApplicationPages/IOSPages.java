package ApplicationPages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webconnector.WebConnector;

import java.util.List;

public class IOSPages {

    WebConnector wc = new WebConnector();

    public void ioSDatePicker() {
        WebDriverWait wait = new WebDriverWait(wc.getDriver(), 10);
        List<WebElement> iosDates = wc.getDriver().findElements(MobileBy.xpath("//XCUIElementTypePickerWheel"));
        for (WebElement ele : iosDates) {
            System.out.println(ele.getText());
        }

        iosDates.get(0).sendKeys("Jun 14");

        List<WebElement> iosDates1 = wc.getDriver().findElements(MobileBy.xpath("//XCUIElementTypePickerWheel"));
        for (WebElement ele : iosDates1) {
            System.out.println(ele.getText());
        }


    }
}
