package ApplicationPages;

import ConstantVariables.Constant;
import helper.helper;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webconnector.WebConnector;

public class AndroidPages {

    WebConnector wc = new WebConnector();
    helper hp = new helper();

    public void androidDatePicker(String testDate) {

        WebDriverWait wait = new WebDriverWait(wc.getDriver(), Constant.waitFor);
        String CurrentDate = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(Constant.androidDateHeader))).getText();

        int appMonth = 0;
        String darw = testDate;
        String[] givenDate = darw.split("/");
        try {

            if (hp.dateVAlidater(testDate)) {
                int testDataMonth = hp.getMonth(testDate);
                appMonth = hp.getMonthFromString(CurrentDate);

                if (testDataMonth > appMonth) {
                    appMonth = Math.abs((testDataMonth - appMonth));
                    for (int i = 1; i <= appMonth; i++) {
                        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(Constant.androidCalenderNext))).click();
                    }
                }
                if (testDataMonth <= appMonth) {
                    appMonth = Math.abs((appMonth - testDataMonth));
                    for (int i = 1; i <= appMonth; i++) {
                        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(Constant.androidCalenderPrevious))).click();
                    }

                }
            }

            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='" + givenDate[0] + "']"))).click();
            String presentState= wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(Constant.androidDateHeader))).
                    getText();
            Assert.assertTrue(presentState.contains(hp.getMonth(Integer.parseInt(givenDate[1]))+" "+givenDate[0]) ,"Expected"+hp.returnMonthFromStringDate(testDate)+" "+givenDate[0] + " Actual: "+presentState);





        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
