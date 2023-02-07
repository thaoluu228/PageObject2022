package jennie.com.pages;

import org.openqa.selenium.WebDriver;

public class CustomerDetailPage extends CustomerPage{
    private WebDriver driver;
    public  CustomerDetailPage(WebDriver _driver){
        super (_driver);
        driver = _driver;
    }
    public void checkCustomerDetails (){
        System.out.println(driver.findElement(company).getAttribute("value"));
        System.out.println(driver.findElement(vat).getAttribute("value"));
        System.out.println(driver.findElement(number).getAttribute("value"));

    }

}
