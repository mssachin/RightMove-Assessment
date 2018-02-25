package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebUtilityFunctions;

import java.util.List;

public class PropertySearchResultsPage {

    private WebDriver driver;
    private static final By sortOrderLocator = By.id("sortType");
    private static final By featurePropertyCardLocator = By.cssSelector("div[class $='--featured']");
    private static final By propertyCardLocator = By.cssSelector("div[class^='l-searchResult'] > div:nth-child(1)");
    private static final By propertyImageLocator = By.cssSelector("a[class = 'propertyCard-link']");
    private static final By propertyCardTitleLocator = By.cssSelector("h2[class = 'propertyCard-title']");
    private static final By propertyCardAddressLocator = By.cssSelector("address[class = 'propertyCard-address']");
    private static final By propertySalePriceLocator = By.cssSelector("a[class $= 'propertyCard-salePrice'");
    private static final By propertyRentalPriceLocator = By.cssSelector("div[class = 'propertyCard-rentalPrice-primary'");

    private String propertyTitleForSelectedProperty;
    private String propertyAddressForSelectedProperty;
    private String propertyPriceForSelectedProperty;



    public PropertySearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeSortOrder(String sortOrder){
        WebUtilityFunctions.selectValueFromADropdownByVisibleText(driver, sortOrderLocator, sortOrder);
        WebUtilityFunctions.explicitlyWaitForAnElement(driver, featurePropertyCardLocator);
    }

    public SinglePropertyDetailsPage clickFirstNonFeaturedProperty(){
        List<WebElement> elements = WebUtilityFunctions.returnWebElements(driver,propertyCardLocator);

        for (WebElement element:elements) {
            WebElement tempElement = element;
            String className = tempElement.getAttribute("class");
            System.out.println("Class Name is "+className);
            if(className.equalsIgnoreCase("propertyCard") && !className.contains("featured")){
                WebElement imageElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyImageLocator);
                WebElement propertyTitleElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyCardTitleLocator);
                setPropertyTitleForSelectedProperty(propertyTitleElement.getText());
                WebElement propertyAddressElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyCardAddressLocator);
                setPropertyAddressForSelectedProperty(propertyAddressElement.getText());
                WebElement propertyPriceElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertySalePriceLocator);
                setPropertyPriceForSelectedProperty(propertyPriceElement.getText());
                imageElement.click();
                break;
            }
        }

        return new SinglePropertyDetailsPage(driver);
    }



    public SinglePropertyDetailsPage clickFirstNonFeaturedPropertyRental(){
        List<WebElement> elements = WebUtilityFunctions.returnWebElements(driver,propertyCardLocator);

        for (WebElement element:elements) {
            WebElement tempElement = element;
            String className = tempElement.getAttribute("class");
            System.out.println("Class Name is "+className);

            if(className.equalsIgnoreCase("propertyCard")){
                WebElement imageElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyImageLocator);
                WebElement propertyTitleElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyCardTitleLocator);
                setPropertyTitleForSelectedProperty(propertyTitleElement.getText());
                WebElement propertyAddressElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyCardAddressLocator);
                setPropertyAddressForSelectedProperty(propertyAddressElement.getText());
                WebElement propertyPriceElement = WebUtilityFunctions.returnWebElementInsideElement(tempElement, propertyRentalPriceLocator);
                setPropertyPriceForSelectedProperty(propertyPriceElement.getText());
                imageElement.click();
                break;
            }
        }

        return new SinglePropertyDetailsPage(driver);
    }


    public String getPropertyTitleForSelectedProperty() {
        return propertyTitleForSelectedProperty;
    }

    public void setPropertyTitleForSelectedProperty(String propertyTitleForSelectedProperty) {
        this.propertyTitleForSelectedProperty = propertyTitleForSelectedProperty;
    }

    public String getPropertyAddressForSelectedProperty() {
        return propertyAddressForSelectedProperty;
    }

    public void setPropertyAddressForSelectedProperty(String propertyAddressForSelectedProperty) {
        this.propertyAddressForSelectedProperty = propertyAddressForSelectedProperty;
    }

    public String getPropertyPriceForSelectedProperty() {
        return propertyPriceForSelectedProperty;
    }

    public void setPropertyPriceForSelectedProperty(String propertyPriceForSelectedProperty) {
        this.propertyPriceForSelectedProperty = propertyPriceForSelectedProperty;
    }
}
