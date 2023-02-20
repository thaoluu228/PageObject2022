package jennie.com.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static Actions action;
    private static WebElement element;
    private static Select select;
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    public static void sleep (double seconds) {
        try {
            Thread.sleep((long) (1000*seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void waitForElementVisible (WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error){
            Assert.fail("Timeout waiting for element visible " + by.toString());
            System.out.println("Timeout waiting for element visible " + by.toString());
        }
    }

    public static void waitForElementPresent (WebDriver driver, By by){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error){
            Assert.fail("Element not exists " + by.toString());
            System.out.println("Element not exists " + by.toString());
        }
    }

    public static void waitForElementClickable (WebDriver driver, By by){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch(Throwable error){
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            System.out.println("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static Boolean checkElementExist(WebDriver driver, String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }

    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

    public static WebElement findElement(WebDriver driver, By by){
        return driver.findElement(by);
    }

    public static void openURL (WebDriver driver, String URL) {
        driver.get(URL);
        waitForPageLoaded(driver);
    }
    public static void clickToElement (WebDriver driver, By by){
        waitForElementVisible(driver, by);
        findElement(driver, by).click();
    }
    public static void sendKeyToElement (WebDriver driver, By by, String value){
        findElement(driver,by).sendKeys(value);
    }
    public static String getTextElement(WebDriver driver, By by){
        return findElement(driver,by).getText();
    }
    public static void acceptAlert (WebDriver driver){
        WebUI.sleep(2);
        driver.switchTo().alert().accept();
    }
    public static void hoverMouseToElement(WebDriver driver, By by){
        action = new Actions (driver);
        element = findElement(driver, by);
        action.moveToElement(element).build().perform();
    }
    public static void selectItemInHTML(WebDriver driver, By by, String value){
        element = findElement(driver, by);
        select = new Select(element);
        select.selectByVisibleText(value);
    }
    public static void selectItemInCustomDropdown(WebDriver driver, By parentXpath, By listOptions, String expectedText){
        findElement(driver, parentXpath).click();
        List<WebElement> allItems = driver.findElements(listOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOptions));
        for (WebElement item : allItems){
            System.out.println("List dropdown: " + item.getText());
            if(item.getText().equals(expectedText)){
                item.click();
                break;
            }
        }

    }
    public static void getFirstItemInHTML(WebDriver driver, By by){
        element = findElement(driver, by);
        select = new Select(element);
        select.getFirstSelectedOption();
    }

    public static String getAttribute(WebDriver driver, By by, String attribute){
        return findElement(driver, by).getAttribute(attribute);
    }

    public void checkTheCheckbox(WebDriver driver, By by){
        element = findElement(driver, by);
        if(!element.isSelected()){
            element.click();
        }
    }
    public static void scrollToElementWithJS(WebDriver driver, By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(driver, by));
    }

}
