package jennie.com.pages;

import jennie.com.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;
    private String COMPANY = "Jennie";
    public CustomerPage (WebDriver _driver){
        driver = _driver;
    }
    By newCustomerButton = By.xpath("//a[normalize-space()='New Customer']");
    By company = By.xpath("//input[@id='company']");
    By vat = By.xpath("//input[@id='vat']");
    By number = By.xpath("//input[@id='phonenumber']");
    By website = By.xpath("//input[@id='website']");
    By group = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    By group_search = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");
    By address = By.xpath("//textarea[@id='address']");
    By city = By.xpath("//input[@id='city']");
    By state = By.xpath("//input[@id='state']");
    By zip = By.xpath("//input[@id='zip']");
    By country = By.xpath("//label[@for='country']/following-sibling::div");
    By country_search = By.xpath("//label[@for='country']/following-sibling::div//input[@class='form-control']");
    By saveButton = By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']");
    By searchCustomer = By.xpath("//input[@class='form-control input-sm']");
    By getCustomer = By.xpath("//tbody/tr[1]/td[3]/a");


    public void addNewCustomer (){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(newCustomerButton).click();
        WebUI.waitForPageLoaded(driver);
        driver.findElement(company).sendKeys(COMPANY);
        driver.findElement(vat).sendKeys("123456");
        //WebUI.sendKeyToElement(driver,vat,"123456");
        driver.findElement(number).sendKeys("03728467");
        //WebUI.sendKeyToElement(driver,number,"98745727");
        driver.findElement(website).sendKeys("https://cmcglobal.com.vn/vi/home-vi/");
        driver.findElement(group).click();
        WebUI.sleep(1);
        driver.findElement(group_search).sendKeys("Gold", Keys.ENTER);
        driver.findElement(address).sendKeys("234");
        driver.findElement(city).sendKeys("Ha Noi");
        driver.findElement(state).sendKeys("Ha Noi");
        driver.findElement(zip).sendKeys("0000");
        driver.findElement(country).click();
        WebUI.sleep(1);
        driver.findElement(country_search).sendKeys("Vietnam", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(saveButton).click();
        WebUI.sleep(1);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//span[@class='alert-title']"));
        //verify message success
        Assert.assertTrue(WebUI.checkElementExist(driver,"//span[@class='alert-title']" ));
        System.out.println(driver.findElement(By.xpath("//span[@class='alert-title']")).getText());
    }
    public void verifyCustomer (){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(searchCustomer).sendKeys(COMPANY);
        WebUI.sleep(1);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, getCustomer);
        String getCustomerName = driver.findElement(getCustomer).getText();
        Assert.assertEquals(getCustomerName, COMPANY, "Fail. Customer name not match");
    }
    public void deleteCustomer() {
        //WebElement element = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a"));
        //Actions action = new Actions(driver);
        //action.moveToElement(element).build().perform();
        WebUI.hoverMouseToElement(driver, By.xpath("//tbody/tr[1]/td[3]/a"));
        WebUI.sleep(2);
        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr[1]/td[3]/div/a[contains(text(),'Delete')]"));
        driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div/a[contains(text(),'Delete')]")).click();
        //Alert alert = driver.switchTo().alert();
        //WebUI.sleep(2);
        //alert.accept();
        WebUI.acceptAlert(driver);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(driver,"//span[@class='alert-title']" ));
        System.out.println(driver.findElement(By.xpath("//span[@class='alert-title']")).getText());
    }
    public CustomerDetailPage openCustomerDetail(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(getCustomer).click();
        WebUI.sleep(1);
        return new CustomerDetailPage(driver);
    }

}
