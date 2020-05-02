package stepdefs;

import ApplicationPages.AndroidPages;
import ApplicationPages.IOSPages;
import io.cucumber.java.en.Given;

public class IOSStepDefs {

    private IOSPages iosEle ;

    public IOSStepDefs(){
        this.iosEle = new IOSPages();

    }

    @Given("user pass the date to IOS apps")
    public void andoiddatepicker() throws Exception{
        iosEle.ioSDatePicker();
    }
}
