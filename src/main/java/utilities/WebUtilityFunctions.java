package utilities;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebUtilityFunctions {


    public static void enterTextInTextBox(WebDriver driver, By locator, String textToEnter){
        WebElement textBoxElement = fluentWaitForAnElement(driver, locator);
        textBoxElement.sendKeys(textToEnter);
    }

    public static void buttonClick(WebDriver driver, By locator){
        WebElement buttonElement = fluentWaitForAnElement(driver, locator);
        buttonElement.click();
    }

    public static void selectValueFromADropdownByVisibleText(WebDriver driver, By locator, String visibleText){
        WebElement dropdownElement = fluentWaitForAnElement(driver, locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    public static List<WebElement> returnWebElements(WebDriver driver, By locator){
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(locator);
        }catch (Exception e){
            e.getMessage();
        }
        return elements;
    }

    public static WebElement returnWebElement(WebDriver driver, By locator){
        WebElement element = null;
        element =fluentWaitForAnElement(driver,locator);
        return element;
    }

    public static WebElement returnWebElementInsideElement(WebElement elementParent, By locator){
        WebElement element = null;
        try{
            element = elementParent.findElement(locator);
        }catch (Exception e){
            e.getMessage();
        }
        return element;
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static WebElement explicitlyWaitForAnElement(WebDriver driver, By locator){
     WebElement element=   (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }


    public static WebElement fluentWaitForAnElement(WebDriver driver, final By locator){

        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            WebElement elementToReturn = null;
            WebElement element = null;
            public WebElement apply(WebDriver driver) {
                try {
                   element  = driver.findElement(locator);

                }catch (Exception e){
                    e.printStackTrace();
                }
                if (element.isDisplayed() && element != null) {
                    elementToReturn = element;
                    return elementToReturn;
                }
                return elementToReturn;
            }
        };

        wait.until(function);

        return function.apply(driver);
    }

}
