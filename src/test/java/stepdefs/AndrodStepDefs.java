package stepdefs;

import ApplicationPages.AndroidPages;
import io.cucumber.java.en.Given;

public class AndrodStepDefs {
    private AndroidPages androidEle;

    public AndrodStepDefs() {
        this.androidEle = new AndroidPages();

    }



    @Given("^User selects the (.*?)$")
    public  void user_selects_the_date_android(String date){
        androidEle.androidDatePicker(date);

    }

}
