package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebUtilityFunctions;

public class HomePage {

    private WebDriver driver;
    private static final By searchTextBoxLocator = By.id("searchLocation");
    private static final By forSaleButtonLocator = By.id("buy");
    private static final By forRentButtonLocator = By.id("rent");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterSearchTermInSearchBox(String searchTerm){
        WebUtilityFunctions.enterTextInTextBox(driver, searchTextBoxLocator, searchTerm);
    }

    public SearchFiltersPage clickOnForSaleButton(){
        WebUtilityFunctions.buttonClick(driver, forSaleButtonLocator);
        return new SearchFiltersPage(driver);
    }


    public SearchFiltersPage clickOnRentButton(){
        WebUtilityFunctions.buttonClick(driver, forRentButtonLocator);
        return new SearchFiltersPage(driver);
    }
}
