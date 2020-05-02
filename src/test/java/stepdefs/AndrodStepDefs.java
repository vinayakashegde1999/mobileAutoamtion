package mobile.stepdefs;

import mobile.ApplicationPages.AndroidPages;
import io.cucumber.java.en.Given;

public class AndrodStepDefs {
    private AndroidPages androidEle ;

    public AndrodStepDefs(){
        this.androidEle = new AndroidPages();

    }

    @Given("^user pass the date to andrid apps$")
        public void andoiddatepicker() throws Exception{
            androidEle.androidDatePicker();

        }
}
