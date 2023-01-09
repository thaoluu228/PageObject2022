package jennie.com.pages;

import jennie.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private String URL = "https://crm.anhtester.com/admin/";
    private WebDriver driver;

    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By menuProject = By.xpath("//li[@class='menu-item-projects']//a");
    public DashboardPage (WebDriver _driver){
        driver = _driver;
    }

    public CustomerPage openCustomerPage(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();
        WebUI.sleep(1);
        return new CustomerPage(driver);
    }

    public ProjectPage openProjectPage(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuProject).click();
        WebUI.sleep(1);
        return new ProjectPage(driver);
    }
}
