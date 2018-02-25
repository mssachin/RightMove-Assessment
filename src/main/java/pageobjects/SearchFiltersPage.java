package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebUtilityFunctions;

public class SearchFiltersPage {

    private WebDriver driver;
    private static final By searchRadiusLocator = By.id("radius");
    private static final By propertyTypeLocator = By.id("displayPropertyType");
    private static final By priceRangeMinLocator = By.id("minPrice");
    private static final By priceRangeMaxLocator = By.id("maxPrice");
    private static final By numberOfBedroomsMinLocator = By.id("minBedrooms");
    private static final By numberOfBedroomsMaxLocator = By.id("maxBedrooms");
    private static final By maxDaysSinceAddedLocator = By.id("maxDaysSinceAdded");
    private static final By includeSSTCLocator = By.id("includeSSTC");
    private static final By findPropertiesButtonLocator = By.id("submit");



    public SearchFiltersPage(WebDriver driver) {
        this.driver = driver;
    }

    public PropertySearchResultsPage selectFiltersAndSearchForProperties(String searchRadius, String propertyType, String minPrice,
                                                                         String maxPrice, String minBedrooms, String maxBedrooms,
                                                                         String daysSinceAdded, boolean SSTCFlag){
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, searchRadiusLocator, searchRadius);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, propertyTypeLocator, propertyType);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, priceRangeMinLocator, minPrice);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, priceRangeMaxLocator, maxPrice);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, numberOfBedroomsMinLocator, minBedrooms);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, numberOfBedroomsMaxLocator, maxBedrooms);
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, maxDaysSinceAddedLocator, daysSinceAdded);
        if(SSTCFlag == true){
            WebUtilityFunctions.buttonClick(driver, includeSSTCLocator);
        }
        WebUtilityFunctions.buttonClick(driver, findPropertiesButtonLocator);
        return new PropertySearchResultsPage(driver);
    }
}
