package jennie.com.pages;

import jennie.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private String URL = "https://crm.anhtester.com/admin/";
    private WebDriver driver;

    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    public DashboardPage (WebDriver _driver){
        driver = _driver;
    }

    public void openCustomerPage(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();
        WebUI.sleep(1);
    }
}
