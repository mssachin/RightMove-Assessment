package com.rightmove.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.PropertySearchResultsPage;
import pageobjects.SearchFiltersPage;
import pageobjects.SinglePropertyDetailsPage;
import utilities.AssertionUtilityFunctions;

import java.util.concurrent.TimeUnit;

public class SearchAndDisplayMethods {
     private WebDriver driver;
     private HomePage homePage;
     private SearchFiltersPage searchFiltersPage;
     private PropertySearchResultsPage propertySearchResultsPage;
     private SinglePropertyDetailsPage singlePropertyDetailsPage;
     private String businessType;
     private TestBase testBase;

    public SearchAndDisplayMethods(TestBase testBase) {
         this.testBase = testBase;
         driver = testBase.getDriver();
    }

    @When("^I carry out a search for properties for \"([^\"]*)\" based on \"([^\"]*)\"$")
    public void i_carry_out_a_search_for_properties_for_based_on(String propertyType, String searchTerm) throws Throwable {
        businessType = propertyType;
        homePage = new HomePage(driver);
        homePage.enterSearchTermInSearchBox(searchTerm);
        if(propertyType.equalsIgnoreCase("sale")){
            searchFiltersPage =homePage.clickOnForSaleButton();
        }else{
            searchFiltersPage =homePage.clickOnRentButton();
        }
    }

    @When("^I select various \"([^\"]*)\" in the dropdown and click on find properties$")
    public void i_select_various_in_the_dropdown_and_click_on_find_properties(String filterOptions) throws Throwable {
        String [] allFilterOptions = filterOptions.split(":");
        String searchRadius = allFilterOptions[0];
        String propertyType = allFilterOptions[1];
        String minPrice = allFilterOptions[2];
        String maxPrice = allFilterOptions[3];
        String minBedrooms = allFilterOptions[4];
        String maxBedrooms = allFilterOptions[5];
        String addedToSite = allFilterOptions[6];
        boolean sstcFlag = Boolean.parseBoolean(allFilterOptions[7]);
        propertySearchResultsPage =searchFiltersPage.selectFiltersAndSearchForProperties(searchRadius,propertyType,minPrice,
                                                              maxPrice,minBedrooms, maxBedrooms,addedToSite,sstcFlag);

    }

    @And("^I change the sort order to \"([^\"]*)\" properties$")
    public void i_change_the_sort_order_to_properties(String sortOrder) throws Throwable {
        propertySearchResultsPage.changeSortOrder(sortOrder);
    }

    @Then("^I should be able to select the first non-featured property$")
    public void i_should_be_able_to_select_the_first_non_featured_property() throws Throwable {
       singlePropertyDetailsPage= propertySearchResultsPage.clickFirstNonFeaturedProperty();

    }


    @Then("^I should be able to select the first non-featured property for rental$")
    public void i_should_be_able_to_select_the_first_non_featured_property_for_rental() throws Throwable {
        singlePropertyDetailsPage= propertySearchResultsPage.clickFirstNonFeaturedPropertyRental();

    }

    @And("^I verify the values$")
    public void i_verify_the_values() throws Throwable {
       String priceOnResultsPage = propertySearchResultsPage.getPropertyPriceForSelectedProperty();
       String titleOnResultsPage = propertySearchResultsPage.getPropertyTitleForSelectedProperty();
       String addressOnResultsPage = propertySearchResultsPage.getPropertyAddressForSelectedProperty();
       String priceOnPropertyDetailsPage = singlePropertyDetailsPage.getHeaderPrice();
       String titleOnPropertyDetailsPage = singlePropertyDetailsPage.getHeaderInformation();
       String addressOnPropertyDetailsPage = singlePropertyDetailsPage.getAddressInformation();

       String priceComponentOnResultsPage = priceOnResultsPage.split("\\n")[0];
       if(businessType.equalsIgnoreCase("sale")){
           AssertionUtilityFunctions.assertStringValue(priceComponentOnResultsPage, priceOnPropertyDetailsPage.split("\\n")[1]);
       }else{
           AssertionUtilityFunctions.assertStringValue(priceComponentOnResultsPage, priceOnPropertyDetailsPage.split("\\n")[0]);

       }
       AssertionUtilityFunctions.assertStringContains(titleOnResultsPage, titleOnPropertyDetailsPage);
       AssertionUtilityFunctions.assertStringContains(addressOnResultsPage, addressOnPropertyDetailsPage);
    }

}
