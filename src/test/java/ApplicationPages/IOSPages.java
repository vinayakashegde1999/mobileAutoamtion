package ApplicationPages;

import ConstantVariables.Constant;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webconnector.WebConnector;

import java.util.List;
import helper.helper;


public class IOSPages {

    WebConnector wc = new WebConnector();
    helper hp = new helper();

    public void ioSDatePicker(String testDate) {
        WebDriverWait wait = new WebDriverWait(wc.getDriver(), Constant.waitFor);
        String monthName= hp.monthNameInString(testDate);
        String givenDates[] =testDate.split("/");
        List<WebElement> iosDates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(Constant.iosDatePicker)));
        String expecetdDate= monthName+" "+givenDates[0];
        System.out.println("expecetdDate: "+ expecetdDate);
        iosDates.get(0).sendKeys(expecetdDate);
        String actualResult=iosDates.get(0).getText();
        Assert.assertTrue(actualResult.contains(expecetdDate),"Expecetd result: "+expecetdDate+"Actual result :"+actualResult);
    }
}
