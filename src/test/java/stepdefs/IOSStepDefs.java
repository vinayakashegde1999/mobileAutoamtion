package stepdefs;

import ApplicationPages.IOSPages;
import io.cucumber.java.en.Given;

public class IOSStepDefs {

    private IOSPages iosEle;

    public IOSStepDefs() {
        this.iosEle = new IOSPages();

    }

    @Given("^User select date on ios app (.*?)$")
    public void andoiddatepicker(String testDate) throws Exception {
        System.out.println("Given dates are "+testDate);
        iosEle.ioSDatePicker(testDate);
    }
}
