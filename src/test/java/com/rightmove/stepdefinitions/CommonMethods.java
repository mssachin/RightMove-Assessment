package com.rightmove.stepdefinitions;

import cucumber.api.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

    private WebDriver driver;
    private TestBase testBase;

    public CommonMethods(TestBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();
    }

    @Given("^I have launched rightmove website$")
    public void i_have_launched_rightmove_website() throws Throwable {
        driver.get("http://www.rightmove.co.uk");

    }
}
