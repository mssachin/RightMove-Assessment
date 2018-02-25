package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebUtilityFunctions;

public class SinglePropertyDetailsPage {

    private WebDriver driver;
    private static final By propertyClassHeaderLocator = By.cssSelector("h1[class ='fs-22']");
    private static final By propertyAddressDetailsLocator = By.cssSelector("address[class *= 'fs-16']");
    private static final By propertyHeaderPriceLocator = By.id("propertyHeaderPrice");

    public SinglePropertyDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderInformation(){
        WebElement headerElement = WebUtilityFunctions.returnWebElement(driver, propertyClassHeaderLocator);
        return headerElement.getText();
    }

    public String getAddressInformation(){
        WebElement addressElement = WebUtilityFunctions.returnWebElement(driver,propertyAddressDetailsLocator);
        return addressElement.getText();
    }

    public String getHeaderPrice(){
        WebElement headerPriceElement = WebUtilityFunctions.returnWebElement(driver, propertyHeaderPriceLocator);
        return headerPriceElement.getText();
    }

}
