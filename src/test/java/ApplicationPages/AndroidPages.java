package ApplicationPages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webconnector.WebConnector;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AndroidPages {
    WebConnector wc = new WebConnector();
        public void androidDatePicker(){

           // System.out.println(wc.getDriver().getCurrentPackage());
            System.out.println("hooooo ooooo");
            WebDriverWait wait = new WebDriverWait(wc.getDriver(),5);


            String CurrentDate= wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/date_picker_header_date"))).getText();
            // DateFormat format2=new SimpleDateFormat("EEEE");
            // String finalDay=format2.format(CurrentDate);

            String darw= "28/02/2020";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                sdf.parse(darw);
                String[]  givenDate=darw.split("/");
                int expecetMonth=Integer.parseInt(givenDate[1]);
                String[] dates=CurrentDate.split(" ");
                Date date = null;

                date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(dates[1]);

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                System.out.println(month);
                int monthNeedtoTravers=month+1;

                if(expecetMonth>monthNeedtoTravers){

                    monthNeedtoTravers= Math.abs((expecetMonth-monthNeedtoTravers));
                    System.out.println("Months need to loop: expecetd months are greaters"+monthNeedtoTravers);

                    for(int i=1;i<=monthNeedtoTravers;i++){
                        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/next"))).click();
                    }

                }
                if(expecetMonth<=monthNeedtoTravers){
                    monthNeedtoTravers=  Math.abs((monthNeedtoTravers-expecetMonth));
                    System.out.println("Months need to loop expecetd i slesser:"+monthNeedtoTravers);
                    for(int i=1;i<=monthNeedtoTravers;i++){
                        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/prev"))).click();
                    }

                }

                System.out.println("Loop THis many times"+monthNeedtoTravers);



                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='"+givenDate[0]+"']"))).click();
                // driver.wait(10);
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}
